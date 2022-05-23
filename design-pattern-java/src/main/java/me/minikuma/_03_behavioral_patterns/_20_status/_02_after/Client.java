package me.minikuma._03_behavioral_patterns._20_status._02_after;

public class Client {
    public static void main(String[] args) {
        OnlineCourse onlineCourse = new OnlineCourse();
        Student peter = new Student("peter");
        Student david = new Student("david");
        david.addPrivateCourse(onlineCourse);

        onlineCourse.addStudent(peter);
        onlineCourse.changeStatus(new Private(onlineCourse));
        onlineCourse.addReview("hello", peter);

        onlineCourse.addStudent(david);

        System.out.println("현재 온라인 수업 상태: " + onlineCourse.getStatus());
        System.out.println("현재 학생들: " + onlineCourse.getStudents());
        System.out.println("현재 리뷰들: " + onlineCourse.getReviews());
    }
}
