package me.minikuma.app.v3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepositoryV3;

    @Autowired
    public OrderServiceV3(OrderRepositoryV3 orderRepositoryV3) {
        this.orderRepositoryV3 = orderRepositoryV3;
    }

    public void orderItem(String itemId) {
        orderRepositoryV3.save(itemId);
    }
}
