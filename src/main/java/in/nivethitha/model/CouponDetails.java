package in.nivethitha.model;

import java.util.Date;

public class CouponDetails {
	private int id;
	private String shoppingSiteName;
	private int discount;
	private double purchaseAmount;
	private Date startDate;
	private Date expiryDate;
	private String status;

	public CouponDetails(int id, String shoppingSiteName, int discount, double purchaseAmount, Date startDate,
			Date expiryDate, String status) {
		super();
		this.id = id;
		this.shoppingSiteName = shoppingSiteName;
		this.discount = discount;
		this.purchaseAmount = purchaseAmount;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShoppingSiteName() {
		return shoppingSiteName;
	}

	public void setShoppingSiteName(String shoppingSiteName) {
		this.shoppingSiteName = shoppingSiteName;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CouponDetails [id=" + id + ", shoppingSiteName=" + shoppingSiteName + ", discount=" + discount
				+ ", purchaseAmount=" + purchaseAmount + ", startDate=" + startDate + ", expiryDate=" + expiryDate
				+ ", status=" + status + "]";
	}

}
