package me.minikuma._01_creational_patterns._02_factory._01_step1;

/**
 * Factory Method 적용 전 코드
 */
public class StarbucksShop implements CafeFactory {
    @Override
    public Coffee createCoffee() {
        return new Coffee();
    }
}
