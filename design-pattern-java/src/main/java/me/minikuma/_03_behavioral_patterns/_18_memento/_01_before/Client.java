package me.minikuma._03_behavioral_patterns._18_memento._01_before;

public class Client {
    public static void main(String[] args) {
        Game game = new Game();
        game.setRedTeamScore(100);
        game.setBlueTeamScore(10);

        // 클라이언트가 내부 상태 정보를 구체적으로 알고 있어야 한다.
        int blueTeamScore = game.getBlueTeamScore();
        int redTeamScore = game.getRedTeamScore();

        Game restoredGame = new Game();
        restoredGame.setBlueTeamScore(blueTeamScore);
        restoredGame.setRedTeamScore(redTeamScore);
    }
}
