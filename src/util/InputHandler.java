package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(br.readLine().trim());
            } catch (NumberFormatException | IOException e) {
                System.out.println("❗️숫자를 입력해주세요.");
            }
        }
    }

    public static int getIntInputInRange(String message, int min, int max) {
        while (true) {
            int input = getIntInput(message);

            if (input >= min && input <= max) {
                return input;
            }

            System.out.println("❗️번호를 확인해주세요. (" + min + " ~ " + max + ")");
        }
    }

    public static int getPositiveIntInput(String message) {
        while (true) {
            int input = getIntInput(message);

            if (input > 0) {
                return input;
            }

            System.out.println("❗️0보다 큰 값을 입력해주세요.");
        }
    }
}
