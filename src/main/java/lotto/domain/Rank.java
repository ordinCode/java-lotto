package lotto.domain;

import java.util.Arrays;

public enum Rank {
	FIFTH(3, 5000, 0),
	FOURTH(4, 500000, 0),
	THIRD(5, 1500000, 0),
	SECOND(5, 30000000, 0),
	FIRST(6, 2000000000, 0);

	private int matchCount;
	private int award;
	private int ticketCount;

	Rank(int matchCount, int award, int ticketCount) {
		this.matchCount = matchCount;
		this.award = award;
		this.ticketCount = ticketCount;
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
}
