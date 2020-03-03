package lotto.domain;

import lotto.validator.InputValidator;

public class Money {
	private int money;

	public Money(String money) {
		InputValidator.validateInt(money);
		this.money = Integer.parseInt(money);
	}
}
