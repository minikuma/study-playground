package me.minikuma.app.v4;

import lombok.RequiredArgsConstructor;
import me.minikuma.trace.logtrace.LogTrace;
import me.minikuma.trace.template.AbstractTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepositoryV4;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                orderRepositoryV4.save(itemId);
                return null;
            }
        };

        template.execute("OrderService.orderItem()");
    }
}
