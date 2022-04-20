package me.minikuma._02_structual_patterns._07_bridge._01_before;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("삼각형");
    }

    @Override
    public void drawLine(int x, int y) {
        System.out.println("삼각형의 선을 " + x + " 에서" + y +" 까지 그린다.");
    }

    @Override
    public void fill() {
        System.out.println("삼각형을 채운다.");
    }
}
