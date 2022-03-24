package me.minikuma._01_creational_patterns._02_factory._01_step1;

/**
 * Factory Method 적용 전 코드
 */
public class CoffeeFactory {

    public static Coffee orderCoffee(String coffeeBean, String type) {
        // validator
        if (coffeeBean == null || coffeeBean.isBlank()) {
            throw new IllegalArgumentException("커피를 선택해 주세요.");
        }

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("ICE/HOT 를 선택해 주세요.");
        }

        // 커피 만들기
        Coffee coffee = new Coffee();
        coffee.setCoffeeBean(coffeeBean);
        coffee.setType(type);

        // 커피 준비중
        prepareFor(coffee.getCoffeeBean(), coffee.getType());

        // 주문완료 커피 알림
        notify(type, coffee);

        return coffee;
    }

    private static void prepareFor(String coffeeBean, String type) {
        System.out.println(coffeeBean + ", " + type + " 커피 준비 중!");
    }

    private static void notify(String type, Coffee coffee) {
        System.out.println(coffee.getCoffeeBean() + ", " + type + " 커피가 만들어졌습니다.");
    }
}
