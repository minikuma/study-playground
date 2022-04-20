package me.minikuma._02_structual_patterns._07_bridge._01_before;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("사각형");
    }

    @Override
    public void drawLine(int x, int y) {
        System.out.println("사각형의 선을 " + x + " 에서" + y +" 까지 그린다.");
    }

    @Override
    public void fill() {
        System.out.println("사각형을 채운다.");
    }
}
