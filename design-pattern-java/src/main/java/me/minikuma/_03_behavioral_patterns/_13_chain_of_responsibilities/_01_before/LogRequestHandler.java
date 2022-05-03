package me.minikuma._03_behavioral_patterns._13_chain_of_responsibilities._01_before;

public class LogRequestHandler extends RequestHandler {
    @Override
    public void handler(Request request) {
        System.out.println("로그 처리 기능");
        super.handler(request);
    }
}
