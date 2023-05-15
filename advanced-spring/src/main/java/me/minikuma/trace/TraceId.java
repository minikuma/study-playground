package me.minikuma.trace;

import java.util.UUID;

public class TraceId {
    private String id;
    private int level;

    // 초기화
    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    /**
     *
     * @return String
     * @Decription 아이디 생성
     */
    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    /**
     *
     * @return TraceGenerator
     * @Decription 다음 아이디 생성
     */
    public TraceId createNextId() {
        return new TraceId(this.id, this.level + 1);
    }

    /**
     *
     * @return TraceGenerator
     * @Decription 이전 아이디
     */
    public TraceId createPrevId() {
        return new TraceId(this.id, this.level - 1);
    }

    /**
     *
     * @return boolean
     * @Decription 첫 번재 레벨 체크
     */
    public boolean isFirstLevel() {
        return this.level == 0;
    }

    /**
     *
     * @return String
     * @Decription 아이디 조회
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return int
     * @Decription 레벨 조회
     */
    public int getLevel() {
        return level;
    }
}
