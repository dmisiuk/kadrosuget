package by.minsler.infokadr.objectify;

import by.minsler.infokadr.dvo.Film;
import by.minsler.infokadr.dvo.Trailer;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 1:04 AM
 */
public class InitObjectify implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ObjectifyService.register(Film.class);
        ObjectifyService.register(Trailer.class);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
