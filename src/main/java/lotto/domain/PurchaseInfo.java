package lotto.domain;

public class PurchaseInfo {
	public static final String ERROR_MESSAGE_MANUAL_LOTTO_COUNT = "구입가능한 로또 수보다 큰 수를 입력하였습니다.";

	private final int manualLottoCount;
	private final int autoLottoCount;


	public PurchaseInfo(Money money, int manualLottoCount) {
		validate(money, manualLottoCount);
		this.manualLottoCount = manualLottoCount;
		this.autoLottoCount = money.divideThousand() - manualLottoCount;
	}

	private void validate(Money money, int manualLottoCount) {
		if (money.divideThousand() < manualLottoCount) {
			throw new IllegalArgumentException(ERROR_MESSAGE_MANUAL_LOTTO_COUNT);
		}
	}

}
