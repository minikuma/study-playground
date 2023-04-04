package me.minikuma._02_structual_patterns._07_bridge._01_before;

public interface Shape {
    void draw();
    void drawLine(int x, int y); // action
    void fill(); // action
}
