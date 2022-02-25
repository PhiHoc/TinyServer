package com.nopcommerce.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.Data;

import commons.BaseTest;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPO;
import pageObject.nopCommerce.UserHomePO;

public class RegisterTabTest extends BaseTest {

	WebDriver driver;
	UserHomePO userHomePO;
	RegisterPO registerPO;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		Data.RegisterData.generateRandomData();
		
		log.info("Before testing - Step 01: Open Home Page");
		userHomePO = PageGeneratorManager.getHomePage(driver);

		log.info("Before testing - Step 02: Open Register Page");
		registerPO = userHomePO.clickToRegisterPage();
	}

	@Test
	public void TC_01_Register_With_Empty_Data() {

		log.info("Register - Step 01: Enter to all validation field with empty data");
		registerPO.filterRegisterData("", "", "", "", "", "");

		log.info("Register - Step 02: Click register button");
		registerPO.clickRegisterButton();

		log.info("Register - Step 03: Verify error message by empty name");
		verifyEquals(registerPO.getErrorMessageAtMandantoryFieldByName(), "First name is required.");

		log.info("Register - Step 04: Verify error message by empty last name");
		verifyEquals(registerPO.getErrorMessageAtMandantoryFieldByLastName(), "Last name is required.");

		log.info("Register - Step 05: Verify error message by empty email");
		verifyEquals(registerPO.getErrorMessageAtMandantoryFieldByEmail(), "Email is required.");

		log.info("Register - Step 06: Verify error message by empty password");
		verifyEquals(registerPO.getErrorMessageAtMandantoryFieldByPassword(), "Password is required.");

		log.info("Register - Step 07: Verify error message by empty confirm password");
		verifyEquals(registerPO.getErrorMessageAtMandantoryFieldByConfirmPassword(), "Password is required.");
	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		log.info("Register Invalid email - Step 01: Refresh the current page");
		registerPO.refreshCurrentPage(driver);

		log.info("Register Invalid email - Step 02: Enter invalid mail");
		registerPO.enterToEmail("1234.com");

		log.info("Register Invalid email - Step 03: Click register button");
		registerPO.clickRegisterButton();

		log.info("Register Invalid email - Step 04: Verify error message");
		verifyEquals(registerPO.getErrorMessageAtMandantoryFieldByEmail(), "Wrong email");
	}

	@Test
	public void TC_03_Register_With_Valid_Data() {

		log.info("Register valid data - Step 01: Refresh the current page");
		registerPO.refreshCurrentPage(driver);

		log.info("Register valid data - Step 02: Enter to all validation field with valid data ");
		registerPO.filterRegisterData(Data.RegisterData.FIRST_NAME, Data.RegisterData.LAST_NAME,
				Data.RegisterData.EMAIL, Data.RegisterData.PASSWORD, Data.RegisterData.PASSWORD,
				Data.RegisterData.COMPANY_NAME);

		log.info("Register valid data - Step 03: Click on register button");
		registerPO.clickRegisterButton();

		log.info("Register valid data - Step 05: Verify register successfull");
		verifyEquals(registerPO.getGistrationCompletedMessage(), "Your registration completed");
		
	}

	@Test
	public void TC_04_Register_With_Existed_Email() {
		userHomePO.clickToLogout();
		
		log.info("Register Existed email - Step 1: Open Register Page");
		userHomePO.clickToRegisterPage();

		log.info("Register Existed email - Step 02: Enter to all field but email is existed");
		registerPO.filterRegisterData(Data.RegisterData.FIRST_NAME, Data.RegisterData.LAST_NAME,
				Data.RegisterData.EMAIL, Data.RegisterData.PASSWORD, Data.RegisterData.PASSWORD,
				Data.RegisterData.COMPANY_NAME);

		log.info("Register Existed email - Step 3: Click on register button");
		registerPO.clickRegisterButton();

		log.info("Register Existed email - Step 4: Verify existed email error message");
		verifyEquals(registerPO.getErorrMessageByExistedEmail(), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_With_Password_Less_Than_6() {

		log.info("Register with password less than 6 characters - Step 1: Refresh the current page");
		registerPO.refreshCurrentPage(driver);

		log.info("Register with password less than 6 characters - Step 2: Enter password less than 6 char ");
		registerPO.enterToPassword("1234");

		log.info("Register with password less than 6 characters - Step 3: Click on register button ");
		registerPO.clickRegisterButton();

		log.info("Register with password less than 6 characters - Step 4: Verify password erorr message");
		verifyEquals(registerPO.getErrorMessageAtMandantoryFieldByPassword(),
				"Password must meet the following rules:" + "\n" + "must have at least 6 characters");
	}

	@Test
	public void TC_06_Register_With_Wrong_Cofirm_Password() {

		log.info("Register with wrong confirm password - Step 1: Refresh the current page");
		registerPO.refreshCurrentPage(driver);

		log.info(
				"Register with wrong confirm password - Step 02: Enter to all validation field with valid data but email is existed");
		registerPO.filterRegisterData(Data.RegisterData.FIRST_NAME, Data.RegisterData.LAST_NAME,
				Data.RegisterData.EMAIL, Data.RegisterData.PASSWORD, "thisIsWrongConfirmPassword",
				Data.RegisterData.COMPANY_NAME);

		log.info("Register with wrong confirm password - Step 03: Click on register button ");
		registerPO.clickRegisterButton();

		log.info("Register with wrong confirm password - Step 04: Verify confirm password not match erorr message");
		verifyEquals(registerPO.getErrorMessageAtMandantoryFieldByConfirmPassword(),
				"The password and confirmation password do not match.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}