import managers.DatabaseManager;
import models.orm.Product;
import models.orm.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;
import providers.repositories.UserRepo;

import java.sql.SQLException;
import java.util.List;

public class testMain {
    static Logger log = Logger.getLogger(testMain.class.getName());


    public static void main(String[] args) throws SQLException {
        var db = DatabaseManager.getInstance();
        db.beginTransaction();

//        session.save(user);
//        System.out.println("user = " + user);
//        Query q = session.createQuery("from User");
//        List<User> users = q.list();
//        for (User user : users) {
//            System.out.println("user = " + user);
//        }

        var userRepo = UserRepo.getInstance();
//        User user = new User();
//        user.setEmail("tester");
//        user.setUserName("tester");
//        user.setPassword("tester");
//        userRepo.create(user);
//        System.out.println("user = " + userRepo.read(user.getUserId()));

        for (User user : userRepo.findLikeName("t")) {
            System.out.println("user = " + user);
        }

        //        System.out.println("user = " + userRepo.read(user.getUserId()));

        db.endTransaction();
    }

}
