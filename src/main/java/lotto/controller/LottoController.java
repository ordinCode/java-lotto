package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.LottoGeneratorManual;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PurchaseInfo;
import lotto.utils.StringUtils;
import lotto.view.InputView;

public class LottoController {
	public static void run() {
		Money money = new Money(InputView.inputMoney());
		int manualLottoCount = StringUtils.toInt(InputView.inputManualLottoCount());
		PurchaseInfo purchaseInfo = new PurchaseInfo(money, manualLottoCount);
		String manualLottoNumbers = InputView.inputManualLottoNumber(purchaseInfo);

		Customer customer = new Customer(purchaseInfo, manualLottoNumbers);

		Lottos lottos = LottoGeneratorManual.generate(customer);
	}
}
