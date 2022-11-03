package me.minikuma.item08;

/**
 * AutoClosable 로 자원을 정리함
 * */

public class Adult {
    public static void main(String[] args) throws Exception {
        try (Room myRoom = new Room(7)){
            System.out.println("안녕!");
        }
    }
}
