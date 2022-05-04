package me.minikuma._03_behavioral_patterns._14_command._02_after;

import me.minikuma._03_behavioral_patterns._14_command._01_before.Light;

import java.util.Stack;

public class Button {
    private final Stack<Command> commandStacks = new Stack<>();

//    public Button(Command command) {
//        this.command = command;
//    }

    public void press(Command command) {
        command.execute();
        commandStacks.push(command);
    }

    public void undo() {
        if (!commandStacks.isEmpty()) {
            Command command = commandStacks.pop();
            command.undo();
        }
    }

    public static void main(String[] args) {
        Button button = new Button();
        button.press(new LightOnCommand(new Light()));
        button.press(new LightOffCommand(new Light()));
        button.undo();
        button.undo();
    }
}
