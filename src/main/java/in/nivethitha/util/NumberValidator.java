package in.nivethitha.util;

import java.time.LocalDate;
import in.nivethitha.exception.InvalidException;

public class NumberValidator {
	private NumberValidator() {
		// Default constructor
	}

	/**
	 * This method is used to checking whether the discount percentage is greater
	 * than one or not
	 * @param discount
	 * @return
	 * @throws InvalidDiscountException
	 */
	public static boolean isPositiveDiscountPercentage(int discount) throws InvalidException {
		if (discount <= 0) {
			throw new InvalidException("discount percentage should not be lesser than 0");
		}
		return true;

	}

	/**
	 * This method is for checking whether the purchasing amount should not be
	 * lesser than 1000 If the amount is lesser than 1000,not able to give discount
	 * @param purchaseamount
	 * @return
	 * @throws InvalidException
	 * @throws InvalidPurchaseAmountException
	 */
	public static boolean isValidAmount(double purchaseAmount) throws InvalidException {

		if (purchaseAmount < 500) {

			throw new InvalidException("Sorry!purchasing amount should be greater than 500 to get coupon");
		}
		return false;
	}

	/**
	 * This method is for checking given date is expired or not
	 * @param givenDate
	 * @return
	 * @throws InvalidDateException
	 */
	public static boolean isValidDate(LocalDate givenDate) throws InvalidException {

		if (givenDate.isBefore(LocalDate.now())) {

			throw new InvalidException("Please give valid date");

		}
		return false;
	}
}
