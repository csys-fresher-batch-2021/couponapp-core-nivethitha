package in.nivethitha.servicetest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import in.nivethitha.service.AddCouponService;
import in.nivethitha.util.Logger;

public class TestAddCouponService {
	@Test
	/**
	 * This method is used to test whether the data is inserted into database or not
	 * If the data is inserted, it will display the success message in console
	 */
	public void testAddCouponDetails() {
		String openingDate = "2021-07-11";
		LocalDate sdate = LocalDate.parse(openingDate);
		String closingDate = "2021-07-20";
		LocalDate edate = LocalDate.parse(closingDate);
		LocalDateTime createdDate=LocalDateTime.now();
		
		try {
			
			AddCouponService.addCoupon(107,"DOMI564",createdDate, 35,sdate, edate);
		} catch (Exception e) {
			assertEquals("coupon details added successfully", e.getMessage());

			Logger.trace(e);
		}
	}

}
