package me.minikuma._03_behavioral_patterns._17_mediator._01_before;

public class Restaurant {

    private final CleaningService cleaningService = new CleaningService();

    public void dinner(Guest guest) {
        System.out.println("dinner: " + guest);
    }

    public void clean() {
        cleaningService.clean(this);
    }

}
