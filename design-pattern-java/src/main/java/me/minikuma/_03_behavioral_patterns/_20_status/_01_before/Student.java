package me.minikuma._03_behavioral_patterns._20_status._01_before;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;

    public Student(String name) {
        this.name = name;
    }

    private final List<OnlineCourse> privateCourses = new ArrayList<>();

    public boolean isEnabledForPrivate(OnlineCourse onlineCourse) {
        return privateCourses.contains(onlineCourse);
    }

    // 온라인 코드 등록
    public void addPrivateOnlineCourse(OnlineCourse onlineCourse) {
        this.privateCourses.add(onlineCourse);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
