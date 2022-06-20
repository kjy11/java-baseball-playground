package baseball.utils;

import baseball.domain.Balls;
import java.util.Random;

public class RandomBallUtils {

    public static Balls randomBalls() {
        int[] numberArray = new int[3];
        for (int i = 0; i < 3; i++) {
            numberArray[i] = getRandomNumber(i, numberArray);
        }
        return new Balls(numberArray[0], numberArray[1], numberArray[2]);
    }

    private static int getRandomNumber(int count, int[] preArray) {
        Random random = new Random();
        boolean flag = true;
        int randomNumber = 0;

        while (flag) {
            randomNumber = random.nextInt(9) + 1;
            if (isDuplicated(count, preArray, randomNumber)) {
                continue;
            }
            flag = false;
        }
        return randomNumber;
    }

    private static boolean isDuplicated(int count, int[] preArray, int randomNumber) {
        for (int i = 0; i < count; i++) {
            if (preArray[i] == randomNumber) {
                return true;
            }
        }
        return false;
    }

}
