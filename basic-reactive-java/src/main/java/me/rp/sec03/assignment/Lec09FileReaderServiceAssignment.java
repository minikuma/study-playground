package me.rp.sec03.assignment;

import me.rp.courseutil.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec09FileReaderServiceAssignment {
    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderService();
        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
        readerService.read(path)
                .map(s -> {
                    int num = Util.faker().random().nextInt(0, 10);
                    if (num > 8) {
                        throw new RuntimeException("Error!");
                    }
                    return s;
                })
                .take(10)
                .subscribe(Util.subscriber());
    }
}
