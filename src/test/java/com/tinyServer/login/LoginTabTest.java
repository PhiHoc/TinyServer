package com.tinyServer.login;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tinyServer.data.ManagerData;
import com.tinyServer.data.UserData;

import commons.BaseTest;
import pageObject.tinyServer.HomePO;
import pageObject.tinyServer.LoginPO;
import pageObject.tinyServer.PageGeneratorManager;
import pageObject.tinyServer.SignUpPO;
import utilities.RandomUtil;

public class LoginTabTest extends BaseTest {
	WebDriver driver;
	LoginPO loginPO;
	SignUpPO signupPO;
	HomePO homePO;
	ManagerData manager;
	ArrayList<UserData> userList;
	int numberOfUser;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		log.info("Get signup page");
		signupPO = PageGeneratorManager.getSingupPage(driver);
	}

	@Test
	public void TC_01_Signup_Account_With_Data() {
		manager = RandomUtil.getRandomManagerData();

		log.info("Singup an account - Step 1: Enter email");
		signupPO.enterToEmailTextBox(manager.email);

		log.info("Singup an account - Step 2: Click to next button");
		signupPO.clickToNextButton();

		log.info("Singup an account - Step 3: Enter full name");
		signupPO.enterToFullNameTextBox(manager.fullname);

		log.info("Singup an account - Step 4: Click to next button");
		signupPO.clickToNextButton();

		log.info("Singup an account - Step 5: Enter company name");
		signupPO.enterToCompanyNameTextBox(manager.company);

		log.info("Singup an account - Step 6: Click to next button");
		signupPO.clickToNextButton();

		log.info("Singup an account - Step 7: Enter employees number");
		signupPO.enterToEmployeesNumberTextBox(manager.employeesNumber);

		log.info("Singup an account - Step 8: Click to next button");
		signupPO.clickToNextButton();

		log.info("Singup an account - Step 9: Enter phone number");
		signupPO.enterToPhoneNumberTextBox(manager.phone);

		log.info("Singup an account - Step 10: Click to next button");
		signupPO.clickToNextButton();

		log.info("Singup an account - Step 11: Enter password");
		signupPO.enterToPasswordTextBox(manager.password);

		log.info("Singup an account - Step 12: Click to next button");
		homePO = signupPO.clickToStartTrialButton();
	}
	
	@Test
	public void TC_02_LogOut_From_System() {
		log.info("Logout from system - Step 1: Click to user avatar");
		homePO.clickToUserAvatar();
		
		log.info("Logout from system - Step 2: Click to logout button");
		loginPO = homePO.clickToLogoutButton();

	}

	@Test
	public void TC_03_Login_To_System_With_Registered_Account() {
		
		log.info("Login to system - Step 1: Enter email");
		loginPO.enterToEmailTextBox(manager.email);

		log.info("Login to system - Step 2: Click continue button");
		loginPO.clickToContinueButton();

		log.info("Login to system - Step 3: Enter password");
		loginPO.enterToPasswordTextBox(manager.password);

		log.info("Login to system - Step 4: Click signin button");
		homePO = loginPO.clickToSignInButton();
	}

	@Test
	public void TC_04_Add_User_Into_List_And_Verify() {
		numberOfUser = 2;
		userList = RandomUtil.getRandomUserList(numberOfUser);

		log.info("Add user - Step 1: Click to setting menu");
		homePO.clickToSettingMenu();

		log.info("Add user - Step 2: Click to add people");
		homePO.clickToAddPeople();

		log.info("Add user - Step 3: Enter to user data");

		int index = 1;
		for (UserData user : userList) {
			homePO.enterUserDataByIndex(index, user.FIRSTNAME, user.LASTNAME, user.EMAIL, user.START_DATE, manager.fullname);
			index++;
		}

		log.info("Add user - Step 4: Click to add people button");
		homePO.clickToAddPeopleButton();

		log.info("Add user - Step 5: Verify congratulation page display");
		verifyEquals(homePO.getCongratulationText(), "Congratulations");

//		log.info("Add user - Step 6: Verify user data");
//		index = 1;
//		for (UserData user : userList) {
//			verifyEquals(homePO.getUserListTextByIndex(index),
//					user.FIRSTNAME + "\n" + user.LASTNAME + "\n"
//							+ user.EMAIL + "\n" + user.START_MONTH + " "
//							+ user.START_DAY + ", " + user.START_YEAR + "\n"
//							+ manager.fullname);
//			index++;
//		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
