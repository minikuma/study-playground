package me.minikuma._01_creational_patterns._02_factory._02_step2;

public class Client {
    public static void main(String[] args) {

        Client client = new Client();
        client.print(new StarbucksFactory(), "인도네시아", "HOT");
        client.print(new MegaCoffeeFactory(), "케냐AA", "ICE");
    }

    private void print(CoffeeFactory coffeeFactory, String coffeeBean, String type) {
        System.out.println(coffeeFactory.makeCoffee(coffeeBean, type));
    }
}
