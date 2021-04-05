package utilities;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listeners.ThreadLocalContext;

import java.io.IOException;

public class ErrorHandler {
    public static void forward(String statusCode, String errorMessage) throws IOException, ServletException {
        System.out.println("ErrorHandler.forward");
        //send error details
        ThreadLocalContext.setRequestAttribute("statusCode", statusCode);
        ThreadLocalContext.setRequestAttribute("errorMessage", errorMessage);
        ThreadLocalContext.forward(PageNames.Error);
    }
}
