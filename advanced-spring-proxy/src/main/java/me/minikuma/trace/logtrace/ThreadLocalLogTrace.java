package me.minikuma.trace.logtrace;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.Prefix;
import me.minikuma.trace.TraceId;
import me.minikuma.trace.TraceStatus;

@Slf4j
public class ThreadLocalLogTrace implements LogTrace {

    private final ThreadLocal<TraceId> traceHolder = new ThreadLocal<>();

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        TraceId traceId = traceHolder.get();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(Prefix.START_PREFIX.getValue(), traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    @Override
    public void end(TraceStatus status) {
        complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    public void syncTraceId() {
        TraceId traceId = traceHolder.get();
        if (traceId == null) {
            traceHolder.set(new TraceId());
        } else {
            traceHolder.set(traceId.createNextId());
        }
    }

    public void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        Long elapsedTime = stopTimeMs - status.getStartTimeMs();

        TraceId traceId = traceHolder.get();

        if (e == null) {
            log.info("[{}] {}{} time={} ms", traceId.getId(), addSpace(Prefix.COMPLETE_PREFIX.getValue(), traceId.getLevel()), status.getMessage(), elapsedTime);
        } else {
            log.info("[{}] {}{} time={} ms ex={}", traceId.getId(), addSpace(Prefix.EXCEPTION_PREFIX.getValue(), traceId.getLevel()), status.getMessage(), elapsedTime, e.toString());
        }

        releaseTraceId();
    }

    private void releaseTraceId() {
        TraceId traceId = traceHolder.get();

        // 레벨이 0 (첫번째 레벨)인 경우
        if (traceId.isFirstLevel()) {
            // 하나의 트랜젝션이 끝남 > 다음 로그를 위해 스레드 로컬 remove
            traceHolder.remove();
        } else {
            // 첫 번째가 아닌 경우 레벨 -1 해준다.
            traceHolder.set(traceId.createPrevId());
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
