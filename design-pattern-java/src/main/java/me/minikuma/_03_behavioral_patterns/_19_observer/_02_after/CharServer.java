package me.minikuma._03_behavioral_patterns._19_observer._02_after;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// observer
public class CharServer {

    private final Map<String, List<Subscriber>> subscribers = new HashMap<>();

    // 옵저버 등록
    public void register(String subject, Subscriber subscriber) {
        if (this.subscribers.containsKey(subject)) {
            this.subscribers.get(subject).add(subscriber);
        } else {
            List<Subscriber> subscriberList = new ArrayList<>();
            subscriberList.add(subscriber);
            this.subscribers.put(subject, subscriberList); // List.of 안됨 (불변)
        }
    }

    // 옵저버 해지
    public void unRegister(String subject, Subscriber subscriber) {
        if (this.subscribers.containsKey(subject)) {
            this.subscribers.get(subject).remove(subscriber);
        }
    }

    // 상태 변경
    public void sendMessage(User user, String subject, String message) {
        if (this.subscribers.containsKey(subject)) {
            this.subscribers.get(subject).forEach(s -> {
                String userMessage = user.getName().concat(":").concat(message);
                s.handleMessages(userMessage);
            });
        }
    }
}
