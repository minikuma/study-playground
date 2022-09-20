package me.rp.sec03.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderService {
    // callable -> 파일 내부를 한줄씩 읽어온다.
    private Callable<BufferedReader> openReader(Path path) {
        return () -> Files.newBufferedReader(path);
    }
    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
        return (br, sink) -> {
            try {
                String line = br.readLine();
                System.out.println("reading -- : " + line);
                // check
                if (Objects.isNull(line)) {
                    sink.complete();
                } else {
                    sink.next(line);
                }
            } catch (IOException e) {
                sink.error(e);
            }
            return br;
        };
    }
    // Consumer
    private Consumer<BufferedReader> closeReader() {
        return br -> {
            try {
                br.close();
                System.out.println("Closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public Flux<String> read(Path path) {
        return Flux.generate(
                openReader(path),
                read(),
                closeReader()

        );
    }
}
