package me.minikuma._02_structual_patterns._09_decorator._02_after;

public class SpamFilteringDecorator extends CommentDecorator {

    public SpamFilteringDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        boolean isSpam = isSpam(comment);
        if (!isSpam) {
            super.addComment(comment);
        }
    }

    private boolean isSpam(String comment) {
        return comment.contains("http");
    }
}
