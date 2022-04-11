package me.minikuma._01_creational_patterns._04_builder._02_after;

import me.minikuma._01_creational_patterns._04_builder._01_before.Computer;

public class ComputerDirector {
    private final ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer orderComputer() {
        return computerBuilder.cpu("인텔")
                .mainBoard("아수수")
                .graphicCard("지포스")
                .power("마이크로닉스")
                .ram("16G")
                .ssd("1TB")
                .getComputer();
    }

    public Computer orderComputerWithOptions() {
        return computerBuilder.cpu("인텔")
                .mainBoard("아수수")
                .graphicCard("지포스")
                .power("마이크로닉스")
                .ram("16G")
                .ssd("1TB")
                .addOption("LG-32", "리얼포스", "MS")
                .getComputer();
    }
}
