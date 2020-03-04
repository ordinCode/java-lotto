package lotto.domain;

public class PurchaseInfo {
	private final int manualLottoCount;
	private final int autoLottoCount;

	public PurchaseInfo(Money money, int manualLottoCount) {
		validate(money, manualLottoCount);
		this.manualLottoCount = manualLottoCount;
		this.autoLottoCount = money.divideThousand() - manualLottoCount;
	}

	private void validate(Money money, int manualLottoCount) {
		if (money.divideThousand() < manualLottoCount) {
			throw new IllegalArgumentException();
		}
	}

}
