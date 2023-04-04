package me.minikuma.item01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
    주어진 리스트를 정렬하시오.
 */
public class ListQuiz {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(20);
        numbers.add(19);
        numbers.add(200);

        System.out.println(numbers.size());

        Comparator<Integer> desc = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        numbers.sort(desc.reversed());
        System.out.println(numbers);
    }
}
