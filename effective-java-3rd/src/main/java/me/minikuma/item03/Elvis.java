package me.minikuma.item03;

import java.io.Serializable;

/**
 * p23. public static final 필드 + private 생성자 = 싱글톤
 */
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();
    private static boolean created;

    private Elvis() {
        if (created) {
            throw new UnsupportedOperationException("Can't be created by constructor.");
        }
        created = true;
    }

    public void sing() {
        System.out.println("I'll sing!!");
    }

    protected Object readResolve() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.sing();
    }
}
