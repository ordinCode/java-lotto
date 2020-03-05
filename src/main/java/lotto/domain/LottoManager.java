package lotto.domain;

public class LottoManager {
	private final Lottos lottos;
	private final WinLotto winLotto;
	private final RankResult rankResult;

	public LottoManager(Lottos lottos, WinLotto winLotto) {
		this.lottos = lottos;
		this.winLotto = winLotto;
		this.rankResult = new RankResult();
	}

	public void match() {
		lottos.match(winLotto, rankResult);
	}

	public int getMatchCount(Rank rank) {
		return rankResult.getMatchCount(rank);
	}
}
