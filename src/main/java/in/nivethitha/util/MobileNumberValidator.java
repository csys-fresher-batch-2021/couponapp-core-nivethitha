package in.nivethitha.util;

import in.nivethitha.exception.ServiceException;
import in.nivethitha.exception.ValidatorException;

public class MobileNumberValidator {
	/**
	 * This method is used to check mobile number length
	 * @param number
	 * @return
	 * @throws ServiceException
	 * @throws ValidatorException
	 */
	public static boolean isValidLength(Long number) throws ValidatorException {

		if (number != null) {
			long numberString = (long) number.toString().trim().length();
			if ((numberString == 10) && number != 0) {
				return true;
			} else {
				throw new ValidatorException("Invalid Mobile Number Length");
			}
		}
		return false;
	}

	/**
	 * This method is used to check whether the number is positive or not
	 * @param number
	 * @return
	 * @throws ServiceException
	 * @throws ValidatorException
	 */
	public static boolean isPositiveNumber(long number) throws ValidatorException {
		boolean isValid = false;
		if (number < 0) {
			isValid = true;
			throw new ValidatorException("mobile number should not be negative");
		}
		return isValid;

	}

	/**
	 * This method is used to check whether the number is valid or not
	 * @param number
	 * @return
	 * @throws ValidatorException
	 */
	public static boolean isValidMobileNumber(long number) throws ValidatorException {
		try {
			MobileNumberValidator.isPositiveNumber(number);
			MobileNumberValidator.isValidLength(number);
			return true;

		} catch (ValidatorException e) {
			Logger.trace(e);

			throw new ValidatorException("Invalid mobile number");
		}

	}
}
