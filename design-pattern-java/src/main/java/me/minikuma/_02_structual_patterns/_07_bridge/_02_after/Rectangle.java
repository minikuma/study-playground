package me.minikuma._02_structual_patterns._07_bridge._02_after;

public class Rectangle extends DefaultShape {

    protected Rectangle(Drawing drawing) {
        super(drawing);
    }

    @Override
    public void draw() {
        System.out.println("사각형");
    }
}
