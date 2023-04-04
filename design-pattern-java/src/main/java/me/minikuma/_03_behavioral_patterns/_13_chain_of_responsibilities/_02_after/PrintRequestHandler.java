package me.minikuma._03_behavioral_patterns._13_chain_of_responsibilities._02_after;

import me.minikuma._03_behavioral_patterns._13_chain_of_responsibilities._01_before.Request;

public class PrintRequestHandler extends RequestHandler {
    public PrintRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handler(Request request) {
        System.out.println(request.getBody());
        super.handler(request);
    }
}
