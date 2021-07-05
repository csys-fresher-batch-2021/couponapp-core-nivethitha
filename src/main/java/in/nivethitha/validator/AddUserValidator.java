package in.nivethitha.validator;

import in.nivethitha.exception.ServiceException;
import in.nivethitha.exception.ValidatorException;
import in.nivethitha.util.Logger;
import in.nivethitha.util.MobileNumberValidator;
import in.nivethitha.util.StringValidator;

public class AddUserValidator {
	/**
	 * This method is used to return the userName and mobile number
	 * @param userName
	 * @return
	 * @throws ServiceException
	 * @throws ValidatorException
	 */
	public static String loginWithUserName(String userName) throws ServiceException {
		try {
			StringValidator.isValidString(userName);
		} catch (ValidatorException e) {
			Logger.trace(e);
			throw new ServiceException("unable to fetch username");
		}
		System.out.println("username returned successfully");
		return userName;

	}
	/**
	 * This method is used to return the mobile number
	 * 
	 * @param number
	 * @return
	 * @throws ValidatorException
	 * @throws ServiceException
	 */
	public static long loginWithMobileNumber(long number) throws ValidatorException, ServiceException {

		try {
			MobileNumberValidator.isValidMobileNumber(number);
		} catch (ValidatorException e) {
			Logger.trace(e);
			throw new ServiceException("unable to fetch mobile number");

		}
		return number;

	}

}
