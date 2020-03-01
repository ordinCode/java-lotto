package lotto.validator;

public class InputValidator {
	public static final String ERROR_MESSAGE_UNDER_ZERO = "0 이상의 수를 입력하세요.";
	public static final int MIN_NUMBER_LOTTO_GAME = 0;
	private static final String ERROR_MESSAGE_NOT_INTEGER = "숫자가 아닌 문자를 입력하였습니다.";

	public static void validateNumber(String inputMoney) {
		try {
			validatePositiveInteger(inputMoney);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INTEGER);
		}
	}

	private static void validatePositiveInteger(String inputMoney) {
		if (Integer.parseInt(inputMoney) < MIN_NUMBER_LOTTO_GAME) {
			throw new IllegalArgumentException(ERROR_MESSAGE_UNDER_ZERO);
		}
	}
}
