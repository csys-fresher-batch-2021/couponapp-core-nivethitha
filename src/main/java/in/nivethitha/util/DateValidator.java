package in.nivethitha.util;

import java.time.LocalDate;

import in.nivethitha.exception.ExpiryDateException;

public class DateValidator {
	private DateValidator() {
		//Default constructor
	}
	
	/**
	 * This method is for comparing today's date with coupon's expiry date
	 * @return
	 */
		public static boolean isExpired(LocalDate givenDate)throws ExpiryDateException
		{
			if (givenDate.isBefore(LocalDate.now())) {
				throw new ExpiryDateException("coupon has expired");

			}

			return true;


		}


		
	}




