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
class CallServiceV3Test {

    @Autowired
    CallServiceV3 callServiceV3;

    @Test
    void external() {
        log.info("target = {}", callServiceV3.getClass()); // 프록시 객체 확인
        callServiceV3.external();
    }
}