package me.minikuma.item06;

public class Strings {
    public static void main(String[] args) {
        String hello = "hello";
        // 이 방법을 사용하지 않는다.
        String hello2 = new String("hello");
        String hello3 = "hello";

        System.out.println(hello == hello2);
        System.out.println(hello.equals(hello2));
        System.out.println(hello == hello3);
    }
}
