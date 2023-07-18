package me.minikuma.config.v6_aop;

import me.minikuma.config.AppV1Config;
import me.minikuma.config.AppV2Config;
import me.minikuma.config.v6_aop.aspect.LogTraceAspect;
import me.minikuma.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
