package providers.repositories;

import managers.DatabaseManager;
import models.orm.User;

import java.util.List;
import java.util.Optional;

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

    public List<User> findLikeName(String name) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("User.findLikeName")
                        .setParameter("name", "%" + name + "%") // dammit
                        .getResultList());
    }

    public Optional<User> findByEmailPassword(String email, String password) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (Optional<User>) session
                        .createNamedQuery("User.findByEmailPassword")
                        .setParameter("email", email)
                        .setParameter("password", password)
                        .getResultList().stream().findAny());
    }

    public Optional<User> findByEmail(String email) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (Optional<User>) session
                .createNamedQuery("User.findByEmail")
                .setParameter("email", email)
                        .getResultList().stream().findAny());
    }
}
