package me.minikuma._03_behavioral_patterns._13_chain_of_responsibilities._02_after;

import me.minikuma._03_behavioral_patterns._13_chain_of_responsibilities._01_before.Request;

public class Client {
    private final RequestHandler requestHandler;

    public Client(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void doWork() {
        Request request = new Request("본문 처리!");
        requestHandler.handler(request);
    }

    public static void main(String[] args) {
        // chain 구성
        RequestHandler chain = new AuthRequestHandler(new PrintRequestHandler(null));
        Client client = new Client(chain);
        client.doWork();
    }
}
