package providers.repositories;

import managers.DatabaseManager;
import models.orm.User;

import java.util.List;

public class UserRepo extends GenericRepo<User, Long> {
    private static volatile UserRepo instance = null;

    private UserRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static UserRepo getInstance() {
        if (instance == null) {
            synchronized (UserRepo.class) {
                if (instance == null) {
                    instance = new UserRepo();
                }
            }
        }
        return instance;
    }

    public List<User> getAll() {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("User.getAll")
                        .list());
    }

    public List<User> findLikeName(String name) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("User.findLikeName")
                        .setParameter("name", "%" + name + "%") // dammit
                        .list());
    }

    public User findByEmailPassword(String email, String password) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (User) session
                        .createNamedQuery("User.findByEmailPassword")
                        .setParameter("email", email)
                        .setParameter("password", password)
                        .getSingleResult());
    }
}
