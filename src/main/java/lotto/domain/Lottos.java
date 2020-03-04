package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lottos lottos1 = (Lottos) o;
		return Objects.equals(lottos, lottos1.lottos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottos);
	}

	public void addAll(List<Lotto> lottosToAdd) {
		this.lottos.addAll(lottosToAdd);
	}
}
