package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
	private List<LottoNo> lotto;

	public Lotto(List<LottoNo> lotto) {
		this.lotto = lotto;
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
