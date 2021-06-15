package in.nivethitha.util;

import in.nivethitha.exception.EmptyStringException;
import in.nivethitha.exception.InvalidException;

public class StringValidator {
	private StringValidator() {
		//Default constructor
	}
	/**
	 * This method is used to check whether the field is empty or null
	 * @param name
	 * @return
	 * @throws EmptyStringException
	 */
	public static boolean isValidString(String name) throws EmptyStringException {

		if (name == null || name.trim().equals("")) {
			
			throw new EmptyStringException("field should not be empty or null");
		} else {

			return true;
		}
	}
	/**
	 * This method is for coupon code's length should not be lesser than five
	 * @param couponCode
	 * @return
	 * @throws InvalidCouponCodeLength
	 */
	public static boolean isvalidCoupon(String couponCode) throws InvalidException {
		if(couponCode.length()<5) {
			throw new InvalidException("Coupon code should not be lesser than five");
		}
		return false;
		
	}
}
