package pageObject.tinyServer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.tinyServer.HomePUI;
import utilities.DateUtil;

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
	
	public void enterUserDataByIndex(int intIndex, String fName,String lName,String email,String startDate,String managerName) {
		String index = String.valueOf(intIndex);
		enterToUserFirstName(fName,index);
		enterToUserLastName(lName,index);
		enterToUserEmail(email,index);
		clickToStartDate(index);
		selectStartDate(startDate);
		selectUserManager(managerName,index);
	}
	
	public void selectStartDate(String startDate) {
		waitForAllElementVisible(driver, HomePUI.DAY_PICKER);
		WebElement nextLink = getElement(driver, HomePUI.DATE_NEXT_LINK);
		WebElement previousLink = getElement(driver, HomePUI.DATE_PREVIOUS_LINK);
		WebElement monthYear = getElement(driver, HomePUI.DATE_MONTH_YEAR);
		
		waitForElementClickable(driver, HomePUI.DAY_PICKER);
		waitForElementClickable(driver, HomePUI.DATE_NEXT_LINK);
		waitForElementClickable(driver, HomePUI.DATE_PREVIOUS_LINK);
		
		DateUtil.selectDatePicker(driver,HomePUI.DAY_PICKER,nextLink,previousLink,monthYear, startDate);
	}

	public void clickToAddPeopleButton() {
		waitForElementClickable(driver, HomePUI.ADD_PEOPLE_BUTTON);
		clickToElement(driver, HomePUI.ADD_PEOPLE_BUTTON);
	}

	public String getCongratulationText() {
		waitForElementVisible(driver, HomePUI.CONGRATULATION_TEXT);
		return getElementText(driver, HomePUI.CONGRATULATION_TEXT).replace("check_circle", "").strip();
	}

	public String getUserListTextByIndex(int intIndex) {
		String index = String.valueOf(intIndex);
		waitForElementVisible(driver, HomePUI.USER_LIST_DYNAMIC,index);
		return getElementText(driver, HomePUI.USER_LIST_DYNAMIC,index).strip();
	}

	public void clickToUserAvatar() {
		waitForElementClickable(driver, HomePUI.USER_AVATAR);
		clickToElement(driver, HomePUI.USER_AVATAR);
	}

	public LoginPO clickToLogoutButton() {
		waitForElementClickable(driver, HomePUI.LOGOUT_BUTTON);
		clickToElement(driver, HomePUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getLoginPage(driver);
	}

}
