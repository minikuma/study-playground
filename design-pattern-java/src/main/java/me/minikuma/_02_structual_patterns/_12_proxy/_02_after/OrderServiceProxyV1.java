package me.minikuma._02_structual_patterns._12_proxy._02_after;

public class OrderServiceProxyV1 implements OrderService {

    private OrderService orderService;

//    public OrderServiceProxyV1(OrderService orderService) {
//        this.orderService = orderService;
//    }

    @Override
    public void order() {
        long start = System.currentTimeMillis();
        if (this.orderService == null) {
            this.orderService = new DefaultOrderService();
        }
        orderService.order();
        System.out.println("elapsed time: " + (System.currentTimeMillis() - start));
    }
}
