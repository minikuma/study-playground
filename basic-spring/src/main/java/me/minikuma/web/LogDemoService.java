package me.minikuma.web;

import lombok.RequiredArgsConstructor;
import me.minikuma.common.MyLogger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    //private final ObjectProvider<MyLogger> myLogger;
    private final MyLogger logger;

    public void logic(String testId) {
        // MyLogger logger = this.myLogger.getObject();
        logger.log("service id = " + testId);
    }
}
