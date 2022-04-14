package me.minikuma._01_creational_patterns._05_prototype._01_before;

public class App {
    public static void main(String[] args) {
        GithubRepository githubRepository = new GithubRepository();
        githubRepository.setUser("minikuma");
        githubRepository.setName("design-pattern");

        GithubIssue githubIssue = new GithubIssue(githubRepository);
        githubIssue.setId(1);
        githubIssue.setTitle("디자인 패턴 강의 - 프로토타입");

        String url = githubIssue.getUrl();
        System.out.println("URL = " + url);

        // TODO clone != githubIssue
        // TODO clone.equals(githubIssue) => true
        // TODO clone.getClass() == githubIssue.getClass() => true (타입 같다)
    }
}
