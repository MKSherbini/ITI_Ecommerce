package constants;

import constants.enums.ServiceNames;
import jakarta.servlet.http.HttpServletRequest;
import models.urls.ServiceUrlMapping;
import models.urls.VCUrlMapping;
import constants.enums.PageNames;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlMappingConstants {
    private final Map<PageNames, VCUrlMapping> urlMap = new HashMap<>();
    private boolean isAbsoluteUrl = false;

    {
        urlMap.put(PageNames.HOME_PAGE, new VCUrlMapping("Home", "home", "index.jsp"));
        urlMap.put(PageNames.SIGN_IN_PAGE, new VCUrlMapping("SignIn", "signin", "signin.jsp"));
        urlMap.put(PageNames.REGISTER_PAGE, new VCUrlMapping("SignUp", "signup", "signup.jsp"));
        urlMap.put(PageNames.NOT_FOUND_404, new VCUrlMapping("Not Found", "404", "404.jsp"));
//        urlMap.put(PageNames.TEST_JSP,new VCUrlMapping("testJSP","test","Testtag.jsp"));
        urlMap.put(PageNames.ABOUT_PAGE, new VCUrlMapping("About", "about", "about.jsp"));
        urlMap.put(PageNames.TEST_JSP, new VCUrlMapping("testJSP", "test", "Testtag.jsp"));
        urlMap.put(PageNames.SHOP, new VCUrlMapping("Shop", "shop", "shop.jsp"));
        urlMap.put(PageNames.EMPTY_SHOP, new VCUrlMapping("No results", "shop", "empty-search.jsp"));
        urlMap.put(PageNames.PRODUCT, new VCUrlMapping("Product", "product", "product-detail.jsp"));
        urlMap.put(PageNames.TEST_USER_JSP, new VCUrlMapping("testUserJSP", "testUser", "TestTagUser.jsp"));
        urlMap.put(PageNames.CART, new VCUrlMapping("Cart", "cart", "cart.jsp"));
        urlMap.put(PageNames.EMPTY_CART, new VCUrlMapping("No items", "cart", "empty-cart.jsp"));
        urlMap.put(PageNames.CHECKOUT, new VCUrlMapping("Check out", "checkout", "checkout.jsp"));
//        urlMap.put(PageNames.MINI_CART, new VCUrlMapping("Mini Cart", "miniCart", "custom/mini-cart.jsp"));

        urlMap.put(PageNames.CONTACT_US, new VCUrlMapping("Contact Us ", "contact", "contact.jsp"));
        // ... add other pages
    }

    private final List<String> publicFolders = Arrays.asList(
            "video", "styles", "scripts", "images", "fonts", "audio"
    );

    private final Map<ServiceNames, ServiceUrlMapping> serviceMap = new HashMap<>();

    {
        serviceMap.put(ServiceNames.SIGN_OUT, new ServiceUrlMapping("SignOut", "signout"));
        serviceMap.put(ServiceNames.ERROR_REDIRECT, new ServiceUrlMapping("Error Redirect", "errorRedirect"));
        serviceMap.put(ServiceNames.PRODUCT_FETCH, new ServiceUrlMapping("Product Fetch", "productFetch"));
        serviceMap.put(ServiceNames.PRODUCT_ADD_TO_CART, new ServiceUrlMapping("Product Add To Cart", "addToCart"));
        serviceMap.put(ServiceNames.PRODUCT_REMOVE_FROM_CART, new ServiceUrlMapping("Product Remove From Cart", "removeFromCart"));
        serviceMap.put(ServiceNames.REMOVE_CART_ITEM, new ServiceUrlMapping("Remove cart item", "removeCartItem"));
        serviceMap.put(ServiceNames.PAYMENT, new ServiceUrlMapping("Checkout Payment", "payment"));
    }


    private static volatile UrlMappingConstants instance = null;

    private UrlMappingConstants() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static UrlMappingConstants getInstance() {
        if (instance == null) {
            synchronized (UrlMappingConstants.class) {
                if (instance == null) {
                    instance = new UrlMappingConstants();
                }
            }
        }
        return instance;
    }

    public String getTitle(PageNames page) {
        return urlMap.containsKey(page) ? urlMap.get(page).getTitle() : "Untitled pos";
    }

    // todo this should return one of 2 views admin's or user's
    public String getViewUrl(PageNames page) {
        return urlMap.containsKey(page) ? urlMap.get(page).getViewUrl() : null;
    }

    public String getControllerUrl(PageNames page) {
        return urlMap.containsKey(page) ? urlMap.get(page).getControllerUrl() : null;
    }

    public String getControllerName(PageNames page) {
        return urlMap.containsKey(page) ? urlMap.get(page).getControllerName() : null;
    }

    public String getServiceUrl(ServiceNames service) {
        return serviceMap.containsKey(service) ? serviceMap.get(service).getServiceUrl() : null;
    }

    public String getServiceName(ServiceNames service) {
        return serviceMap.containsKey(service) ? serviceMap.get(service).getServiceName() : null;
    }

    /**
     * to be a public jsp
     * you either not exist at all in the list (to handle the resources)
     * or you exist with a public jsp set to true (index.jsp for example)
     * each pass one must be true
     */
    public boolean isPublic(HttpServletRequest request) {
        boolean ret = false;
        final String url = request.getRequestURI();
        final String baseUrl = request.getContextPath();

        // check if it's a public controller
        ret |= isPublicControllerUrl(request);

        if (!ret)
            // check if it's public folder
            ret |= publicFolders.stream().anyMatch(folder -> url.startsWith(baseUrl + "/" + folder));

        if (!ret)
            // check if it's a public service
            ret |= isPublicService(request);

        // sanity check
        if (ret) {
            System.out.println(url + " is public");
        } else {
            System.out.println(url + " is not public");
        }

        return ret;
    }

    public boolean isPublicControllerUrl(HttpServletRequest request) {
        boolean ret = false;
        final String url = request.getRequestURI();
        final String baseUrl = request.getContextPath();

        // check if it's a controller
        if (!isAbsoluteUrl) {
            ret = urlMap.values().stream().anyMatch(mapping ->
                    url.equals(baseUrl + "/" + mapping.getControllerUrl())
                            && !mapping.isAdminOnly());
        } else {
            ret = urlMap.values().stream().anyMatch(mapping ->
                    url.equals(mapping.getControllerUrl())
                            && !mapping.isAdminOnly());
        }
        return ret;
    }

    public boolean isControllerUrl(HttpServletRequest request) {
        boolean ret = false;
        final String url = request.getRequestURI();
        final String baseUrl = request.getContextPath();

//        final String regex = "\\/(?!.*\\/)(.*)";
//        final Pattern pattern = Pattern.compile(regex);
//        final Matcher matcher = pattern.matcher(request.getRequestURI());
//        if (matcher.find()) {
//            var target = matcher.group(1);
//            ret |= urlMap.entrySet().stream().anyMatch(mapping -> (mapping.getValue().getControllerUrl().equals(target)));
//        }

        // check if it's a controller
        if (!isAbsoluteUrl) {
            ret = urlMap.entrySet().stream().anyMatch(mapping ->
                    url.equals(baseUrl + "/" + mapping.getValue().getControllerUrl()));
        } else {
            ret = urlMap.entrySet().stream().anyMatch(mapping ->
                    url.equals(mapping.getValue().getControllerUrl()));
        }
        return ret;
    }

    public boolean isPublicService(HttpServletRequest request) {
        final String url = request.getRequestURI();
        final String baseUrl = request.getContextPath();

        return serviceMap.values().stream()
                .anyMatch(service ->
                        url.equals(baseUrl + "/" + service.getServiceUrl())
                                && !service.isAdminOnly());
    }

    public boolean isService(HttpServletRequest request) {
        final String url = request.getRequestURI();
        final String baseUrl = request.getContextPath();

        return serviceMap.values().stream()
                .anyMatch(service ->
                        url.equals(baseUrl + "/" + service.getServiceUrl()));
    }

    public void makeUrlMappingAbsolute(String contextPath) {
        isAbsoluteUrl = true;
        System.out.println("urlMap = " + urlMap);
        for (var entry : urlMap.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            var newValue = new VCUrlMapping(value.getTitle(),
                    contextPath + "/" + value.getControllerUrl(), value.getControllerUrl(),
                    /*contextPath + "/" + */ value.getViewUrl(), value.isAdminOnly());
            urlMap.put(key, newValue);
        }
        System.out.println("urlMap = " + urlMap);
    }
}
