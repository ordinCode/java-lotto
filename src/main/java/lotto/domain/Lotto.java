package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	public static final int LOTTO_SIZE = 6;
	public static final String ERROR_MESSAGE_LOTTO_SIZE = "6개의 숫자가 아닙니다.";
	public static final String ERROR_MESSAGE_OVERLAP_NUMBER = "숫자는 중복될 수 없습니다.";

	private final Set<LottoNo> lotto;

	public Lotto(List<LottoNo> lotto) {
		validate(lotto);
		this.lotto = new TreeSet<>(lotto);
	}

	private void validate(List<LottoNo> lotto) {
		if (new HashSet<>(lotto).size() != lotto.size()) {
			throw new IllegalArgumentException(ERROR_MESSAGE_OVERLAP_NUMBER);
		}

		if (lotto.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_SIZE);
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lotto lotto1 = (Lotto) o;
		return Objects.equals(lotto, lotto1.lotto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto);
	}

	@Override
	public String toString() {
		return lotto + "\n";
	}
}
