package study;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator {

    private final String ERROR_MSG = "유효하지 않은 입력입니다.";
    private OutputStream out;

    @BeforeEach
    void setOut() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void calculator() {
        InputStream in = new ByteArrayInputStream("2 + 3 * 4 / 2".getBytes());
        System.setIn(in);
        calculate();

        assertThat(out.toString()).isEqualTo("10");
    }

    @Test
    @DisplayName("유효하지 않은 연산자")
    void calculator_error1() {
        InputStream in = new ByteArrayInputStream("2 1 3 * 4 / 2".getBytes());
        System.setIn(in);
        calculate();

        assertThat(out.toString()).isEqualTo(ERROR_MSG);
    }

    @Test
    @DisplayName("유효하지 않은 길이")
    void calculator_error2() {
        InputStream in = new ByteArrayInputStream("2 + 3 * 4 / 2 +".getBytes());
        System.setIn(in);
        calculate();

        assertThat(out.toString()).isEqualTo(ERROR_MSG);
    }

    @Test
    @DisplayName("유효하지 않은 숫자")
    void calculator_error3() {
        InputStream in = new ByteArrayInputStream("a + 3 * 4 / 2 +".getBytes());
        System.setIn(in);
        calculate();

        assertThat(out.toString()).isEqualTo(ERROR_MSG);
    }

    private void calculate() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] values = input.split(" ");
        int result;

        if (values.length % 2 != 1) {
            System.out.print(ERROR_MSG);
            return;
        }

        try {
            result = calculate(values);
        } catch (IllegalArgumentException e) {
            System.out.print(ERROR_MSG);
            return;
        }

        System.out.print(result);
    }

    private int calculate(String[] values) {
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i <= values.length / 2; i++) {
            result = calculate(result, values[i * 2 - 1], Integer.parseInt(values[i * 2]));
        }
        return result;
    }

    private int calculate(int num1, String op, int num2) {
        if (op.equals("+")) {
            return num1 + num2;
        }
        if (op.equals("-")) {
            return num1 - num2;
        }
        if (op.equals("*")) {
            return num1 * num2;
        }
        if (op.equals("/")) {
            return num1 / num2;
        }
        throw new IllegalArgumentException();
    }
}
