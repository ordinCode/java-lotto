package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGeneratorManual {

	public static Lottos generate(String[] lottoNumbers) {
		List<Lotto> lottos = new ArrayList<>();
		for (String lottoNumber : lottoNumbers) {
			List<LottoNo> lottoNos = Arrays.stream(lottoNumber.split(","))
					.map(Integer::parseInt)
					.map(LottoNo::toLottoNo)
					.collect(Collectors.toList());
			lottos.add(new Lotto(lottoNos));
		}
		return new Lottos(lottos);
	}
}
