package pageObject.nopCommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.SearchPUI;

public class SearchPO extends BasePage {

	private WebDriver driver;

	public SearchPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterToSearchKeyWordTextBox(String data)
	{
		waitForAllElementVisible(driver, SearchPUI.SEARCH_KEYWORD_TEXTBOX);
		sendkeysToElement(driver, SearchPUI.SEARCH_KEYWORD_TEXTBOX, data);
	}

	public String getSearchErrorMessage() {
		waitForAllElementVisible(driver, SearchPUI.SEARCH_ERROR_MESSAGE);
		return getElementText(driver, SearchPUI.SEARCH_ERROR_MESSAGE);
	}

	public void clickToSearchButton() {
		waitForAllElementVisible(driver, SearchPUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPUI.SEARCH_BUTTON);
	}

	public int numberOfProductAppear() {
		waitForAllElementVisible(driver, SearchPUI.PRODUCT_TITLE_LINK);
		return countElementSize(driver, SearchPUI.PRODUCT_TITLE_LINK); 
	}

	public List<WebElement> getListOfProductsAppeared() {
		waitForAllElementVisible(driver, SearchPUI.PRODUCT_TITLE_LINK);
		return getElements(driver, SearchPUI.PRODUCT_TITLE_LINK);
	}


	public void checkToAdvancedSearch() {
		waitForElementVisible(driver, SearchPUI.ADVANCED_SEARCH_CHECKBOX);
		checkToCheckboxOrRadio(driver, SearchPUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void selectCategoryDropDown(String category) {
		waitForElementVisible(driver, SearchPUI.CATEGORY_DROPDOWN);
		selectDropdownByText(driver, SearchPUI.CATEGORY_DROPDOWN, category);
	}

	public void uncheckToAutomaticallySearchSubCategories() {
		waitForElementVisible(driver, SearchPUI.AUTOMATICALLY_SEARCH_CHECKBOX);
		uncheckToCheckboxOrRadio(driver, SearchPUI.AUTOMATICALLY_SEARCH_CHECKBOX);
	}

	public void checkToAutomaticallySearchSubCategories() {
		waitForElementVisible(driver, SearchPUI.AUTOMATICALLY_SEARCH_CHECKBOX);
		checkToCheckboxOrRadio(driver, SearchPUI.AUTOMATICALLY_SEARCH_CHECKBOX);
	}

	public void selectOnManufacturerDropdown(String text) {
		waitForElementVisible(driver, SearchPUI.MANUFACTURER_DROPDOWN);
		selectDropdownByText(driver, SearchPUI.MANUFACTURER_DROPDOWN, text);
	}


}
