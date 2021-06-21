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
	public static double isValidCoupon(int id, String couponCode) throws InvalidException, DBException {

		Double priceAmount = 0d;
		String toIgnoreCase = couponCode.toUpperCase();
		List<ApplyCoupon> coupon = ApplyCouponDAO.getCoupon();
		try {
			// to get expiry date
			DateValidator.isExpired(ApplyCouponDAO.getExpiryDate(couponCode));
			// to get the count of particular id(number of times used)
			getCountOfparticularId(id, couponCode);
			// to get updated row count
			usageCount(id);
			// to get number of times coupon used
			ApplyCouponDAO.toUpdateCountValue(id);

		} catch (ExpiryDateException | DBException e) {
			Logger.trace(e);
		}
		for (ApplyCoupon coupons : coupon) {
			if (couponCode.equals(toIgnoreCase) && coupons.getId() == (id)) {
				priceAmount = coupons.getFinalBillAmount();
				break;
			}
		}
		System.out.println(priceAmount);
		return priceAmount;

	}

	/**
	 * This method is used to get the updated usage count value
	 * @param id
	 * @return
	 * @throws DBException
	 * @throws InvalidException
	 */
	public static int usageCount(int id) throws DBException, InvalidException {
		int count = ApplyCouponDAO.getNumberOfTimesUsed(id);
		System.out.println("usagecount" + (count++));
		return count++;

	}

	/**
	 * This method is used to get the count of particular user id
	 * @param id
	 * @param couponCode
	 * @throws InvalidException
	 * @throws DBException
	 */
	public static void getCountOfparticularId(int id, String couponCode) throws InvalidException, DBException {
		int particularIdCount = ApplyCouponDAO.getCountValue(id, couponCode);
		if (particularIdCount >= 2) {
			throw new InvalidException("Sorry to say this we don�t offer discount for this because the same coupon code is already two times used by the user");
		}

	}

	public static void main(String[] args) throws InvalidException, DBException {
		isValidCoupon(2,"MYNT1120");
	}

}
