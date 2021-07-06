package in.nivethitha.servicetest;

import org.junit.Test;

import in.nivethitha.exception.DBException;
import in.nivethitha.service.DisplayCouponDetails;

public class TestDisplayCouponDetails {
	/**
	 * Test case:To display all coupon details
	 * @throws DBException 
	 */
	@Test
	public void testDisplayCoupon() throws DBException {
		DisplayCouponDetails.getAll();
	}

}
