package me.minikuma._03_behavioral_patterns._20_status._01_before;

public class Client {
    public static void main(String[] args) {
        Student peter = new Student("peter");
        OnlineCourse onlineCourse = new OnlineCourse();

        Student david = new Student("david");
        david.addPrivateOnlineCourse(onlineCourse);

        onlineCourse.addStudent(peter);
        onlineCourse.changeStatus(OnlineCourse.Status.PRIVATE);
        onlineCourse.addReview("welcome", peter);

        onlineCourse.addStudent(david);
        onlineCourse.addReview("hello", david);

        System.out.println("현재 온라인 수업 상태: " + onlineCourse.getStatus());
        System.out.println("현재 학생들: " + onlineCourse.getStudents());
        System.out.println("현재 리뷰들: " + onlineCourse.getReviews());
    }
}
