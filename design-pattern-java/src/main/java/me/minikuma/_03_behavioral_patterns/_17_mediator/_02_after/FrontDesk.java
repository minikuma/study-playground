package me.minikuma._03_behavioral_patterns._17_mediator._02_after;

import java.time.LocalDateTime;

/**
 * 중재자
 */
public class FrontDesk {

    private final CleaningService cleaningService = new CleaningService();
    private final Restaurant restaurant = new Restaurant();
    public void getTowels(Guest guest, int numberOfTowels) {
        cleaningService.getTowels(guest.getId(), numberOfTowels);
    }

    public String getRoomNumberFor(int guestId) {
        return "1290";
    }

    public void dinner(Guest guest, LocalDateTime dataTime) {
        this.restaurant.dinner(guest.getId(), dataTime);
    }
}
