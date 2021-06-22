package in.nivethitha.model;

public class ApplyCoupon {

	private double finalBillAmount;
	private String couponCode;
	private int id;
	private int numberOfTimesCouponUsed;

	public double getFinalBillAmount() {
		return finalBillAmount;
	}

	public void setFinalBillAmount(double finalBillAmount) {
		this.finalBillAmount = finalBillAmount;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfTimesCouponUsed() {
		return numberOfTimesCouponUsed;
	}

	public void setNumberOfTimesCouponUsed(int numberOfTimesCouponUsed) {
		this.numberOfTimesCouponUsed = numberOfTimesCouponUsed;
	}

	@Override
	public String toString() {
		return "ApplyCoupon [finalBillAmount=" + finalBillAmount + ", couponCode=" + couponCode + ", id=" + id
				+ ", numberOfTimesCouponUsed=" + numberOfTimesCouponUsed + "]";
	}

}