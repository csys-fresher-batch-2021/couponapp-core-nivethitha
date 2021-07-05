package in.nivethitha.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApplyCoupon {
	
	private int id;
	@Override
	public String toString() {
		return "ApplyCoupon [id=" + id + ", count=" + count + ", userName=" + userName + ", mobileNumber="
				+ mobileNumber + ", eMailId=" + eMailId + ", couponCode=" + couponCode + ", appliedDate=" + appliedDate
				+ ", createdDate=" + createdDate + ", discount=" + discount + ", purchasingAmount=" + purchasingAmount
				+ ", startDate=" + startDate + ", expiryDate=" + expiryDate + ", numberOfTimesused=" + numberOfTimesused
				+ ", status=" + status + ", totalBillAmount=" + totalBillAmount + ", discounted_amount="
				+ discounted_amount + "]";
	}

	private int count;   
	private String userName;
	private long mobileNumber;
	private String eMailId;
	private String couponCode;
	private LocalDateTime appliedDate;
	private LocalDateTime createdDate;
	private int discount;
	private double purchasingAmount;
	private LocalDate startDate;
	private LocalDate expiryDate;
	private int numberOfTimesused;
	private String status;
	private double totalBillAmount;
	private double discounted_amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public LocalDateTime getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDateTime appliedDate) {
		this.appliedDate = appliedDate;
	}
	public double getPurchasingAmount() {
		return purchasingAmount;
	}

	public void setPurchasingAmount(double purchasingAmount) {
		this.purchasingAmount = purchasingAmount;
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

	public int getNumberofTimesused() {
		return numberOfTimesused;
	}

	public void setNumberofTimesused(int numberofTimesused) {
		this.numberOfTimesused = numberofTimesused;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getDiscounted_amount() {
		return discounted_amount;
	}

	public void setDiscounted_amount(double discounted_amount) {
		this.discounted_amount = discounted_amount;
	}
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}
	public String geteMailId() {
		return eMailId;
	}

	public void seteMailId(String eMailId) {
		this.eMailId = eMailId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
