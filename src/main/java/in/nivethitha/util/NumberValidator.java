package in.nivethitha.util;

import java.time.LocalDate;
import in.nivethitha.exception.ServiceException;

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
	public static boolean isPositiveDiscountPercentage(int discount) throws ServiceException {
		if (discount <= 0) {
			throw new ServiceException("discount percentage should not be lesser than 0");
		}
		return true;

	}

	/**
	 * This method is for checking whether the purchasing amount should not be
	 * lesser than 1000 If the amount is lesser than 1000,not able to give discount
	 * @param purchaseamount
	 * @return
	 * @throws ServiceException
	 * @throws InvalidPurchaseAmountException
	 */
	public static boolean isValidAmount(double purchaseAmount) throws ServiceException {

		if (purchaseAmount < 500) {

			throw new ServiceException("Sorry!purchasing amount should be greater than 500 to get coupon");
		}
		return false;
	}

	/**
	 * This method is for checking given date is expired or not
	 * @param givenDate
	 * @return
	 * @throws InvalidDateException
	 */
	public static boolean isValidDate(LocalDate givenDate) throws ServiceException {

		if (givenDate.isBefore(LocalDate.now())) {

			throw new ServiceException("Please give valid date");

		}
		return false;
	}
}
