import models.orm.Product;
import models.orm.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;

import java.sql.SQLException;

public class testMain {
    static Logger log = Logger.getLogger(testMain.class.getName());


    public static void main(String[] args) throws SQLException {
        ServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("/hibernate.cfg.xml") // can be ignored
                        .build();
        Metadata metadata =
                new MetadataSources(standardRegistry)
                        .buildMetadata();
        SessionFactory fact =
                metadata.getSessionFactoryBuilder().build();

        var session = fact.openSession();

        User user = new User();
        user.setEmail("test");
        user.setUserName("test");
        user.setPassword("test");
        session.save(user);

        session.close();

        System.out.println("user = " + user);
    }

}
