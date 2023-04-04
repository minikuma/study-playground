package me.minikuma._01_creational_patterns._05_prototype._02_after;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("minikuma");
        repository.setName("디자인패턴");

        GithubIssue issue = new GithubIssue(repository);
        issue.setId(1);
        issue.setTitle("디자인 패턴 - 프로토 타입");

        String url = issue.getUrl();
        System.out.println("url = " + url);

        // clone 사용
        GithubIssue clone = (GithubIssue) issue.clone();
        System.out.println("url(clone) = " + clone.getUrl());

        repository.setUser("새로운 유저");

        System.out.println(clone != issue);
        System.out.println(clone.equals(issue));
        System.out.println(clone.getClass() == issue.getClass());

        // shallow copy
        System.out.println(clone.getGithubRepository() == issue.getGithubRepository());
    }
}
