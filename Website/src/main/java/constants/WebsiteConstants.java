package constants;

public class WebsiteConstants {
    // database
    public static String Username = "user547";
    public static String email = "mohaelkaed@gmail.com";
    public static String Password = "pass547";


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
