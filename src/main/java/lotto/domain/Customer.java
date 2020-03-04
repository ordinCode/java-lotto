package lotto.domain;

public class Customer {
	public static final String LOTTO_DELIMITER = "\n";

	private PurchaseInfo purchaseInfo;
	private String[] manualLottoNo;

	public Customer(PurchaseInfo purchaseInfo, String manualLottoNo) {
		this.purchaseInfo = purchaseInfo;
		this.manualLottoNo = manualLottoNo.split(LOTTO_DELIMITER);
	}

	public String[] getManualLottoNo() {
		return manualLottoNo;
	}

	public PurchaseInfo getPurchaseInfo() {
		return purchaseInfo;
	}
}
