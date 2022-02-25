package com.nopcommerce.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.Data;

import commons.BaseTest;
import pageObject.nopCommerce.CompareProductListPO;
import pageObject.nopCommerce.ComputersPO;
import pageObject.nopCommerce.LoginPO;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RecentlyViewPO;
import pageObject.nopCommerce.ShoppingCartPO;
import pageObject.nopCommerce.UserHomePO;
import pageObject.nopCommerce.WishListPO;

public class WishlistCompareRecentViewTabTest extends BaseTest {

	WebDriver driver;
	WishListPO wishListPO;
	UserHomePO userHomePO;
	LoginPO loginPO;
	RecentlyViewPO recentlyViewPO;
	CompareProductListPO compareProductPO;
	ShoppingCartPO shoppingCartPO;
	String appUrl;
	ComputersPO computersPO;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		this.appUrl = appUrl;
		log.info("Register - Step 1: Open home Page");
		userHomePO = PageGeneratorManager.getHomePage(driver);
		
		log.info("Before testing - Step 2: Login an account");
		loginPO = userHomePO.clickToLoginPage();
		loginPO.loginWithData(Data.RegisterData.EMAIL, Data.RegisterData.PASSWORD);
		
	}
	
	@Test
	public void TC_01_Add_To_WishList() {
		log.info("Add to wishlist - step 1: Open product");
		userHomePO.clickToProductByName("HTC One M8 Android L 5.0 Lollipop");
		
		log.info("Add to wishlist - step 2: Click to add to wishlist button");
		userHomePO.clickToAddToWishListButton();
		
		log.info("Add to wishlist - step 3: Verify message in notification bar");
		verifyEquals(userHomePO.getTextOnNotificationBar(), "The product has been added to your wishlist");
		
		log.info("Add to wishlist - step 4: Click close button on notification bar");
		userHomePO.clickCloseNotificationBar();
		
		log.info("Add to wishlist - step 5: Click to WishList page");
		wishListPO = userHomePO.clickToWishListPage();
		
		log.info("Add to wishlist - step 6: Verify product has been add to wishlist");
		verifyTrue(wishListPO.getNumberOfProductInWishlist()==1);
		
		log.info("Add to wishlist - step 7: Click to URL sharing link");
		wishListPO.clickToURLSharingLink();
		
		log.info("Add to wishlist - step 8: Verify page title text");
		verifyEquals(wishListPO.getPageTitleText(), "Wishlist of " + Data.RegisterData.FIRST_NAME + " " + Data.RegisterData.LAST_NAME);
	}
	
	@Test
	public void TC_02_Add_Product_To_Cart_From_WishLlist_Page() {
		log.info("Add to cart - step 1: Return to homepage");
		userHomePO.openUrl(driver, appUrl);
		
		log.info("Add to cart - step 2: Click to wishlist page");
		userHomePO.clickToWishListPage();
		
		log.info("Add to cart - step 3: Check to add to cart check box");
		wishListPO.checkToAddToCartCheckBox();
		
		log.info("Add to cart - step 4: Click add to cart button");
		wishListPO.clickToAddToCartButton();
		
		log.info("Add to cart - step 5: click to wishlist page");
		userHomePO.clickToWishListPage();
		
		log.info("Add to cart - step 6: Verify is product removed from wishlist");
		verifyTrue(wishListPO.getNumberOfProductInWishlist()==0);
		
		log.info("Add to cart - step 7: Click to shopping cart");
		shoppingCartPO = userHomePO.clickToShoppingCartPage();
		
		log.info("Add to cart - step 8: Verify is product added to shopping cart");
		verifyTrue(shoppingCartPO.getNumberOfProductInShoppingCart()==1);
	}
	
	@Test
	public void TC_03_Remove_Product_In_WishLlist_Page() {
		log.info("Remove product in wishlist - step 1: Return to homepage");
		userHomePO.openUrl(driver, appUrl);
		
		log.info("Remove product in wishlist - step 2: Open product");
		userHomePO.clickToProductByName("HTC One M8 Android L 5.0 Lollipop");
		
		log.info("Remove product in wishlist - step 3: Click to add to wishlist button");
		userHomePO.clickToAddToWishListButton();
		
		log.info("Remove product in wishlist - step 4: Verify message in notification bar");
		verifyEquals(userHomePO.getTextOnNotificationBar(), "The product has been added to your wishlist");
		
		log.info("Remove product in wishlist - step 5: Click close button on notification bar");
		userHomePO.clickCloseNotificationBar();
		
		log.info("Remove product in wishlist - step 6: Click to WishList page");
		userHomePO.clickToWishListPage();
		
		log.info("Remove product in wishlist - step 7: Click to remove button");
		wishListPO.clickToRemoveButton();
		
		log.info("Remove product in wishlist - step 8: Verify message in page body");
		verifyEquals(wishListPO.getMessageInPageBody(), "The wishlist is empty!");
		
		log.info("Remove product in wishlist - step 9: Verify no product displayed in wishlist");
		verifyTrue(wishListPO.getNumberOfProductInWishlist() == 0);
	}
	
	@Test
	public void TC_04_Add_Product_To_Compare() {

		log.info("Add product to compare - step 1: Return to homepage");
		userHomePO.openUrl(driver, appUrl);
		
		log.info("Add product to compare - step 2: Click to compare button of the first product");
		userHomePO.clickToCompareButtonOfProductByName("Build your own computer");
		
		log.info("Add product to compare - step 3: Verify message in notification bar");
		verifyEquals(userHomePO.getTextOnNotificationBar(), "The product has been added to your product comparison");
		
		log.info("Add product to compare - step 4: Click close button on notification bar");
		userHomePO.clickCloseNotificationBar();
		
		log.info("Add product to compare - step 5: Click to compare button of the second product");
		userHomePO.clickToCompareButtonOfProductByName("Apple MacBook Pro 13-inch");
		
		log.info("Add product to compare - step 6: Verify message in notification bar");
		verifyEquals(userHomePO.getTextOnNotificationBar(), "The product has been added to your product comparison");
		
		log.info("Add product to compare - step 7: Click close button on notification bar");
		userHomePO.clickCloseNotificationBar();
		
		log.info("Add product to compare - step 8: Click to compare product list link");
		compareProductPO = userHomePO.clickToCompareProductListPage();
		
		log.info("Add product to compare - step 9: Verify are two remove buttons displayed");
		verifyTrue(compareProductPO.areTwoRemoveButtonsDisplayed());
		
		log.info("Add product to compare - step 10: Verify name of products");
		verifyEquals(compareProductPO.getNameProductInCompareTable(),"Name Apple MacBook Pro 13-inch Build your own computer");
		
	}
	
	@Test
	public void TC_05_Recently_View_Product() {
		log.info("Recently view product - step 1: Return to homepage");
		userHomePO.openUrl(driver, appUrl);
		
		log.info("Recently view product - step 2: Click to computers page");
		computersPO = userHomePO.clickToComputersPage();
		
		log.info("Recently view product - step 3: Click to notebooks link");
		computersPO.clickToNoteBooksLink();
		
		log.info("Recently view product - step 4: View first product");
		computersPO.clickToProductByName("Apple MacBook Pro 13-inch");
		computersPO.backToPage(driver);
		
		log.info("Recently view product - step 5: View second product");
		computersPO.clickToProductByName("Asus N551JK-XO076H Laptop");
		computersPO.backToPage(driver);
		
		log.info("Recently view product - step 6: View 3th product");
		computersPO.clickToProductByName("HP Envy 6-1180ca 15.6-Inch Sleekbook");
		computersPO.backToPage(driver);
		
		log.info("Recently view product - step 7: View 4th product");
		computersPO.clickToProductByName("HP Spectre XT Pro UltraBook");
		computersPO.backToPage(driver);
		
		log.info("Recently view product - step 8: View 5th product");
		computersPO.clickToProductByName("Lenovo Thinkpad X1 Carbon Laptop");
		computersPO.backToPage(driver);
		
		log.info("Recently view product - step 9: Click to recently view product link");
		recentlyViewPO = userHomePO.clickToRecentlyViewPage();
		
		verifyEquals(recentlyViewPO.getProductTitle(), "Lenovo Thinkpad X1 Carbon Laptop HP Spectre XT Pro UltraBook HP Envy 6-1180ca 15.6-Inch Sleekbook ");
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}