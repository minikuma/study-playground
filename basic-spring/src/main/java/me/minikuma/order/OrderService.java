package me.minikuma.order;

public interface OrderService {
    // 주문
    Order createOrder(Long memberId, String productName, int productPrice);
}
