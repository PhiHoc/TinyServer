package pageObject.nopCommerce;

	import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CompareProductListPUI;

public class CompareProductListPO extends BasePage {

	private WebDriver driver;

	public CompareProductListPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getNumberOfRemoveButtonsDisplayed() {
		return countElementSize(driver, CompareProductListPUI.REMOVE_BUTTON);
	}

	public String getNameProductInCompareTable() {
		waitForElementVisible(driver, CompareProductListPUI.TABLE_PRODUCT_NAME);
		return getElementText(driver, CompareProductListPUI.TABLE_PRODUCT_NAME);
	}

}
