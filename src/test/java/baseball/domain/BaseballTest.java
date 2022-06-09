package baseball.domain;

import org.junit.jupiter.api.Test;

public class BaseballTest {

    Baseball baseball = new Baseball();

    @Test
    void getNumberArray() {
        int[] array = baseball.getNumberArray();
        for (int i = 0; i < 3; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
