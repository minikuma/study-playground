package me.minikuma._01_creational_patterns._02_factory._01_step1;

public class Client {
    public static void main(String[] args) {

        Coffee coffee1 = new StarbucksShop().orderCoffee("콜롬비아", "HOT");
        System.out.println(coffee1);
        Coffee coffee2 = new StarbucksShop().orderCoffee("케냐AA", "ICE");
        System.out.println(coffee2);

        Coffee coffee3 = new MegaCoffeeShop().orderCoffee("과테말라", "ICE");
        System.out.println(coffee3);
        Coffee coffee4 = new MegaCoffeeShop().orderCoffee("인도네시아", "HOT");
        System.out.println(coffee4);
    }
}
