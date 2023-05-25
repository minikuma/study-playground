package me.minikuma.trace.template.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();
//        log.info("비즈니스 로직-1 실행");
        call();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        log.info("경과 시간 = {}", elapsedTime);
    }

    protected abstract void call();
}
