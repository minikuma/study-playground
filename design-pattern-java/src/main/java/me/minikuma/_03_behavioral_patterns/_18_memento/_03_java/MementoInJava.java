package me.minikuma._03_behavioral_patterns._18_memento._03_java;

import me.minikuma._03_behavioral_patterns._18_memento._02_after.Game;

import java.io.*;

public class MementoInJava {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Game game = new Game();
        game.setRedTeamScore(100);
        game.setBlueTeamScore(100);

        try (FileOutputStream fo = new FileOutputStream("GameSave.hex")) {
            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(game);
        }
        // 값 변경
        game.setBlueTeamScore(11);
        game.setRedTeamScore(11);

        try (FileInputStream fi = new FileInputStream("GameSave.hex")) {
            ObjectInputStream in = new ObjectInputStream(fi);
            game = (Game) in.readObject();
            System.out.println(game.getRedTeamScore());
            System.out.println(game.getBlueTeamScore());
        }
    }
}
