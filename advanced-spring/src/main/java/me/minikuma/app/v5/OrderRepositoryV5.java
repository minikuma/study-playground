package me.minikuma.app.v5;

import lombok.RequiredArgsConstructor;
import me.minikuma.trace.callback.TraceCallback;
import me.minikuma.trace.callback.TraceTemplate;
import me.minikuma.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV5 {
    private final TraceTemplate traceTemplate;
    // 저장
    public void save(String itemId) {

        traceTemplate.execute("OrderRepository.save()", new TraceCallback<Void>() {
            @Override
            public Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("Exception");
                }
                sleep(1000);
                return null;
            }
        });
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
