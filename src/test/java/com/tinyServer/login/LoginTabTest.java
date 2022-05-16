package com.tinyServer.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tinyServer.data.userData;

import commons.BaseTest;
import pageObject.tinyServer.HomePO;
import pageObject.tinyServer.LoginPO;
import pageObject.tinyServer.PageGeneratorManager;

public class LoginTabTest extends BaseTest{
	WebDriver driver;
	LoginPO loginPO;
	HomePO homePO;
	String user1Index = "1";
	String user2Index = "2";
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		log.info("Get signup page");
		loginPO = PageGeneratorManager.getSingupPage(driver);
	}
	
	@Test
	public void TC_01_Login_To_System_With_Data_Created_In_Manual_TestCase() {
		log.info("Login to system - Step 1: Enter email");
		loginPO.enterToEmailTextBox(userData.Login.EMAIL);
		
		log.info("Login to system - Step 2: Click continue button");
		loginPO.clickToContinueButton();
		
		log.info("Login to system - Step 3: Enter password");
		loginPO.enterToPasswordTextBox(userData.Login.PASSWORD);
		
		log.info("Login to system - Step 4: Click signin button");
		homePO = loginPO.clickToSignInButton();
	}
	
	@Test
	public void TC_02_Add_User_Into_List_And_Verify() {
		
		log.info("Add user - Step 1: Click to setting menu");
		homePO.clickToSettingMenu();
		
		log.info("Add user - Step 2: Click to add people");
		homePO.clickToAddPeople();
		
		log.info("Add user - Step 3: Enter to user 1 data");
		homePO.enterUserDataByIndex(user1Index,
				userData.ADD_USER.USER1.FIRSTNAME,
				userData.ADD_USER.USER1.LASTNAME,
				userData.ADD_USER.USER1.EMAIL,
				userData.ADD_USER.USER1.START_MONTH,
				userData.ADD_USER.USER1.START_YEAR,
				userData.ADD_USER.USER1.START_DAY,
				userData.ADD_USER.USER1.MANAGER);
		
		log.info("Add user - Step 4: Enter to user 2 data");
		homePO.enterUserDataByIndex(user2Index,
				userData.ADD_USER.USER2.FIRSTNAME,
				userData.ADD_USER.USER2.LASTNAME,
				userData.ADD_USER.USER2.EMAIL,
				userData.ADD_USER.USER2.START_MONTH,
				userData.ADD_USER.USER2.START_YEAR,
				userData.ADD_USER.USER2.START_DAY,
				userData.ADD_USER.USER2.MANAGER);
		
		log.info("Add user - Step 5: Click to add people button");
		homePO.clickToAddPeopleButton();
		
		driver.manage().window().maximize();
		log.info("Add user - Step 6: Verify congratulation page display");
		verifyEquals(homePO.getCongratulationText(), "Congratulations");
		
		log.info("Add user - Step 7: Verify user 1 data");
		verifyEquals(homePO.getUserListTextByIndex(user1Index), userData.ADD_USER.USER1.FIRSTNAME+"\n"+
				userData.ADD_USER.USER1.LASTNAME+"\n"+
				userData.ADD_USER.USER1.EMAIL+"\n"+
				userData.ADD_USER.USER1.START_MONTH + " " +
				userData.ADD_USER.USER1.START_DAY + ", "+
				userData.ADD_USER.USER1.START_YEAR + "\n"+
				userData.ADD_USER.USER1.MANAGER);
		
		log.info("Add user - Step 8: Verify user 2 data");
		verifyEquals(homePO.getUserListTextByIndex(user2Index), userData.ADD_USER.USER2.FIRSTNAME+"\n"+
				userData.ADD_USER.USER2.LASTNAME+"\n"+
				userData.ADD_USER.USER2.EMAIL+"\n"+
				userData.ADD_USER.USER2.START_MONTH + " " +
				userData.ADD_USER.USER2.START_DAY + ", "+
				userData.ADD_USER.USER2.START_YEAR + "\n"+
				userData.ADD_USER.USER2.MANAGER);
	}
}
