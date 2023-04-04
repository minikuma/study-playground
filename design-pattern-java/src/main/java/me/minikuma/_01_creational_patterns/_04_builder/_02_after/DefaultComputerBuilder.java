package me.minikuma._01_creational_patterns._04_builder._02_after;

import me.minikuma._01_creational_patterns._04_builder._01_before.Computer;
import me.minikuma._01_creational_patterns._04_builder._01_before.Options;

import java.util.ArrayList;
import java.util.List;

public class DefaultComputerBuilder implements ComputerBuilder {

    private String cpu;
    private String ram;
    private String ssd;
    private String graphicCard;
    private String power;
    private String mainBoard;
    private String monitor;
    private String keyBoard;
    private String mouse;
    private List<Options> optionsList;

    @Override
    public ComputerBuilder cpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder ram(String ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public ComputerBuilder ssd(String ssd) {
        this.ssd = ssd;
        return this;
    }

    @Override
    public ComputerBuilder graphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
        return this;
    }

    @Override
    public ComputerBuilder power(String power) {
        this.power = power;
        return this;
    }

    @Override
    public ComputerBuilder mainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
        return this;
    }

    @Override
    public ComputerBuilder addOption(String monitor, String keyBoard, String mouse) {
        if (monitor != null || keyBoard != null || mouse != null) {
            this.optionsList = new ArrayList<>();
        }
        this.optionsList.add(new Options(monitor, keyBoard, mouse));
        return this;
    }

    @Override
    public Computer getComputer() {
        return new Computer(cpu, ram, ssd, graphicCard, power, mainBoard, optionsList);
    }
}
