package me.minikuma.trace.tracetest;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.Prefix;
import me.minikuma.trace.TraceId;
import me.minikuma.trace.TraceStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TraceV2 {

    // 시작 메시지
    // 예외 or 종료 메시지

    public TraceStatus begin(String message) {
        // trace id 생성
        TraceId traceId = new TraceId();
        // 시간 정보 필요
        long startMilliMs = System.currentTimeMillis();
        // 로그 출력
        log.info("[{}] {}{}", traceId.getId(), addSpace(Prefix.START_PREFIX.getValue(), traceId.getLevel()), message);
        return new TraceStatus(traceId, startMilliMs, message);
    }

    public TraceStatus beginSync(TraceId beforeTraceId, String message) {
        TraceId nextId = beforeTraceId.createNextId();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", nextId.getId(), addSpace(Prefix.START_PREFIX.getValue(), nextId.getLevel()), message);
        return new TraceStatus(nextId, startTimeMs, message);
    }

    public void end(TraceStatus traceStatus) {
        // 출력
        complete(traceStatus, null);
    }

    public void exception(TraceStatus traceStatus, Exception e) {
        // 출력
        complete(traceStatus, e);
    }

    private void complete(TraceStatus status, Exception e) {
        long stopTimeMs = System.currentTimeMillis();
        long elapsedTime = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();

        if (e == null) {
            log.info("[{}] {}{} time={} ms", traceId.getId(), addSpace(Prefix.COMPLETE_PREFIX.getValue(), traceId.getLevel()), status.getMessage(), elapsedTime);
        } else {
            log.info("[{}] {}{} time={} ms ex={}", traceId.getId(), addSpace(Prefix.EXCEPTION_PREFIX.getValue(), traceId.getLevel()), status.getMessage(), elapsedTime, e.toString());
        }
    }

    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append((i == level - 1) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }
}
