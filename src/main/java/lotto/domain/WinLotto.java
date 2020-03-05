package lotto.domain;

import lotto.utils.StringUtils;

public class WinLotto {
	private final Lotto lotto;
	private final Bonus bonus;

	public WinLotto(String lottoNumber, Bonus bonus) {
		this.lotto = toLotto(lottoNumber);
		this.bonus = bonus;
	}

	private Lotto toLotto(String lottoNumber) {
		return StringUtils.toLotto(lottoNumber);
	}
}
