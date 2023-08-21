package me.minikuma.aop.internal_call;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {
    private CallServiceV1 callServiceV1;

    /**
     *
     * @param callServiceV1
     * @Decription 생성자 주입으로 하면 순환 참조 발생 자기 자신을 주입 받는 구조
     *             setter 주입으로 해야 함
     */
    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        this.callServiceV1 = callServiceV1;
    }

    public void external() {
        log.info("call external");
        callServiceV1.internal(); // 내부 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
