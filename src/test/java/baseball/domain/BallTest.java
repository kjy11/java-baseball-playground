package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    void 최댓값() {
        assertThat(Ball.isValid(9)).isTrue();
    }

    @Test
    void 최솟값() {
        assertThat(Ball.isValid(1)).isTrue();
    }

    @Test
    void 최대_초과() {
        assertThat(Ball.isValid(10)).isFalse();
    }

    @Test
    void 최소_미만() {
        assertThat(Ball.isValid(0)).isFalse();
    }

    @Test
    void 같은_값() {
        Ball answer = new Ball(2);
        Ball userBall = new Ball(2);
        assertThat(answer.equals(userBall)).isTrue();
    }

    @Test
    void 다른_값() {
        Ball answer = new Ball(2);
        Ball userBall = new Ball(4);
        assertThat(answer.equals(userBall)).isFalse();
    }
}
