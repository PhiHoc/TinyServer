package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ComputersPUI;

public class ComputersPO extends BasePage {

	private WebDriver driver;

	public ComputersPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToNoteBooksLink() {
		waitForElementVisible(driver, ComputersPUI.NOTEBOOKS_LINK);
		clickToElement(driver, ComputersPUI.NOTEBOOKS_LINK);
	}

	public void clickToDesktopLink() {
		waitForElementVisible(driver, ComputersPUI.DESKTOP_LINK);
		clickToElement(driver, ComputersPUI.DESKTOP_LINK);
	}

	public void selectSortByDropDownByText(String text) {
		waitForElementVisible(driver, ComputersPUI.SORT_BY_DROPDOWN);
		selectDropdownByText(driver, ComputersPUI.SORT_BY_DROPDOWN, text);
		waitForProductReloaded();
	}

	public boolean isProductSortInAToZOrder() {
		return isDataStringSortedAscending(driver, ComputersPUI.PRODUCT_TITLE_LINK);
	}

	public boolean isProductSortInZToAOrder() {
		return isDataStringSortedDescending(driver, ComputersPUI.PRODUCT_TITLE_LINK);
	}

	public void waitForProductReloaded() {
		while (isElementDisplayed(driver, ComputersPUI.PRODUCT_BUSY));
	}

	public boolean isProductSortPriceInLowToHighOrder() {

		return isDataFloatSortedAscending(driver, ComputersPUI.PRICE_IN_PAGE_BODY);
	}

	public boolean isProductSortPriceInHighToLowOrder() {

		return isDataFloatSortedDescending(driver, ComputersPUI.PRICE_IN_PAGE_BODY);
	}

	public boolean isPriceLowToHighOnSortByDropDownSelected() {

		return getSelectedItemDropdown(driver, ComputersPUI.SORT_BY_DROPDOWN) == "Price: Low to High";
	}

	public void selectOnDisplayDropDownByText(String text) {
		waitForElementVisible(driver, ComputersPUI.DISPLAY_DROPDOWN);
		selectDropdownByText(driver, ComputersPUI.DISPLAY_DROPDOWN, text);
		waitForProductReloaded();
	}

	public int numberOfProductDisplayed() {
		waitForElementVisible(driver, ComputersPUI.PRODUCT_TITLE_LINK);
		return countElementSize(driver, ComputersPUI.PRODUCT_TITLE_LINK);
	}

	public String getCurrentPageText() {
		waitForElementVisible(driver, ComputersPUI.CURRENT_PAGE_LINK);
		return getElementText(driver, ComputersPUI.CURRENT_PAGE_LINK);
	}

	public void clickToNextPageIcon() {
		waitForElementClickable(driver, ComputersPUI.NEXT_PAGE_LINK);
		clickToElement(driver, ComputersPUI.NEXT_PAGE_LINK);
		waitForProductReloaded();
	}

	public boolean isNextPageIconDisplay() {
		return countElementSize(driver, ComputersPUI.NEXT_PAGE_LINK) != 0;
	}

	public boolean isPreviousPageIconDisplay() {
		return countElementSize(driver, ComputersPUI.PREVIOUS_PAGE_LINK) != 0;
	}

	public boolean isCurrentPageDisplay() {
		return countElementSize(driver, ComputersPUI.CURRENT_PAGE_LINK) != 0;
	}

	public void clickToProductByName(String name) {
		waitForElementVisible(driver, ComputersPUI.DYNAMIC_PRODUCT_TITLE_LINK, name);
		clickToElement(driver, ComputersPUI.DYNAMIC_PRODUCT_TITLE_LINK, name);
	}

	public void clickAddToCartButton() {
		waitForElementVisible(driver, ComputersPUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, ComputersPUI.ADD_TO_CART_BUTTON);
	}

	public void selectProcessorByText(String text) {
		waitForAllElementVisible(driver, ComputersPUI.PROCESSOR_DROPDOWN);
		selectDropdownByText(driver, ComputersPUI.PROCESSOR_DROPDOWN, text);
	}

	public void selectRAMByText(String text) {
		waitForAllElementVisible(driver, ComputersPUI.RAM_DROPDOWN);
		selectDropdownByText(driver, ComputersPUI.RAM_DROPDOWN, text);
	}

	public void select400GbHDD() {
		waitForAllElementVisible(driver, ComputersPUI.HDD_400GB_RADIO);
		checkToCheckboxOrRadio(driver, ComputersPUI.HDD_400GB_RADIO);
	}

	public void selectPremiumOS() {
		waitForElementVisible(driver, ComputersPUI.PREMIUM_OS_RADIO);
		checkToCheckboxOrRadio(driver, ComputersPUI.PREMIUM_OS_RADIO);
	}

	public void checkToTotalComanderSoftWare() {
		waitForElementVisible(driver, ComputersPUI.COMANDER_CHECKBOX);
		checkToCheckboxOrRadio(driver, ComputersPUI.COMANDER_CHECKBOX);
	}

	public void checkToMicrosoftOfficeSoftWare() {
		waitForElementVisible(driver, ComputersPUI.MICROSOFT_CHECKBOX);
		checkToCheckboxOrRadio(driver, ComputersPUI.MICROSOFT_CHECKBOX);
	}

	public void checkToAcrobatReaderSoftWare() {
		waitForElementVisible(driver, ComputersPUI.ACROBATCO_CHECKBOX);
		checkToCheckboxOrRadio(driver, ComputersPUI.ACROBATCO_CHECKBOX);
	}

	public void selectHomeOS() {
		waitForElementVisible(driver, ComputersPUI.HOME_OS_RADIO);
		checkToCheckboxOrRadio(driver, ComputersPUI.HOME_OS_RADIO);
	}

	public void enterToQuantityTextBox(String string) {
		waitForElementVisible(driver, ComputersPUI.QUANTITY_TEXTBOX);
		sendkeysToElement(driver, ComputersPUI.QUANTITY_TEXTBOX, string);
	}

	public void select320GbHDD() {
		waitForElementVisible(driver, ComputersPUI.HDD_320GB_RADIO);
		checkToCheckboxOrRadio(driver, ComputersPUI.HDD_320GB_RADIO);
	}

	public String getProductPrice() {
		waitForElementVisible(driver, ComputersPUI.PRODUCT_PRICE);
		return getElementText(driver, ComputersPUI.PRODUCT_PRICE);
	}

	public void unCheckToAcrobatReaderSoftWare() {
		waitForElementVisible(driver, ComputersPUI.ACROBATCO_CHECKBOX);
		uncheckToCheckboxOrRadio(driver, ComputersPUI.ACROBATCO_CHECKBOX);
	}

	public void unCheckToTotalComanderSoftWare() {
		waitForElementVisible(driver, ComputersPUI.COMANDER_CHECKBOX);
		uncheckToCheckboxOrRadio(driver, ComputersPUI.COMANDER_CHECKBOX);
	}

}
