package me.minikuma;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
    public static void run(Class<?> applicationClass, String... args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            // 기능 확장
            @Override
            protected void onRefresh() {
                super.onRefresh();
                // 디스패치서블릿 등록 작업
                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
                dispatcherServlet.setApplicationContext(this); // 없어도 됨 > 스프리이 컨테이너가 등록해줌

                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",
                                    new DispatcherServlet(this))
                            .addMapping("/*");
                });

                webServer.start();
            }
        };

        // applicationContext.registerBean(HelloController.class);
        // applicationContext.registerBean(SimpleHelloService.class);
        // applicationContext.register(BasicSpringBootApplication.class);
        applicationContext.register(applicationClass);
        applicationContext.refresh();
    }
}
