package lotto.view;

import java.util.Scanner;

public class InputView {
	private final static Scanner scanner = new Scanner(System.in);

	public static String inputMoney() {
		System.out.println("구매할 금액을 입력하세요.");
		return scanner.next();
	}
}
