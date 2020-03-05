package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseInfo;

public class OutputView {

	public static final String MESSAGE_FORMAT_PURCHASE = "수동으로 %d장 자동으로 %d장 구매했습니다.";

	public static void printLottos(Lottos lottos, PurchaseInfo purchaseInfo) {
		System.out.println(String.format(MESSAGE_FORMAT_PURCHASE
				, purchaseInfo.getManualLottoCount(), purchaseInfo.getAutoLottoCount()));
		StringBuilder builder = new StringBuilder();
		for (Lotto lotto : lottos.getLottos()) {
			builder.append(lotto.toString());
		}
		System.out.println(builder.toString());
	}
}
