package me.minikuma.app.v2;

import lombok.RequiredArgsConstructor;
import me.minikuma.trace.TraceStatus;
import me.minikuma.trace.tracetest.TraceV2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {
    private final OrderServiceV2 orderServiceV2;
    private final TraceV2 trace;

    @PostMapping("/v2/request")
    public String request(String itemId) {

        TraceStatus status = null;

        try {
            status = trace.begin("OrderController.request()");
            orderServiceV2.orderItem(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 던져 줘야 함!
        }

        return "OK";
    }
}
