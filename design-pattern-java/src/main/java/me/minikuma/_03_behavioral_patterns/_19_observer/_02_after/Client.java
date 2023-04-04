package me.minikuma._03_behavioral_patterns._19_observer._02_after;

public class Client {
    public static void main(String[] args) {
        CharServer charServer = new CharServer();
        User user1 = new User("미니");
        User user2 = new User("쿠마");

        charServer.register("디자인 패턴", user1);
        charServer.register("디자인 패턴", user2);
        charServer.register("자바", user1);

        charServer.sendMessage(user1, "디자인 패턴", "옵저버 패턴입니다....");
        charServer.sendMessage(user2, "자바", "자바의 정석은 진리이다....");

        charServer.unRegister("자바", user1);
        charServer.sendMessage(user1, "자바", "해지 이후 자바의 정석? .....");
    }
}
