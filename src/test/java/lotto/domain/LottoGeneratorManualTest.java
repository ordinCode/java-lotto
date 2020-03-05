package lotto.domain;

import lotto.domain.lottogenerator.LottoGeneratorManual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorManualTest {
	private PurchaseInfo purchaseInfo;

	@BeforeEach
	void setUp() {
		purchaseInfo = new PurchaseInfo(new Money("4000"), 2);
	}

	@DisplayName("String[] 으로 입력된 로또번호로 수동로또 생성")
	@Test
	void generate() {
		String lottoNumbers = "1,2,3,4,5,6\n11,12,13,14,15,16";
		Customer customer = new Customer(purchaseInfo, lottoNumbers);

		List<Lotto> lottos = new ArrayList<>();
		lottos.add(new Lotto(IntStream.range(1, 7).boxed()
				.map(LottoNo::toLottoNo)
				.collect(Collectors.toList())));
		lottos.add(new Lotto(IntStream.range(11, 17).boxed()
				.map(LottoNo::toLottoNo)
				.collect(Collectors.toList())));

		assertThat(new LottoGeneratorManual().generate(customer)).isEqualTo(lottos);
	}

	@DisplayName("7개의 숫자입력")
	@Test
	void errorTest1() {
		String lottoNumbers = "1,2,3,4,5,6,7\n11,12,13,14,15,16";
		Customer customer = new Customer(purchaseInfo, lottoNumbers);

		assertThatThrownBy(() -> new LottoGeneratorManual().generate(customer))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("6개의 숫자가 아닙니다.");
	}

	@DisplayName("5개의 숫자 입력")
	@Test
	void errorTest2() {
		String lottoNumbers = "1,2,3,4,5\n11,12,13,14,15,16";
		Customer customer2 = new Customer(purchaseInfo, lottoNumbers);

		assertThatThrownBy(() -> new LottoGeneratorManual().generate(customer2))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("6개의 숫자가 아닙니다.");
	}

	@DisplayName("중복된 숫자 입력(총 7개의 숫자)")
	@Test
	void errorTest3() {
		String lottoNumbers = "1,2,3,4,5,6,6\n11,12,13,14,15,16";
		Customer customer = new Customer(purchaseInfo, lottoNumbers);

		assertThatThrownBy(() -> new LottoGeneratorManual().generate(customer))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("숫자는 중복될 수 없습니다.");
	}

	@DisplayName("중복된 숫자 입력(총 6개의 숫자)")
	@Test
	void errorTest4() {
		String lottoNumbers = "1,2,3,4,6,6\n11,12,13,14,15,16";
		Customer customer = new Customer(purchaseInfo, lottoNumbers);

		assertThatThrownBy(() -> new LottoGeneratorManual().generate(customer))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("숫자는 중복될 수 없습니다.");
	}
}
