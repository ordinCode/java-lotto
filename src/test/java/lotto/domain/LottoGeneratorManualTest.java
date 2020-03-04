package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorManualTest {
	@DisplayName("String[] 으로 입력된 로또번호로 수동로또 생성")
	@Test
	void generate() {
		String[] lottoNumbers = new String[]{"1,2,3,4,5,6", "11,12,13,14,15,16"};
		List<Lotto> lottos = new ArrayList<>();

		lottos.add(new Lotto(IntStream.range(1, 7).boxed()
				.map(LottoNo::toLottoNo)
				.collect(Collectors.toList())));
		lottos.add(new Lotto(IntStream.range(11, 17).boxed()
				.map(LottoNo::toLottoNo)
				.collect(Collectors.toList())));

		assertThat(LottoGeneratorManual.generate(lottoNumbers)).isEqualTo(new Lottos(lottos));
	}
}
