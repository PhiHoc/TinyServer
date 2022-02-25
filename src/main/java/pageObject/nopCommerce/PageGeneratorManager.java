package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static UserHomePO getHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static AdminPO getAdminPage(WebDriver driver) {
		return new AdminPO(driver);
	}
	
	public static RegisterPO getRegisterPage(WebDriver driver) {
		return new RegisterPO(driver);
	}
	
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}

	public static MyAccountPO getMyAccountPage(WebDriver driver) {
		return new MyAccountPO(driver);
	}
	
	public static SearchPO getSearchPage(WebDriver driver) {
		return new SearchPO(driver);
	}
	
	public static ReviewPO getReviewPage(WebDriver driver) {
		return new ReviewPO(driver);
	}

	public static ComputersPO getComputersPage(WebDriver driver) {
		return new ComputersPO(driver);
	}
	
	public static WishListPO getWishListPage(WebDriver driver) {
		return new WishListPO(driver);
	}
	
	public static CompareProductListPO getCompareProductListPage(WebDriver driver) {
		return new CompareProductListPO(driver);
	}
	
	public static RecentlyViewPO getRecentlyViewPage(WebDriver driver) {
		return new RecentlyViewPO(driver);
	}

	public static ShoppingCartPO getShoppingCartPage(WebDriver driver) {
		return new ShoppingCartPO(driver);
	}
}
