package lotto.domain;

import java.util.Arrays;

public enum Rank {
	FIFTH(3, 5000),
	FOURTH(4, 500000),
	THIRD(5, 1500000),
	SECOND(5, 30000000),
	FIRST(6, 2000000000);

	private int matchCount;
	private int award;

	Rank(int matchCount, int award) {
		this.matchCount = matchCount;
		this.award = award;
	}

	public static Rank findRank(int matchCount, boolean bonus) {
		Rank rank = Arrays.stream(Rank.values())
				.filter(x -> x.matchCount == matchCount)
				.findFirst()
				.orElse(null);
		rank = secondOrThird(bonus, rank);
		return rank;
	}

	private static Rank secondOrThird(boolean bonus, Rank rank) {
		if (rank == THIRD & bonus) {
			rank = SECOND;
		}
		return rank;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getAward() {
		return award;
	}
}
