package me.minikuma.app.v1;

import lombok.RequiredArgsConstructor;
import me.minikuma.trace.TraceStatus;
import me.minikuma.trace.tracetest.TraceV1;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV1 orderServiceV1;
    private final TraceV1 trace;

    @PostMapping("/v1/request")
    public String request(String itemId) {

        TraceStatus status = null;

        try {
            status = trace.begin("OrderController.request()");
            orderServiceV1.orderItem(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 던져 줘야 함!
        }

        return "OK";
    }
}
