package managers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import providers.database.Database;
import providers.database.DatabaseFactory;
import providers.database.DatabaseServerType;
import utilities.SafeConverter;

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
    private static final String defaultDummyUserInfoKey = "nb";


    public Optional<String> readCookie(HttpServletRequest request, String key) {
        if (request.getCookies() != null) {
            return Arrays.stream(request.getCookies())
                    .filter(c -> key.equals(c.getName()))
                    .map(Cookie::getValue)
                    .findAny();
        } else {
            return Optional.empty();
        }
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

    public void writeDummyUserInfoCookie(HttpServletResponse response, Long id) {
        String userInfo = id.toString() + ":" + "some random bs to make it look long and important and some more random bs to make it look long and important";
        String encodedUserInfo = Base64.getEncoder().encodeToString(userInfo.getBytes());

        writeCookie(response, defaultDummyUserInfoKey, encodedUserInfo, defaultAgeInDays);
    }

    public String readUserInfoCookie(HttpServletRequest request) {
        var cookie = readCookie(request, defaultUserInfoKey);
        if (cookie.isPresent()) {
            return new String(Base64.getDecoder().decode(cookie.get()));
        } else {
            return null;
        }
    }

    public Optional<Long> readDummyUserInfoCookie(HttpServletRequest request) {
        var cookie = readCookie(request, defaultDummyUserInfoKey);
        if (cookie.isPresent()) {
            var splits = new String(Base64.getDecoder().decode(cookie.get())).split(":");
            if (splits.length != 2) return Optional.empty();
            var ret = SafeConverter.safeLongParse(splits[0], -1L);
            if (ret == -1) return Optional.empty();
            return Optional.of(ret);
        } else {
            return Optional.empty();
        }
    }

    public void deleteUserInfoCookie(HttpServletResponse response) {
        writeCookie(response, defaultUserInfoKey, "", 0);
    }
}
