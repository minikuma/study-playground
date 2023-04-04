package me.minikuma.item09.puzzler;

import java.io.*;

public class Copy {

    private static final int BUFFER_SIZE = 8 * 1024;

    // 자바 퍼즐러 예제
   static void copy(String src, String dst) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dst);

        try {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf,0, n);
            }
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                // TODO 안전한가? 만약 IO Exception 이 발생하지 않으면 그냥 종료됨
            }
            try {
                in.close();
            } catch (IOException e) {

            }
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}
