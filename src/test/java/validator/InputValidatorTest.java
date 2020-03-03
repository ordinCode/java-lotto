package validator;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
	@Test
	void notInt() {
		String input = "a";

		assertThatThrownBy(() -> InputValidator.validateInt(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("숫자가 아닌 문자를 입력하였습니다.");
	}
}
