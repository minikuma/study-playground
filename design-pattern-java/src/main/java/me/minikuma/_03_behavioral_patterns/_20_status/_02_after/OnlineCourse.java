package me.minikuma._03_behavioral_patterns._20_status._02_after;

import java.util.ArrayList;
import java.util.List;

public class OnlineCourse {
    private Status status = new Draft(this);
    private final List<Student> students = new ArrayList<>();
    private final List<String> reviews = new ArrayList<>();

    public void addStudent(Student student) {
        this.status.addStudent(student);
    }

    public void addReview(String review, Student student) {
        this.status.addReview(review, student);
    }

    public Status getStatus() {
        return status;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void changeStatus(Private aPrivate) {
        this.status = aPrivate;
    }
}
