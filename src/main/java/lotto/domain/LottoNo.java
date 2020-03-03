package lotto.domain;

import java.util.HashMap;

public class LottoNo {
	private static HashMap<Integer, LottoNo> lottoBox = new HashMap<>();

	static {
		for (int i = 1; i <= 45; i++) {
			lottoBox.put(i, valueOf(i));
		}
	}

	private int number;

	private LottoNo(int number) {
		this.number = number;
	}

	private static LottoNo valueOf(int number) {
		return new LottoNo(number);
	}

	public static LottoNo toLottoNo(int number) {
		return lottoBox.get(number);
	}
}
