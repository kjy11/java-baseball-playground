package baseball.domain;

public class BallResult {

    private int ball = 0;
    private int strike = 0;

    public void report(BallStatus status) {
        if (status.isBall()) {
            ball += 1;
        }
        if (status.isStrike()) {
            strike += 1;
        }
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
