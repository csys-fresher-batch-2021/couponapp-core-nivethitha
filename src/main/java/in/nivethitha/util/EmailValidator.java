package in.nivethitha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.nivethitha.exception.ValidatorException;

public class EmailValidator {
	private EmailValidator() {
		//Default constructor
	}
/**
 * This method is used to check whether the email id field is empty or not
 * then check your email is match with user entered mail or not
 * @param mailId
 * @return
 * @throws ValidatorException
 */
	public static boolean isValidMailId(String mailId) throws ValidatorException {
		if (mailId == null || mailId.isEmpty()) {
			throw new ValidatorException("E-mail field should not be null or empty");
		}

		else {
			String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			Pattern mailFormat = Pattern.compile(regex);
			Matcher matcher = mailFormat.matcher(mailId);
			if (matcher.matches()) {
				return matcher.matches();
			}
			throw new ValidatorException("Invalid email");

		}
}
	}
