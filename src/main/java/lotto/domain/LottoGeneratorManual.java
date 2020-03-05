package lotto.domain;

import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneratorManual {
	public static Lottos generate(Customer customer) {
		List<Lotto> lottos = new ArrayList<>();
		for (String lottoNumber : customer.getManualLottoNo()) {
			lottos.add(StringUtils.toLotto(lottoNumber));
		}
		return new Lottos(lottos);
	}
}
