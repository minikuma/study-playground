package me.minikuma._01_creational_patterns._04_builder._02_after;

import me.minikuma._01_creational_patterns._04_builder._01_before.Computer;

public interface ComputerBuilder {

    ComputerBuilder cpu(String cpu);
    ComputerBuilder ram(String ram);
    ComputerBuilder ssd(String ssd);
    ComputerBuilder graphicCard(String graphicCard);
    ComputerBuilder power(String power);
    ComputerBuilder mainBoard(String mainBoard);
    ComputerBuilder addOption(String monitor, String keyBoard, String mouse);

    Computer getComputer();
}
