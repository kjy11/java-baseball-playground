package baseball.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    public static int[] gameInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        return Arrays.stream(scanner.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    public static int retryInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int retryInt = scanner.nextInt();
            if (retryInt == 1 || retryInt == 2) {
                return retryInt;
            }
        }
    }
}
