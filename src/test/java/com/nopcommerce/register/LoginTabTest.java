package com.nopcommerce.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.Data;

import commons.BaseTest;
import pageObject.nopCommerce.LoginPO;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPO;
import pageObject.nopCommerce.UserHomePO;

public class LoginTabTest extends BaseTest {

	WebDriver driver;
	UserHomePO userHomePO;
	LoginPO loginPO;
	RegisterPO registerPO;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		log.info("Before testing - Step 1: Open home Page");
		userHomePO = PageGeneratorManager.getHomePage(driver);
		
		log.info("Before testing - Step 2: Click to login page");
		loginPO = userHomePO.clickToLoginPage();
	}

	@Test
	public void TC_01_Login_With_Empty_Data() {

		log.info("Login empty data - Step 01: Login with empty email and password");
		loginPO.loginWithData("","");
		
		log.info("Login empty data - Step 02: Verify error message");
		verifyEquals(loginPO.getErorrMessageByEmail(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_With_Invalid_Email() {
		
		log.info("Login invalid data - Step 01: Refresh the current page ");
		loginPO.refreshCurrentPage(driver);

		log.info("Login invalid data - Step 02: Login with an invalid email ");
		loginPO.loginWithData("1234.com","");

		log.info("Login invalid data - Step 03: Verify error message");
		verifyEquals(loginPO.getErorrMessageByEmail(), "Wrong email");
	}

	@Test
	public void TC_03_Login_With_Unregister_Email() {

		log.info("Login empty data - Step 01: Refresh the current page ");
		loginPO.refreshCurrentPage(driver);

		log.info("Login empty data - Step 02: Login with an unregister email");
		loginPO.loginWithData(Data.getRandomEmail(),"");

		log.info("Login empty data - Step 03: Verify error message");
		verifyEquals(loginPO.getValidationSummaryErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_04_Login_With_Valid_Email_But_Empty_Password() {

		log.info("Login empty password - Step 01: Refresh the current page ");
		loginPO.refreshCurrentPage(driver);

		log.info("Login empty password - Step 02: Login with valid email but empty password");
		loginPO.loginWithData(Data.RegisterData.EMAIL,"");

		log.info("Login empty password - Step 03: Verify error message");
		verifyEquals(loginPO.getValidationSummaryErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");
	}

	@Test
	public void TC_05_Login_With_Valid_Email_But_Wrong_Password() {

		log.info("Login wrong password - Step 01: Refresh the current page ");
		loginPO.refreshCurrentPage(driver);
		
		log.info("Login wrong password - Step 02: Login with valid email but wrong password");
		loginPO.loginWithData(Data.RegisterData.EMAIL,"thisIsWrongPassword");

		log.info("Login wrong password - Step 03: Verify error message");
		verifyEquals(loginPO.getValidationSummaryErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_With_Valid_Email_And_Password() {

		log.info("Login valid data - Step 01: Refresh the current page ");
		loginPO.refreshCurrentPage(driver);

		log.info("Login valid data - Step 02: Login with valid email and password");
		loginPO.loginWithData(Data.RegisterData.EMAIL,Data.RegisterData.PASSWORD);

		log.info("Login valid data - Step 03: Verify current page are home page");
		log.info("Verify is logout link displayed");
		verifyTrue(userHomePO.isLogoutLinkDisplayed());

		log.info("Verify is my account link displayed");
		verifyTrue(userHomePO.isMyAccountLinkDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
