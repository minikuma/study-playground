package me.minikuma.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.threadlocal.code.FieldService;
import me.minikuma.trace.threadlocal.utils.SleepUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class FieldServiceTest {
    private final FieldService fieldService = new FieldService();

    @Test
    @DisplayName("동시성의 문제가 발생하는 테스트")
    void field() {
        log.info("main start!");
        Runnable userA = new Runnable() {
            @Override
            public void run() {
                fieldService.logic("userA");
            }
        };

        Runnable userB = new Runnable() {
            @Override
            public void run() {
                fieldService.logic("userB");
            }
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        SleepUtils.sleep(100); // 동시성 오류 발생
        threadB.start();

        // TODO: CountLatch 활용하는 방법도 존재
        SleepUtils.sleep(3000);
        log.info("main exit!");
    }
}
