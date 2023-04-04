package me.minikuma.item03.serialization;

import java.io.*;
import java.time.LocalDate;

public class SerializationExample {

    // 직렬화
    private void serialize(Book book) {
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("book.obj"))) {
            out.writeObject(book);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 역 직력화
    private Book deserialize() {
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("book.obj"))) {
            return (Book) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Book book = new Book("1234", "삼국지 1권", "나관중", LocalDate.of(2021, 1, 1), 200);
        SerializationExample serializationExample = new SerializationExample();
        Book.name = "나";
        serializationExample.serialize(book);
        Book.name = "너";
        Book deserializeBook = serializationExample.deserialize();
        System.out.println(book);
        System.out.println(deserializeBook);
    }
}