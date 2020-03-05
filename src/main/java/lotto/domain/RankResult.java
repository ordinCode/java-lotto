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
		if (rank == null) {
			return;
		}
		rankResult.put(rank, rankResult.get(rank) + 1);
	}

	public int getMatchCount(Rank rank) {
		return rankResult.get(rank);
	}
}
