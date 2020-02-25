package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoCreate implements LottoCreateStrategy {
    private static final int START_LOTTO_NO = 1;
    private static final int END_LOTTO_NO = 45;
    private static final int LOTTO_FROM_INDEX = 0;
    private static final int LOTTO_TO_INDEX = 6;

    private static List<LottoNo> lottoNumberBox = new ArrayList<>();

    static {
        for (int count = START_LOTTO_NO; count <= END_LOTTO_NO; count++) {
            lottoNumberBox.add(new LottoNo(count));
        }
    }

    public Lotto CreateLotto() {
        List<LottoNo> lotto = pickSixRandomNo();
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    private List<LottoNo> pickSixRandomNo() {
        List<LottoNo> lotto = new ArrayList<>(lottoNumberBox);
        Collections.shuffle(lotto);
        lotto = lotto.subList(LOTTO_FROM_INDEX, LOTTO_TO_INDEX);
        return lotto;
    }
}
