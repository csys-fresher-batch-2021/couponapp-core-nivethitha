package in.nivethitha.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import in.nivethitha.exception.DBException;
import in.nivethitha.model.CouponDetail;
import in.nivethitha.util.ConnectionUtil;
import in.nivethitha.util.Logger;

public class DisplayCouponDAO {
	private DisplayCouponDAO() {
		// Default constructor
	}
/**
 * This method is used to get the coupon details
 * @return
 * @throws DBException
 */
	public static List<CouponDetail> getCoupondetails() throws DBException {
		List<CouponDetail> siteCouponDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select id,coupon_code,created_date,discount,start_date,expiry_date from coupon_detail";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				int discount = rs.getInt("discount");
				Timestamp date = rs.getTimestamp("created_date");
				LocalDateTime createdDate = date.toLocalDateTime();
				String couponCode = rs.getString("coupon_code");
				Date openDate = rs.getDate("start_date");
				LocalDate startDate = openDate.toLocalDate();
				Date closeDate = rs.getDate("expiry_date");
				LocalDate expiryDate = closeDate.toLocalDate();
				// Store the data in model
				CouponDetail coupon = new CouponDetail();
				coupon.setId(id);
				coupon.setCreatedDate(createdDate);
				coupon.setDiscount(discount);
				coupon.setCouponCode(couponCode);
				coupon.setStartDate(startDate);
				coupon.setExpiryDate(expiryDate);
				siteCouponDetails.add(coupon);
			}
			Logger.log("successfully added");
		} catch (Exception e) {
			Logger.trace(e);
			throw new DBException("Unable to add coupon detail");
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return siteCouponDetails;

	}

}