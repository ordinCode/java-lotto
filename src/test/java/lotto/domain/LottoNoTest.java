package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNoTest {
	@Test
	void createLottoNo() {
		assertThat(LottoNo.toLottoNo(1) == LottoNo.toLottoNo(1));
	}
}
