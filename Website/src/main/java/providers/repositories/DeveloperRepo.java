package providers.repositories;

import managers.DatabaseManager;
import models.orm.Developer;


import java.util.List;
import java.util.Optional;

public class DeveloperRepo extends GenericRepo<Developer, Long> {
    private static volatile DeveloperRepo instance = null;

    private DeveloperRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static DeveloperRepo getInstance() {
        if (instance == null) {
            synchronized (DeveloperRepo.class) {
                if (instance == null) {
                    instance = new DeveloperRepo();
                }
            }
        }
        return instance;
    }

    public List<Developer> findAll() {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Developer.findAll")
                        .getResultList());
    }


}
