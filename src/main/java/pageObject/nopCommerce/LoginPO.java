package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPUI;

public class LoginPO extends BasePage {

	private WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String email)
	{
		waitForElementVisible(driver, LoginPUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, LoginPUI.EMAIL_TEXTBOX,email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPUI.LOGIN_BUTTON);
	}

	public String getErorrMessageByEmail() {
		waitForElementVisible(driver, LoginPUI.EMAIL_ERORR_MESSAGE);
		return getElementText(driver, LoginPUI.EMAIL_ERORR_MESSAGE);
	}

	public String getValidationSummaryErrorMessage() {
		waitForElementVisible(driver, LoginPUI.VALIDATION_SUMMARY_ERORR_MESSAGE);
		return getElementText(driver, LoginPUI.VALIDATION_SUMMARY_ERORR_MESSAGE);
	}

	public void loginWithData(String email, String pass) {
			enterToEmailTextbox(email);
			enterToPasswordTextbox(pass);
			clickToLoginButton();
	}

}
