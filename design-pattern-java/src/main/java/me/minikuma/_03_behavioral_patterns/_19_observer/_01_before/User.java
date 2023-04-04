package me.minikuma._03_behavioral_patterns._19_observer._01_before;

import java.util.List;

public class User {
    private final ChatServer chatServer;

    public User(ChatServer chatServer) {
        this.chatServer = chatServer;
    }

    public void send(String subject, String message) {
        chatServer.add(subject, message);
    }

    public List<String> get(String subject) {
        return chatServer.getMessages(subject);
    }
}
