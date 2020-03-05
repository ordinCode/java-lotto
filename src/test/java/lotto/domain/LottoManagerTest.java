package lotto.domain;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoManagerTest {
	@Test
	void match() {
		WinLotto winLotto = new WinLotto("1,2,3,4,5,6", "7");
		Lotto lotto1 = StringUtils.toLotto("1,2,3,4,5,6");
		Lotto lotto2 = StringUtils.toLotto("1,2,3,11,12,13");
		Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));
		LottoManager lottoManager = new LottoManager(lottos, winLotto);

		lottoManager.match();
	}
}
