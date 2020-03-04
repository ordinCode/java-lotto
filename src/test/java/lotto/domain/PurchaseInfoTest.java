package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchaseInfoTest {
	@DisplayName("구입가능한 로또 수보다 큰수의 수동로또 구매")
	@Test
	void init() {
		int manualLottoCount = 3;
		Money money = new Money("2000");
		assertThatThrownBy(() -> new PurchaseInfo(money, manualLottoCount))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구입가능한 범위에서 수동 로또 구매")
	@Test
	void init2() {
		int manualLottoCount = 3;
		Money money = new Money("3000");

		assertThat(new PurchaseInfo(money, manualLottoCount));
	}
}
