package me.minikuma._01_creational_patterns._02_factory._01_step1;

public interface CafeFactory {

    default Coffee orderCoffee(String coffeeBean, String type) {
        // validation
        validate(coffeeBean, type);
        // prepare
        prepareFor(coffeeBean, type);
        // 객체 생성 - 하위 클래스에게 위임
        Coffee coffee = createCoffee();
        coffee.setCoffeeBean(coffeeBean);
        coffee.setType(type);
        // notify
        notify(type, coffee);

        return coffee;
    }

    Coffee createCoffee();

    // private method - validate
    private void validate(String coffeeBean, String type) {
        if (coffeeBean == null || coffeeBean.isBlank()) {
            throw new IllegalArgumentException("커피를 선택해 주세요.");
        }

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("ICE/HOT 를 선택해 주세요.");
        }
    }

    // private method - prepareFor
    private static void prepareFor(String coffeeBean, String type) {
        System.out.println(coffeeBean + ", " + type + " 커피 준비 중!");
    }

    // private method - notify
    private static void notify(String type, Coffee coffee) {
        System.out.println(coffee.getCoffeeBean() + ", " + type + " 커피가 만들어졌습니다.");
    }
}
