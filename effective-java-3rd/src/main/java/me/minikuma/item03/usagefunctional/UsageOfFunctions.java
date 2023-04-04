package me.minikuma.item03.usagefunctional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsageOfFunctions {
    public static void main(String[] args) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1987, 8, 15));
        dates.add(LocalDate.of(1986, 10, 1));
        dates.add(LocalDate.of(1999, 2, 19));

        List<Integer> before2000 = dates.stream()
                .filter(d -> d.isBefore(LocalDate.of(2000, 1, 1)))
                .map(LocalDate::getYear)
                .collect(Collectors.toList());

        System.out.println(before2000);
    }
}
