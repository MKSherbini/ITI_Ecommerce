package managers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import constants.enums.ServiceNames;
import jakarta.servlet.ServletException;
import listeners.ThreadLocalContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import providers.database.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;

public class DatabaseManager {
    private static volatile DatabaseManager instance = null;
    private final SessionFactory sessionFactory;
    private Session currentSession;

    private DatabaseManager() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
        ServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("/hibernate.cfg.xml") // can be ignored
                        .build();
        Metadata metadata =
                new MetadataSources(standardRegistry)
                        .buildMetadata();
        sessionFactory =
                metadata.getSessionFactoryBuilder().build();
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager();
                }
            }
        }
        return instance;
    }

    public void beginTransaction() {
        sessionFactory.openSession();
        sessionFactory.getCurrentSession().getTransaction().begin();
    }

    public void flush() {
        sessionFactory.getCurrentSession().flush();
    }

    public void endTransaction() {
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    public <T> T runTransactionWithRet(Function<Session, T> transaction) {
        try {

            T ret = transaction.apply(sessionFactory.getCurrentSession());
            return ret;
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
            handleError();
        }

        // unreachable
        return null;
    }

    public void runTransaction(Consumer<Session> transaction) {
        try {
            transaction.accept(sessionFactory.getCurrentSession());
        } catch (PersistenceException e) {
            e.printStackTrace();
            handleError();
        }
    }

    public void handleError() {
        // TODO: actually handle this f* error
//        try {
//            ThreadLocalContext.forward(ServiceNames.ERROR_REDIRECT);
//        } catch (IOException | ServletException ioException) {
//            ioException.printStackTrace();
//        }
    }
}
