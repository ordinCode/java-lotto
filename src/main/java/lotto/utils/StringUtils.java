package lotto.utils;

import lotto.validator.InputValidator;

public class StringUtils {
	public static int toInt(String input) {
		InputValidator.validateInt(input);
		return Integer.parseInt(input);
	}
}
