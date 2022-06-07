package me.minikuma.item01;

public enum OrderStatus {

    PREPARING(0), SHIPPED(1), DELIVERING(2), DELIVERED(3);

    private int num;

    OrderStatus(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
