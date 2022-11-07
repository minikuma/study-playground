package me.minikuma.item08.outerclass;

import java.lang.reflect.Field;

public class LambdaExample {
    private int value = 0;

    private Runnable instanceLambda = () -> {
        System.out.println(value);
    };

    public static void main(String[] args) {
        LambdaExample lambdaExample = new LambdaExample();
        Field[] declaredFields = lambdaExample.instanceLambda.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field type :: " + field.getType());
            System.out.println("field name :: " + field.getName());
        }
    }
}
