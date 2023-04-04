package me.minikuma._02_structual_patterns._08_composite._02_after;

public class Product implements Component {

    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

}
