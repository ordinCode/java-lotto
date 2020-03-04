package lotto.domain;

import lotto.validator.InputValidator;

public class Money {
	public static final int LOTTO_PRICE = 1000;
	public static final String ERROR_MESSAGE_MIN_MONEY = "1000원 이상의 금액을 입력하세요.";

	private int money;

	public Money(String money) {
		validate(money);
		this.money = Integer.parseInt(money);
	}

	private void validate(String money) {
		InputValidator.validateInt(money);

		if (Integer.parseInt(money) < LOTTO_PRICE) {
			throw new IllegalArgumentException(ERROR_MESSAGE_MIN_MONEY);
		}
	}

	public int divideThousand() {
		return this.money / LOTTO_PRICE;
	}
}
