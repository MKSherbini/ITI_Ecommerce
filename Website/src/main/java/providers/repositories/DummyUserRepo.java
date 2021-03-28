package providers.repositories;

import managers.DatabaseManager;
import models.orm.Admin;
import models.orm.DummyUser;

import java.util.Optional;

public class DummyUserRepo extends GenericRepo<DummyUser, Long> {
    private static volatile DummyUserRepo instance = null;

    private DummyUserRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static DummyUserRepo getInstance() {
        if (instance == null) {
            synchronized (DummyUserRepo.class) {
                if (instance == null) {
                    instance = new DummyUserRepo();
                }
            }
        }
        return instance;
    }
}
