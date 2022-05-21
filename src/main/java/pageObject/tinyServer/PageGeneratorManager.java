package pageObject.tinyServer;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static SignUpPO getSingupPage (WebDriver driver) {
		return new SignUpPO(driver);
	}
	
	public static LoginPO getLoginPage (WebDriver driver) {
		return new LoginPO(driver);
	}
	
	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);
	}
}
