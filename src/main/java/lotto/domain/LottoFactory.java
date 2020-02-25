package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static final String ERROR_MESSAGE_NULL_POINT_LOTTO_FACTORY = "입력값이 비었습니다.";

    public static List<Lotto> createLotteries(Money money) {
        validate(money);
        List<Lotto> lotteries = new ArrayList<>();
        int createCount = money.divideThousand();
        for (int i = 0; i < createCount; i++) {
            lotteries.add(createLotto(new LottoAutoCreate()));
        }
        return lotteries;
    }

    private static Lotto createLotto(LottoCreateStrategy createLotto) {
        return createLotto.CreateLotto();
    }

    private static void validate(Money money) {
        if (money == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NULL_POINT_LOTTO_FACTORY);
        }
    }
}
