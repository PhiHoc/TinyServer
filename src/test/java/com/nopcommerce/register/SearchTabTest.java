package com.nopcommerce.register;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.SearchPO;
import pageObject.nopCommerce.UserHomePO;

public class SearchTabTest extends BaseTest {

	WebDriver driver;
	SearchPO searchPO;
	UserHomePO userHomePO;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		log.info("Before testing - Step 1: Open Open Home Page");
		userHomePO = PageGeneratorManager.getHomePage(driver);
		
		log.info("Before testing - Step 2: Open Open Search Page");
		searchPO = userHomePO.clickToSearchPage();
	}

	@Test
	public void TC_01_Search_With_Empty_Data() {
		
		log.info("Search with empty data - Step 1: Enter to search keyword with empty data");
		searchPO.enterToSearchKeyWord("");
		
		log.info("Search with empty data - Step 2: Click to search button");
		searchPO.clickToSearchButton();
		
		log.info("Search with empty data - Step 3: Verify error message");
		verifyEquals(searchPO.getSearchErrorMessage(), "Search term minimum length is 3 characters");
	}
	
	@Test
	public void TC_02_Search_With_Not_Exist_Data() {
		
		log.info("Search with not exist data - Step 1: Enter to search keyword with not exist data");
		searchPO.enterToSearchKeyWord("Macbook Pro 2050");
		
		log.info("Search with not exist data - Step 2: Click to search button");
		searchPO.clickToSearchButton();
		
		log.info("Search with not exist data - Step 3: Verify error message");
		verifyEquals(searchPO.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_03_Search_With_Relative_Product_Name() {
		
		log.info("Search with relative product name - Step 2: Search with keyword Lenovo");
		searchPO.enterToSearchKeyWord("Lenovo");
		
		log.info("Search with relative product name - Step 3: Click to search button");
		searchPO.clickToSearchButton();
		
		log.info("Search with relative product name - Step 4: Verify is 2 lenovo product appear");
		verifyEquals(searchPO.numberOfProductAppear(),2);
		
		List<WebElement> productList = searchPO.getListOfProductsAppeared();
		
		log.info("Search with relative product name - Step 5: Verify name of the first lenovo product");
		verifyEquals(productList.get(0).getText(),"Lenovo IdeaCentre 600 All-in-One PC");
		
		log.info("Search with relative product name - Step 6: Verify name of the second lenovo product");
		verifyEquals(productList.get(1).getText(),"Lenovo Thinkpad X1 Carbon Laptop");
	}
	
	@Test
	public void TC_04_Search_With_Absolute_Product_Name() {
		
		log.info("Search with absolute product name - Step 2: Search with keyword ThinkPad X1 Carbon");
		searchPO.enterToSearchKeyWord("ThinkPad X1 Carbon");
		
		log.info("Search with absolute product name - Step 3: Click to search button");
		searchPO.clickToSearchButton();
		
		log.info("Search with absolute product name - Step 4: Verify is only 1 product appear");
		verifyEquals(searchPO.numberOfProductAppear(),1);
		
		List<WebElement> productList = searchPO.getListOfProductsAppeared();
		
		log.info("Search with absolute product name - Step 5: Verify name of the product");
		verifyEquals(productList.get(0).getText(),"Lenovo Thinkpad X1 Carbon Laptop");
	}
	
	@Test
	public void TC_05_Avanced_Search_With_Parent_Categories() {
		
		log.info("Avanced search with parent categories - Step 2: Search with keyword Apple MacBook Pro");
		searchPO.enterToSearchKeyWord("Apple MacBook Pro");
		
		log.info("Avanced search with parent categories - Step 3: Check to advanced search");
		searchPO.checkToAdvancedSearch();
		
		log.info("Avanced search with parent categories - Step 4: Select computers on Category dropdown");
		searchPO.selectCategoryDropDown("Computers");
		
		log.info("Avanced search with parent categories - Step 5: uncheck to Automatically search sub categories");
		searchPO.uncheckToAutomaticallySearchSubCategories();
		
		log.info("Avanced search with parent categories - Step 6: Click to search button");
		searchPO.clickToSearchButton();
		
		log.info("Avanced search with parent categories - Step 7: Verify error message");
		verifyEquals(searchPO.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_06_Avanced_Search_With_Sub_Categories() {
		
		log.info("Avanced search with sub categories - Step 2: Search with keyword Apple MacBook Pro");
		searchPO.enterToSearchKeyWord("Apple MacBook Pro");
		
		log.info("Avanced search with sub categories - Step 3: Check to advanced search");
		searchPO.checkToAdvancedSearch();
		
		log.info("Avanced search with sub categories - Step 4: Select computers on Category dropdown");
		searchPO.selectCategoryDropDown("Computers");
		
		log.info("Avanced search with sub categories - Step 5: check to Automatically search sub categories");
		searchPO.checkToAutomaticallySearchSubCategories();
		
		log.info("Avanced search with sub categories - Step 6: Click to search button");
		searchPO.clickToSearchButton();
		
		log.info("Avanced search with sub categories - Step 7: Verify 1 product appear");
		verifyEquals(searchPO.numberOfProductAppear(),1);
		
		List<WebElement> productList = searchPO.getListOfProductsAppeared();
		
		log.info("Avanced search with sub categories - Step 8: Verify name of the product");
		verifyEquals(productList.get(0).getText(),"Apple MacBook Pro 13-inch");
	}
	
	@Test
	public void TC_07_Avanced_Search_With_Incorrect_Manufacturer() {
		
		log.info("Avanced search with incorrect manufacturer - Step 2: Search with keyword Apple MacBook Pro");
		searchPO.enterToSearchKeyWord("Apple MacBook Pro");
		
		log.info("Avanced search with incorrect manufacturer - Step 3: Check to advanced search");
		searchPO.checkToAdvancedSearch();
		
		log.info("Avanced search with incorrect manufacturer - Step 4: Select computers on Category dropdown");
		searchPO.selectCategoryDropDown("Computers");
		
		log.info("Avanced search with incorrect manufacturer - Step 5: check to Automatically search sub categories");
		searchPO.checkToAutomaticallySearchSubCategories();
		
		log.info("Avanced search with incorrect manufacturer - Step 6: Select HP on manufracturer dropdown");
		searchPO.selectOnManufacturerDropdown("HP");
		
		log.info("Avanced search with incorrect manufacturer - Step 7: Click to search button");
		searchPO.clickToSearchButton();
		
		log.info("Avanced search with incorrect manufacturer - Step 8: Verify error message");
		verifyEquals(searchPO.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_08_Avanced_Search_With_Correct_Manufacturer() {
		
		log.info("Avanced search with correct manufacturer - Step 2: Search with keyword Apple MacBook Pro");
		searchPO.enterToSearchKeyWord("Apple MacBook Pro");
		
		log.info("Avanced search with correct manufacturer - Step 3: Check to advanced search");
		searchPO.checkToAdvancedSearch();
		
		log.info("Avanced search with correct manufacturer - Step 4: Select computers on Category dropdown");
		searchPO.selectCategoryDropDown("Computers");
		
		log.info("Avanced search with correct manufacturer - Step 5: check to Automatically search sub categories");
		searchPO.checkToAutomaticallySearchSubCategories();
		
		log.info("Avanced search with correct manufacturer - Step 6: Select apple on manufracturer dropdown");
		searchPO.selectOnManufacturerDropdown("Apple");
		
		log.info("Avanced search with correct manufacturer - Step 7: Click to search button");
		searchPO.clickToSearchButton();
		
		log.info("Avanced search with correct manufacturer - Step 8: Verify 1 product appear");
		verifyEquals(searchPO.numberOfProductAppear(),1);
		
		List<WebElement> productList = searchPO.getListOfProductsAppeared();
		
		log.info("Avanced search with correct manufacturer - Step 9: Verify name of the product");
		verifyEquals(productList.get(0).getText(),"Apple MacBook Pro 13-inch");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
