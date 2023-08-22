package me.minikuma.aop.internal_call;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {

    //private final ApplicationContext applicationContext;
    private final ObjectProvider<CallServiceV2> provider;

    public CallServiceV2(ObjectProvider<CallServiceV2> provider) {
        this.provider = provider;
    }

    public void external() {
        log.info("call external");
        provider.getObject().internal();
    }

    public void internal() {
        log.info("call internal");
    }
}
