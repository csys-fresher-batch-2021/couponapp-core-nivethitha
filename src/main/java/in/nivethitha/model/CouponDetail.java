package in.nivethitha.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CouponDetail {


	@Override
	public String toString() {
		return "CouponDetail [id=" + id + ", shoppingSiteName=" + shoppingSiteName + ", createdDate=" + createdDate
				+ ", couponCode=" + couponCode + ", discount=" + discount + ", purchaseAmount=" + purchaseAmount
				+ ", startDate=" + startDate + ", expiryDate=" + expiryDate + ", status=" + status + "]";
	}
	private int id;
	private String shoppingSiteName;
	private String couponCode;
	private LocalDateTime createdDate;
	private int discount;
	private double purchaseAmount;
	private LocalDate startDate;
	private LocalDate expiryDate;
	private String status;

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

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

}
