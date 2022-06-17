package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallNumberTest {

    @Test
    void 최댓값() {
        assertThat(BallNumber.isValid(9)).isTrue();
    }

    @Test
    void 최솟값() {
        assertThat(BallNumber.isValid(1)).isTrue();
    }

    @Test
    void 최대_초과() {
        assertThat(BallNumber.isValid(10)).isFalse();
    }

    @Test
    void 최소_미만() {
        assertThat(BallNumber.isValid(0)).isFalse();
    }
}
