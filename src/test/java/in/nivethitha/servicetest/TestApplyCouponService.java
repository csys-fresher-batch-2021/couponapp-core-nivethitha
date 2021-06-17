package in.nivethitha.servicetest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import in.nivethitha.exception.DBException;
import in.nivethitha.exception.ExpiryDateException;
import in.nivethitha.service.ApplyCouponService;
import in.nivethitha.util.Logger;

public class TestApplyCouponService {
	@Test
	public void testWithValidCouponCode() {
		int id = 10;
		String couponCode = "CLUB078";
		try {
			Double billAmount = ApplyCouponService.isValidCoupon(couponCode, id);
			System.out.println("Your bill amount is " + billAmount);
			assertEquals(6300.0, billAmount, 0.001);

		} catch (ExpiryDateException | DBException e) {

			Logger.trace(e);
		}
	}

	@Test
	public void testWithExpiredCouponCode() {
		int id = 3;
		String couponCode = "AMZOG32";
		try {
			Double billAmount = ApplyCouponService.isValidCoupon(couponCode, id);
			System.out.println("Your bill amount is " + billAmount);
		} catch (ExpiryDateException | DBException e) {
			assertEquals("Coupon has expired", e.getMessage());

			Logger.trace(e);
		}
	}
}
