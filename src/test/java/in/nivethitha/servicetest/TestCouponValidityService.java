package in.nivethitha.servicetest;

import org.junit.Test;
import in.nivethitha.exception.ExpiryDateException;
import in.nivethitha.service.CouponValidityService;
import in.nivethitha.util.Logger;

public class TestCouponValidityService {
	@Test
	public void testWithvalidCouponCode() {
		String couponCode = "FLIP1020";
		try {
			CouponValidityService.isCouponExpired(couponCode);
		} catch (ExpiryDateException e) {
			Logger.trace(e);

		}
		System.out.println("--------------------------------------");
	}

	@Test
	public void testWithLowerCase() {
		String couponCode = "fliP1020";
		try {
			CouponValidityService.isCouponExpired(couponCode);
		} catch (ExpiryDateException e) {
			Logger.trace(e);

		}
		System.out.println("-------------------------------------");

	}

	@Test
	public void testWithInvalidCode() {
		String couponCode = "AMZYL020";
		try {
			CouponValidityService.isCouponExpired(couponCode);
		} catch (ExpiryDateException e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------------");

	}

}
