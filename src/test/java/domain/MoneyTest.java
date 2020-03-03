package domain;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
	@DisplayName("숫자가 아닌 문자 입력")
	@Test
	void notInt() {
		String inputMoney = "a";

		assertThatThrownBy(() -> new Money(inputMoney))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("숫자가 아닌 문자를 입력하였습니다.");
	}
}
