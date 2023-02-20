package me.minikuma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class BasicSpringBootApplication {
    /* Bean 제거 후 컴포넌트 스캔 활용
    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    @Bean
    public HelloService helloService() {
        return new SimpleHelloService();
    }*/

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    public static void main(String[] args) {
        // Spring Container 생성
        //MySpringApplication.run(BasicSpringBootApplication.class, args);
        SpringApplication.run(BasicSpringBootApplication.class, args);

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
