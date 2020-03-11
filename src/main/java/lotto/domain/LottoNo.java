package lotto.domain;

import java.util.HashMap;

public class LottoNo implements Comparable<LottoNo> {
	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;
	public static final String ERROR_MESSAGE_NUMBER_RANGE = "1이상 45이하의 숫자만 입력 가능합니다.";

	private int number;
	public static HashMap<Integer, LottoNo> lottoBox = new HashMap<>();

	static {
		for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
			lottoBox.put(i, valueOf(i));
		}
	}

	private LottoNo(int number) {
		this.number = number;
	}

	private static LottoNo valueOf(int number) {
		return new LottoNo(number);
	}

	public static LottoNo toLottoNo(int number) {
		if (lottoBox.get(number) == null) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_RANGE);
		}
		return lottoBox.get(number);
	}

	@Override
	public String toString() {
		return number + "";
	}

	@Override
	public int compareTo(LottoNo o) {
		return Integer.compare(this.number, o.number);
	}
}
