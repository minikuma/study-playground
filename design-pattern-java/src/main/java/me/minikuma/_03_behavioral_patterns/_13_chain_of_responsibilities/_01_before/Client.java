package me.minikuma._03_behavioral_patterns._13_chain_of_responsibilities._01_before;

/**
 * 사용해야 될 핸들러를 사용자가 알아야 한다.
 */
public class Client {
    public static void main(String[] args) {
        Request request = new Request("요청 본문 입니다.");
//        RequestHandler requestHandler = new RequestHandler();
//        RequestHandler requestHandler = new AuthRequestHandler();
        RequestHandler requestHandler = new LogRequestHandler();
        requestHandler.handler(request);
    }
}
