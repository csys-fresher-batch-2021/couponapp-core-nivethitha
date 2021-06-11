package in.nivethitha.service;

import java.time.LocalDate;
import java.util.Map;
import in.nivethitha.dao.CouponValidityDAO;
import in.nivethitha.exception.ExpiryDateException;
import in.nivethitha.util.DateValidator;
import in.nivethitha.util.Logger;

public class CouponValidityService {
	private CouponValidityService() {
		// Default constructor
	}

	/**
	 * This method is for checking whether the coupon is expired or not
	 * 
	 * @param date
	 * @return
	 * @throws InvalidDateException
	 */
	public static boolean isCouponExpired(String couponCode) throws ExpiryDateException {

		Map<String, LocalDate> CouponValidity = CouponValidityDAO.getCouponValidity();
		if (CouponValidity.containsKey(couponCode.toUpperCase())) {
			if (DateValidator.isExpired(CouponValidity.get(couponCode.toUpperCase()))) {
				Logger.log("Coupon is in progress");
			}
		} else {
			Logger.log("Sorry!coupon code does not match");
		}
		return false;

	}

}
