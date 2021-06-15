package in.nivethitha.validator;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import in.nivethitha.exception.EmptyStringException;
import in.nivethitha.exception.InvalidException;
import in.nivethitha.util.Logger;
import in.nivethitha.util.NumberValidator;
import in.nivethitha.util.StringValidator;

public class TestAddCouponvalidator {
	@Test
	public void testSiteNameWithEmptystring() {
		try {
			StringValidator.isValidString("");
		} catch (EmptyStringException e) {
			assertEquals("site name should not be empty or null", e.getMessage());
			Logger.trace(e);
		}
	}

	@Test
	public void testCouponCodeLengthWithLesserThanFive() {
		try {
			StringValidator.isvalidCoupon("");
		} catch (InvalidException e) {
			assertEquals("Coupon code should not be lesser than five", e.getMessage());

			Logger.trace(e);
		}
	}

	@Test
	public void testDiscountwithNegativeValue() {
		try {
			NumberValidator.isPositiveDiscountPercentage(0);
		} catch (Exception e) {
			assertEquals("discount percentage should not be lesser than 0", e.getMessage());

			Logger.trace(e);
		}
	}

	@Test
	public void testPurchasingAmountWithLesserThanFiveHundred() {
		try {
			NumberValidator.isValidAmount(100);
		} catch (Exception e) {
			assertEquals("Sorry!purchasing amount should be greater than 500 to get coupon",e.getMessage());

			Logger.trace(e);
		}
	}

	@Test
	public void testWithExpiredStartDate() {
		String date = "2021-06-10";
		LocalDate startDate = LocalDate.parse(date);
		try {
			NumberValidator.isValidDate(startDate);
		} catch (Exception e) {
			assertEquals("don't give expired date", e.getMessage());

			Logger.trace(e);
		}
	}

	@Test
	public void testWithExpiredDate() {
		String date = "2021-06-14";
		LocalDate endDate = LocalDate.parse(date);
		try {
			NumberValidator.isValidDate(endDate);
		} catch (Exception e) {
			assertEquals("don't give expired date", e.getMessage());

			Logger.trace(e);
		}
	}

	@Test
	public void testWithEmptystatus() {
		try {
			StringValidator.isValidString(null);
		} catch (EmptyStringException e) {
			assertEquals("field should not be empty or null", e.getMessage());

			Logger.trace(e);
		}
	}
}