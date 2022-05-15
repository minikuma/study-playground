package me.minikuma._03_behavioral_patterns._18_memento._02_after;

public class Client {
    public static void main(String[] args) {
        Game game = new Game();
        game.setRedTeamScore(100);
        game.setBlueTeamScore(100);

        GameSave save = game.save();
        game.setBlueTeamScore(1);
        game.setRedTeamScore(1);

        game.restore(save);

        System.out.println(game.getBlueTeamScore());
        System.out.println(game.getRedTeamScore());
    }
}
