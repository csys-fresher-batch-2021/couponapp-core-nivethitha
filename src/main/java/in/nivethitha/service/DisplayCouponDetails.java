package in.nivethitha.service;

import java.util.List;

import in.nivethitha.dao.CouponDAO;
import in.nivethitha.model.CouponDetails;

public class DisplayCouponDetails {
	private DisplayCouponDetails() {
           //Default constructor
	}

	/**
	 * This method is for displaying coupon details
	 */
	public static List<CouponDetails> showDetails() {
		CouponDAO couponDAO = new CouponDAO();
		List<CouponDetails> siteCouponDetails = couponDAO.data();
		for (CouponDetails couponDetails : siteCouponDetails) {

			System.out.println(couponDetails);

		}
		return siteCouponDetails;
	}

	public static void main(String[] args) {
		showDetails();
	}
}
