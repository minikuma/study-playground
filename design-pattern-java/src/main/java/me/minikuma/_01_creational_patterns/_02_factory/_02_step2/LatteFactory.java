package me.minikuma._01_creational_patterns._02_factory._02_step2;

public class LatteFactory extends DefaultCoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new Latte();
    }
}
