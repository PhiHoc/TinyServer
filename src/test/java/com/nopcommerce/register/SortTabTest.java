package com.nopcommerce.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.ComputersPO;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.UserHomePO;

public class SortTabTest extends BaseTest {

	WebDriver driver;
	ComputersPO computersPO;
	UserHomePO userHomePO;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		log.info("Before testing - step 1: Open Open Home Page");
		userHomePO = PageGeneratorManager.getHomePage(driver);

		log.info("Before testing - step 2: Click to computers page");
		computersPO = userHomePO.clickToComputersPage();
		
		log.info("Before testing - step 3: Click to notebooks link");
		computersPO.clickToNoteBooksLink();
	}
	
	@Test
	public void TC_01_Sort_With_Name_A_To_Z() {
		log.info("Sort with name from A to Z - Step 1: Choose Name: A-Z on sort by dropdown");
		computersPO.selectSortByDropDownByText("Name: A to Z");

		log.info("Sort with name from A to Z - Step 2: Verify is product name sort in A - Z order");
		verifyTrue(computersPO.isProductSortInAToZOrder());
	}
	
	@Test
	public void TC_02_Sort_With_Name_Z_To_A() {

		log.info("Sort with name from Z to A - Step 1: Choose Name: Z-A on sort by dropdown");
		computersPO.selectSortByDropDownByText("Name: Z to A");

		log.info("Sort with name from Z to A - Step 2: Verify is product name sort in Z - A order");
		//verifyTrue(computersPO.isProductSortInZToAOrder());
	}

	@Test
	public void TC_03_Sort_With_Price_Low_To_High() {

		  log.info("Sort with price low to high - Step 1: Choose Price: Low to High on sort by dropdown"); 
		  computersPO.selectSortByDropDownByText("Price: Low to High");
		  
		  log.info("Sort with price low to high - Step 2: Verify is product name sort in A - Z order"); 
		  verifyTrue(computersPO.isProductSortPriceInLowToHighOrder());
	}

	@Test
	public void TC_04_Sort_With_Price_High_To_Low() {

		log.info("Sort with price high to low - Step 1: Choose Price: high to low on sort by dropdown");
		computersPO.selectSortByDropDownByText("Price: High to Low");

		log.info("Sort with price high to low - Step 2: Verify is product name sort in A - Z order");
		verifyTrue(computersPO.isProductSortPriceInHighToLowOrder());
	}
	
	@Test
	public void TC_05_Display_With_3_Product_Per_Page() {
		log.info("Display with 3 product per page - Step 1: Select 3 on display dropdown");
		computersPO.selectOnDisplayDropDownByText("3");
		
		log.info("Display with 3 product per page - Step 2: Verify only 3 or less than 3 product displayed");
		verifyTrue(computersPO.numberOfProductDisplayed() <= 3);
		
		log.info("Display with 3 product per page - Step 3: Verify is current page is page 1");
		verifyEquals(computersPO.getCurrentPageText(),"1");
		
		log.info("Display with 3 product per page - Step 4: Verify is next icon appeard at page 1");
		verifyTrue(computersPO.isNextPageIconDisplay());
		
		log.info("Display with 3 product per page - Step 5: Click to next page icon");
		computersPO.clickToNextPageIcon();
		
		log.info("Display with 3 product per page - Step 6: Verify is current page is page 2");
		verifyEquals(computersPO.getCurrentPageText(),"2");
		
		log.info("Display with 3 product per page - Step 7: Verify is previous icon appeard at page 2");
		verifyTrue(computersPO.isPreviousPageIconDisplay());
	}
	
	@Test
	public void TC_06_Display_With_6_Product_Per_Page() {
		log.info("Display with 6 product per page - Step 1: Select 6 on display dropdown");
		computersPO.selectOnDisplayDropDownByText("6");
		
		log.info("Display with 6 product per page - Step 2: Verify only 6 or less than 6 product displayed");
		verifyTrue(computersPO.numberOfProductDisplayed() <= 6);
		
		log.info("Display with 6 product per page - Step 3: Verify paging not displayed");
		verifyFalse(computersPO.isNextPageIconDisplay());
		verifyFalse(computersPO.isCurrentPageDisplay());
		
	}
	@Test
	public void TC_07_Display_With_9_Product_Per_Page() {
		log.info("Display with 9 product per page - Step 1: Select 9 on display dropdown");
		computersPO.selectOnDisplayDropDownByText("9");

		log.info("Display with 9 product per page - Step 2: Verify only 9 or less than 9 product displayed");
		verifyTrue(computersPO.numberOfProductDisplayed() <= 9);
		
		log.info("Display with 9 product per page - Step 3: Verify paging not displayed");
		verifyFalse(computersPO.isNextPageIconDisplay());
		verifyFalse(computersPO.isCurrentPageDisplay());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
