package me.minikuma.trace.logtrace;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.trace.Prefix;
import me.minikuma.trace.TraceId;
import me.minikuma.trace.TraceStatus;

@Slf4j
public class FieldLogTrace implements LogTrace {

    private TraceId traceIdHolder; // TraceId 동기화, 동시성 이슈 발생

    private void syncTranceId() {
        if (traceIdHolder == null) {
            traceIdHolder = new TraceId();
        } else {
            traceIdHolder = traceIdHolder.createNextId();
        }
    }

    @Override
    public TraceStatus begin(String message) {
        // TraceId
        syncTranceId();
        // 시간 정보
        Long startTimeMs = System.currentTimeMillis();
        // 출력
        log.info("[{}] {}{}", traceIdHolder.getId(), addSpace(Prefix.START_PREFIX.getValue(), traceIdHolder.getLevel()), message);
        return new TraceStatus(traceIdHolder, startTimeMs, message);
    }

    @Override
    public void end(TraceStatus status) {
        complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        Long elapsedTime = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();

        if (e == null) {
            log.info("[{}] {}{} time={} ms", traceId.getId(), addSpace(Prefix.COMPLETE_PREFIX.getValue(), traceId.getLevel()), status.getMessage(), elapsedTime);
        } else {
            log.info("[{}] {}{} time={} ms ex={}", traceId.getId(), addSpace(Prefix.EXCEPTION_PREFIX.getValue(), traceId.getLevel()), status.getMessage(), elapsedTime, e.toString());
        }
        releaseTraceId();
    }

    private void releaseTraceId() {
        // 첫번째 레벨은 객체 관계를 정리해 준다.
        if (traceIdHolder.isFirstLevel()) {
            traceIdHolder = null;
        } else {
            // 첫번째 레벨이 아닌 경우 이런 레벨로 교체
            traceIdHolder = traceIdHolder.createPrevId();
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
