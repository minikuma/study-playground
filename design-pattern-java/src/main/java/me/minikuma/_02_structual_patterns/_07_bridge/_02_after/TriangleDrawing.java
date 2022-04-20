package me.minikuma._02_structual_patterns._07_bridge._02_after;

public class TriangleDrawing implements Drawing {
    @Override
    public void drawLine(int x, int y) {
        System.out.println("삼각형의 선을 " + x + " 에서" + y +" 까지 그린다.");
    }

    @Override
    public void fill() {
        System.out.println("삼각형을 채운다.");
    }
}
