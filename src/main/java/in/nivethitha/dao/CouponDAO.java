package in.nivethitha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import in.nivethitha.model.CouponDetails;
import in.nivethitha.util.ConnectionUtil;

public class CouponDAO {

	public static List<CouponDetails> getCoupondetails() {
		List<CouponDetails> siteCouponDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select id,shopping_site,discount,purchasing_amount,start_date,expiry_date,Status from coupondetails";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String shoppingSite = rs.getString("shopping_site");
				int discount = rs.getInt("discount");
				double purchasingAmount = rs.getDouble("purchasing_amount");
				Date startDate = rs.getDate("start_date");
				Date expiryDate = rs.getDate("expiry_date");
				String status = rs.getString("Status");
				// Store the data in model
				CouponDetails coupon = new CouponDetails(id, shoppingSite, discount, purchasingAmount, startDate,
						expiryDate, status);
				// Store all user site coupon details in list
				siteCouponDetails.add(coupon);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
