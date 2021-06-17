package in.nivethitha.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.nivethitha.exception.ConnectionException;
import in.nivethitha.exception.DBException;
import in.nivethitha.model.ApplyCoupon;
import in.nivethitha.util.ConnectionUtil;
import in.nivethitha.util.Logger;

public class ApplyCouponDAO {
	private ApplyCouponDAO() {
		// Default constructor
	}

	/**
	 * This method is used to get the couponCode and final bill amount from database
	 * @return
	 */
	public static List<ApplyCoupon> getCoupon() {
		List<ApplyCoupon> applyCoupon = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select (purchasing_amount-(purchasing_amount*discount)/100) as bill_amount,coupon_code,id from coupondetails";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String couponCode = rs.getString("coupon_code");
				double billAmount = rs.getDouble("bill_amount");
				int id = rs.getInt("id");
				ApplyCoupon cop = new ApplyCoupon();
				cop.setCouponCode(couponCode);
				cop.setId(id);
				cop.setFinalBillAmount(billAmount);
				applyCoupon.add(cop);

			}

		} catch (ConnectionException | SQLException e) {
			Logger.trace(e);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return applyCoupon;

	}

	/**
	 * This method is used to get the expiry date
	 * @param couponCode
	 * @return
	 * @throws DBException
	 */
	public static LocalDate getExpiryDate(String couponCode) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		LocalDate expiryDate = null;
		try {

			con = ConnectionUtil.getConnection();
			String sql = "select expiry_date from coupondetails where coupon_code=" + "'" + couponCode + "'";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				Date date = rs.getDate("expiry_date");
				expiryDate = date.toLocalDate();
			}

		} catch (SQLException e) {
			throw new DBException("Unable to get expiry date");
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return expiryDate;

	}

}
