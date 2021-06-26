package in.nivethitha.servicetest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import in.nivethitha.service.CouponService;
import in.nivethitha.util.Logger;

public class TestCouponService {
	@Test
	/**
	 * This method is used to test whether the data is inserted into database or not
	 * If the data is inserted, it will display the success message in console
	 */
	public void testAddCouponDetails() {
		String openingDate = "2021-09-01";
		LocalDate sdate = LocalDate.parse(openingDate);
		String closingDate = "2021-09-05";
		LocalDate edate = LocalDate.parse(closingDate);
		String cDate="2021-06-02 04:00:00";
		LocalDateTime createdDate=LocalDateTime.parse(cDate);
		
		try {
			
			CouponService.addCoupon("clubfactory", "CLUB078",createdDate, 10, 7000, sdate, edate, "OPEN");
		} catch (Exception e) {
			assertEquals("coupon details added successfully", e.getMessage());

			Logger.trace(e);
		}
	}

}
