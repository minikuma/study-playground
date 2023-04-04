package me.minikuma._02_structual_patterns._09_decorator._02_after;

public class TrimmingDecorator extends CommentDecorator {

    public TrimmingDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        super.addComment(trim(comment));
    }

    private String trim(String comment) {
        return comment.replace("...", "");
    }
}
