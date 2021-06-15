package in.nivethitha.util;

import java.time.LocalDate;

public class NumberValidator {
	/**
	 * This method is used to checking whether the discount percentage is greater
	 * than one or not
	 * @param discount
	 * @return
	 */
	public static boolean isPositiveDiscountPercentage(int discount) {
		if (discount <= 0) {
			throw new RuntimeException("discount percentage should not be lesser than 0");
		}
		return true;

	}

	/**
	 * This method is for checking whether the purchasing amount should not be
	 * lesser than 1000 If the amount is lesser than 1000,not able to give discount
	 * @param purchaseamount
	 * @return
	 */
	public static boolean isValidAmount(double purchaseAmount) {

		if (purchaseAmount < 500) {

			throw new RuntimeException(
					"Sorry!coupon is available for only the purchasing amount should be above 500Rs");
		}
		return false;
	}

	/**
	 * This method is for checking given date is expired or not
	 * @param givenDate
	 * @return
	 */
	public static boolean isValidDate(LocalDate givenDate) {

		if (givenDate.isBefore(LocalDate.now())) {

			throw new RuntimeException("don't give expired date");

		}
		return false;
	}
}
