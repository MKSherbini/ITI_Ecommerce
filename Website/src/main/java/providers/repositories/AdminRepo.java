package providers.repositories;

import managers.DatabaseManager;
import models.orm.Admin;
import models.orm.User;

import java.util.List;

public class AdminRepo extends GenericRepo<Admin, Long> {
    private static volatile AdminRepo instance = null;

    private AdminRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static AdminRepo getInstance() {
        if (instance == null) {
            synchronized (AdminRepo.class) {
                if (instance == null) {
                    instance = new AdminRepo();
                }
            }
        }
        return instance;
    }

    public Admin findByEmailPassword(String email, String password) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (Admin) session
                        .createNamedQuery("Admin.findByEmailPassword")
                        .setParameter("email", email)
                        .setParameter("password", password)
                        .getSingleResult());
    }
}
