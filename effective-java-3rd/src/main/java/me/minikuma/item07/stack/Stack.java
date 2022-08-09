package me.minikuma.item07.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    // 스택 저장
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 스택 꺼내기 (문제 - 메모리 누수 가능성)
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    public Object newPop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // 객체 해지
        return result;
    }

    /**
     * 배열 공간 확인
     * 배열 크기를 늘려야 하는 경우 대략 2배씩 증가 (더블링)
     */
    public void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args) {
            stack.push(arg);
        }

        while (true) {
            System.out.println("data :: " + stack.pop());
        }
    }
}
