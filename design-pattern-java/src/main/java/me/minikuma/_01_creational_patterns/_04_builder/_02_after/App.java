package me.minikuma._01_creational_patterns._04_builder._02_after;

import me.minikuma._01_creational_patterns._04_builder._01_before.Computer;

import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        ComputerBuilder builder = new DefaultComputerBuilder();
        Computer computer = builder.cpu("인텔")
                .mainBoard("아수수")
                .graphicCard("지포스")
                .power("마이크로닉스")
                .ram("16G")
                .ssd("1TB")
                .getComputer();

        ComputerDirector director = new ComputerDirector(new DefaultComputerBuilder());
        director.orderComputer();
        director.orderComputerWithOptions();
    }
}
