package in.nivethitha.service;

import java.time.LocalDate;
import java.util.Map;

import in.nivethitha.dao.CouponValidityDAO;
import in.nivethitha.exception.ExpiryDateException;
import in.nivethitha.exception.InvalidCouponCodeException;
import in.nivethitha.exception.ServiceException;
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
	 * @throws ServiceException 
	 * @throws InvalidDateException
	 */
	public static boolean isCouponExpired(String couponCode) throws ExpiryDateException,ServiceException {

		Map<String, LocalDate> couponValidity = CouponValidityDAO.getCouponValidity();
		boolean isMatched = false;
		if (couponValidity.containsKey(couponCode.toUpperCase())) {
			if (DateValidator.isExpired(couponValidity.get(couponCode.toUpperCase()))) {
				Logger.log("Coupon is in progress");
				isMatched = true;
			}
		} else {
			throw new ServiceException("Sorry!inavlid coupon");
		}
		return isMatched;

	}
	public static void main(String[] args) throws ExpiryDateException, InvalidCouponCodeException, ServiceException {
		isCouponExpired("MYNT1120");
	}

}
