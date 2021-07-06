package in.nivethitha.servicetest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import in.nivethitha.exception.DBException;
import in.nivethitha.exception.ExpiryDateException;
import in.nivethitha.exception.ServiceException;
import in.nivethitha.service.ApplyCouponService;

public class TestApplyCouponService {
	/**
	 * This method returns the expected bill amount as 3910.0
	 * @throws ExpiryDateException
	 */
	@Test
	public void testWithvalidCouponAndNotExpired() throws ExpiryDateException {
		int id = 1;
		String couponCode = "FLIP1020";

		try {
			Double result = ApplyCouponService.isValidCoupon(id, couponCode);
			//System.out.println("Your bill amount is: " + result);
			assertEquals(3910.0, result, 0.1);

		} catch (ServiceException | DBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method throws the expiry exception because this coupon date is expired
	 */
	@Test
	public void testWithExpiredCoupon() {// expiry date-2021-05-25
		int id = 3;
		String couponCode = "AMZOG32";
		try {
			ApplyCouponService.isValidCoupon(id, couponCode);
		} catch ( DBException | ExpiryDateException | ServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method throws invalid exception,the limit exceeds two
	 */

	@Test
	public void testWithNumberOfTimesExceededLimit() {// limit-2
		int id = 10;
		String couponCode = "CLUB078";
		try {
			ApplyCouponService.isValidCoupon(id, couponCode);
		} catch (ServiceException | DBException | ExpiryDateException e) {
			e.printStackTrace();
		}
	}
}
