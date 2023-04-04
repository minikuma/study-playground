package me.minikuma._02_structual_patterns._09_decorator._02_after;

public class App {

    private static final boolean enabledSpamFilter = false;
    private static final boolean enabledTrim = false;

    public static void main(String[] args) {

        CommentService commentService = new DefaultCommentService();

        if (enabledSpamFilter) {
            commentService = new SpamFilteringDecorator(commentService);
        }

        if (enabledTrim) {
            commentService = new TrimmingDecorator(commentService);
        }

        Client client = new Client(commentService);
        client.writeComment("moon night");
        client.writeComment("마블이 이집트 신화까지...");
        client.writeComment("https://tistory.com");
    }
}
