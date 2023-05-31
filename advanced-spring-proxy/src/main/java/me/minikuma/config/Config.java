package me.minikuma.config;

import me.minikuma.trace.logtrace.LogTrace;
import me.minikuma.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
