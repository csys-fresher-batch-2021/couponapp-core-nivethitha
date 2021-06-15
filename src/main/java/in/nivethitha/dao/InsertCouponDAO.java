package in.nivethitha.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.nivethitha.exception.ConnectionException;
import in.nivethitha.exception.DBException;
import in.nivethitha.model.CouponDetail;
import in.nivethitha.util.ConnectionUtil;
import in.nivethitha.util.Logger;

public class InsertCouponDAO {
	private InsertCouponDAO() {
		//default constructor
	}

	/**
	 * This method is used to insert coupon details into database
	 * @param coupon
	 * @throws SQLException
	 * @throws DBException
	 */
	public static void save(CouponDetail coupon) throws SQLException, DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "insert into coupondetails(shopping_site,coupon_code,discount,purchasing_amount,start_date,expiry_date,Status)values(?,?,?,?,?,?,?)";
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, coupon.getShoppingSiteName());
			pst.setString(2, coupon.getCouponCode());
			pst.setInt(3, coupon.getDiscount());
			pst.setDouble(4, coupon.getPurchaseAmount());
			Date openDate = Date.valueOf(coupon.getStartDate());
			pst.setDate(5, openDate);
			Date closeDate = Date.valueOf(coupon.getExpiryDate());
			pst.setDate(6, closeDate);
			pst.setString(7, coupon.getStatus());
			pst.executeUpdate();
			Logger.log("coupon details added successfully");
		} catch (ConnectionException e) {
			Logger.trace(e);
			throw new DBException("Unable to add coupon details");
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}

	}

}
