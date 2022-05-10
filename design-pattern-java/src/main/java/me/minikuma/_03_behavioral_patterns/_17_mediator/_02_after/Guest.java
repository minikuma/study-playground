package me.minikuma._03_behavioral_patterns._17_mediator._02_after;

import java.time.LocalDateTime;

public class Guest {

    private int id;
    private final FrontDesk frontDesk = new FrontDesk();

    public void getTowels(int numberOfTowels) {
        this.frontDesk.getTowels(this, numberOfTowels);
    }

    public void dinner(LocalDateTime dataTime) {
        this.frontDesk.dinner(this, dataTime);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
