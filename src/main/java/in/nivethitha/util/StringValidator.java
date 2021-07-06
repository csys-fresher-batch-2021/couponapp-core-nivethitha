package in.nivethitha.util;

import in.nivethitha.exception.ValidatorException;

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
	public static boolean isValidString(String name) throws ValidatorException {

		if (name == null || name.trim().equals("")) {
			
			throw new ValidatorException("field should not be empty or null");
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
	public static boolean isvalidCoupon(String couponCode) throws ValidatorException {
		
		if(couponCode.startsWith("2C")) {
			
			throw new ValidatorException("Invalid coupon");
		}
		return false;
		
	}
}
