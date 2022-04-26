package me.minikuma._02_structual_patterns._09_decorator._01_before;

public class Client {

    private final CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    private void writeComment(String comment) {
        commentService.addComment(comment);
    }

    public static void main(String[] args) {
//        Client client = new Client(new CommentService());
//        Client client = new Client(new TrimmingCommentService());
        Client client = new Client(new SpamFilteringCommentService());
        client.writeComment("Moon Night");
        client.writeComment("이집트 신화를 마블이 표현해 내다니...");
        client.writeComment("https://tistory.com");
    }
}
