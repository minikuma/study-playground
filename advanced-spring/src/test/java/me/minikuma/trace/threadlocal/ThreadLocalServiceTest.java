package me.minikuma.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.threadlocal.code.ThreadLocalService;
import me.minikuma.trace.threadlocal.utils.SleepUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ThreadLocalServiceTest {

    private final ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    @DisplayName("스레드 로컬을 사용하여 동시성을 해결")
    void threadLocalServiceTest() {
        log.info("main start!");
        Runnable userA = new Runnable() {
            @Override
            public void run() {
                threadLocalService.logic("userA");
            }
        };

        Runnable userB = new Runnable() {
            @Override
            public void run() {
                threadLocalService.logic("userB");
            }
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        SleepUtils.sleep(10); // 동시성 오류 발생
        threadB.start();

        // TODO: CountLatch 활용하는 방법도 존재
        SleepUtils.sleep(3000);
        log.info("main exit!");
    }
}
