package me.minikuma.config;

import me.minikuma.trace.callback.TraceTemplate;
import me.minikuma.trace.logtrace.LogTrace;
import me.minikuma.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

    @Bean
    public TraceTemplate traceTemplate() {
        return new TraceTemplate(logTrace());
    }
}
