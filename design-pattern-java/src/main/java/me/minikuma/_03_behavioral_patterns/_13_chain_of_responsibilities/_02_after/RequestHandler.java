package me.minikuma._03_behavioral_patterns._13_chain_of_responsibilities._02_after;

import me.minikuma._03_behavioral_patterns._13_chain_of_responsibilities._01_before.Request;

public abstract class RequestHandler {
    private final RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handler(Request request) {
        if (nextHandler != null) {
            nextHandler.handler(request);
        }
    }
}
