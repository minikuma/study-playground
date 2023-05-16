package me.minikuma.trace.tracetest;

import me.minikuma.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class TraceV2Test {
    @Test
    void sync_begin_end() {
        TraceV2 trace = new TraceV2();
        TraceStatus status1 = trace.begin("TraceV2 Test(1)");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "TraceV2 Test(2)");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void sync_begin_exception_end() {
        TraceV2 trace = new TraceV2();
        TraceStatus status1 = trace.begin("TraceV2 Exception Test(1)");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "TraceV2 Exception Test(2)");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}