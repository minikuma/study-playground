package me.minikuma._01_creational_patterns._02_factory._01_step1;

public class MegaCoffeeShop implements CafeFactory {
    @Override
    public Coffee createCoffee() {
        return new Coffee();
    }
}
