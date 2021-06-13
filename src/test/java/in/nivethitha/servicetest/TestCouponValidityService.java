package in.nivethitha.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import in.nivethitha.exception.ExpiryDateException;
import in.nivethitha.exception.InvalidCouponCodeException;
import in.nivethitha.service.CouponValidityService;
import in.nivethitha.util.Logger;

public class TestCouponValidityService {
	@Test
	public void testWithvalidCouponCode() throws InvalidCouponCodeException {
		try {
			String couponCode = "FLIP1020";

			boolean isMatched = CouponValidityService.isCouponExpired(couponCode);
			assertTrue(isMatched);

		} catch (Exception e) {
			assertEquals("Coupon is in progress", e.getMessage());

			Logger.trace(e);
		}

		System.out.println("--------------------------------------");

	}

	@Test
	public void testWithLowerCase() throws InvalidCouponCodeException {
		String couponCode = "fliP1020";
		try {
			boolean isMatched = CouponValidityService.isCouponExpired(couponCode);
			assertTrue(isMatched);
		} catch (ExpiryDateException e) {
			assertEquals("Coupon is in progress", e.getMessage());

			Logger.trace(e);

		}
		System.out.println("-------------------------------------");

	}

	@Test
	public void testWithInvalidCode() throws InvalidCouponCodeException {
		String couponCode = "AMZYL020";
		try {
			boolean isMatched = CouponValidityService.isCouponExpired(couponCode);
			assertFalse(isMatched);
		} catch (InvalidCouponCodeException | ExpiryDateException e) {
			assertEquals("Sorry!coupon code does not match", e.getMessage());

			Logger.trace(e);
		}
		System.out.println("-------------------------------------");

	}

}
