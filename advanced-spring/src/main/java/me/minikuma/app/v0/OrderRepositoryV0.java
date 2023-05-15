package me.minikuma.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {
    // 저장
    public void save(String itemId) {
        // Validation
        if (itemId.equals("ex")) {
            throw new IllegalStateException("Exception");
        }
        sleep(1000);
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
