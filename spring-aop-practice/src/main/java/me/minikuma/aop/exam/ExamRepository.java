package me.minikuma.aop.exam;

import me.minikuma.aop.exam.annotation.Retry;
import me.minikuma.aop.exam.annotation.Trace;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Target;

@Repository
public class ExamRepository {
    private static int seq = 0;

    /**
     * 5번에 1번 실패하는 요청
     */
    @Trace
    @Retry(value = 4)
    public String save(String itemId) {
        seq++;
        if (seq % 5 == 0) {
            throw new IllegalStateException("예외 발생");
        }
        return "OK";
    }
}
