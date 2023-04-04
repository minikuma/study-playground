package me.minikuma._03_behavioral_patterns._21_strategy._02_after;

public class Faster implements Speed {
    @Override
    public void blueLight() {
        System.out.println("-->");
    }

    @Override
    public void redLight() {
        System.out.println("==>");
    }
}
