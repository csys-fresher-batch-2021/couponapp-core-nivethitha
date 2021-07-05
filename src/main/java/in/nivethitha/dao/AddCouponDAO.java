package in.nivethitha.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import in.nivethitha.exception.ConnectionException;
import in.nivethitha.exception.DBException;
import in.nivethitha.model.CouponDetail;
import in.nivethitha.util.ConnectionUtil;
import in.nivethitha.util.Logger;

public class AddCouponDAO {
	private AddCouponDAO() {
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
		String sql = "insert into coupon_detail(id,coupon_code,created_date,discount,start_date,expiry_date)values(?,?,?,?,?,?)";
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, coupon.getId());
			pst.setString(2, coupon.getCouponCode());
			LocalDateTime cDate=coupon.getCreatedDate();
			Timestamp createdDate=Timestamp.valueOf(cDate);
			pst.setTimestamp(3,createdDate);	
			pst.setInt(4, coupon.getDiscount());
			Date openDate = Date.valueOf(coupon.getStartDate());
			pst.setDate(5, openDate);
			Date closeDate = Date.valueOf(coupon.getExpiryDate());
			pst.setDate(6, closeDate);
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
