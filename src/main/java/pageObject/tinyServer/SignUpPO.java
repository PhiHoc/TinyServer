package pageObject.tinyServer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.tinyServer.SignupPUI;

public class SignUpPO extends BasePage{
	WebDriver driver;
	
	public SignUpPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(driver, SignupPUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, SignupPUI.EMAIL_TEXTBOX, email);
	}

	public void clickToNextButton() {
		waitForElementClickable(driver, SignupPUI.NEXT_BUTTON);
		clickToElement(driver, SignupPUI.NEXT_BUTTON);
	}

	public void enterToFullNameTextBox(String fullname) {
		waitForElementVisible(driver, SignupPUI.FULLNAME_TEXTBOX);
		sendkeysToElement(driver, SignupPUI.FULLNAME_TEXTBOX, fullname);
	}
	
	public void enterToCompanyNameTextBox(String company) {
		waitForElementVisible(driver, SignupPUI.COMPANYNAME_TEXTBOX);
		sendkeysToElement(driver, SignupPUI.COMPANYNAME_TEXTBOX, company);
	}
	
	public void enterToEmployeesNumberTextBox(String empNum) {
		waitForElementVisible(driver, SignupPUI.EMPLOYEES_NUMBER_TEXTBOX);
		sendkeysToElement(driver, SignupPUI.EMPLOYEES_NUMBER_TEXTBOX, empNum);
	}
	
	public void enterToPhoneNumberTextBox(String phone) {
		waitForElementVisible(driver, SignupPUI.PHONE_NUMBER_TEXTBOX);
		sendkeysToElement(driver, SignupPUI.PHONE_NUMBER_TEXTBOX, phone);
	}
	
	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, SignupPUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, SignupPUI.PASSWORD_TEXTBOX, password);
	}

	public HomePO clickToStartTrialButton() {
		waitForElementClickable(driver, SignupPUI.NEXT_BUTTON);
		clickToElement(driver, SignupPUI.NEXT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
