package baseball.controller;

import baseball.domain.BallResult;
import baseball.domain.Balls;
import baseball.utils.RandomBallUtils;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballController {

    Balls answers;
    Balls userBalls;

    public void startGame() {
        String retryInput = "1";
        while (retryInput.equals("1")) {
            oneGame();
            retryInput = InputView.retryInput();
        }
    }

    public void oneGame() {
        answers = RandomBallUtils.randomBalls();
        boolean continueFlag = true;
        while (continueFlag) {
            continueFlag = playGame();
        }
    }

    private boolean playGame() {
        try {
            int[] input = InputView.gameInput();
            userBalls = new Balls(input[0], input[1], input[2]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        BallResult result = answers.match(userBalls);
        printOutput(result.getBall(), result.getStrike());
        return result.getStrike() != Balls.COUNT;
    }

    private void printOutput(int ballCount, int strikeCount) {
        ResultView.printResult(ballCount, strikeCount);
    }

}