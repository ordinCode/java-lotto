package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
	public static int toInt(String input) {
		InputValidator.validateInt(input);
		return Integer.parseInt(input);
	}

	public static Lotto toLotto(String lottoNo) {
		List<LottoNo> lotto = (Arrays.stream(lottoNo.split(","))
				.map(Integer::parseInt)
				.map(LottoNo::toLottoNo)
				.collect(Collectors.toList()));
		return new Lotto(lotto);
	}
}
