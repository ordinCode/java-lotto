package lotto.domain;

import lotto.domain.lottogenerator.LottoNo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNoTest {
	@DisplayName("로또넘버객체를 재사용하는지 테스트")
	@Test
	void 재사용테스트() {
		LottoNo number1 = LottoNo.toLottoNo(1);
		LottoNo number2 = LottoNo.toLottoNo(1);

		assertThat(number1 == number2).isTrue();
	}
}
