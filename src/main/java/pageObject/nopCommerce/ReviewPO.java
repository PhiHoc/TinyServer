package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ReviewPUI;

public class ReviewPO extends BasePage {

	private WebDriver driver;

	public ReviewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToReviewTitle(String title) {
		waitForElementVisible(driver, ReviewPUI.REVIEW_TITLE_TEXTBOX);
		sendkeysToElement(driver, ReviewPUI.REVIEW_TITLE_TEXTBOX, title);
	}

	public void enterToReviewText(String text) {
		waitForElementVisible(driver, ReviewPUI.REVIEW_TEXT_TEXTAREA);
		sendkeysToElement(driver, ReviewPUI.REVIEW_TEXT_TEXTAREA, text);
	}


	public void clickSubmitReviewButton() {
		waitForElementClickable(driver, ReviewPUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ReviewPUI.SUBMIT_REVIEW_BUTTON);
	}

}
