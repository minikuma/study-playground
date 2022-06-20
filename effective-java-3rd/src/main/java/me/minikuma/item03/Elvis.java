package me.minikuma.item03;

/**
 * p23. public static final 필드 + private 생성자 = 싱글톤
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {

    }

    public void sing() {
        System.out.println("I'll sing!!");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.sing();
    }
}
