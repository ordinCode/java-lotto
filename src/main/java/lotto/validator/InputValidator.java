package lotto.validator;

public class InputValidator {
	public static void validateInt(String input) {
		String pattern = "^[0-9]+$";
		if (!input.matches(pattern)) {
			throw new IllegalArgumentException("숫자가 아닌 문자를 입력하였습니다.");
		}
	}
}
