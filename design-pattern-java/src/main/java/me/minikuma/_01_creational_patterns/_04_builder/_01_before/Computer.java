package me.minikuma._01_creational_patterns._04_builder._01_before;

import java.util.List;

public class Computer {
    private String cpu;
    private String ram;
    private String ssd;
    private String graphicCard;
    private String power;
    private String mainBoard;
    private List<Options> optionsList;

    public Computer() {

    }

    public Computer(String cpu, String ram, String ssd, String graphicCard, String power, String mainBoard, List<Options> optionsList) {
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        this.graphicCard = graphicCard;
        this.power = power;
        this.mainBoard = mainBoard;
        this.optionsList = optionsList;
    }

    public Computer(String cpu, String ram, String ssd, String graphicCard, String power, String mainBoard) {
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        this.graphicCard = graphicCard;
        this.power = power;
        this.mainBoard = mainBoard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public List<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<Options> optionsList) {
        this.optionsList = optionsList;
    }

    public void addOption(String monitor, String keyBoard, String mouse) {
        this.optionsList.add(new Options(monitor, keyBoard, mouse));
    }
}
