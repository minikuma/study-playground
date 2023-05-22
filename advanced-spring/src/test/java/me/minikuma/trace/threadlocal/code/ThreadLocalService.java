package me.minikuma.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.threadlocal.utils.SleepUtils;

@Slf4j
public class ThreadLocalService {

    private final ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("저장 name={} ==> nameStore={}", name, nameStore.get());
        nameStore.set(name);

        SleepUtils.sleep(1000);

        String savedName = nameStore.get();
        nameStore.remove();

        log.info("조회 nameStore={}", savedName);
        return savedName;
    }
}
