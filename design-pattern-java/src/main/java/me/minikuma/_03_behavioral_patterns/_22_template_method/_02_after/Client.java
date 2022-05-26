package me.minikuma._03_behavioral_patterns._22_template_method._02_after;

public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new Plus("numbers.txt");
        int result = fileProcessor.process((result1, lineNumber) -> result1 += lineNumber);
        System.out.println("총 합계: " + result);
    }
}
