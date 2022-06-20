package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    Balls answers;

    @BeforeEach
    void setAnswers() {
        answers = new Balls(1, 2, 3);
    }

    @Test
    void result_nothing() {
        Balls userBalls = new Balls(4, 5, 6);
        BallResult result = answers.match(userBalls);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void result_1ball_1strike() {
        Balls userBalls = new Balls(1, 3, 6);
        BallResult result = answers.match(userBalls);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void result_3strike() {
        Balls userBalls = new Balls(1, 2, 3);
        BallResult result = answers.match(userBalls);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }
}
