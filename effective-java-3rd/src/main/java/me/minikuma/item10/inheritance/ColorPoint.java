package me.minikuma.item10.inheritance;

import me.minikuma.item10.color.Color;
import me.minikuma.item10.point.Point;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint)) {
            return false;
        }
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }

    public static void main(String[] args) {
        // 대칭성 위배
        Point point = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(point.equals(cp) + " " + cp.equals(point));

        // 추이성 위배
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s\n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}
