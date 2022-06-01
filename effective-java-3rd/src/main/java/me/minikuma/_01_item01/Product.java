package me.minikuma._01_item01;

public class Product {
    public static void main(String[] args) {
        Settings settings1 = Settings.newInstance();
        Settings settings2 = Settings.newInstance();

        System.out.println(settings1 == settings2); // 동일 객체 반환
    }
}
