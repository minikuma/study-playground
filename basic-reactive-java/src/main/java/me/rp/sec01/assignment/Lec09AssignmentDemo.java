package me.rp.sec01.assignment;

import me.rp.courseutil.Util;

public class Lec09AssignmentDemo {
    public static void main(String[] args) {
        FileService.read("file01.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onCompleted());

        FileService.write("file01.txt", "This is file03")
                .subscribe(Util.onNext(), Util.onError(), Util.onCompleted());

        FileService.delete("file01.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onCompleted());
    }
}
