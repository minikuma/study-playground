package me.minikuma.item01;

/**
 * 서비스 프로바이드 서비스 -> 실제 구현체는 다른 jar file 에 존재하는 경우
 */
public interface HelloService {
    String hello();

    static private void prepareMessage() {

    }

    static String hi() {
        prepareMessage();
        return "hi";
    }

    static String welcome() {
        prepareMessage();
        return "welcome";
    }

    static String bye() {
        prepareMessage();
        return "bye";
    }
}
