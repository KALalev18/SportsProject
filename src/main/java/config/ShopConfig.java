package config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.DispatcherServlet;

public class ShopConfig {
    public void startUp(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) throws ServletException {

        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
                "/img",
                1024 * 1024 * 10,
                1024 * 1024 * 20,
                1024 * 1024
        );
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setMultipartConfig(multipartConfigElement);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
