package com.nopcommerce.data;

import java.util.Random;

public class Data {

	public static class ReviewData {
		public static final String REVIEW_TITLE = getRandomString(7);
		public static final String REVIEW_TEXT = getRandomString(50);
	}

	public static class RegisterData {
		public static String FIRST_NAME, LAST_NAME, COMPANY_NAME, CITY, ADDRESS_1, EMAIL, PASSWORD, PHONE, FAX,
				NEW_PASSWORD, ZIP_POSTAL_CODE;

		public static void generateRandomData() {
			FIRST_NAME = getRandomName();
			LAST_NAME = getRandomString(5);
			COMPANY_NAME = "CTY " + getRandomString(5);
			CITY = "TP" + getRandomString(3);
			ADDRESS_1 = getRandomAddress();
			EMAIL = getRandomEmail();
			PASSWORD = getRandomPassword();
			PHONE = getRandomNumber();
			FAX = getRandomNumber();
			NEW_PASSWORD = getRandomPassword();
			ZIP_POSTAL_CODE = getRandomNumber();
		}
//		public static String FIRST_NAME = getRandomName();
//		public static String LAST_NAME = getRandomString(5);
//		public static String COMPANY_NAME = "CTY " + getRandomString(5);
//		public static String CITY = "TP" + getRandomString(3);
//		public static String ADDRESS_1 = getRandomAddress();
//		public static String EMAIL = getRandomEmail();
//		public static String PASSWORD = getRandomPassword();
//		public static String PHONE = getRandomNumber();
//		public static String FAX = getRandomNumber();
//		public static String NEW_PASSWORD = getRandomPassword();
//		public static String ZIP_POSTAL_CODE = getRandomNumber();
	}

	public static class CustomerInfoUpdateData {
		public static final String FIRST_NAME = "Automation";
		public static final String LAST_NAME = "FC";
		public static final String DATE = "10";
		public static final String MONTH = "January";
		public static final String YEAR = "1999";
		public static final String EMAIL = getRandomEmail();
		public static final String COMPANY_NAME = "Automation FC";
	}

	public class AddressesData {
		public static final String ADDRESS_FIRST_NAME = "Automation";
		public static final String ADDRESS_LAST_NAME = "FC";
		public static final String ADDRESS_EMAIL = "automationfc.vn@gmail.com";
		public static final String ADDRESS_COMPANY_NAME = "Automation FC";
		public static final String ADDRESS_COUNTRY = "Viet Nam";
		public static final String ADDRESS_STATE = "Other";
		public static final String ADDRESS_CITY = "Da Nang";
		public static final String ADDRESS_1 = "123/04 Le Lai";
		public static final String ADDRESS_2 = "234/05 Hai Phong";
		public static final String ADDRESS_ZIP_POSTAL_CODE = "550000";
		public static final String ADDRESS_PHONE = "0123456789";
		public static final String ADDRESS_FAX = "0987654321";
	}

	static Random rand = new Random();

	public static String getRandomString(int length) {
		String randomString = "";
		for (int i = 0; i < length; i++) {
			if (rand.nextBoolean())
				randomString += (char) (rand.nextInt(122 - 97) + 97);
			else
				randomString += (char) (rand.nextInt(90 - 65) + 65);
		}
		return randomString;
	}

	public static String getRandomName() {
		return "AutoTest" + rand.nextInt(9999);
	}

	public static String getRandomEmail() {
		return "testing" + rand.nextInt(9999) + "@gmail.com";
	}

	public static String getRandomPassword() {
		return getRandomString(5) + rand.nextInt(9999);
	}

	public static String getRandomAddress() {
		return getRandomString(3) + rand.nextInt(9999);
	}

	public static String getRandomNumber() {
		return rand.nextInt(99999) + "" + rand.nextInt(99999);
	}

}
