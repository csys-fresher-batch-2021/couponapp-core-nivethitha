package in.nivethitha.service;

import java.sql.SQLException;
//import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import in.nivethitha.dao.CouponListDAO;
import in.nivethitha.exception.DBException;
import in.nivethitha.model.CouponDetail;
import in.nivethitha.util.Logger;

public class CouponService {
	private CouponService() {
		//Default constructor
	}
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
	public static void addCoupon(String siteName, String code,LocalDateTime createdDate, int discountPercent, double amount,
			LocalDate startingDate, LocalDate endingDate, String couponStatus) {
		CouponDetail cd = new CouponDetail();
		cd.setShoppingSiteName(siteName);
		cd.setCouponCode(code);
		cd.setCreatedDate(createdDate);;
		cd.setDiscount(discountPercent);
		cd.setPurchaseAmount(amount);
		cd.setStartDate(startingDate);
		cd.setExpiryDate(endingDate);
		cd.setStatus(couponStatus);
		try {
			CouponListDAO.save(cd);
		} catch (SQLException | DBException e) {
			Logger.trace(e);
		}

	}
	public static void main(String[] args) {
		String openingDate = "2021-09-01";
		LocalDate sdate = LocalDate.parse(openingDate);
		String closingDate = "2021-09-05";
		LocalDate edate = LocalDate.parse(closingDate);
		LocalDateTime createdDate=LocalDateTime.now();
		
     CouponService.addCoupon("clubfactory", "CLUB078",createdDate, 10, 7000, sdate, edate, "OPEN");
	}
	
}
