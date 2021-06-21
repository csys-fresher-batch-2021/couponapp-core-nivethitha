package in.nivethitha.servicetest;


import org.junit.Test;

import in.nivethitha.exception.DBException;
import in.nivethitha.exception.InvalidException;
import in.nivethitha.service.ApplyCouponService;

public class TestApplyCouponService {
@Test
	public void testWithExceededCount() {
		int id=10;
		String couponCode="CLUB078";
		
		try {
			Double result=ApplyCouponService.isValidCoupon(id,couponCode);
			System.out.println(result);
		} catch (InvalidException | DBException e) {
			
			e.printStackTrace();
		}
	}

}

	
