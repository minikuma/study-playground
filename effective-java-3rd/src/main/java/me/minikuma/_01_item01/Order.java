package me.minikuma._01_item01;

public class Order {
    private boolean prime;
    private boolean urgent;
    private Product product;

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
}
