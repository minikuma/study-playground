package me.minikuma._03_behavioral_patterns._20_status._02_after;

public class Private implements Status {

    private final OnlineCourse onlineCourse;

    public Private(OnlineCourse onlineCourse) {
        this.onlineCourse = onlineCourse;
    }

    @Override
    public void addReview(String review, Student student) {
        if (this.onlineCourse.getStudents().contains(student)) {
            this.onlineCourse.getReviews().add(review);
        } else {
            throw new UnsupportedOperationException("PRIVATE 코스는 수강생만 리뷰를 남길 수 있음!");
        }
    }

    @Override
    public void addStudent(Student student) {
        if (student.isAvailable(onlineCourse)) {
            this.onlineCourse.getStudents().add(student);
        } else {
            throw new UnsupportedOperationException("PRIVATE 코스를 수강할 수 없음!");
        }
    }
}
