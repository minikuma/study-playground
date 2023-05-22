package me.minikuma.trace.logtrace;

import me.minikuma.trace.TraceStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {
    ThreadLocalLogTrace trace;

    @BeforeEach
    void init() {
        this.trace = new ThreadLocalLogTrace();
    }

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("첫 번째 로그");
        TraceStatus status2 = trace.begin("두 번째 로그");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = trace.begin("첫 번째 에러 로그");
        TraceStatus status2 = trace.begin("두 번째 에러 로그");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}