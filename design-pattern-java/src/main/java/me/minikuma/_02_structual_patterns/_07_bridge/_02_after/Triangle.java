package me.minikuma._02_structual_patterns._07_bridge._02_after;

public class Triangle extends DefaultShape {

    protected Triangle(Drawing drawing) {
        super(drawing);
    }

    @Override
    public void draw() {
        System.out.println("삼각형");
    }
}
