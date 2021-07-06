package in.nivethitha.service;

import java.time.LocalDateTime;

import in.nivethitha.dao.ApplyCouponDAO;
import in.nivethitha.exception.DBException;
import in.nivethitha.exception.ServiceException;
import in.nivethitha.exception.ValidatorException;
import in.nivethitha.model.ApplyCoupon;
import in.nivethitha.util.EmailValidator;
import in.nivethitha.util.Logger;
import in.nivethitha.util.MobileNumberValidator;

public class ApplyCouponService {


	public static void applyCoupon(int id, long number, String email, double amount, String code) throws ServiceException {
		try {
			getCountOfparticularId(id);
			isMobileNumberExist(number, email);
			isValidCouponCode(id,code);
			purchasingAmount(amount);
			calculateBillAmount(id,amount);
			setstatus(id,amount);
			Double discountedAmount=calculateBillAmount(id,amount);
			String couponStatus=setstatus(id,amount);
			LocalDateTime appliedDate=LocalDateTime.now();
			userCouponDetail(id,email,number,code,amount,discountedAmount,appliedDate,couponStatus);

		} catch (ServiceException | DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to process coupon");
		}
	}

	public static void userCouponDetail(int id,String eMail, long mobile, String code, Double amount, double discountedAmount,
			LocalDateTime appliedDate, String status) throws ServiceException {
		try {
			MobileNumberValidator.isValidMobileNumber(mobile);
			EmailValidator.isValidMailId(eMail);
			ApplyCoupon user = new ApplyCoupon();
			user.setId(id);
			user.seteMailId(eMail);
			user.setMobileNumber(mobile);
			user.setCouponCode(code);
			user.setPurchasingAmount(amount);
			user.setDiscounted_amount(discountedAmount);
			user.setAppliedDate(appliedDate);
			user.setStatus(status);
			ApplyCouponDAO.save(user);
			Logger.log("added successfully");
		} catch (ValidatorException | DBException e) {
			e.printStackTrace();
			throw new ServiceException("unable to add user details");
		}
	}

	/**
	 * Initially user will enter email then that email will check user entered
	 * mobile number is valid or not If the user's mobile number and coupon code is
	 * matched with database then you can purchase your products
	 * @param amount
	 * @return
	 * @return
	 * @return
	 * @throws DBException
	 */
	public static boolean isMobileNumberExist(Long mobile, String email) throws DBException {
		boolean isValid=false;
		Long mobileNumber = ApplyCouponDAO.getMobileNumberByEmailId(email);
		if (mobileNumber.equals(mobile)) {
			isValid=true;
		}
		System.out.println("mobile number matched: " + isValid);
		return isValid;

	}

	/**
	 * This method is for user entered coupon code is exist or not If it is exist
	 * then you have to give your purchasing amount
	 * @param couponCode
	 * @return
	 * @throws DBException
	 */
	public static boolean isValidCouponCode(int id,String couponCode) throws DBException {
		boolean isMatched = false;
		String code = ApplyCouponDAO.getCouponCode(id);
		System.out.println("coupon code:"+code);

		if (couponCode.equals(code)) {
			isMatched = true;
		}
		System.out.println("valid coupon:" + isMatched);

		return isMatched;
	}

	/**
	 * to apply purchasing amount
	 * @param amount
	 * @return
	 */
	public static double purchasingAmount(double amount) {
		return amount;

	}

	/**
	 * This method is for calculate bill amount from discount
	 * @return
	 * @throws DBException
	 */
	public static Double calculateBillAmount(int id,double amount) throws DBException {
		
		double totalAmount = purchasingAmount(amount);
		int discount = ApplyCouponDAO.getDiscount(id);
		//System.out.println(discount);
		double billAmount = totalAmount - (totalAmount * discount) / 100;
		System.out.println("billAmount"+billAmount);
		return billAmount;
	}

	/**
	 * This method is for user can use the coupon only one time from same mobile
	 * number
	 * @param id
	 * @param couponCode
	 * @throws ServiceException
	 * @throws DBException
	 */
	public static void getCountOfparticularId(int id) throws ServiceException, DBException {
		String email = "";
		int particularIdCount = ApplyCouponDAO.getNumberOfTimesUsed(email);
		Integer limit = 1;
		System.out.println(particularIdCount);
		if (limit != null && particularIdCount != limit) {
			throw new ServiceException(
					"Sorry to say this we don’t offer discount for this because the same id is already one time used by the user");
		}

	}

	/**
	 * This method is set status of the coupon 'SUCCESS' or 'FAILURE'
	 * @return
	 * @throws DBException
	 */
	public static String setstatus(int id,double amount) throws DBException {
		String isValid="FAILURE";
		Double discountedAmount = ApplyCouponService.calculateBillAmount(id,amount);
		if (discountedAmount > 0) {
			isValid="SUCCESS";
		}
		System.out.println("status"+isValid);
		return isValid; 

	}

	public static void main(String[] args) throws ValidatorException, ServiceException, DBException {
		String number="9876450948";
		 Long mobile=Long.valueOf(number);
		 String email="nithya94.@gmail.com";
		ApplyCouponService.applyCoupon(107,mobile,email,3700,"DOMI564");
		
	}

}
