package me.minikuma.item10.inheritance;

import me.minikuma.item10.Color;
import me.minikuma.item10.Point;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
    // 대칭성, 위배
//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof ColorPoint)) {
//            return false;
//        }
//        return super.equals(obj) && ((ColorPoint) obj).color == color;
//    }

    // 추이성 위배 (57쪽)
    @Override
    public boolean equals(Object o) {
        // Point 타입이 아닌 경우 필터링
        if (!(o instanceof Point)) {
            return false;
        }

        // Point 인 경우를 확인한다. (위험한 코드)
        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        // Color 타입의 속성까지 확인
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public static void main(String[] args) {
        // 대칭성 위배
//        Point point = new Point(1, 2);
//        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
//        System.out.println(point.equals(cp) + " " + cp.equals(point));

        // 추이성 위배
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s\n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}
