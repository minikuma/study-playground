package me.minikuma.item03.staticfactory;

/**
 * 싱글톤 만들기 - private 생성 + static method
 */
public class Elvis implements Singer {
    private Elvis() {

    }

    private static final Elvis INSTANCE = new Elvis();

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
    }

    @Override
    public void sing() {
        System.out.println("my way~~");
    }
}
