package constants;

import jakarta.servlet.http.HttpServletRequest;
import models.VCUrlMapping;
import constants.enums.PageNames;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlMappingConstants {
    private final Map<PageNames, VCUrlMapping> urlMap = new HashMap<>();
    private boolean isAbsoluteUrl = false;

    {
        urlMap.put(PageNames.HOME_PAGE, new VCUrlMapping("Home", "home", "index.jsp"));
        urlMap.put(PageNames.NOT_FOUND_404, new VCUrlMapping("Not Found", "404", "404.jsp"));
        // ... add other pages
    }

    private final List<String> publicFolders = Arrays.asList(
            "video", "styles", "scripts", "images", "fonts", "audio"
    );

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

        // check if it's a controller
        ret |= isControllerUrl(request);

        // check if it's public folder
        ret |= publicFolders.stream().anyMatch(folder -> url.startsWith(baseUrl + "/" + folder));

        // sanity check
        if (ret) {
            System.out.println(url + " is public");
        } else {
            System.out.println(url + " is not public");
        }

        return ret;
    }

    public void makeUrlMappingAbsolute(String contextPath) {
        isAbsoluteUrl = true;
        System.out.println("urlMap = " + urlMap);
        for (var entry : urlMap.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            var newValue = new VCUrlMapping(value.getTitle(),
                    contextPath + "/" + value.getControllerUrl(),
                    /*contextPath + "/" + */ value.getViewUrl());
            urlMap.put(key, newValue);
        }
        System.out.println("urlMap = " + urlMap);
    }
}
