package in.nivethitha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import in.nivethitha.model.CouponDetail;
import in.nivethitha.util.ConnectionUtil;
import in.nivethitha.util.Logger;

public class CouponValidityDAO {
	private CouponValidityDAO() {
		//Default constructor
	}
	/**
	 * This method is used to get the coupon code and expiry date from database
	 * @return
	 */
	public static Map<String, LocalDate> getCouponValidity() {
		Map<String, LocalDate>validity = new HashMap<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select coupon_code,expiry_date from coupondetails";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String couponCode = rs.getString("coupon_code");
				Date closeDate = rs.getDate("expiry_date");
				LocalDate expiryDate = closeDate.toLocalDate();
				// Store the data in model
				CouponDetail coupon = new CouponDetail();
				coupon.setCouponCode(couponCode);
				coupon.setExpiryDate(expiryDate);
				// Store coupon validity details in list
				validity.put(couponCode, expiryDate);

			}
		} catch (Exception e) {
			Logger.trace(e);
			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return validity;
	}
}