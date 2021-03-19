package providers.repositories;

public class CategoryRepo extends GenericRepo<CategoryRepo, Long> {
    private static volatile CategoryRepo instance = null;

    private CategoryRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static CategoryRepo getInstance() {
        if (instance == null) {
            synchronized (CategoryRepo.class) {
                if (instance == null) {
                    instance = new CategoryRepo();
                }
            }
        }
        return instance;
    }
}
