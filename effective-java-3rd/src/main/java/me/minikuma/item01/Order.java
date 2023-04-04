package me.minikuma.item01;

import java.util.Arrays;

public class Order {
    private boolean prime;
    private boolean urgent;
    private Product product;

    private OrderStatus orderStatus;

    public Order() {
        // default constructor
    }

    // 생성자를 이름이 고정된다.
    public Order(Product product, boolean prime) {
        this.product = product;
        this.prime = prime;
    }

    // 이름으로 명시적으로 표현하자.
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

    public static void main(String[] args) {
        OrderStatus[] orderStatuses = OrderStatus.values();
        Arrays.stream(orderStatuses).forEach(System.out::println);
        Order order = new Order();
        if (order.orderStatus == OrderStatus.DELIVERED) {
            System.out.println("delivered");
        }
    }
}
