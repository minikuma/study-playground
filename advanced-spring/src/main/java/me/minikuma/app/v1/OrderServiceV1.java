package me.minikuma.app.v1;

import lombok.RequiredArgsConstructor;
import me.minikuma.trace.TraceStatus;
import me.minikuma.trace.tracetest.TraceV1;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepositoryV1;
    private final TraceV1 trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;

        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepositoryV1.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
