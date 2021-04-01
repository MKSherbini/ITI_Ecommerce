package utilities;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorHandler {
    public static void errorRedirect(HttpServletRequest req, HttpServletResponse res , String statusCode , String errorMessage) throws IOException, ServletException {
        //send error details
        req.setAttribute("statusCode", statusCode);
        req.setAttribute("errorMessage", errorMessage);
        req.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.Error)).forward(req, res);
    }
}
