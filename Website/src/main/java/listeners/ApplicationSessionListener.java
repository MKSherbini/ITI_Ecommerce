package listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import managers.ReqCountManager;
import utilities.Serializer;

@WebListener
public class ApplicationSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("ApplicationRequestListener.sessionCreated()");
        ReqCountManager.getInstance().incrementSessions();
        HttpSessionListener.super.sessionCreated(se);
        Serializer.getInstance().serializeXML(ReqCountManager.class, "D:\\counter.xml");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("ApplicationRequestListener.sessionDestroyed()");
        ReqCountManager.getInstance().decrementSessions();
        HttpSessionListener.super.sessionDestroyed(se);
        Serializer.getInstance().serializeXML(ReqCountManager.class, "D:\\counter.xml");
    }

}