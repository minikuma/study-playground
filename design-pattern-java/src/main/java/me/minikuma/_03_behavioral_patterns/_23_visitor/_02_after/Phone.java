package me.minikuma._03_behavioral_patterns._23_visitor._02_after;

public class Phone implements Device {
    @Override
    public void print(Rectangle rectangle) {
        System.out.println("Print Rectangle to Phone");
    }

    @Override
    public void print(Triangle triangle) {
        System.out.println("Print Triangle to Phone");
    }
}
