package me.minikuma._03_behavioral_patterns._22_template_method._02_after;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    private final String path;

    public FileProcessor(String path) {
        this.path = path;
    }

    public final int process(Operator operator) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            int result = 0;
            String line = null;
            while ((line = reader.readLine()) != null) {
                result = operator.getResult(result, Integer.parseInt(line));
            }
            return result;
        } catch (IOException ie) {
            throw new IllegalArgumentException(path + " 에 해당하는 파일이 존재하지 않습니다.", ie);
        }
    }

    // template method 기능을 추상화 함
//    protected abstract int getResult(int result, int lineNumber);
}
