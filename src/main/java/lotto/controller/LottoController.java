package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.LottoGeneratorAuto;
import lotto.domain.LottoGeneratorManual;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PurchaseInfo;
import lotto.domain.WinLotto;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	public static void run() {
		Money money = new Money(InputView.inputMoney());
		int manualLottoCount = StringUtils.toInt(InputView.inputManualLottoCount());
		PurchaseInfo purchaseInfo = new PurchaseInfo(money, manualLottoCount);
		String manualLottoNumbers = InputView.inputManualLottoNumber(purchaseInfo);

		Customer customer = new Customer(purchaseInfo, manualLottoNumbers);

		Lottos lottos = LottoGeneratorManual.generate(customer);
		lottos.addAll(LottoGeneratorAuto.generate(customer));
		OutputView.printLottos(lottos, purchaseInfo);

		WinLotto winLotto = new WinLotto(InputView.inputWinLotto(), InputView.inputBonus());
		LottoManager lottoManager = new LottoManager(lottos, winLotto);
		lottoManager.match();

		OutputView.printResult(lottoManager);
	}
}
