package me.minikuma._02_structual_patterns._11_flyweight._02_after;

public class Client {

    public static void main(String[] args) {
        FontFactory fontFactory = new FontFactory();
        Character c1 = new Character('m', "blue", fontFactory.getFont("hack:12"));
        Character c2 = new Character('i', "blue", fontFactory.getFont("hack:12"));
        Character c3 = new Character('n', "white", fontFactory.getFont("hack:12"));
        Character c4 = new Character('i', "white", fontFactory.getFont("hack:12"));
    }

}
