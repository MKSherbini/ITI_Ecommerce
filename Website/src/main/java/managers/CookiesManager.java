package managers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import providers.database.Database;
import providers.database.DatabaseFactory;
import providers.database.DatabaseServerType;

import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

public class CookiesManager {
    private static volatile CookiesManager instance = null;

    private CookiesManager() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static CookiesManager getInstance() {
        if (instance == null) {
            synchronized (CookiesManager.class) {
                if (instance == null) {
                    instance = new CookiesManager();
                }
            }
        }
        return instance;
    }

    private static final int secondsToDays = 60 * 60 * 24;
    private static final int defaultAgeInDays = 14;
    private static final String defaultUserInfoKey = "sb";

    public Optional<String> readCookie(HttpServletRequest request, String key) {
        return Arrays.stream(request.getCookies())
                .filter(c -> key.equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }

    public void writeCookie(HttpServletResponse response, String key, String value) {
        writeCookie(response, key, value, defaultAgeInDays);
    }

    public void writeCookie(HttpServletResponse response, String key, String value, int ageInDays) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(ageInDays * secondsToDays);
        response.addCookie(cookie);
    }

    public void writeUserInfoCookie(HttpServletResponse response, String email, String password) {
        String userInfo = email + ":" + password;
        String encodedUserInfo = Base64.getEncoder().encodeToString(userInfo.getBytes());

        writeCookie(response, defaultUserInfoKey, encodedUserInfo, defaultAgeInDays);
    }

    public void readUserInfoCookie(HttpServletRequest request) {
        var cookie = readCookie(request, defaultUserInfoKey);
        if (cookie.isPresent()) {
            var value = new String(Base64.getDecoder().decode(cookie.get()));
            System.out.println("value.split(\":\") = " + Arrays.toString(value.split(":")));
        }
    }
}
