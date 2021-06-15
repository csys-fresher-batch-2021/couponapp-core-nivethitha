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
			assertEquals("Sorry!purchasing amount should be greater than 500 to get coupon", e.getMessage());
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
			assertEquals("Please give valid date", e.getMessage());
			Logger.trace(e);
		}

	}
}
