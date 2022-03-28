package me.minikuma._01_creational_patterns._02_factory._01_step1;

public class CoffeeFactory {
    public static Coffee makeCoffee(String coffeeBean, String type) {
        // validate
        if (coffeeBean == null || coffeeBean.isBlank()) {
            throw new IllegalArgumentException("커피 원두를 선택해 주세요.");
        }

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("ICE 혹은 HOT 을 선택해 주세요.");
        }

        // prepare
        prepareFor(coffeeBean, type);

        Coffee coffee = new Coffee();
        coffee.setCoffeeBean(coffeeBean);
        coffee.setType(type);

        // customized
        if (coffeeBean.equalsIgnoreCase("케냐AA")) {
            coffee.setAroma("다크");
        } else if (coffeeBean.equalsIgnoreCase("인도네시아")) {
            coffee.setAroma("산미");
        }

        sendToCoffee(coffeeBean, type);

        return coffee;
    }

    private static void prepareFor(String coffeeBean, String type) {
        System.out.println(coffeeBean + ", " + type + " 를 만들고 있습니다.");
    }

    private static void sendToCoffee(String coffeeBean, String type) {
        System.out.println(coffeeBean + ", " + type + " 준비 되었습니다.");
    }
}
