package me.minikuma;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BasicSpringBootApplication {
    public static void main(String[] args) {
        // Spring Container 생성
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        applicationContext.registerBean(HelloController.class);
        applicationContext.registerBean(SimpleHelloService.class);
        applicationContext.refresh();

        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                // HelloController helloController = new HelloController();
                servletContext.addServlet("frontController", new HttpServlet() {
                    @Override
                    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                        // 인증, 보안, 다국어, 공통 기능 필요
                        if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                            String name = req.getParameter("name"); // (1) Mapping

                            HelloController helloController = applicationContext.getBean(HelloController.class);
                            String ret = helloController.hello(name); // (2) Binding

                            resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                            resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
                            resp.setStatus(HttpStatus.OK.value());

                            resp.getWriter().println(ret);
                        } else if (req.getRequestURI().equals("/user")) {
                            // do something
                        } else {
                            resp.setStatus(HttpStatus.NOT_FOUND.value());
                        }
                    }
                }).addMapping("/*");
            }
        });
        webServer.start();
    }
}
