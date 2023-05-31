package me.minikuma.app.v5;

import lombok.RequiredArgsConstructor;
import me.minikuma.trace.callback.TraceCallback;
import me.minikuma.trace.callback.TraceTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    private final TraceTemplate traceTemplate;

    public void orderItem(String itemId) {
        traceTemplate.execute("OrderService.orderItem()", (TraceCallback<Void>) () -> {
            orderRepositoryV5.save(itemId);
            return null;
        });
    }
}
