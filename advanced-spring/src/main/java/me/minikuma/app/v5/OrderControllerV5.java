package me.minikuma.app.v5;

import lombok.RequiredArgsConstructor;
import me.minikuma.trace.callback.TraceCallback;
import me.minikuma.trace.callback.TraceTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV5;
    private final TraceTemplate traceTemplate;

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return traceTemplate.execute("OrderController.request()", new TraceCallback<String>() {
            @Override
            public String call() {
                orderServiceV5.orderItem(itemId);
                return "OK";
            }
        });
    }
}
