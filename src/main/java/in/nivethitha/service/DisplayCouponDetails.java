package in.nivethitha.service;

import java.util.List;
import in.nivethitha.dao.CouponDAO;
import in.nivethitha.model.CouponDetail;

public class DisplayCouponDetails {
	private DisplayCouponDetails() {
		// Default constructor
	}

	/**
	 * This method is for displaying coupon details
	 */
	public static List<CouponDetail> showDetails() {
		List<CouponDetail> siteCouponDetails = CouponDAO.getCoupondetails();
		for (CouponDetail couponDetails : siteCouponDetails) {

			System.out.println(couponDetails);

		}
		return siteCouponDetails;
	}

}
