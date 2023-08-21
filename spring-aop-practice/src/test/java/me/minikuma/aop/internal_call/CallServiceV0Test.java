package me.minikuma.aop.internal_call;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.aop.internal_call.aop.CallLogAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import({CallLogAspect.class})
@SpringBootTest
class CallServiceV0Test {

    @Autowired
    CallServiceV0 callServiceV0;

    @Test
    void external() {
        log.info("target = {}", callServiceV0.getClass()); // 프록시 객체 확인
        callServiceV0.external();
    }

    @Test
    void internal() {
        callServiceV0.internal();
    }
}