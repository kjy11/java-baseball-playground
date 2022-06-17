package baseball.domain;

public class BallNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private int number;

    public BallNumber(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 가능합니다.");
        }
        this.number = number;
    }

    public static boolean isValid(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
}
