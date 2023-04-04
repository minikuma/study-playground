package me.minikuma._01_creational_patterns._02_factory._02_step2;

public abstract class DefaultCoffeeFactory implements CoffeeFactory {
    @Override
    public void sendToCoffee(String coffeeBean, String type) {
        System.out.println(coffeeBean + ", " + type + " 준비 되었습니다.");
    }
}
