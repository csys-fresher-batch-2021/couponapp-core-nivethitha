package in.nivethitha.service;

import java.sql.SQLException;
//import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import in.nivethitha.dao.AddCouponDAO;
import in.nivethitha.exception.DBException;
import in.nivethitha.model.CouponDetail;
import in.nivethitha.util.Logger;

public class AddCouponService {
	private AddCouponService() {
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
	public static void addCoupon(int id,String code,LocalDateTime createdDate, int discountPercent,LocalDate startingDate, LocalDate endingDate) {
		CouponDetail cd = new CouponDetail();
		cd.setId(id);
		cd.setCouponCode(code);
		cd.setCreatedDate(createdDate);
		cd.setDiscount(discountPercent);
		cd.setStartDate(startingDate);
		cd.setExpiryDate(endingDate);
		try {
			AddCouponDAO.save(cd);
		} catch (SQLException | DBException e) {
			Logger.trace(e);
		}

	}
	public static void main(String[] args) {
		String openingDate = "2021-07-11";
		LocalDate sdate = LocalDate.parse(openingDate);
		String closingDate = "2021-07-20";
		LocalDate edate = LocalDate.parse(closingDate);
		LocalDateTime createdDate=LocalDateTime.now();
		
     AddCouponService.addCoupon(107,"DOMI564",createdDate, 35,sdate, edate);
	}
	
}
