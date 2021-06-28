package me.nimkoes;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MyWebConfig.class);
        context.refresh();

        // DispatcherServlet 을 만들 때 설정 정보를 가지고 있는 context 를 넘겨 준다.
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // ServletContext 에 DispatcherServlet 을 등록 한다.
        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);
        app.addMapping("/app/*");
    }
}
