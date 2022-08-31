package me.rp.sec01.assignment;

import jdk.jshell.spi.ExecutionControl;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * [Assignment] create FileService
 * - read file & return content
 * - create file & write content
 * - delete file
 *
 * File service method (subscribe)
 * Communicate the error to the subscriber in case of issues.
 *
 */
public class FileService {
    // 경로 지정
    private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");

    // publisher
    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    // subscriber
    public static Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> writeFile(fileName, content));
    }

    public static Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    // read file
    private static String readFile(String fileName) {
        try {
            return Files.readString(PATH.resolve(fileName)); //byte 로 읽어온다.
        } catch (IOException ie) {
            throw new RuntimeException(ie);
        }
    }

    // write file
    private static void writeFile(String fileName, String content) {
        try {
            Files.writeString(PATH.resolve(fileName), content);
        } catch (IOException ie) {
            throw new RuntimeException(ie);
        }
    }

    // delete file
    private static void deleteFile(String fileName) {
        try {
            Files.delete(PATH.resolve(fileName));
        } catch (IOException ie) {
            throw new RuntimeException(ie);
        }
    }


}
