package in.nivethitha.service;

import java.util.List;

import in.nivethitha.dao.ApplyCouponDAO;
import in.nivethitha.exception.DBException;
import in.nivethitha.exception.ExpiryDateException;
import in.nivethitha.exception.InvalidException;
import in.nivethitha.model.ApplyCoupon;
import in.nivethitha.util.DateValidator;
import in.nivethitha.util.Logger;

public class ApplyCouponService {
	private ApplyCouponService() {
		// Default constructor
	}

	/**
	 * This method is used to check the coupon validity and whether it is a valid
	 * coupon code or not if the given coupon code is valid it will subtract the
	 * discount percentage from your purchasing amount then it will display which
	 * amount you have to pay
	 * @param couponCode
	 * @param id
	 * @param String
	 * @return
	 * @throws InvalidException
	 * @throws ExpiryDateException
	 * @throws DBException
	 * @throws
	 */
	public static Double isValidCoupon(String couponCode, int id) throws InvalidException {

		Double priceAmount = 0d;
		List<ApplyCoupon> coupon = ApplyCouponDAO.getCoupon();
		try {
			DateValidator.isExpired(ApplyCouponDAO.getExpiryDate(couponCode));
		} catch (ExpiryDateException | DBException e1) {

			Logger.trace(e1);
		}

		for (ApplyCoupon coupons : coupon) {
			if (couponCode.equals(couponCode.toUpperCase()) && coupons.getId() == (id)) {
				try {
					priceAmount = coupons.getFinalBillAmount();
				} catch (Exception e) {

					e.printStackTrace();
					throw new InvalidException("Sorry!Unable to process coupon");

				}

				break;
			}

		}
		return priceAmount;

	}

}
