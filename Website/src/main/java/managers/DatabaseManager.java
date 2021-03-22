package managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import providers.database.*;

import javax.persistence.EntityManager;
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

    public void endTransaction() {
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    public <T> T runTransactionWithRet(Function<Session, T> transaction) {
        T ret = transaction.apply(sessionFactory.getCurrentSession());
        return ret;
    }

    public void runTransaction(Consumer<Session> transaction) {
        transaction.accept(sessionFactory.getCurrentSession());
    }
}
