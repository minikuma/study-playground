package me.minikuma._02_structual_patterns._12_proxy._02_after;

import me.minikuma._02_structual_patterns._12_proxy._01_before.OrderService;

public class OrderServiceProxy extends OrderService {

    @Override
    public void order() throws InterruptedException {
        long start = System.currentTimeMillis();
        super.order();
        System.out.println("elapsed time: " + (System.currentTimeMillis() - start));
    }
}
