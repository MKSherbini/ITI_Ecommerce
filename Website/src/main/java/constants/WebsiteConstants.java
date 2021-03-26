package constants;

public class WebsiteConstants {
    // database
    public static final String paramCategoryName = "category";
    public static final String paramSearchName = "search";
    public static final String paramMinPriceName = "minPrice";
    public static final String paramMaxPriceName = "maxPrice";
    public static final String paramProductId = "ref";
    public static final String paramPageNumber = "page";

    private String WebsiteName = "ChillStore";


    private static volatile WebsiteConstants instance = null;

    private WebsiteConstants() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static WebsiteConstants getInstance() {
        if (instance == null) {
            synchronized (WebsiteConstants.class) {
                if (instance == null) {
                    instance = new WebsiteConstants();
                }
            }
        }
        return instance;
    }

    public String getWebsiteName() {
        return WebsiteName;
    }
}
