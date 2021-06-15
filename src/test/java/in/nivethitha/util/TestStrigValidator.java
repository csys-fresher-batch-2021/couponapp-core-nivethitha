package in.nivethitha.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import in.nivethitha.exception.EmptyStringException;
import in.nivethitha.exception.InvalidCouponCodeLength;

public class TestStrigValidator {
	@Test
	public void testWithEmptyString() {
		String name = "";
		try {
			StringValidator.isValidString(name);
		} catch (EmptyStringException e) {
			assertEquals("site name should not be empty or null", e.getMessage());
			Logger.trace(e);
		}
	}

	@Test
	public void testWithNullvalue() {
		String name = null;
		try {
			StringValidator.isValidString(name);
		} catch (EmptyStringException e) {
			assertEquals("field should not be empty or null", e.getMessage());
			Logger.trace(e);
		}

	}

	@Test
	public void WithInvalidCouponcodeLength() {
		String couponCode = "FL1";
		try {
			StringValidator.isvalidCoupon(couponCode);
		} catch (InvalidCouponCodeLength e) {
			assertEquals("Coupon code should not be lesser than five", e.getMessage());

			Logger.trace(e);
		}
	}
}
