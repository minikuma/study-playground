package me.minikuma.item08;

/**
 * 구현한 cleaner (안정망) try-with-resource 를 사용하지 않는 경우 사용가능함
 */
public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("아무렴");

        // GC 를 명시적으로 하게 되면 자원이 반납될 수도 있음
        System.gc();
    }
}
