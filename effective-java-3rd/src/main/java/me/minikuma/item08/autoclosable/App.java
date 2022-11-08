package me.minikuma.item08.autoclosable;

public class App {
    public static void main(String[] args) {
        try (AutoClosableIsGood good = new AutoClosableIsGood()) {
            // AutoClosable 을 구현한 클래스의 close 메서드를 호출해서 자원해지 함
            good.readFile("myText.txt");
        }
    }
}
