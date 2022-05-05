package me.minikuma._03_behavioral_patterns._15_interpreter._02_after;

import java.util.Map;

// Terminal Expression 정의
public class VariableExpression implements PostfixExpression {

    private final Character variable;

    public VariableExpression(Character variable) {
        this.variable = variable;
    }

    @Override
    public int interpret(Map<Character, Integer> context) {
        return context.get(variable);
    }
}
