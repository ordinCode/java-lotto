package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankResultTest {
	@DisplayName("랭크 저장 테스트")
	@Test
	void rankPlus() {
		Rank rank = Rank.FIRST;
		RankResult rankResult = new RankResult();

		rankResult.rankPlus(rank);
		rankResult.rankPlus(rank);

		assertThat(rankResult.getRankResult().get(Rank.FIRST)).isEqualTo(2);
	}
}
