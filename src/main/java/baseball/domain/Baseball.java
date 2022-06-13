package baseball.domain;

import java.util.Random;

public class Baseball {
    private final int[] numberArray = new int[3];
    private int[] inputArray = new int[3];
    private int strikeCount = 0;
    private int ballCount = 0;

    public void setInputArray(int[] inputArray) {
        this.inputArray = inputArray;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void init() {
        makeNumberArray();
        ballCount = 0;
        strikeCount = 0;
        inputArray = new int[3];
    }

    public void makeNumberArray() {
        for (int i = 0; i < 3; i++) {
            numberArray[i] = getRandomNumber(i, numberArray);
        }
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

    public void checkInput() {
        ballCount = 0;
        strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                compareArrayElement(i, j);
            }
        }
    }

    private void compareArrayElement(int i, int j) {
        if (inputArray[i] == numberArray[j]) {
            if (i == j) {
                strikeCount += 1;
                return;
            }
            ballCount += 1;
        }
    }
}
