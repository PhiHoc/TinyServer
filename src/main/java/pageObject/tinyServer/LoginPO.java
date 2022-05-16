package pageObject.tinyServer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.tinyServer.LoginPUI;

public class LoginPO extends BasePage{
	WebDriver driver;
	
	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(driver, LoginPUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, LoginPUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, LoginPUI.CONTINUE_BUTTON);
		clickToElement(driver, LoginPUI.CONTINUE_BUTTON);
	}

	public HomePO clickToSignInButton() {
		waitForElementClickable(driver, LoginPUI.SIGNIN_BUTTON);
		clickToElement(driver, LoginPUI.SIGNIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
}
