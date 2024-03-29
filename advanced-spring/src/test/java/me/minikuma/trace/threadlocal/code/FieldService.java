package me.minikuma.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.threadlocal.utils.SleepUtils;

@Slf4j
public class FieldService {
    private String nameStore;

    public String logic(String name) {
        log.info("저장 name={} ==> nameStore={}", name, nameStore);
        nameStore = name;
        SleepUtils.sleep(1000);
        log.info("조회 nameStore={}", nameStore);
        return nameStore;
    }
}
