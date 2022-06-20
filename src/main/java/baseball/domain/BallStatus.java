package baseball.domain;

public enum BallStatus {

    NOTHING,
    BALL,
    STRIKE;

    public boolean isNothing() {
        return this == NOTHING;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }
}
