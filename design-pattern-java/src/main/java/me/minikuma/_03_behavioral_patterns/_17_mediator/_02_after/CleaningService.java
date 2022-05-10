package me.minikuma._03_behavioral_patterns._17_mediator._02_after;

public class CleaningService {

    private final FrontDesk frontDesk = new FrontDesk();

    public void getTowels(int guestId, int numberOfTowels) {
        String roomNumber = this.frontDesk.getRoomNumberFor(guestId);
        System.out.println("provide " + numberOfTowels + " to " + roomNumber);
    }
}
