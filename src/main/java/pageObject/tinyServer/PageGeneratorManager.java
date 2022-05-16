package pageObject.tinyServer;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPO getSingupPage (WebDriver driver) {
		return new LoginPO(driver);
	}
	
	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);
	}
}
