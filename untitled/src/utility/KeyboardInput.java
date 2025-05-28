package utility;

import java.util.Scanner;

public class KeyboardInput {
    private static final Scanner scanner = new Scanner(System.in);

    private KeyboardInput() {
        // 생성자 private -> 인스턴스화 방지
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
