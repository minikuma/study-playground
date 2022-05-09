package me.minikuma._03_behavioral_patterns._16_iterator._01_before;

import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        Board board = new Board();
        board.addPost("디자인 패턴");
        board.addPost("이터레이터 패턴");

        List<Post> posts = board.getPosts();

        Iterator<Post> iterator = posts.iterator();
        System.out.println(iterator.getClass());

        // iterator
        for (Post post : posts) {
            System.out.println(post.getTitle());
        }

        // sorting
        posts.sort((p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));

        // iterator
        for (Post post : posts) {
            System.out.println(post.getTitle());
        }
    }
}
