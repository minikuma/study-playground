package me.minikuma.app.v4;

import lombok.RequiredArgsConstructor;
import me.minikuma.trace.logtrace.LogTrace;
import me.minikuma.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {
    private final OrderServiceV4 orderServiceV4;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderServiceV4.orderItem(itemId);
                return "OK";
            }
        };
        return template.execute("OrderController.request()");
    }
}
