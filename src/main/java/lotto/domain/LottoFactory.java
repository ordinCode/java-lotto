package lotto.domain;

import lotto.util.LottoUtils;
import lotto.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoFactory {
    private static final int START_LOTTO_NO = 1;
    private static final int END_LOTTO_NO = 45;
    private static final int LOTTO_FROM_INDEX = 0;
    private static final int LOTTO_TO_INDEX = 6;
    private static final String ERROR_MESSAGE_NULL_POINT_LOTTO_FACTORY = "입력값이 비었습니다.";

    private static List<LottoNo> lottoNumberBox = new ArrayList<>();

    static {
        for (int number = START_LOTTO_NO; number <= END_LOTTO_NO; number++) {
            lottoNumberBox.add(new LottoNo(number));
        }
    }

    public static List<Lotto> createLotteries(Customer customer, String userLottoNumbers) {
        validate(customer);
        List<Lotto> lotteries = new ArrayList<>();
        if (userLottoNumbers == null || userLottoNumbers.isEmpty()) {
            return addAutoLotto(lotteries, customer.divideThousand());
        }

        String[] manualLotteries = StringUtils.splitByLineSeparator(userLottoNumbers);
        lotteries = createUserLotto(manualLotteries);
        return addAutoLotto(lotteries, customer.divideThousand() - manualLotteries.length);
    }

    private static void validate(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NULL_POINT_LOTTO_FACTORY);
        }
    }

    public static List<Lotto> createUserLotto(String[] manualLotteries) {
        List<Lotto> manualLotto = new ArrayList<>();
        for (String numbers : manualLotteries) {
            Set<LottoNo> lotto = LottoUtils.toLottoNoSet(StringUtils.splitByComma(numbers));
            manualLotto.add(new Lotto(lotto));
        }
        return manualLotto;
    }

    private static List<Lotto> addAutoLotto(List<Lotto> lottos, int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(createLottoAuto());
        }
        return lottos;
    }

    private static Lotto createLottoAuto() {
        Set<LottoNo> lotto = new TreeSet<>(pickSixRandomNo());
        return new Lotto(lotto);
    }

    private static List<LottoNo> pickSixRandomNo() {
        List<LottoNo> lotto = new ArrayList<>(lottoNumberBox);
        Collections.shuffle(lotto);
        lotto = lotto.subList(LOTTO_FROM_INDEX, LOTTO_TO_INDEX);
        return lotto;
    }
}
