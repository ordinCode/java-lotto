package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PurchaseInfo;
import lotto.domain.Rank;

public class OutputView {

	private static final String PERCENT = "%";
	public static final String MESSAGE_FORMAT_PURCHASE = "수동으로 " + PERCENT + "d장 자동으로 %d장 구매했습니다.";

	public static void printLottos(Lottos lottos, PurchaseInfo purchaseInfo) {
		System.out.println(String.format(MESSAGE_FORMAT_PURCHASE
				, purchaseInfo.getManualLottoCount(), purchaseInfo.getAutoLottoCount()));
		StringBuilder builder = new StringBuilder();
		for (Lotto lotto : lottos.getLottos()) {
			builder.append(lotto.toString());
		}
		System.out.println(builder.toString());
	}

	public static void printResult(LottoManager lottoManager, Money money) {
		System.out.println("당첨통계\n----------");
		for (Rank rank : Rank.values()) {
			printCount(lottoManager, rank);
		}
		System.out.println("수익률 : " + lottoManager.calculateIncomeRate(money) + PERCENT);
	}

	private static void printCount(LottoManager lottoManager, Rank rank) {
		if (rank == Rank.SECOND) {
			System.out.println(String.format(PERCENT + "d개 일치, 보너스 일치 (%d원) : %d 개"
					, rank.getMatchCount(), rank.getAward(), lottoManager.getMatchCount(rank)));
			return;
		}
		System.out.println(String.format(PERCENT + "d개 일치 (%d원) : %d 개"
				, rank.getMatchCount(), rank.getAward(), lottoManager.getMatchCount(rank)));
	}
}
