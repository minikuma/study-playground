package me.minikuma._03_behavioral_patterns._21_strategy._02_after;

public class Client {
    public static void main(String[] args) {
        BlueLightRedLight blueLightRedLight = new BlueLightRedLight();
        blueLightRedLight.blueLight(new Faster());
        blueLightRedLight.redLight(new Normal());
    }
}
