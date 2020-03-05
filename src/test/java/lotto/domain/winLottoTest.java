package lotto.domain;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class winLottoTest {
	@DisplayName("1등 찾기")
	@Test
	void matchLotto1() {
		WinLotto winLotto = new WinLotto("1,2,3,4,5,6", "7");
		Lotto lotto = StringUtils.toLotto("1,2,3,4,5,6");

		assertThat(winLotto.findRank(lotto)).isEqualTo(Rank.FIRST);
	}

	@DisplayName("2등 찾기")
	@Test
	void matchLotto2() {
		WinLotto winLotto = new WinLotto("1,2,3,4,5,6", "11");
		Lotto lotto = StringUtils.toLotto("1,2,3,4,5,11");

		assertThat(winLotto.findRank(lotto)).isEqualTo(Rank.SECOND);
	}

	@DisplayName("3등 찾기")
	@Test
	void matchLotto3() {
		WinLotto winLotto = new WinLotto("1,2,3,4,5,6", "7");
		Lotto lotto = StringUtils.toLotto("1,2,3,4,5,11");

		assertThat(winLotto.findRank(lotto)).isEqualTo(Rank.THIRD);
	}

	@DisplayName("4등 찾기")
	@Test
	void matchLotto4() {
		WinLotto winLotto = new WinLotto("1,2,3,4,5,6", "7");
		Lotto lotto = StringUtils.toLotto("1,2,3,4,12,11");

		assertThat(winLotto.findRank(lotto)).isEqualTo(Rank.FOURTH);
	}

	@DisplayName("5등 찾기")
	@Test
	void matchLotto5() {
		WinLotto winLotto = new WinLotto("1,2,3,4,5,6", "7");
		Lotto lotto = StringUtils.toLotto("1,2,3,13,12,11");

		assertThat(winLotto.findRank(lotto)).isEqualTo(Rank.FIFTH);
	}
}
