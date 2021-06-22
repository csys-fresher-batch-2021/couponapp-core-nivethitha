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
import in.nivethitha.exception.InvalidException;
import in.nivethitha.model.ApplyCoupon;
import in.nivethitha.service.ApplyCouponService;
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
	 * @param  
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
			String sql = "select expiry_date from coupondetails where coupon_code=?";
			pst = con.prepareStatement(sql);
			pst.setString(1,couponCode);
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

	/**
	 * This method is used to get number of times a coupon used
	 * @param id
	 * @return
	 * @throws DBException
	 * @throws InvalidException
	 */

	public static int getNumberOfTimesUsed(int id) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int numberOfTimesCouponUsed = 0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select no_of_times_used from coupondetails where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			if (rs.next()) {
				numberOfTimesCouponUsed = rs.getInt("no_of_times_used");

			}
		} catch (ConnectionException | SQLException e) {
			Logger.trace(e);
			throw new DBException("Unable to get how many times used");

		} finally {
			ConnectionUtil.close(rs, pst, con);

		}

		return numberOfTimesCouponUsed;
	}

	/**
	 * This method is used to set the row count
	 * @param id
	 * @return
	 * @throws InvalidException
	 * @throws DBException
	 */

	public static int toUpdateCountValue(int id) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int numberOfTimesUsed = ApplyCouponService.usageCount(id);

		try {
			con = ConnectionUtil.getConnection();
			String sql = "update coupondetails set no_of_times_used=? where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, numberOfTimesUsed);
			pst.setInt(2, id);
			pst.execute();

		} catch (ConnectionException | SQLException e) {
			Logger.trace(e);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return numberOfTimesUsed;

	}

	/**
	 * This method is used to get the updated row count
	 * @param id
	 * @param couponCode
	 * @return
	 * @throws InvalidException
	 * @throws DBException
	 */
	public static int getCountValue(int id, String couponCode) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int rowCount = 0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select no_of_times_used as count from coupondetails where id=? and coupon_code=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, couponCode);
			rs = pst.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt("count");

			}

		} catch (ConnectionException | SQLException e) {
			Logger.trace(e);
			throw new DBException("Unable to get number of times used");

		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return rowCount;

	}
	
}
