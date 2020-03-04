package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGeneratorAuto {
	public static List<Lotto> generate(Customer customer) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < customer.getPurchaseInfo().getAutoLottoCount(); i++) {
			lottos.add(new Lotto(makeAutoLotto()));
		}
		return lottos;
	}

	private static List<LottoNo> makeAutoLotto() {
		List<LottoNo> lottoNos = new ArrayList<>(LottoNo.lottoBox.values());
		Collections.shuffle(lottoNos);
		return lottoNos.subList(0, 6);
	}
}
