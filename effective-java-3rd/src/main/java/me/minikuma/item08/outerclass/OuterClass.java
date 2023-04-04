package me.minikuma.item08.outerclass;

import java.lang.reflect.Field;

/**
 * 중첩 클래스에서 cleaner 를 만드는 경우는 static 으로 만들어야 한다.
 */
public class OuterClass {
    public void hi() {

    }

    // 내부 클래스에서 바깥 클래스의 메서드를 참조 하기 위해서...
    class InnerClass {
        public void hello() {
            OuterClass.this.hi();
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();

        System.out.println(innerClass);

        outerClass.printField();
    }

    private void printField() {
        Field[] declaredFields = InnerClass.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field type :: " + field.getType());
            System.out.println("field name :: " + field.getName());
        }
    }
}
