package me.minikuma._01_creational_patterns._02_factory._02_step2;

public interface CoffeeFactory {

    default Coffee makeCoffee(String coffeeBean, String type) {
        validate(coffeeBean, type);
        prepareFor(coffeeBean, type);
        Coffee coffee = createCoffee();
        sendToCoffee(coffeeBean, type);
        return coffee;
    }

    Coffee createCoffee();

    private void validate(String coffeeBean, String type) {
        if (coffeeBean == null || coffeeBean.isBlank()) {
            throw new IllegalArgumentException("커피 원두를 선택해 주세요.");
        }

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("ICE 혹은 HOT 을 선택해 주세요.");
        }
    }

    private void prepareFor(String coffeeBean, String type) {
        System.out.println(coffeeBean + ", " + type + " 를 만들고 있습니다.");
    }

    private void sendToCoffee(String coffeeBean, String type) {
        System.out.println(coffeeBean + ", " + type + " 준비 되었습니다.");
    }
}
