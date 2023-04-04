package me.minikuma._03_behavioral_patterns._14_command._01_before;

// invoker
public class Button {
    private final Light light;

    public Button(Light light) {
        this.light = light;
    }

    public void press() {
        light.on();
    }

    public static void main(String[] args) {
        Button button = new Button(new Light()
        );
        button.press();
        button.press();
        button.press();
        button.press();
    }
}
