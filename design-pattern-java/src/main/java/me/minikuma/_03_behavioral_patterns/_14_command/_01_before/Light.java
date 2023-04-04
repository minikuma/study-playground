package me.minikuma._03_behavioral_patterns._14_command._01_before;

// receiver
public class Light {
    private boolean onState;

    public void on() {
        System.out.println("불을 켭니다.");
        this.onState = true;
    }

    public void off() {
        System.out.println("불을 끕니다.");
        this.onState = false;
    }

    public boolean isOnState() {
        return this.onState;
    }
}
