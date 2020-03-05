package lotto.domain.lottogenerator;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneratorManual implements LottoGenerator {
	public List<Lotto> generate(Customer customer) {
		List<Lotto> lottos = new ArrayList<>();
		for (String lottoNumber : customer.getManualLottoNo()) {
			lottos.add(StringUtils.toLotto(lottoNumber));
		}
		return lottos;
	}
}
