package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PurchaseInfo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoControllerTest {
	@Test
	void makeLotto() {
		PurchaseInfo purchaseInfo = new PurchaseInfo(new Money("5000"), 1);
		Customer customer = new Customer(purchaseInfo, "1,2,3,4,5,6");
		Lottos lottos = LottoController.makeLottos(customer);

		assertThat(lottos.getLottos().size()).isEqualTo(5);
	}
}
