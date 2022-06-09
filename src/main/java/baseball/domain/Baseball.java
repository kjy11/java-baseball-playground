package baseball.domain;

import java.util.Random;

public class Baseball {

    public int[] getNumberArray() {

        int[] numberArray = new int[3];
        for (int i = 0; i < 3; i++) {
            numberArray[i] = getRandomNumber(i, numberArray);
        }
        return numberArray;
    }

    private int getRandomNumber(int count, int[] preArray) {
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

    private boolean isDuplicated(int count, int[] preArray, int randomNumber) {
        for (int i = 0; i < count; i++) {
            if (preArray[i] == randomNumber) {
                return true;
            }
        }
        return false;
    }
}
