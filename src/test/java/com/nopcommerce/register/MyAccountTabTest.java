package com.nopcommerce.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.Data;

import commons.BaseTest;
import pageObject.nopCommerce.LoginPO;
import pageObject.nopCommerce.MyAccountPO;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPO;
import pageObject.nopCommerce.ReviewPO;
import pageObject.nopCommerce.UserHomePO;

public class MyAccountTabTest extends BaseTest {

	WebDriver driver;
	UserHomePO userHomePO;
	MyAccountPO myAccountPO;
	RegisterPO registerPO;
	LoginPO loginPO;
	ReviewPO reviewPO;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		log.info("Before testing - Step 1: Open home Page");
		userHomePO = PageGeneratorManager.getHomePage(driver);
		
		log.info("Before testing - Step 2: Login an account");
		loginPO = userHomePO.clickToLoginPage();
		loginPO.loginWithData(Data.RegisterData.EMAIL, Data.RegisterData.PASSWORD);
		
		log.info("Before testing - Step 3: Click to my account page");
		myAccountPO = userHomePO.clickToMyAccountPage();
	}

	@Test
	public void TC_01_Update_Customer_Info() {

		log.info("Update customer info - Step 01: CLick on female radio");
		myAccountPO.clickOnFemaleRadio();

		log.info("Update customer info - Step 02: Update data");
		myAccountPO.updateCustomerData(Data.CustomerInfoUpdateData.FIRST_NAME, 
				Data.CustomerInfoUpdateData.LAST_NAME,
				Data.CustomerInfoUpdateData.DATE, 
				Data.CustomerInfoUpdateData.MONTH, 
				Data.CustomerInfoUpdateData.YEAR,
				Data.CustomerInfoUpdateData.EMAIL, 
				Data.CustomerInfoUpdateData.COMPANY_NAME);

		log.info("Update customer info - Step 03: Click save button");
		myAccountPO.clickToSaveButtonAtCustomerInfo();

		log.info("Update customer info - Step 04: Verify female gender is checked");
		verifyTrue(myAccountPO.isFemaleRadioChecked());

		log.info("Update customer info - Step 05: Verify first name");
		verifyEquals(myAccountPO.getValueOfFirstName(), Data.CustomerInfoUpdateData.FIRST_NAME);

		log.info("Update customer info - Step 06: Verify last name");
		verifyEquals(myAccountPO.getValueOfLastName(), Data.CustomerInfoUpdateData.LAST_NAME);

		log.info("Update customer info - Step 07: Verify date of birth day");
		verifyEquals(myAccountPO.getValueDOBDay(), Data.CustomerInfoUpdateData.DATE);

		log.info("Update customer info - Step 08: Verify date of birth month");
		verifyEquals(myAccountPO.getValueDOBMonth(), Data.CustomerInfoUpdateData.MONTH);

		log.info("Update customer info - Step 09: Verify date of birth year");
		verifyEquals(myAccountPO.getValueDOBYear(), Data.CustomerInfoUpdateData.YEAR);

		log.info("Update customer info - Step 10: Verify email");
		verifyEquals(myAccountPO.getValueOfEmail(), Data.CustomerInfoUpdateData.EMAIL);

		log.info("Update customer info - Step 11: Verify company name");
		verifyEquals(myAccountPO.getValueOfCompanyName(), Data.CustomerInfoUpdateData.COMPANY_NAME);
	}

	@Test
	public void TC_02_Add_Address() {

		log.info("Add address - Step 01: Click to addresses");
		myAccountPO.clickToAddresses();

		log.info("Add address - Step 02: Click to add new button");
		myAccountPO.clickToAddNewButton();

		log.info("Add address - Step 03: Enter data to all field");
		myAccountPO.enterToAddressData(Data.AddressesData.ADDRESS_FIRST_NAME, 
				Data.AddressesData.ADDRESS_LAST_NAME,
				Data.AddressesData.ADDRESS_EMAIL, Data.AddressesData.ADDRESS_COMPANY_NAME,
				Data.AddressesData.ADDRESS_COUNTRY, Data.AddressesData.ADDRESS_STATE, 
				Data.AddressesData.ADDRESS_CITY,Data.AddressesData.ADDRESS_1, 
				Data.AddressesData.ADDRESS_2, Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE,
				Data.AddressesData.ADDRESS_PHONE, Data.AddressesData.ADDRESS_FAX);

		log.info("Add address - Step 4: Click save button");
		myAccountPO.clickToSaveButtonAtAddress();

		log.info("Add address - Step 5: Verify title");
		String FULL_NAME = Data.AddressesData.ADDRESS_FIRST_NAME + " " + Data.AddressesData.ADDRESS_LAST_NAME;
		verifyEquals(myAccountPO.getValueOfAddressTitle(), FULL_NAME);

		log.info("Add address - Step 6: Verify name");
		verifyEquals(myAccountPO.getValueOfAddressName(), FULL_NAME);

		log.info("Add address - Step 7: Verify email");
		verifyEquals(myAccountPO.getValueOfAddressEmail(), "Email: " + Data.AddressesData.ADDRESS_EMAIL);

		log.info("Add address - Step 8: Verify phone");
		verifyEquals(myAccountPO.getValueOfAddressPhone(), "Phone number: " + Data.AddressesData.ADDRESS_PHONE);

		log.info("Add address - Step 9: Verify fax");
		verifyEquals(myAccountPO.getValueOfAddressFax(), "Fax number: " + Data.AddressesData.ADDRESS_FAX);

		log.info("Add address - Step 10: Verify company");
		verifyEquals(myAccountPO.getValueOfAddressCompany(), Data.AddressesData.ADDRESS_COMPANY_NAME);

		log.info("Add address - Step 11: Verify address 1");
		verifyEquals(myAccountPO.getValueOfAddress1(), Data.AddressesData.ADDRESS_1);

		log.info("Add address - Step 12: Verify address 2");
		verifyEquals(myAccountPO.getValueOfAddress2(), Data.AddressesData.ADDRESS_2);

		log.info("Add address - Step 13: Verify city, zip");
		String City_State_Zip = Data.AddressesData.ADDRESS_CITY + ", " + Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE;
		verifyEquals(myAccountPO.getValueOfCityStateZip(), City_State_Zip);

		log.info("Add address - Step 14: Verify country");
		verifyEquals(myAccountPO.getValueOfCountry(), Data.AddressesData.ADDRESS_COUNTRY);
	}

	@Test
	public void TC_03_Change_Password() {

		log.info("Change password - Step 01: Click to change password");
		myAccountPO.clickToChangePassword();

		log.info("Change password - Step 02: Enter to old password");
		myAccountPO.enterToOldPasswordTextBox(Data.RegisterData.PASSWORD);

		log.info("Change password - Step 03: Enter to new password");
		myAccountPO.enterToNewPasswordTextBox(Data.RegisterData.NEW_PASSWORD);

		log.info("Change password - Step 04: Enter to confirm password");
		myAccountPO.enterToConfirmNewPasswordTextBox(Data.RegisterData.NEW_PASSWORD);

		log.info("Change password - Step 05: Click to change password button");
		myAccountPO.clickToChangePasswordButton();

		log.info("Change password - Step 06: Verify 'password was change' message on notification bar");
		verifyEquals(myAccountPO.getTextOnNotificationBar(), "Password was changed");

		log.info("Change password - Step 07: Click close on password was change notification");
		myAccountPO.clickCloseNotificationBar();

		log.info("Change password - Step 08: Log out");
		userHomePO.clickToLogout();
		
		log.info("Change password - Step 09: Click to login page");
		userHomePO.clickToLoginPage();

		log.info("Change password - Step 10: Log in again with updated email and old password");
		loginPO.loginWithData(Data.CustomerInfoUpdateData.EMAIL, Data.RegisterData.PASSWORD);

		log.info("Change password - Step 11: Verify error message by wrong password");
		loginPO.getValidationSummaryErrorMessage();

		log.info("Change password - Step 12: Log in again with new password");
		loginPO.loginWithData(Data.CustomerInfoUpdateData.EMAIL, Data.RegisterData.NEW_PASSWORD);

		log.info("Change password  - Step 13: Verify current page are home page");
		log.info("Verify is logout link displayed");
		verifyTrue(userHomePO.isLogoutLinkDisplayed());

		log.info("Verify is my account link displayed");
		verifyTrue(userHomePO.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_04_My_Products_Review() {

		log.info("Review product - Step 02: Click to product Apple MacBook Pro 13-inch");
		userHomePO.clickToProductByName("Apple MacBook Pro 13-inch");

		log.info("Review product - Step 03: Click to add your review");
		reviewPO = userHomePO.clickToAddYourReviewPage();

		log.info("Review product - Step 04: Enter to review title");
		reviewPO.enterToReviewTitle(Data.ReviewData.REVIEW_TITLE);

		log.info("Review product - Step 05: Enter to review text");
		reviewPO.enterToReviewText(Data.ReviewData.REVIEW_TEXT);

		log.info("Review product - Step 06: Click to submit button");
		reviewPO.clickSubmitReviewButton();

		log.info("Review product - Step 07: Click to my account");
		myAccountPO = userHomePO.clickToMyAccountPage();

		log.info("Review product - Step 08: Click to my product review");
		myAccountPO.clickToMyProductsReview();

		log.info("Review product - Step 09: Verify review title");
		verifyEquals(myAccountPO.getLastestReviewTitle(), Data.ReviewData.REVIEW_TITLE);

		log.info("Review product - Step 10: Verify review text");
		verifyEquals(myAccountPO.getLastestReviewText(), Data.ReviewData.REVIEW_TEXT);
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
