package me.minikuma._03_behavioral_patterns._20_status._01_before;

import java.util.ArrayList;
import java.util.List;

public class OnlineCourse {

    // 상태
    public enum Status {
        DRAFT, PUBLISHED, PRIVATE
    }

    private Status status = Status.DRAFT; // 초기 상태
    private final List<String> reviews = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    // 리뷰 추가
    public void addReview(String review, Student student) {
        if (this.status == Status.PUBLISHED) {
            this.reviews.add(review);
        } else if (this.status == Status.PRIVATE && this.students.contains(student)) {
            this.reviews.add(review);
        } else {
            throw new UnsupportedOperationException("드래프트 상태에서는 리뷰를 작성할 수 없음!");
        }
    }

    // 학생 추가
    public void addStudent(Student student) {
        if (this.status == Status.DRAFT || this.status == Status.PUBLISHED) {
            this.students.add(student);
        } else if (this.status == Status.PRIVATE && availableTo(student)) {
            this.students.add(student);
        } else {
            throw new UnsupportedOperationException("학생을 수업에 등록할 수 없습니다.");
        }

        if (this.students.size() > 1) {
            this.status = Status.PRIVATE;
        }
    }

    public void changeStatus(Status newStatus) {
        this.status = newStatus;
    }

    public Status getStatus() {
        return status;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public List<Student> getStudents() {
        return students;
    }

    private boolean availableTo(Student student) {
        return student.isEnabledForPrivate(this);
    }
}
