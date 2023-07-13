package me.minikuma;

import me.minikuma.config.v4_postprocessor.BeanPostProcessorConfig;
import me.minikuma.trace.logtrace.LogTrace;
import me.minikuma.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(ProxyFactoryConfigV1.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV2.class)
@Import(BeanPostProcessorConfig.class)
@SpringBootApplication(scanBasePackages = "me.minikuma.app")
public class AdvancedSpringProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedSpringProxyApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
