package me.config.autoconfig;

import me.config.ConditionalMyOnClass;
import me.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("io.undertow.Undertow")
public class UndertowWebServerConfig {
    @Bean(name = "undertowWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory webServerFactory() {
        return new UndertowServletWebServerFactory();
    }
}
