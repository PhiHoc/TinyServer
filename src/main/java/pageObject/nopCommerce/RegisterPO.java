package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RegisterPUI;

public class RegisterPO extends BasePage {

	private WebDriver driver;

	public RegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToLastnameEmpty() {
		waitForElementVisible(driver, RegisterPUI.LASTNAME_TEXTBOX);
		sendkeysToElement(driver, RegisterPUI.LASTNAME_TEXTBOX, "");
	}

	public void enterToCompanyName(String name) {
		waitForElementVisible(driver, RegisterPUI.COMPANYNAME_TEXTBOX);
		sendkeysToElement(driver, RegisterPUI.COMPANYNAME_TEXTBOX, name);

	}

	public void enterToPassword(String password) {
		waitForElementVisible(driver, RegisterPUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, RegisterPUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToEmail(String email) {
		waitForElementVisible(driver, RegisterPUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, RegisterPUI.EMAIL_TEXTBOX, email);
	}

	public void enterToConfirmPassword(String confirmPW) {
		waitForElementVisible(driver, RegisterPUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeysToElement(driver, RegisterPUI.CONFIRMPASSWORD_TEXTBOX, confirmPW);

	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, RegisterPUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtMandantoryFieldByName() {
		waitForElementVisible(driver, RegisterPUI.FIRST_NAME_ERORR_MESSAGE);
		return getElementText(driver, RegisterPUI.FIRST_NAME_ERORR_MESSAGE);
	}

	public String getErrorMessageAtMandantoryFieldByLastName() {
		waitForElementVisible(driver, RegisterPUI.LAST_NAME_ERORR_MESSAGE);
		return getElementText(driver, RegisterPUI.LAST_NAME_ERORR_MESSAGE);
	}

	public String getErrorMessageAtMandantoryFieldByEmail() {
		waitForElementVisible(driver, RegisterPUI.EMAIL_ERORR_MESSAGE);
		return getElementText(driver, RegisterPUI.EMAIL_ERORR_MESSAGE);
	}

	public String getErrorMessageAtMandantoryFieldByPassword() {
		waitForElementVisible(driver, RegisterPUI.PASSWORD_ERORR_MESSAGE);
		return getElementText(driver, RegisterPUI.PASSWORD_ERORR_MESSAGE);
	}

	public String getErrorMessageAtMandantoryFieldByConfirmPassword() {
		waitForElementVisible(driver, RegisterPUI.CONFIRMPASSWORD_ERORR_MESSAGE);
		return getElementText(driver, RegisterPUI.CONFIRMPASSWORD_ERORR_MESSAGE);
	}

	public void enterToLastName(String lastname) {
		waitForElementVisible(driver, RegisterPUI.LASTNAME_TEXTBOX);
		sendkeysToElement(driver, RegisterPUI.LASTNAME_TEXTBOX, lastname);
	}

	public String getGistrationCompletedMessage() {
		waitForElementVisible(driver, RegisterPUI.REGISTRATION_COMPLETED_MESSAGE);
		return getElementText(driver, RegisterPUI.REGISTRATION_COMPLETED_MESSAGE);
	}

	public String getErorrMessageByExistedEmail() {
		waitForElementVisible(driver, RegisterPUI.EXISTED_EMAIL_ERORR_MESSAGE);
		return getElementText(driver, RegisterPUI.EXISTED_EMAIL_ERORR_MESSAGE);
	}

	public void clickContinueButton() {
		waitForElementVisible(driver, RegisterPUI.CONTINUE_BUTTON);
		clickToElement(driver, RegisterPUI.CONTINUE_BUTTON);
	}


	public void filterRegisterData(String fName, String lName, String email, String pwd, String confirmPwd,
			String company) {
		enterToFirstName(fName);
		enterToLastName(lName);
		enterToEmail(email);
		enterToPassword(pwd);
		enterToConfirmPassword(confirmPwd);
		enterToCompanyName(company);
	}

	public void enterToFirstName(String string) {
		waitForElementVisible(driver, RegisterPUI.FIRTNAME_TEXTBOX);
		sendkeysToElement(driver, RegisterPUI.FIRTNAME_TEXTBOX, string);
	}

}
