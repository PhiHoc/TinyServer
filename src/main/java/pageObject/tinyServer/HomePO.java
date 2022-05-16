package pageObject.tinyServer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.tinyServer.HomePUI;

public class HomePO extends BasePage{
	WebDriver driver;
	
	public HomePO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSettingMenu() {
		waitForLoadingIconDisapear();
		waitForElementClickable(driver, HomePUI.SETTING_MENU);
		clickToElement(driver, HomePUI.SETTING_MENU);
	}

	public void clickToAddPeople() {
		waitForElementClickable(driver, HomePUI.ADD_PEOPLE_MENU);
		clickToElement(driver, HomePUI.ADD_PEOPLE_MENU);
	}

	public void enterToUserFirstName(String name, String index) {
		waitForElementVisible(driver, HomePUI.FIRSTNAME_TEXTBOX_DYNAMIC, index);
		sendkeysToElement(driver, String.format(HomePUI.FIRSTNAME_TEXTBOX_DYNAMIC, index), name);
	}
	
	public void enterToUserLastName(String name, String index) {
		waitForElementVisible(driver, HomePUI.LASTNAME_TEXTBOX_DYNAMIC, index);
		sendkeysToElement(driver, String.format(HomePUI.LASTNAME_TEXTBOX_DYNAMIC, index), name);
	}
	
	public void enterToUserEmail(String email, String index) {
		waitForElementVisible(driver, HomePUI.EMAIL_TEXTBOX_DYNAMIC, index);
		sendkeysToElement(driver, String.format(HomePUI.EMAIL_TEXTBOX_DYNAMIC, index), email);
	}
	
	public void clickToStartDate(String index) {
		waitForElementClickable(driver, HomePUI.START_DATE_DYNAMIC, index);
		clickToElement(driver, HomePUI.START_DATE_DYNAMIC, index);
	}

	public void selectUserStartMonth(String month) {
		waitForElementClickable(driver, HomePUI.MONTH_PICKER);
		clickToElement(driver, HomePUI.MONTH_PICKER);
		waitForElementClickable(driver, HomePUI.MONTH_AND_YEAR_PICKER_DYNAMIC, month);
		clickToElement(driver, HomePUI.MONTH_AND_YEAR_PICKER_DYNAMIC, month);
	}

	public void selectUserStartYear(String year) {
		waitForElementClickable(driver, HomePUI.YEAR_PICKER);
		clickToElement(driver, HomePUI.YEAR_PICKER);
		waitForElementClickable(driver, HomePUI.MONTH_AND_YEAR_PICKER_DYNAMIC, year);
		clickToElement(driver, HomePUI.MONTH_AND_YEAR_PICKER_DYNAMIC, year);
	}

	public void selectUserStartDay(String day) {
		waitForElementClickable(driver, HomePUI.DAY_PICKER_DYNAMIC, day);
		clickToElement(driver, HomePUI.DAY_PICKER_DYNAMIC, day);
	}

	public void selectUserManager(String managerName, String index) {
		waitForElementClickable(driver, HomePUI.MANAGER_SELECT_DYNAMIC, index);
		clickToElement(driver, HomePUI.MANAGER_SELECT_DYNAMIC, index);
		
		waitForElementClickable(driver, HomePUI.MANAGER_DROPDOWN_DYNAMIC, managerName);
		clickToElement(driver, HomePUI.MANAGER_DROPDOWN_DYNAMIC, managerName);
	}
	
	public void waitForLoadingIconDisapear() {
		waitForElementVisible(driver, HomePUI.LOADING_ICON);
		waitForElementInvisible(driver, HomePUI.LOADING_ICON);
	}
	
	public void enterUserDataByIndex(String index, String fName,String lName,String email,String month,String year,String day,String managerName) {
		enterToUserFirstName(fName,index);
		enterToUserLastName(lName,index);
		enterToUserEmail(email,index);
		clickToStartDate(index);
		selectUserStartMonth(month);
		selectUserStartYear(year);
		selectUserStartDay(day);
		selectUserManager(managerName,index);
	}

	public void clickToAddPeopleButton() {
		waitForElementClickable(driver, HomePUI.ADD_PEOPLE_BUTTON);
		clickToElement(driver, HomePUI.ADD_PEOPLE_BUTTON);
	}

	public String getCongratulationText() {
		waitForElementVisible(driver, HomePUI.CONGRATULATION_TEXT);
		return getElementText(driver, HomePUI.CONGRATULATION_TEXT).replace("check_circle", "").strip();
	}

	public String getUserListTextByIndex(String index) {
		waitForElementVisible(driver, HomePUI.USER_LIST_DYNAMIC,index);
		return getElementText(driver, HomePUI.USER_LIST_DYNAMIC,index).strip();
	}

}
