package me.minikuma._02_structual_patterns._11_flyweight._01_before;

/**
 * 편집기 프로그램
 * (문제) 문자가 많아질수록 객체의 생성이 많아짐 (비 효율적)
 */
public class Client {

    public static void main(String[] args) {
        Character c1 = new Character('m', "black", "Hack", 10);
        Character c2 = new Character('i', "black", "Hack", 10);
        Character c3 = new Character('n', "white", "Hack", 10);
        Character c4 = new Character('i', "white", "Hack", 10);
    }

}
