package in.nivethitha.exception;

public class InvalidCouponCodeLength extends Exception {

	/**
	 * It throws the invalid coupon length exception message
	 */
	private static final long serialVersionUID = 7689721153101419554L;
	public InvalidCouponCodeLength(String message) {
		super(message);
	}

}
