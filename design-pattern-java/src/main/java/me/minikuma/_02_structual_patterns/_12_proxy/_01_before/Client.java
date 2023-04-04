package me.minikuma._02_structual_patterns._12_proxy._01_before;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        OrderService orderService = new OrderService();
        // order start
        orderService.order();
        // order end
    }
}
