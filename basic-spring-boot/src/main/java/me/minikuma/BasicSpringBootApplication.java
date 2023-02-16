package me.minikuma;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class BasicSpringBootApplication {
    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    @Bean
    public HelloService helloService() {
        return new SimpleHelloService();
    }

    public static void main(String[] args) {
        // Spring Container 생성
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            // 기능 확장
            @Override
            protected void onRefresh() {
                super.onRefresh();
                // 디스패치서블릿 등록 작업
                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

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
        applicationContext.register(BasicSpringBootApplication.class);
        applicationContext.refresh();

//[DispatcherServlet 적용을 위한 코드 정리]
//        WebServer webServer = serverFactory.getWebServer(new ServletContextInitializer() {
//            @Override
//            public void onStartup(ServletContext servletContext) throws ServletException {
        // HelloController helloController = new HelloController();
//                servletContext.addServlet("dispatcherServlet", new HttpServlet() {
//                    @Override
//                    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//                        // 인증, 보안, 다국어, 공통 기능 필요
//                        if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
//                            String name = req.getParameter("name"); // (1) Mapping
//
//                            HelloController helloController = applicationContext.getBean(HelloController.class);
//                            String ret = helloController.hello(name); // (2) Binding
//
//                            resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
//                            resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//                            resp.setStatus(HttpStatus.OK.value());
//
//                            resp.getWriter().println(ret);
//                        } else if (req.getRequestURI().equals("/user")) {
//                            // do something
//                        } else {
//                            resp.setStatus(HttpStatus.NOT_FOUND.value());
//                        }
//                    }
//                }).addMapping("/*");
//            }
//        });
//        webServer.start();
//    }
    }
}
