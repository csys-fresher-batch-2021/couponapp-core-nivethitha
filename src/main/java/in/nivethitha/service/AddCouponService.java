package in.nivethitha.service;

import java.sql.SQLException;
import java.time.LocalDate;

import in.nivethitha.dao.InsertCouponDAO;
import in.nivethitha.exception.DBException;
import in.nivethitha.model.CouponDetail;
import in.nivethitha.util.Logger;

public class AddCouponService {
	/**
	 * This method is used to insert the coupon details into DAO
	 * @param siteName
	 * @param code
	 * @param discountPercent
	 * @param amount
	 * @param startingDate
	 * @param endingDate
	 * @param couponStatus
	 */
	public static void addCoupon(String siteName, String code, int discountPercent, double amount,
			LocalDate startingDate, LocalDate endingDate, String couponStatus) {
		CouponDetail cd = new CouponDetail();
		cd.setShoppingSiteName(siteName);
		cd.setCouponCode(code);
		cd.setDiscount(discountPercent);
		cd.setPurchaseAmount(amount);
		cd.setStartDate(startingDate);
		cd.setExpiryDate(endingDate);
		cd.setStatus(couponStatus);
		try {
			InsertCouponDAO.save(cd);
		} catch (SQLException | DBException e) {
			Logger.trace(e);
		}

	}

}
