package lotto.domain;

import lotto.util.StringUtils;

public class Customer {
    private static final int LOTTO_PRICE = 1000;
    private static final int TO_PERCENT_VALUE = 100;
    private static final int MIN_MANUAL_LOTTO_COUNT = 0;
    private static final String ERROR_MESSAGE_MIN_MONEY = "천원 이상의 금액만 가능합니다.";
    private static final String ERROR_MESSAGE_OVER_COUNT = "구입 가능한 수보다 큰 수를 입력하였습니다.";
    private static final String ERROR_MESSAGE_NULL_POINT = "입력값이 비어있습니다.";

    private final int money;
    private final int manualLottoCount;
    private String[] manualLottoNumbers;

    public Customer(int inputMoney, int manualLottoCount) {
        validateMoneyOverThousand(inputMoney);
        validateUserLottoCount(inputMoney, manualLottoCount);
        this.money = inputMoney;
        this.manualLottoCount = manualLottoCount;
    }

    private void validateMoneyOverThousand(int inputMoney) {
        if (inputMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MIN_MONEY);
        }
    }

    private static void validateUserLottoCount(int inputMoney, int userLottoCount) {
        if (userLottoCount > inputMoney / LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OVER_COUNT);
        }
    }

    public int divideThousand() {
        return money / LOTTO_PRICE;
    }

    public int calculateIncomeRate(long income) {
        return (int) (income * TO_PERCENT_VALUE / money);
    }

    public boolean isUserLottoCountOverZero() {
        return manualLottoCount > MIN_MANUAL_LOTTO_COUNT;
    }

    public int calculatorAutoLottoCount() {
        return divideThousand() - manualLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public String[] getManualLottoNumbers() {
        return manualLottoNumbers;
    }

    public void setManualLottoNumbers(String manualLottoNumbers) {
        validateManualLottoNumbers(manualLottoNumbers);
        this.manualLottoNumbers = StringUtils.splitByLineSeparator(manualLottoNumbers);
    }

    private void validateManualLottoNumbers(String manualLottoNumbers) {
        if (manualLottoNumbers == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NULL_POINT);
        }
    }
}
