package me.minikuma.web;

import lombok.RequiredArgsConstructor;
import me.minikuma.common.MyLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    //private final ObjectProvider<MyLogger> myLogger;
    private final MyLogger logger;

    @GetMapping("log-demo")
    public String logDemo(HttpServletRequest request) {;
        // MyLogger logger = this.myLogger.getObject();
        String requestURI = request.getRequestURI();
        System.out.println("logger.getClass() = " + logger.getClass());
        logger.setRequestUrl(requestURI);

        logger.log("Controller Test");
        logDemoService.logic("testId");
        return "OK";
    }
}
