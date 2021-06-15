package in.nivethitha.servicetest;

import java.time.LocalDate;

import org.junit.Test;

import in.nivethitha.service.AddCouponService;

public class TestAddCouponService {
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
		AddCouponService.addCoupon("clubfactory", "CLUB078", 18, 7000, sdate, edate, "OPEN");
	}

}
