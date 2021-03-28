package models.urls;

public class ServiceUrlMapping {
    private final String title;
    private final String serviceUrl;
    private final String serviceName;
    private final boolean isAdminOnly;


    public ServiceUrlMapping(String title, String serviceUrl, boolean isAdminOnly) {
        this.title = title;
        this.serviceUrl = serviceUrl;
        this.serviceName = serviceUrl;
        this.isAdminOnly = isAdminOnly;
    }

    public ServiceUrlMapping(String title, String serviceUrl) {
        this(title, serviceUrl, false);
    }

    public String getTitle() {
        return title;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public String getServiceName() {
        return serviceName;
    }

    public boolean isAdminOnly() {
        return isAdminOnly;
    }


    @Override
    public String toString() {
        return "ServiceUrlMapping{" +
                "title='" + title + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", isAdminOnly=" + isAdminOnly +
                '}';
    }
}
