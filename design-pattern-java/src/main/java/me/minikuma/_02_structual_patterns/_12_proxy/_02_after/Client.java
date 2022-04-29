package me.minikuma._02_structual_patterns._12_proxy._02_after;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        OrderService orderService = new OrderServiceProxyV1();
        orderService.order();
    }
}
