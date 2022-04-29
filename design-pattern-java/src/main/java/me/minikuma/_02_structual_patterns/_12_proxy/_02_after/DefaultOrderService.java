package me.minikuma._02_structual_patterns._12_proxy._02_after;

/**
 * real subject
 */
public class DefaultOrderService implements OrderService {
    @Override
    public void order() {
        System.out.println("주문을 처리 중입니다.");
    }
}
