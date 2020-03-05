package lotto.domain;

import lotto.utils.StringUtils;

public class WinLotto {
	private final Lotto winLotto;
	private final LottoNo bonus;

	public WinLotto(String lottoNumber, String bonus) {
		this.winLotto = toLotto(lottoNumber);
		this.bonus = LottoNo.toLottoNo(StringUtils.toInt(bonus));
	}

	private Lotto toLotto(String lottoNumber) {
		return StringUtils.toLotto(lottoNumber);
	}

	public Rank findRank(Lotto lotto) {
		int matchCount = lotto.findmatchCount(winLotto);
		boolean bonus = lotto.contains(this.bonus);
		return Rank.findRank(matchCount, bonus);
	}
}
