package in.nivethitha.validator;


import in.nivethitha.exception.EmptyStringException;
import in.nivethitha.exception.InvalidCouponCodeLength;
import in.nivethitha.model.CouponDetail;
import in.nivethitha.util.NumberValidator;
import in.nivethitha.util.StringValidator;

public class AddCouponValidation {
	/**
	 * This method is used to check whether site name and coupon code field,status
	 * should not be empty and discount field should not be lesser than 0 then
	 * coupon code is only for those who are purchasing above 1000 Rs and start date
	 * and expiry date should not be the expired date
	 * @param co
	 * @return
	 * @throws EmptyStringException
	 * @throws InvalidCouponCodeLength
	 */
	public static boolean isValidCouponDetails(CouponDetail co) throws EmptyStringException, InvalidCouponCodeLength {
		boolean isValid = false;
		if (StringValidator.isValidString(co.getShoppingSiteName()) && StringValidator.isvalidCoupon(co.getCouponCode())
				&& NumberValidator.isPositiveDiscountPercentage(co.getDiscount())
				&& NumberValidator.isValidAmount(co.getPurchaseAmount())
				&& NumberValidator.isValidDate(co.getStartDate()) && NumberValidator.isValidDate(co.getExpiryDate())
				&& StringValidator.isValidString(co.getStatus())) {
			isValid = true;
		}
		return isValid;
	}

	

	
}
