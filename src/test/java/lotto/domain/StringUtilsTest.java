package lotto.domain;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class StringUtilsTest {
	@DisplayName("입력된 String 로또 번호로 로또 생성")
	@Test
	void toLotto() {
		String input = "1,2,3,4,5,6";
		Lotto result = new Lotto(IntStream.range(1, 7)
				.boxed()
				.map(LottoNo::toLottoNo)
				.collect(Collectors.toList()));

		assertThat(StringUtils.toLotto(input)).isEqualTo(result);
	}

	@DisplayName("입력된 String 로또 번호로 로또 생성 시 범위를 벗어난 숫자1")
	@Test
	void toLottoError1() {
		String input = "0,1,2,3,4,5";

		assertThatThrownBy(() -> StringUtils.toLotto(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1이상 45이하의 숫자만 입력 가능합니다.");
	}

	@DisplayName("입력된 String 로또 번호로 로또 생성 시 범위를 벗어난 숫자2")
	@Test
	void toLottoError2() {
		String input = "1,2,3,4,5,46";

		assertThatThrownBy(() -> StringUtils.toLotto(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1이상 45이하의 숫자만 입력 가능합니다.");
	}

	@DisplayName("입력된 String 로또 번호로 로또 생성 시 6개가 아닌 숫자 입력1")
	@Test
	void toLottoError3() {
		String input = "1,2,3,4,5";

		assertThatThrownBy(() -> StringUtils.toLotto(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("6개의 숫자가 아닙니다.");
	}

	@DisplayName("입력된 String 로또 번호로 로또 생성 시 중복된 숫자입력")
	@Test
	void toLottoError4() {
		String input = "1,2,3,4,5,6,6";

		assertThatThrownBy(() -> StringUtils.toLotto(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("숫자는 중복될 수 없습니다.");
	}
}
