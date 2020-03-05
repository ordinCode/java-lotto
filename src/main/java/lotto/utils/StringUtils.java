package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
	public static final String DELIMITER_LOTTO_NO = ",";
	public static final String ERROR_MESSAGE_NULL_POINT = "공란을 입력하였습니다.";

	public static int toInt(String input) {
		InputValidator.validateInt(input);
		return Integer.parseInt(input);
	}

	public static Lotto toLotto(String lottoNo) {
		if (lottoNo == null) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NULL_POINT);
		}
		List<LottoNo> lotto = (Arrays.stream(lottoNo.split(DELIMITER_LOTTO_NO))
				.map(Integer::parseInt)
				.map(LottoNo::toLottoNo)
				.collect(Collectors.toList()));
		return new Lotto(lotto);
	}
}
