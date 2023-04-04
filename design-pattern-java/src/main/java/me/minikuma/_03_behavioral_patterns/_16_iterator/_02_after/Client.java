package me.minikuma._03_behavioral_patterns._16_iterator._02_after;

import me.minikuma._03_behavioral_patterns._16_iterator._01_before.Post;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {

        Board board = new Board();
        board.addPost("디자인 패턴");
        board.addPost("이터레이터 패턴");

        Iterator<Post> iterator = board.getDefaultIterator();

        // iterator
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }

        // 최근 글
        Iterator<Post> recentPostIterator = board.getRecentPostIterator();
        while (recentPostIterator.hasNext()) {
            System.out.println(recentPostIterator.next().getTitle());
        }
    }
}
