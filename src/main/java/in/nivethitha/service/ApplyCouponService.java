package in.nivethitha.service;

import java.util.List;

import in.nivethitha.dao.ApplyCouponDAO;
import in.nivethitha.exception.DBException;
import in.nivethitha.exception.ExpiryDateException;
import in.nivethitha.model.ApplyCoupon;
import in.nivethitha.util.DateValidator;

public class ApplyCouponService {
	private ApplyCouponService() {
		// Default constructor
	}
/**
 * This method is used to check the coupon validity and whether it is a valid coupon code or not
 * if the given coupon code is valid it will subtract the discount percentage from your purchasing amount
 * then it will display which amount you have to pay
 * @param couponCode
 * @param id
 * @param String 
 * @return
 * @throws ExpiryDateException
 * @throws DBException
 */
	public static Double isValidCoupon(String couponCode, int id) throws ExpiryDateException, DBException {

		Double priceAmount = 0d;
		List<ApplyCoupon> coupon = ApplyCouponDAO.getCoupon();
		DateValidator.isExpired(ApplyCouponDAO.getExpiryDate(couponCode));

		for (ApplyCoupon coupons : coupon) {
			if (couponCode.equals(couponCode.toUpperCase()) && coupons.getId() == (id)) {
				try {
					priceAmount = coupons.getFinalBillAmount();
				} catch (Exception e) {

					e.printStackTrace();
					throw new RuntimeException("Sorry!Unable to process coupon");

				}

				break;
			}

		}
		return priceAmount;

	}

}
