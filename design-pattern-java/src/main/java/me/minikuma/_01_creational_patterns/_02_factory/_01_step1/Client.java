package me.minikuma._01_creational_patterns._02_factory._01_step1;

public class Client {
    public static void main(String[] args) {
        Coffee coffee1 = CoffeeFactory.makeCoffee("케냐AA", "ICE");
        System.out.println(coffee1);
        Coffee coffee2 = CoffeeFactory.makeCoffee("인도네시아", "HOT");
        System.out.println(coffee2);
    }
}
