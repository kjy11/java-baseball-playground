package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Balls {

    private static final int COUNT = 3;

    private final List<Ball> balls;

    public Balls(int ball1, int ball2, int ball3) {
        balls = Arrays.asList(new Ball(ball1), new Ball(ball2), new Ball(ball3));
    }

    public Ball get(int index) {
        return balls.get(index);
    }

    public BallResult match(Balls otherBalls) {
        BallResult result = new BallResult();
        for (int i = 0; i < COUNT; i++) {
            result.report(match(i, otherBalls.get(i)));
        }
        return result;
    }

    private BallStatus match(int index, Ball otherBall) {
        BallStatus status = BallStatus.NOTHING;
        int i = 0;
        while (i < COUNT && status.isNothing()) {
            status = match(i, index, otherBall);
            i++;
        }
        return status;
    }

    private BallStatus match(int thisIndex, int otherIndex, Ball otherBall) {
        if (otherBall.equals(balls.get(thisIndex))) {
            return matchWhenNumberEquals(thisIndex, otherIndex);
        }
        return BallStatus.NOTHING;
    }

    private BallStatus matchWhenNumberEquals(int thisIndex, int otherIndex) {
        if (otherIndex == thisIndex) {
            return BallStatus.STRIKE;
        }
        return BallStatus.BALL;
    }
}
