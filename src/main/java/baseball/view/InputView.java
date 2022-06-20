package baseball.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    public static int[] gameInput() {
        Scanner scanner = new Scanner(System.in);
        int[] inputArray;
        System.out.print("숫자를 입력해 주세요 : ");
        try {
            inputArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해 주세요.");
        }
        return inputArray;
    }

    public static String retryInput() {
        Scanner scanner = new Scanner(System.in);
        String retryInput = "";
        while (!retryInput.equals("1") && !retryInput.equals("2")) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            retryInput = scanner.nextLine();
        }
        return retryInput;
    }
}
