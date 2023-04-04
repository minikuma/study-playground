package me.minikuma.item08.autoclosable;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 권장하는 방법: AutoClosable 인터페이스 구현 필요
 */

public class AutoClosableIsGood implements AutoCloseable {
    private BufferedInputStream inputStream;

    // 편의를 위해 파일 내용을 출력하는 메서드 생성
    public void readFile(String filePath) {
        try {
            inputStream = new BufferedInputStream(new FileInputStream(filePath));
            StringBuilder sb = new StringBuilder();
            while (inputStream.available() > 0) {
                sb.append((char) inputStream.read());
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            System.out.println("Input Stream Resource closed");
            inputStream.close();
        } catch (IOException ie) {
            // 에러 변환
            throw new RuntimeException("Failed to close " + inputStream);
        }
    }
}
