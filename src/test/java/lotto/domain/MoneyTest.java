package lotto.domain;

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

	@DisplayName("1000원 이하의 금액입력")
	@Test
	void underThousand() {
		String inputMoney = "999";
		assertThatThrownBy(() -> new Money(inputMoney))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1000원 이상의 금액을 입력하세요.");
	}

	@DisplayName("0원 입력")
	@Test
	void underThousand2() {
		String inputMoney = "0";
		assertThatThrownBy(() -> new Money(inputMoney))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1000원 이상의 금액을 입력하세요.");
	}

	@DisplayName("수익률 계산")
	@Test
	void incomeRate() {
		Money money = new Money("1000");

		assertThat(money.calculateIncomeRate(5000)).isEqualTo(500);
	}
}
