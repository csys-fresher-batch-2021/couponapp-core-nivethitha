package in.nivethitha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.nivethitha.exception.DBConnectionCloseException;
import in.nivethitha.model.CouponDetails;
import in.nivethitha.util.ConnectionUtil;

public class CouponDAO {
	public List<CouponDetails> data() {
		List<CouponDetails> siteCouponDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select Id,ShoppingSite,Discount,PurchasingAmount,Validity,Status from coupondetails";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("Id");
				String shoppingSite = rs.getString("ShoppingSite");
				int discount = rs.getInt("Discount");
				double purchasingAmount = rs.getDouble("PurchasingAmount");
				String validity = rs.getString("Validity");
				String status = rs.getString("Status");
				// Store the data in model
				CouponDetails coupon = new CouponDetails(id, shoppingSite, discount, purchasingAmount, validity,status);
				// Store all user site coupon details in list
				siteCouponDetails.add(coupon);
			}
		} catch (Exception e) {

			e.getMessage();
		} finally {
			try {
				ConnectionUtil.close(rs, pst, connection);
			} catch (DBConnectionCloseException e) {
				e.printStackTrace();
			}
		}
		System.out.println(siteCouponDetails);
		return siteCouponDetails;
	}

}
