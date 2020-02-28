package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringUtilsTest {
    @DisplayName("수동로또 입력시 엔터기준으로 split 테스트")
    @Test
    void splitLotto() {
        String inputManualLotto = "1,2,3,4,5,6\n7,8,9,10,11,12";
        String[] result = new String[]{"1,2,3,4,5,6", "7,8,9,10,11,12"};

        assertThat(StringUtils.splitByLineSeparator(inputManualLotto)).isEqualTo(result);
    }

    @DisplayName("숫자가 아닌값을 입력")
    @Test
    void notInteger() {
        String inputMoney = "a";
        assertThatThrownBy(() -> StringUtils.ToInt(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 문자를 입력하였습니다.");
    }
}
