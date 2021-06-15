package in.nivethitha.util;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class TestNumberValidator {
	@Test
	public void testWithNegativeDiscountPercentage() {
		try {
			int discount = -5;
			NumberValidator.isPositiveDiscountPercentage(discount);
		} catch (Exception e) {
			assertEquals("discount percentage should not be lesser than 0", e.getMessage());

			Logger.trace(e);
		}
	}

	@Test
	public void testWithLesserThanFiveHundred() {
		try {
			double purchaseAmount = 200;
			NumberValidator.isValidAmount(purchaseAmount);
		} catch (Exception e) {
			assertEquals("Sorry!coupon is available for only the purchasing amount should be above 500Rs", e.getMessage());
			Logger.trace(e);
		}

	}

	@Test
	public void testWithExpiredDate() {
		try {
			String date = "2021-05-21";
			LocalDate givenDate = LocalDate.parse(date);
			NumberValidator.isValidDate(givenDate);
		} catch (Exception e) {
			assertEquals("don't give expired date", e.getMessage());
			Logger.trace(e);
		}

	}
}
