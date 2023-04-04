package me.minikuma.item07.listner;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private final List<WeakReference<User>> users; // 잘못된 부분(*)

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(new WeakReference<>(user));
    }

    public void sendMessage(String message) {
        users.forEach(user -> {
            user.get().receive(message);
        });
    }

    public List<WeakReference<User>> getUsers() {
        return users;
    }
}
