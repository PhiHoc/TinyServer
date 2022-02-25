package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.WishListPUI;

public class WishListPO extends BasePage {

	private WebDriver driver;

	public WishListPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getNumberOfProductInWishlist() {
		return countElementSize(driver, WishListPUI.PRODUCT_NAME_lINK);
	}

	public void clickToURLSharingLink() {
		waitForElementVisible(driver, WishListPUI.SHARE_LINK);
		clickToElement(driver, WishListPUI.SHARE_LINK);
	}

	public String getPageTitleText() {
		waitForElementVisible(driver, WishListPUI.PAGE_TITLE_HEADING);
		return getElementText(driver, WishListPUI.PAGE_TITLE_HEADING);
	}

	public void checkToAddToCartCheckBox() {
		waitForElementVisible(driver, WishListPUI.ADD_TO_CART_CHECKBOX);
		checkToCheckboxOrRadio(driver, WishListPUI.ADD_TO_CART_CHECKBOX);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, WishListPUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishListPUI.ADD_TO_CART_BUTTON);
	}

	public String getShoppingCartQuantity() {
		waitForElementVisible(driver, WishListPUI.SHOPPING_CART_QUANTITY);
		return getElementText(driver, WishListPUI.SHOPPING_CART_QUANTITY);
	}

	public void clickToRemoveButton() {
		waitForElementClickable(driver, WishListPUI.REMOVE_BUTTON);
		clickToElement(driver, WishListPUI.REMOVE_BUTTON);
	}

	public String getMessageInPageBody() {
		waitForElementVisible(driver, WishListPUI.PAGE_BODY);
		return getElementText(driver, WishListPUI.PAGE_BODY);
	}

}
