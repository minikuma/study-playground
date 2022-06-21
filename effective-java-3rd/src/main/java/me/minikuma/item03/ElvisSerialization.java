package me.minikuma.item03;

import java.io.*;

/**
 *  역 직렬화로 인해 여러 객체가 생성
 */
public class ElvisSerialization {
    public static void main(String[] args) throws RuntimeException {
        // 직렬화
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
            out.writeObject(Elvis.INSTANCE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 역 직렬화
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))) {
            Elvis elvis = (Elvis) in.readObject();
            System.out.println((elvis == Elvis.INSTANCE) ? "동일 객체" : "다른 객체");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
