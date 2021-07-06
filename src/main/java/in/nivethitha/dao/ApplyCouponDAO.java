package in.nivethitha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import in.nivethitha.exception.ConnectionException;
import in.nivethitha.exception.DBException;
import in.nivethitha.exception.ServiceException;
import in.nivethitha.model.ApplyCoupon;
import in.nivethitha.util.ConnectionUtil;
import in.nivethitha.util.Logger;

public class ApplyCouponDAO {

	private ApplyCouponDAO() {
		// Default constructor
	}
	/**
	 * It returns userName,mobile number,coupon applied date
	 * @param co
	 * @throws DBException 
	 */
	public static void save(ApplyCoupon coupon) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into user_coupons(coupon_id,email_id,mobile_number,coupon_code,purchasing_amount,discounted_amount,applied_date,status)values(?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, coupon.getId());
			pst.setString(2, coupon.geteMailId());
			pst.setLong(3,coupon.getMobileNumber());
			pst.setString(4,coupon.getCouponCode());
			pst.setDouble(5, coupon.getPurchasingAmount());
			pst.setDouble(6, coupon.getDiscounted_amount());
			LocalDateTime date=coupon.getAppliedDate();
			Timestamp appliedDate=Timestamp.valueOf(date);
			pst.setTimestamp(7,appliedDate);
			pst.setString(8, coupon.getStatus());
			pst.execute();
			Logger.log("user details added successfully");
		} catch (ConnectionException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to add user details");
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
	}
	
	/**
	 * This method is used to get mobile number of particular user
	 * @param mobile 
	 * @param id
	 * @throws DBException
	 */
	public static long getMobileNumberByEmailId(String email) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Long mobileNumber=0L;
		//String couponCode="";
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select mobile_number from users where email=?";
			pst = con.prepareStatement(sql);
			pst.setString(1,email);
			rs=pst.executeQuery();
			if(rs.next()) {
				mobileNumber=rs.getLong("mobile_number");
			}
			Logger.log("mobile number matched");
		} catch (SQLException e) {
			throw new DBException("Unable to add mobile number");
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		System.out.println("mobile:"+mobileNumber);
		return mobileNumber;

	}
	public static String getCouponCode(int id) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String coupon="";
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select coupon_code from coupon_detail where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				 coupon=rs.getString("coupon_code");
			}
		} catch (SQLException e) {
			throw new DBException("Unable to get coupon code");
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		System.out.println("couponcode:"+coupon);
		return coupon;

	}
	public static int getDiscount(int id) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int discount =0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select discount from coupon_detail where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				discount=rs.getInt("discount");
			}
			Logger.log("discount matched");
		} catch (SQLException e) {
			throw new DBException("Unable to get discount");
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		System.out.println("discount"+discount);
		return discount;

	}
	
	public static int getNumberOfTimesUsed(String email) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		Long mobileNumber=ApplyCouponDAO.getMobileNumberByEmailId(email);
		int count =0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select count(mobile_number=?)as usageCount from user_coupons";
			pst = con.prepareStatement(sql);
			pst.setLong(1, mobileNumber);
			rs=pst.executeQuery();
			if(rs.next()) {
			count=rs.getInt("usageCount");
			}
			
			//Logger.log("discount matched");
		} catch (SQLException e) {
			throw new DBException("Unable to get nof");
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		System.out.println("count"+count);
		return count;

	}
	public static void main(String[] args) throws DBException, ServiceException {
		//getCouponCode(101);
		getNumberOfTimesUsed("nithya94.@gmail.com");
	}
	
}
