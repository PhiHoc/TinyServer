package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ShopppingCartPUI;

public class ShoppingCartPO extends BasePage {

	private WebDriver driver;

	public ShoppingCartPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getNumberOfProductInShoppingCart() {
		return countElementSize(driver, ShopppingCartPUI.PRODUCT_NAME_LINK);
	}

	public String getNameOfProductInShoppingCart() {
		waitForElementVisible(driver, ShopppingCartPUI.PRODUCT_NAME_LINK);
		return getElementText(driver, ShopppingCartPUI.PRODUCT_NAME_LINK);
	}

	public String getPriceOfProductInShoppingCart() {
		waitForElementVisible(driver, ShopppingCartPUI.PRODUCT_PRICE);
		return getElementText(driver, ShopppingCartPUI.PRODUCT_PRICE);
	}

	public void clickToEditLink() {
		waitForElementClickable(driver, ShopppingCartPUI.EDIT_LINK);
		clickToElement(driver, ShopppingCartPUI.EDIT_LINK);
	}

	public String getTotalPriceOfProductInShoppingCart() {
		waitForElementVisible(driver, ShopppingCartPUI.PRODUCT_TOTAL_PRICE);
		return getElementText(driver, ShopppingCartPUI.PRODUCT_TOTAL_PRICE);
	}

	public String getQuantityOfProductInShoppingCart() {
		waitForElementVisible(driver, ShopppingCartPUI.PRODUCT_QUANTITY);
		return getElementAttributeValue(driver, ShopppingCartPUI.PRODUCT_QUANTITY,"value");
	}

	public void clickRemoveButton() {
		waitForElementClickable(driver, ShopppingCartPUI.REMOVE_BUTTON);
		clickToElement(driver, ShopppingCartPUI.REMOVE_BUTTON);
	}

	public String getMessageInPageBody() {
		waitForElementVisible(driver, ShopppingCartPUI.PAGE_BODY);
		return getElementText(driver, ShopppingCartPUI.PAGE_BODY);
	}

	public void updateToQuantity(String num) {
		waitForElementVisible(driver, ShopppingCartPUI.PRODUCT_QUANTITY);
		sendkeysToElement(driver, ShopppingCartPUI.PRODUCT_QUANTITY,num);
	}

	public void clickToUppdateShoppingCartButton() {
		waitForElementClickable(driver, ShopppingCartPUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, ShopppingCartPUI.UPDATE_SHOPPING_CART_BUTTON);
	}

	public void selectShippingAddressCountryDropDownByText(String country) {
		waitForElementVisible(driver, ShopppingCartPUI.ESTIMATE_SHIPPING_COUNTRY_DROPDOWN);
		selectDropdownByText(driver, ShopppingCartPUI.ESTIMATE_SHIPPING_COUNTRY_DROPDOWN, country);
	}

	public void enterToShippingAddressZipPostalCode(String zip) {
		waitForElementVisible(driver, ShopppingCartPUI.ZIP_POSTAL_CODE_TEXTBOX);
		sendkeysToElement(driver, ShopppingCartPUI.ZIP_POSTAL_CODE_TEXTBOX, zip);
	}
	
	public void waitForShippingMethodAppear() {
		waitForAllElementVisible(driver, ShopppingCartPUI.SHIPPING_METHOD_ITEMS);
	}
	
	public void clickToEstimateShippingLink() {
		waitForElementClickable(driver, ShopppingCartPUI.ESTIMATE_SHIPPING_LINK);
		clickToElement(driver, ShopppingCartPUI.ESTIMATE_SHIPPING_LINK);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, ShopppingCartPUI.APPLY_BUTTON);
		clickToElement(driver, ShopppingCartPUI.APPLY_BUTTON);
	}

	public void checkToIAgreeCheckBox() {
		waitForElementVisible(driver, ShopppingCartPUI.I_AGREE_CHECKBOX);
		checkToCheckboxOrRadio(driver, ShopppingCartPUI.I_AGREE_CHECKBOX);
	}

	public CheckoutPO clickToCheckoutButton() {
		waitForElementClickable(driver, ShopppingCartPUI.CHECKOUT_BUTTON);
		clickToElement(driver, ShopppingCartPUI.CHECKOUT_BUTTON);
		return new CheckoutPO(driver);
	}

	public void updateQuantityTo10() {
		waitForElementVisible(driver, ShopppingCartPUI.PRODUCT_QUANTITY);
		sendkeysToElement(driver, ShopppingCartPUI.PRODUCT_QUANTITY,"10");
	}

}
