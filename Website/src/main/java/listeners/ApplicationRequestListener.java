package listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import managers.ReqCountManager;

@WebListener
public class ApplicationRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ApplicationSessionListener.requestDestroyed()");
		ReqCountManager.getInstance().incrementRequsts();
		ServletRequestListener.super.requestDestroyed(sre);
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ApplicationSessionListener.requestInitialized()");
		ServletRequestListener.super.requestInitialized(sre);
	}


}