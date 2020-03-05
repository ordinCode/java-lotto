package lotto.view;

import lotto.domain.PurchaseInfo;

import java.util.Scanner;

public class InputView {
	private final static Scanner scanner = new Scanner(System.in);

	public static String inputMoney() {
		System.out.println("구매할 금액을 입력하세요.");
		return scanner.next();
	}

	public static String inputManualLottoCount() {
		System.out.println("수동으로 구매할 로또의 수를 입력하세요.");
		return scanner.next();
	}

	public static String inputManualLottoNumber(PurchaseInfo purchaseInfo) {
		if (purchaseInfo.isManualLottoCountZero()) {
			return "";
		}

		System.out.println("수동으로 구매할 번호를 입력하세요.");
		return manualNumberBuild(purchaseInfo);
	}

	private static String manualNumberBuild(PurchaseInfo purchaseInfo) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < purchaseInfo.getManualLottoCount(); i++) {
			builder.append(scanner.next() + "\n");
		}
		return builder.toString();
	}

	public static String inputWinLotto() {
		System.out.println("이번주 당첨번호를 입력하세요.");
		return scanner.next();
	}

	public static String inputBonus() {
		System.out.println("보너스 번호를 입력하세요.");
		return scanner.next();
	}
}
