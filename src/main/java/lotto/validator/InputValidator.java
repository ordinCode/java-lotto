package lotto.validator;

public class InputValidator {

	public static final String ERROR_MESSAGE_NOT_INT = "숫자가 아닌 문자를 입력하였습니다.";

	public static void validateInt(String input) {
		String pattern = "^[0-9]+$";
		if (!input.matches(pattern)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INT);
		}
	}
}
