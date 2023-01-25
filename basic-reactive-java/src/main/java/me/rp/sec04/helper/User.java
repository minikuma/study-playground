package me.rp.sec04.helper;

import lombok.Data;
import lombok.ToString;
import me.rp.courseutil.Util;

@Data
@ToString
public class User {
    private int userId;
    private String name;

    // constructor
    public User(int userId) {
        this.userId = userId;
        this.name = Util.faker().name().firstName();
    }
}
