package me.minikuma._03_behavioral_patterns._22_template_method._01_before;

public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor("numbers.txt");
        int result = fileProcessor.process();
        System.out.println("총 합계: " + result);
    }
}
