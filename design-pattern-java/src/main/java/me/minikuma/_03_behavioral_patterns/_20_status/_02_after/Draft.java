package me.minikuma._03_behavioral_patterns._20_status._02_after;

public class Draft implements Status {

    private final OnlineCourse onlineCourse;

    public Draft(OnlineCourse onlineCourse) {
        this.onlineCourse = onlineCourse;
    }

    @Override
    public void addReview(String review, Student student) {
        throw new UnsupportedOperationException("드래프트 상태에서는 리뷰를 남길 수 없음!");
    }

    @Override
    public void addStudent(Student student) {
        this.onlineCourse.getStudents().add(student);
        if (onlineCourse.getStudents().size() > 1) {
            this.onlineCourse.changeStatus(new Private(this.onlineCourse));
        }
    }
}
