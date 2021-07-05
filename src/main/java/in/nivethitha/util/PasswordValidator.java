package in.nivethitha.util;

import in.nivethitha.exception.ValidatorException;

public class PasswordValidator {
	public static String isValidPassword(String pass) throws ValidatorException {
		if (pass.length() != 5) {
			throw new ValidatorException("Password must be 5 charasters");

		}
		return pass;

	}
}

