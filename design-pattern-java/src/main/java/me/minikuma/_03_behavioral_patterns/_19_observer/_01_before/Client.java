package me.minikuma._03_behavioral_patterns._19_observer._01_before;

public class Client {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User user1 = new User(chatServer);
        user1.send("디자인 패턴", "공부중입니다....");
        user1.send("점심시간", "뭐 먹을까요?");

        User user2 = new User(chatServer);
        System.out.println(user2.get("디자인 패턴"));

        user1.send("디자인 패턴", "옵저버 패턴....");
        System.out.println(user2.get("디자인 패턴"));
    }
}
