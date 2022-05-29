package me.minikuma._03_behavioral_patterns._23_visitor._01_before;

public class Rectangle implements Shape {
    @Override
    public void printTo(Device device) {
        if (device instanceof Phone) {
            System.out.println("Print Rectangle to Phone");
        } else if (device instanceof Watch) {
            System.out.println("Print Rectangle to Watch");
        } else {
            System.out.println("Not Found");
        }
    }
}
