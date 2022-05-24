package me.minikuma._03_behavioral_patterns._21_strategy._02_after;

/**
 * 컨텍스트 클래스
 */
public class BlueLightRedLight {

    public void blueLight(Speed speed) {
        speed.blueLight();
    }

    public void redLight(Speed speed) {
        speed.redLight();
    }
}
