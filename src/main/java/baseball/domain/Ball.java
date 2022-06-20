package baseball.domain;

public class Ball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;

    public Ball(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 가능합니다.");
        }
        this.number = number;
    }

    public boolean equals(Ball ball) {
        return ball.isSameNumber(number);
    }

    private boolean isSameNumber(int number) {
        return this.number == number;
    }

    public static boolean isValid(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
}
