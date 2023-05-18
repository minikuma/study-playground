package me.minikuma.app.v3;

import lombok.RequiredArgsConstructor;
import me.minikuma.trace.TraceId;
import me.minikuma.trace.TraceStatus;
import me.minikuma.trace.logtrace.LogTrace;
import me.minikuma.trace.tracetest.TraceV2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
    private final LogTrace trace;
    // 저장
    public void save(String itemId) {
        TraceStatus status = null;

        try {
            status = trace.begin("OrderRepository.save()");

            if (itemId.equals("ex")) {
                throw new IllegalStateException("Exception");
            }
            // Validation
            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
