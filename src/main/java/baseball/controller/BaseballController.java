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
        int retryInt = 1;
        while (retryInt == 1) {
            oneGame();
            retryInt = InputView.retryInput();
        }
    }

    public void oneGame() {
        answers = RandomBallUtils.randomBalls();
        BallResult result = new BallResult();

        while (result.getStrike() < 3) {
            int[] input = InputView.gameInput();
            userBalls = new Balls(input[0], input[1], input[2]);
            result = answers.match(userBalls);
            printOutput(result.getBall(), result.getStrike());
        }
    }

    private void printOutput(int ballCount, int strikeCount) {
        ResultView.printResult(ballCount, strikeCount);
    }

}