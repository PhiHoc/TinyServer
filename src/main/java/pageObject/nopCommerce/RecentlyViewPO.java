package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.RecentlyViewPUI;

public class RecentlyViewPO extends BasePage {

	private WebDriver driver;

	public RecentlyViewPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductTitle() {
		String productTitle = "";
		waitForElementVisible(driver, RecentlyViewPUI.PRODUCT_TITLE);
		for(WebElement element : getElements(driver, RecentlyViewPUI.PRODUCT_TITLE))
			productTitle +=  element.getText()+" ";
		return productTitle;
	}

}
