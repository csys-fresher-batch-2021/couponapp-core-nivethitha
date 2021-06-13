package in.nivethitha.service;

import java.time.LocalDate;
import java.util.Map;
import in.nivethitha.dao.CouponValidityDAO;
import in.nivethitha.exception.ExpiryDateException;
import in.nivethitha.exception.InvalidCouponCodeException;
import in.nivethitha.util.DateValidator;
import in.nivethitha.util.Logger;

public class CouponValidityService {
	private CouponValidityService() {
		// Default constructor
	}

	/**
	 * This method is for checking whether the coupon is expired or not
	 * @param date
	 * @return
	 * @throws InvalidCouponCodeException
	 * @throws InvalidDateException
	 */
	public static boolean isCouponExpired(String couponCode) throws ExpiryDateException, InvalidCouponCodeException {

		Map<String, LocalDate> couponValidity = CouponValidityDAO.getCouponValidity();
		boolean isMatched = false;
		if (couponValidity.containsKey(couponCode.toUpperCase())) {
			if (DateValidator.isExpired(couponValidity.get(couponCode.toUpperCase()))) {
				Logger.log("Coupon is in progress");
				isMatched = true;
			}
		} else {
			throw new InvalidCouponCodeException("Sorry!coupon code does not match");
		}
		return isMatched;

	}

}
