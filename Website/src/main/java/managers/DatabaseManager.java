package managers;

import jakarta.servlet.ServletException;
import listeners.ThreadLocalContext;
import utilities.ErrorHandler;

import javax.persistence.*;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.persistence.EntityManager;


public class DatabaseManager {
    private static volatile DatabaseManager instance = null;
    private final EntityManagerFactory emf;
    //    private final EntityManager entityManager;
    private static final ThreadLocal<EntityManager> entityManagerInstance = new ThreadLocal<>();

    public static void main(String[] args) {
        DatabaseManager.getInstance().beginSession();
    }

    private DatabaseManager() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
        emf = Persistence.createEntityManagerFactory("persistenceEcommerce");
//        entityManager = emf.createEntityManager();
//        entityManager.setFlushMode(FlushModeType.AUTO);
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

    public void beginSession() {
//        if (!entityManager.getTransaction().isActive())
        var entityManager = emf.createEntityManager();
        entityManagerInstance.set(entityManager);
        entityManager.getTransaction().begin();
    }

    public void flush() {
        entityManagerInstance.get().flush();
        entityManagerInstance.get().getTransaction().commit();
    }

    public void endSession() {
        var entityManager = entityManagerInstance.get();
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public <T> T runTransactionWithRet(Function<EntityManager, T> transaction) {
        try {
//            beginSession();
            T ret = transaction.apply(entityManagerInstance.get());
//            endSession();
            return ret;
        } catch (javax.persistence.PersistenceException e) {
//            e.printStackTrace();
            handleError(e);
        }

        // unreachable
        return null;
    }

    public void runTransaction(Consumer<EntityManager> transaction) {
        try {
//            beginSession();
            transaction.accept(entityManagerInstance.get());
//            endSession();
        } catch (PersistenceException e) {
//            e.printStackTrace();
            handleError(e);
        }
    }

    public void handleError(Exception e) {
        try {
            ErrorHandler.forward("666", e.getMessage());
        } catch (IOException | ServletException ee) {
            ee.printStackTrace();
        }

        // TODO: actually handle this f* error
        // try {
        // ThreadLocalContext.forward(ServiceNames.ERROR_REDIRECT);
        // } catch (IOException | ServletException ioException) {
        // ioException.printStackTrace();
        // }
    }
}
