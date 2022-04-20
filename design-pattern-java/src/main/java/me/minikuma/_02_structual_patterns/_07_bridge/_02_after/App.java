package me.minikuma._02_structual_patterns._07_bridge._02_after;

public class App {
    public static void main(String[] args) {
        DefaultShape rectangle = new Rectangle(new RectangleDrawing()); //composition
        DefaultShape triangle = new Triangle(new TriangleDrawing()); // composition

        rectangle.drawLine(1, 2);
        rectangle.draw();
        rectangle.fill();

        triangle.drawLine(5, 10);
        triangle.draw();
        triangle.fill();
    }
}
