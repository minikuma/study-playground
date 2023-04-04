package me.minikuma._01_creational_patterns._04_builder._01_before;

public class OrderComputerApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setCpu("intel");
        computer.setGraphicCard("지포스");
        computer.setMainBoard("기가바이트");
        computer.setRam("삼성-32G");
        computer.setSsd("1TB");
        computer.setPower("마이크로닉스");
        computer.addOption("LG-32인치", "해피해킹", "로지텍");

        Computer anotherComputer = new Computer();
        anotherComputer.setCpu("셀러론");
        anotherComputer.setSsd("500G");
        anotherComputer.setMainBoard("아수스");
        anotherComputer.setPower("마이크로닉스");
        anotherComputer.setGraphicCard("라데온");
        anotherComputer.setRam("삼성-16GB");
    }
}
