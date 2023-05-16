package me.minikuma.app.v2;

import lombok.RequiredArgsConstructor;
import me.minikuma.trace.TraceId;
import me.minikuma.trace.TraceStatus;
import me.minikuma.trace.tracetest.TraceV2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
    private final TraceV2 trace;
    // 저장
    public void save(TraceId traceId, String itemId) {
        TraceStatus status = null;

        try {
            status = trace.beginSync(traceId, "OrderRepository.save()");

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
