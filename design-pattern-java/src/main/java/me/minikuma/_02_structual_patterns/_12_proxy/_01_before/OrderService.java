package me.minikuma._02_structual_patterns._12_proxy._01_before;

public class OrderService {
    public void order() throws InterruptedException {
        System.out.println("주문을 처리 중입니다.");
        Thread.sleep(1000L);
    }
}
