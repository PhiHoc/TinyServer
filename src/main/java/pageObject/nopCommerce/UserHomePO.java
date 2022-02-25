package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.UserHomePageUI;

public class UserHomePO extends BasePage {

	private WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPO clickToRegisterPage() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPO clickToLoginPage() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public MyAccountPO clickToMyAccountPage() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}
	
	public SearchPO clickToSearchPage() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_LINK);
		clickToElement(driver, UserHomePageUI.SEARCH_LINK);
		return PageGeneratorManager.getSearchPage(driver);
	}

	public void clickToLogout() {
		waitForElementClickable(driver, UserHomePageUI.LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public void clickToProductByName(String name) {
		waitForElementClickable(driver, UserHomePageUI.PRODUCT_TITLE_LINK, name);
		clickToElement(driver, UserHomePageUI.PRODUCT_TITLE_LINK, name);
	}

	public ReviewPO clickToAddYourReviewPage() {
		waitForElementClickable(driver, UserHomePageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, UserHomePageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getReviewPage(driver);
	}
	
	public ComputersPO clickToComputersPage() {
		waitForElementClickable(driver, UserHomePageUI.COMPUTER_LINK);
		clickToElement(driver, UserHomePageUI.COMPUTER_LINK);
		return PageGeneratorManager.getComputersPage(driver);
	}
	
	public WishListPO clickToWishListPage() {
		waitForElementClickable(driver, UserHomePageUI.WISHLIST_LINK);
		clickToElement(driver, UserHomePageUI.WISHLIST_LINK);
		return PageGeneratorManager.getWishListPage(driver);
	}
	
	public CompareProductListPO clickToCompareProductListPage() {
		waitForElementClickable(driver, UserHomePageUI.COMPARE_PRODUCT_LIST_LINK);
		clickToElement(driver, UserHomePageUI.COMPARE_PRODUCT_LIST_LINK);
		return PageGeneratorManager.getCompareProductListPage(driver);
	}
	
	public RecentlyViewPO clickToRecentlyViewPage() {
		waitForElementClickable(driver, UserHomePageUI.RECENTLY_VIEW_LINK);
		clickToElement(driver, UserHomePageUI.RECENTLY_VIEW_LINK);
		return PageGeneratorManager.getRecentlyViewPage(driver);
	}
	
	public ShoppingCartPO clickToShoppingCartPage() {
		waitForElementClickable(driver, UserHomePageUI.SHOPPING_CART_LINK);
		clickToElement(driver, UserHomePageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}

	public void clickToAddToWishListButton() {
		waitForElementClickable(driver, UserHomePageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, UserHomePageUI.ADD_TO_WISHLIST_BUTTON);
	}

	public Object getTextOnNotificationBar() {
		waitForElementVisible(driver, UserHomePageUI.NOTIFICATION_BAR);
		return getElementText(driver, UserHomePageUI.NOTIFICATION_BAR);
	}

	public void clickCloseNotificationBar() {
		waitForElementClickable(driver, UserHomePageUI.NOTIFICATION_BAR_CLOSE_BUTTON);
		clickToElement(driver, UserHomePageUI.NOTIFICATION_BAR_CLOSE_BUTTON);
	}

	public void clickToCompareButtonOfProductByName(String name) {
		waitForElementClickable(driver, UserHomePageUI.ADD_TO_COMPARE_BUTTON, name);
		clickToElement(driver, UserHomePageUI.ADD_TO_COMPARE_BUTTON, name);
	}

	
	

	
	
	
	
//	@Step("Click to Register Link")
//	public UserRegisterPO clickToRegisterLink() {
//		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
//		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
//		return PageGeneratorManager.getRegisterPage(driver);
//	}
//
//	public UserLoginPO clickToLoginLink() {
//		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
//		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
//		return PageGeneratorManager.getLoginPage(driver);
//	}
//
	/*
	 * public boolean isHomePageSliderDisplayed() { waitForElementVisible(driver,
	 * UserHomePageUI.HOMEPAGE_SLIDER); return isElementDisplayed(driver,
	 * UserHomePageUI.HOMEPAGE_SLIDER); }
	 */
//
//	public UserCustomerInforPO clickToMyAccountLink() {
//		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
//		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
//		return PageGeneratorManager.getCustomerPage(driver);
//	}
//
//	public boolean isRegisterLinkUndisplayed() {
//		return isElementUndisplayed(driver, UserHomePageUI.REGISTER_LINK);	
//	}
//
//	@Step("verify is element undisplayed")
//	public boolean isLoginLinkUndisplayed() {
//		return isElementUndisplayed(driver, UserHomePageUI.LOGIN_LINK);	
//	}
//
//
//	public boolean isShoppingCartNoItemTooltipUndisplayed() {
//		// TODO Auto-generated method stub
//		return isElementUndisplayed(driver, UserHomePageUI.SHOPPING_CART_ITEM_TOOLTIP);	
//	}
//
//	@Step("Verify register link is displayed")
//	public boolean isRegisterLinkDisplayed() {
//		waitForElementVisible(driver, UserHomePageUI.REGISTER_LINK);
//		return isElementDisplayed(driver, UserHomePageUI.REGISTER_LINK);
//	}
//	
//	@Step("Verify login link is displayed")
//	public boolean isLoginLinkDisplayed() {
//		waitForElementVisible(driver, UserHomePageUI.LOGIN_LINK);
//		return isElementDisplayed(driver, UserHomePageUI.REGISTER_LINK);
//	}

}
