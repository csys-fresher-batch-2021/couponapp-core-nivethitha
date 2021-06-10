package in.nivethitha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import in.nivethitha.model.CouponDetail;
import in.nivethitha.util.ConnectionUtil;
import in.nivethitha.util.Logger;

public class CouponDAO {
	private CouponDAO() {
		// Default constructor
	}

	public static List<CouponDetail> getCoupondetails() {
		List<CouponDetail> siteCouponDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select id,shopping_site,coupon_code,discount,purchasing_amount,start_date,expiry_date,Status from coupondetails";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String shoppingSiteName = rs.getString("shopping_site");
				int discount = rs.getInt("discount");
				String couponCode = rs.getString("coupon_code");
				double purchasingAmount = rs.getDouble("purchasing_amount");
				Date openDate = rs.getDate("start_date");
				LocalDate startDate = openDate.toLocalDate();
				Date closeDate = rs.getDate("expiry_date");
				LocalDate expiryDate = closeDate.toLocalDate();
				String status = rs.getString("Status");
				// Store the data in model
				CouponDetail coupon = new CouponDetail(id, shoppingSiteName, couponCode, discount, purchasingAmount,
						startDate, expiryDate, status);
				// Store all user site coupon details in list
				siteCouponDetails.add(coupon);
			}
		} catch (Exception e) {
			Logger.trace(e);
			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		System.out.println(siteCouponDetails);
		return siteCouponDetails;
	}
	public static void main(String[] args) {
		getCoupondetails();
	}
}