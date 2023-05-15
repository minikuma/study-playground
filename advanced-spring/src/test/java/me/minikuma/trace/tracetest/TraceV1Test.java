package me.minikuma.trace.tracetest;

import me.minikuma.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TraceV1Test {
    @Test
    @DisplayName("시작로그와 출력 로그가 찍히는 지 확인한다.")
    void begin_end() {
        TraceV1 traceV1 = new TraceV1();
        TraceStatus status = traceV1.begin("log message test");
        traceV1.end(status);
    }

    @Test
    @DisplayName("시작로그와 예외 발생 로그가 찍히는 지 확인한다.")
    void begin_exception() {
        TraceV1 traceV1 = new TraceV1();
        TraceStatus status = traceV1.begin("log exception message test");
        traceV1.exception(status, new IllegalStateException());
    }

}