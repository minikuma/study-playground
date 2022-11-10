package me.minikuma.item09.subpress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    // 47 쪽 try-finally 가 자원을 회수하는 최선의 방법은 아니다.
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BadBufferedReader(new FileReader(path));
        // (case 1) try-with-resources 미적용
//        try {
//            return br.readLine();
//        } finally {
//            br.close();
//        }
        // (case 2) try-with-resource 적용
        try (br) {
            return br.readLine();
        }
    }
    // (case 1) 여러 에러 발생 시 가장 마지막 에러가 보인다.
    // (case 2) 여러 에러를 다 보여 준다.
    public static void main(String[] args) throws IOException {
        System.out.println(firstLineOfFile("build.gradle"));
    }
}
