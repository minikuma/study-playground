package me.minikuma._03_behavioral_patterns._17_mediator._02_after;

import java.time.LocalDateTime;

public class Restaurant {

    private final FrontDesk frontDesk = new FrontDesk();

    public void dinner(int id, LocalDateTime dataTime) {
        String roomNumber = this.frontDesk.getRoomNumberFor(id);
        System.out.println("charge to " + roomNumber + "Hours of use: " + dataTime);
    }
}
