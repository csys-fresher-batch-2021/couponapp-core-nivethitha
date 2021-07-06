package in.nivethitha.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CouponDetail {
	private int id;
	private String couponCode;
	private LocalDateTime createdDate;
	private int discount;
	private LocalDate startDate;
	private LocalDate expiryDate;

	@Override
	public String toString() {
		return "CouponDetail [id=" + id + ", couponCode=" + couponCode + ", createdDate=" + createdDate + ", discount="
				+ discount + ", startDate=" + startDate + ", expiryDate=" + expiryDate + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
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
	
	

}
