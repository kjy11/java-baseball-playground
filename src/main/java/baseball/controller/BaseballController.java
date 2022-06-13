package baseball.controller;

import baseball.domain.Baseball;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballController {

    Baseball baseball = new Baseball();

    public void startGame() {
        int retryInt = 1;
        while (retryInt == 1) {
            oneGame();
            retryInt = InputView.retryInput();
        }
    }

    public void oneGame() {
        baseball.init();
        while (baseball.getStrikeCount() < 3) {
            baseball.setInputArray(InputView.gameInput());
            baseball.checkInput();
            printOutput();
        }
    }

    private void printOutput() {
        ResultView.printResult(baseball.getBallCount(), baseball.getStrikeCount());
    }

}