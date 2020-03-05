package lotto.domain;

import lotto.domain.lottogenerator.LottoGeneratorAuto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorAutoTest {
	@DisplayName("자동로또 생성 개수 테스트")
	@Test
	void generate2() {
		String lottoNumbers = "1,2,3,4,5,6\n11,12,13,14,15,16";
		PurchaseInfo purchaseInfo = new PurchaseInfo(new Money("4000"), 2);
		Customer customer = new Customer(purchaseInfo, lottoNumbers);

		assertThat(new LottoGeneratorAuto().generate(customer).size()).isEqualTo(2);
	}
}
