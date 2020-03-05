package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PurchaseInfo;
import lotto.domain.WinLotto;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.lottogenerator.LottoGeneratorAuto;
import lotto.domain.lottogenerator.LottoGeneratorManual;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
	private static List<LottoGenerator> lottoGenerators = Arrays.asList(
			new LottoGeneratorManual(), new LottoGeneratorAuto());

	public static void run() {
		Money money = new Money(InputView.inputMoney());
		int manualLottoCount = StringUtils.toInt(InputView.inputManualLottoCount());
		PurchaseInfo purchaseInfo = new PurchaseInfo(money, manualLottoCount);
		String manualLottoNumbers = InputView.inputManualLottoNumber(purchaseInfo);

		Customer customer = new Customer(purchaseInfo, manualLottoNumbers);
		Lottos lottos = makeLottos(customer);
		OutputView.printLottos(lottos, purchaseInfo);

		WinLotto winLotto = new WinLotto(InputView.inputWinLotto(), InputView.inputBonus());
		LottoManager lottoManager = new LottoManager(lottos, winLotto);
		lottoManager.match();

		OutputView.printResult(lottoManager, money);
	}

	public static Lottos makeLottos(Customer customer) {
		List<Lotto> lottos = new ArrayList<>();
		for (LottoGenerator lottoGenerator : lottoGenerators) {
			lottos.addAll(lottoGenerator.generate(customer));
		}
		return new Lottos(lottos);
	}
}
