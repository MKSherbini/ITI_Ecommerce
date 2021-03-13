package listeners;

import java.io.*;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import constants.UrlMappingConstants;
import constants.WebsiteConstants;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import managers.ReqCountManager;
import utilities.Serializer;

@WebListener
public class ApplicationLifeCycleListener implements ServletContextListener {
    public static String getFileContent(
            FileInputStream fis,
            String encoding) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(fis, encoding))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ApplicationLifeCycleListener.contextInitialized()");
        ServletContextListener.super.contextInitialized(sce);
        var applicationScope = sce.getServletContext();
        applicationScope.setAttribute("urlMappingConstants", UrlMappingConstants.getInstance());
        applicationScope.setAttribute("websiteConstants", WebsiteConstants.getInstance());

        try {
            FileInputStream fis = new FileInputStream("D:\\counter.xml");
            ReqCountManager m = Serializer.getInstance().deserializeXML(ReqCountManager.class, getFileContent(fis, "utf-8"));
            m.copytoSingleton();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ApplicationLifeCycleListener.contextDestroyed()");
        ServletContextListener.super.contextDestroyed(sce);
        Serializer.getInstance().serializeXML(ReqCountManager.class, "D:\\counter.xml");
        cleanupDrivers();
    }

    // clean up leaking resources
    void cleanupDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        Driver driver = null;

        // clear drivers
        while (drivers.hasMoreElements()) {
            try {
                driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // MySQL driver leaves around a thread. This static method cleans it up.
        AbandonedConnectionCleanupThread.uncheckedShutdown();
    }

}