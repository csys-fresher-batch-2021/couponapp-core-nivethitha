package in.nivethitha.model;

import java.time.LocalDate;

public class CouponValidity {
	private String couponCode;
	private LocalDate expiryDate;

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "CouponValidity [couponCode=" + couponCode + ", expiryDate=" + expiryDate + "]";
	}

}
