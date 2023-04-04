package me.minikuma._03_behavioral_patterns._21_strategy._01_before;

public class BlueLightRedLight {
    private final int speed;

    public BlueLightRedLight(int speed) {
        this.speed = speed;
    }

    public void blueLight() {
        if (speed == 1) {
            System.out.println("->");
        } else if (speed == 2) {
            System.out.println("-->");
        } else {
            System.out.println("--->");
        }
    }

    public void redLight() {
        if (speed == 1) {
            System.out.println("=>");
        } else if (speed == 2) {
            System.out.println("==>");
        } else {
            System.out.println("===>");
        }
    }
}
