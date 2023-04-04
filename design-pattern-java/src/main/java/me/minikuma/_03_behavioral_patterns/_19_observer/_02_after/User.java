package me.minikuma._03_behavioral_patterns._19_observer._02_after;

public class User implements Subscriber {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void handleMessages(String message) {
        System.out.println(message);
    }
}
