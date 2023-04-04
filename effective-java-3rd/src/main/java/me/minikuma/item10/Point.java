package me.minikuma.item10;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 자신의 타입만을 비교하는 경우 추이성이 위배된다.(상속인 경우)
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        // 유입된 객체 타입이 Point 인지 확인
//        if (!(o instanceof Point)) {
//            return false;
//        }
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

    // 코드 10-4 잘못된 코드 - 리스코프 치환 (59쪽) 위배
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass()) {
//            return false;
//        }
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }
}
