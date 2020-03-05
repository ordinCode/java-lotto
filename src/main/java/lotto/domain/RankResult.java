package lotto.domain;

import java.util.HashMap;

public class RankResult {
	private final HashMap<Rank, Integer> rankResult = new HashMap<>();

	public RankResult() {
		for (Rank rank : Rank.values()) {
			rankResult.put(rank, 0);
		}
	}

	public void rankPlus(Rank rank) {
		rankResult.put(rank, rankResult.get(rank) + 1);
	}

	public HashMap<Rank, Integer> getRankResult() {
		return rankResult;
	}
}
