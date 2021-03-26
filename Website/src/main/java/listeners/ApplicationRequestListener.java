package listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import managers.DatabaseManager;

@WebListener
public class ApplicationRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ApplicationSessionListener.requestInitialized()");
//        var db = DatabaseManager.getInstance();
//        db.beginTransaction();
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ApplicationSessionListener.requestDestroyed()");
//        var db = DatabaseManager.getInstance();
//        db.endTransaction();
    }


}