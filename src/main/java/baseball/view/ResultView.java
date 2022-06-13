package baseball.view;

public class ResultView {

    public static void printResult(int ball, int strike) {
        StringBuilder sb = new StringBuilder();
        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }
        if (ball > 0) {
            sb.append(ball);
            sb.append("볼 ");
        }
        if (strike > 0 && strike < 3) {
            sb.append(strike);
            sb.append("스트라이크");
        }
        if (strike == 3) {
            sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        System.out.println(sb);
    }
}
