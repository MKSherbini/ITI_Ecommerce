package models.urls;

public class VCUrlMapping {
    private final String title;
    private final String controllerUrl;
    private final String viewUrl;
    private final boolean isAdminOnly;

    public VCUrlMapping(String title, String controllerUrl, String viewUrl, boolean isAdminOnly) {
        this.title = title;
        this.controllerUrl = controllerUrl;
        this.viewUrl = viewUrl;
        this.isAdminOnly = isAdminOnly;
    }

    public VCUrlMapping(String title, String controllerUrl, String viewUrl) {
        this(title, controllerUrl, viewUrl, false);
    }

    public String getTitle() {
        return title;
    }

    public String getControllerUrl() {
        return controllerUrl;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public boolean isAdminOnly() {
        return isAdminOnly;
    }

    @Override
    public String toString() {
        return "VCUrlMapping{" +
                "title='" + title + '\'' +
                ", controllerUrl='" + controllerUrl + '\'' +
                ", viewUrl='" + viewUrl + '\'' +
                ", isAdminOnline=" + isAdminOnly +
                '}';
    }
}
