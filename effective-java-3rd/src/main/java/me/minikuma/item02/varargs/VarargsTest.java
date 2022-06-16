package me.minikuma.item02.varargs;

import java.util.Arrays;

public class VarargsTest {
    public void printNumbers(int... numbers) {
        System.out.println(numbers.getClass().getCanonicalName());
        System.out.println(numbers.getClass().getComponentType());
        Arrays.stream(numbers).forEach(System.out::println);
    }

    // Heap Pollution
    public static void main(String[] args) {
        VarargsTest varargsTest = new VarargsTest();
        varargsTest.printNumbers(1, 30, 20, 40); // 배열
    }
}
