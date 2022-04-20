package me.minikuma._02_structual_patterns._07_bridge._02_after;

public abstract class DefaultShape {
    private final Drawing drawing;

    protected DefaultShape(Drawing drawing) {
        this.drawing = drawing;
    }

    public abstract void draw();

    public void drawLine(int x, int y) {
        drawing.drawLine(x, y);
    }

    public void fill() {
        drawing.fill();
    }
}
