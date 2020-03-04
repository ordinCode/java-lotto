package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

	public static void printLottos(Lottos lottos) {
		StringBuilder builder = new StringBuilder();
		for (Lotto lotto : lottos.getLottos()) {
			builder.append(lotto.toString());
		}
		System.out.println(builder.toString());
	}
}
