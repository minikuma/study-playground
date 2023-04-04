package me.minikuma._03_behavioral_patterns._23_visitor._01_before;

public class Triangle implements Shape {
    @Override
    public void printTo(Device device) {
        if (device instanceof Phone) {
            System.out.println("Print Triangle to Phone");
        } else if (device instanceof Watch) {
            System.out.println("Print Triangle to Watch");
        } else {
            System.out.println("Not Found");
        }
    }
}
