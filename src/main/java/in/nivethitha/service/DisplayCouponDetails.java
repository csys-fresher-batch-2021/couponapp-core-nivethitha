package in.nivethitha.service;

import java.util.List;

import in.nivethitha.dao.DisplayCouponDAO;
import in.nivethitha.exception.DBException;
import in.nivethitha.model.CouponDetail;
import in.nivethitha.util.Logger;

public class DisplayCouponDetails {
	private DisplayCouponDetails() {
		// Default constructor
	}

	/**
	 * This method is for display coupon details
	 * @throws DBException 
	 */
	public static List<CouponDetail> getAll() throws DBException {
		List<CouponDetail> siteCouponDetails = DisplayCouponDAO.getCoupondetails();
		Logger.log(siteCouponDetails);
		return siteCouponDetails;
	}
	public static void main(String[] args) throws DBException {
		getAll();
	}
}
