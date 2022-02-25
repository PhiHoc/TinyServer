package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CheckoutPUI;

public class CheckoutPO extends BasePage {

	private WebDriver driver;

	public CheckoutPO(WebDriver driver) {
		this.driver = driver;
	}

	public void uncheckToShipToTheSameAddress() {
		waitForElementVisible(driver, CheckoutPUI.SHIPPING_SAME_ADDRESS_CHECKBOX);
		uncheckToCheckboxOrRadio(driver, CheckoutPUI.SHIPPING_SAME_ADDRESS_CHECKBOX);
	}

	public void selectBillingCountryDropDown(String country) {
		waitForElementVisible(driver, CheckoutPUI.BILLING_COUNTRY_DROPDOWN);
		selectDropdownByText(driver, CheckoutPUI.BILLING_COUNTRY_DROPDOWN, country);
	}

	public void enterToBillingCity(String city) {
		waitForElementVisible(driver, CheckoutPUI.BILLING_CITY_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.BILLING_CITY_TEXTBOX, city);
	}

	public void enterToBillingAddress1(String addr1) {
		waitForElementVisible(driver, CheckoutPUI.BILLING_ADDRESS_1_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.BILLING_ADDRESS_1_TEXTBOX, addr1);
	}

	public void enterToBillingPhoneNumber(String phonenum) {
		waitForElementVisible(driver, CheckoutPUI.BILLING_PHONE_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.BILLING_PHONE_TEXTBOX, phonenum);
	}

	public void clickToBillingContinueButton() {
		waitForElementClickable(driver, CheckoutPUI.BILLING_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPUI.BILLING_CONTINUE_BUTTON);
	}

	public void enterToBillingZipPostalCode(String zipcode) {
		waitForElementVisible(driver, CheckoutPUI.BILLING_ZIP_POSTAL_CODE_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.BILLING_ZIP_POSTAL_CODE_TEXTBOX, zipcode);
	}

	public void selectNewShippingAddress() {
		waitForElementVisible(driver, CheckoutPUI.NEW_SHIPPING_ADDRESS_DROPDOWN);
		selectDropdownByText(driver, CheckoutPUI.NEW_SHIPPING_ADDRESS_DROPDOWN, "New Address");
	}

	public void selectShippingCountryDropDown(String country) {
		waitForElementVisible(driver, CheckoutPUI.SHIPPING_COUNTRY_DROPDOWN);
		selectDropdownByText(driver, CheckoutPUI.SHIPPING_COUNTRY_DROPDOWN, country);
	}

	public void enterToShippingCity(String city) {
		waitForElementVisible(driver, CheckoutPUI.SHIPPING_CITY_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.SHIPPING_CITY_TEXTBOX, city);
	}

	public void enterToShippingZipPostalCode(String zipcode) {
		waitForElementVisible(driver, CheckoutPUI.SHIPPING_ZIP_POSTAL_CODE_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.SHIPPING_ZIP_POSTAL_CODE_TEXTBOX, zipcode);
	}

	public void enterToShippingAddress1(String addr1) {
		waitForElementVisible(driver, CheckoutPUI.SHIPPING_ADDRESS_1_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_1_TEXTBOX, addr1);
	}

	public void enterToShippingPhoneNumber(String phonenum) {
		waitForElementVisible(driver, CheckoutPUI.SHIPPING_PHONE_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.SHIPPING_PHONE_TEXTBOX, phonenum);
	}

	public void clickToShippingAddressContinueButton() {
		waitForElementClickable(driver, CheckoutPUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
	}

	public void clickToShippingMethodContinueButton() {
		waitForElementClickable(driver, CheckoutPUI.SHIPPING_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPUI.SHIPPING_METHOD_CONTINUE_BUTTON);
	}

	public void selectToPaymentMethodCheckMoneyOrder() {
		waitForElementVisible(driver, CheckoutPUI.CHECK_MONEY_ORDER_RADIO);
		checkToCheckboxOrRadio(driver, CheckoutPUI.CHECK_MONEY_ORDER_RADIO);
	}

	public void clickToPaymentMethodContinueButton() {
		waitForElementClickable(driver, CheckoutPUI.PAYMENT_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPUI.PAYMENT_CONTINUE_BUTTON);
	}

	public String getPaymentInfoSectionText() {
		waitForElementVisible(driver, CheckoutPUI.PAYMENT_INFO_SECTION);
		return getElementText(driver, CheckoutPUI.PAYMENT_INFO_SECTION);
	}

	public void clickToPaymentInfoContinueButton() {
		waitForElementClickable(driver, CheckoutPUI.PAYMENT_INFO_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPUI.PAYMENT_INFO_CONTINUE_BUTTON);
	}

	public void clickToConfirmButton() {
		waitForElementClickable(driver, CheckoutPUI.CONFIRM_BUTTON);
		clickToElement(driver, CheckoutPUI.CONFIRM_BUTTON);
	}

	public String getBillingInfoText() {
		waitForElementVisible(driver, CheckoutPUI.CONFIRM_BILLING_INFO);
		return getElementText(driver, CheckoutPUI.CONFIRM_BILLING_INFO);
	}

	public String getPaymentMethodText() {
		waitForElementVisible(driver, CheckoutPUI.CONFIRM_PAYMENT_METHOD_INFO);
		return getElementText(driver, CheckoutPUI.CONFIRM_PAYMENT_METHOD_INFO);
	}

	public String getShippingMethodText() {
		waitForElementVisible(driver, CheckoutPUI.CONFIRM_SHIPPING_METHOD_INFO);
		return getElementText(driver, CheckoutPUI.CONFIRM_SHIPPING_METHOD_INFO);
	}

	public String getShippinAddressInfoText() {
		waitForElementVisible(driver, CheckoutPUI.CONFIRM_SHIPPING_INFO);
		return getElementText(driver, CheckoutPUI.CONFIRM_SHIPPING_INFO);
	}

	public String getProductSKUText() {
		waitForElementVisible(driver, CheckoutPUI.SKU_NUMBER);
		return getElementText(driver, CheckoutPUI.SKU_NUMBER);
	}

	public String getProductNameText() {
		waitForElementVisible(driver, CheckoutPUI.PRODUCT_NAME_LINK);
		return getElementText(driver, CheckoutPUI.PRODUCT_NAME_LINK);
	}

	public String getProductPriceText() {
		waitForElementVisible(driver, CheckoutPUI.PRODUCT_PRICE);
		return getElementText(driver, CheckoutPUI.PRODUCT_PRICE);
	}

	public String getProductQuantityText() {
		waitForElementVisible(driver, CheckoutPUI.PRODUCT_QUANTITY);
		return getElementText(driver, CheckoutPUI.PRODUCT_QUANTITY);
	}

	public String getProductSubtotalText() {
		waitForElementVisible(driver, CheckoutPUI.PRODUCT_SUBTOTAL);
		return getElementText(driver, CheckoutPUI.PRODUCT_SUBTOTAL);
	}

	public String getGiftWrappingText() {
		waitForElementVisible(driver, CheckoutPUI.GIFT_WRAPPING);
		return getElementText(driver, CheckoutPUI.GIFT_WRAPPING);
	}

	public String getOrderSubTotalText() {
		waitForElementVisible(driver, CheckoutPUI.ORDER_SUBTOTAL);
		return getElementText(driver, CheckoutPUI.ORDER_SUBTOTAL);
	}

	public String getShippingCostText() {
		waitForElementVisible(driver, CheckoutPUI.SHIPPING_COST);
		return getElementText(driver, CheckoutPUI.SHIPPING_COST);
	}

	public String getTaxText() {
		waitForElementVisible(driver, CheckoutPUI.TAX_VALUE);
		return getElementText(driver, CheckoutPUI.TAX_VALUE);
	}

	public String getOrderTotalText() {
		waitForElementVisible(driver, CheckoutPUI.ORDER_TOTAL);
		return getElementText(driver, CheckoutPUI.ORDER_TOTAL);
	}

	public String getOrderCompletePageBodyTitleText() {
		waitForElementVisible(driver, CheckoutPUI.ORDER_COMPELTE_PAGE_BODY_TITLE);
		return getElementText(driver, CheckoutPUI.ORDER_COMPELTE_PAGE_BODY_TITLE);
	}

	public boolean isOrderNumberVisible() {
		return isElementDisplayed(driver, CheckoutPUI.ORDER_NUMBER);
	}

	public String getOrderNumber() {
		waitForElementVisible(driver, CheckoutPUI.ORDER_NUMBER);
		return getElementText(driver, CheckoutPUI.ORDER_NUMBER);
	}

	public void selectToPaymentMethodCreditCard() {
		waitForElementVisible(driver, CheckoutPUI.CREDIT_CARD_RADIO);
		checkToCheckboxOrRadio(driver, CheckoutPUI.CREDIT_CARD_RADIO);
	}

	public void enterToCardHolderName(String name) {
		waitForElementVisible(driver, CheckoutPUI.CARD_HOLDER_NAME_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.CARD_HOLDER_NAME_TEXTBOX, name);
	}

	public void enterToCardNumber(String cardnum) {
		waitForElementVisible(driver, CheckoutPUI.CARD_NUMBER_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.CARD_NUMBER_TEXTBOX, cardnum);
	}

	public void enterToCardCode(String code) {
		waitForElementVisible(driver, CheckoutPUI.CARD_CODE_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.CARD_CODE_TEXTBOX, code);
	}

	public void selectNewBillingAddress() {
		waitForElementVisible(driver, CheckoutPUI.NEW_BILLING_ADDRESS_DROPDOWN);
		selectDropdownByText(driver, CheckoutPUI.NEW_BILLING_ADDRESS_DROPDOWN, "New Address");
	}

	public void enterToBillingAddressFirstName(String firstName) {
		waitForElementVisible(driver, CheckoutPUI.BILLING_FIRST_NAME_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.BILLING_FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToBillingAddressLastName(String lastName) {
		waitForElementVisible(driver, CheckoutPUI.BILLING_LAST_NAME_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.BILLING_LAST_NAME_TEXTBOX, lastName);
	}

	public void enterToBillingAddressEmail(String email) {
		waitForElementVisible(driver, CheckoutPUI.BILLING_EMAIL_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.BILLING_EMAIL_TEXTBOX, email);
	}

	public void enterToShippingAddressFirstName(String firstName) {
		waitForElementVisible(driver, CheckoutPUI.SHIPPING_FIRST_NAME_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.SHIPPING_FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToShippingAddressLastName(String lastName) {
		waitForElementVisible(driver, CheckoutPUI.SHIPPING_LAST_NAME_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.SHIPPING_LAST_NAME_TEXTBOX, lastName);
	}

	public void enterToShippingAddressEmail(String email) {
		waitForElementVisible(driver, CheckoutPUI.SHIPPING_EMAIL_TEXTBOX);
		sendkeysToElement(driver, CheckoutPUI.SHIPPING_EMAIL_TEXTBOX, email);
	}

	public void checkToNextDayAirMethodRadio() {
		waitForElementVisible(driver, CheckoutPUI.NEXT_DAY_AIR_SHIP_METHOD_RADIO);
		checkToCheckboxOrRadio(driver, CheckoutPUI.NEXT_DAY_AIR_SHIP_METHOD_RADIO);
	}

	public void enterDataToBillingAddress(String fName, String lName, String email, String country, String city,
			String add1, String code, String phone) {
		if (!fName.isEmpty() && !lName.isEmpty() && !email.isEmpty() && !country.isEmpty() && !city.isEmpty()
				&& !add1.isEmpty() && !code.isEmpty() && !phone.isEmpty()) {
			enterToBillingAddressFirstName(fName);
			enterToBillingAddressLastName(lName);
			enterToBillingAddressEmail(email);
			selectBillingCountryDropDown(country);
			enterToBillingCity(city);
			enterToBillingAddress1(add1);
			enterToBillingZipPostalCode(code);
			enterToBillingPhoneNumber(phone);
		}
	}

	public void enterDataToShippingAddress(String fName, String lName, String email, String country, String city,
			String add1, String code, String phone) {
		if (!fName.isEmpty() && !lName.isEmpty() && !email.isEmpty() && !country.isEmpty() && !city.isEmpty()
				&& !add1.isEmpty() && !code.isEmpty() && !phone.isEmpty()) {
			enterToShippingAddressFirstName(fName);
			enterToShippingAddressLastName(lName);
			enterToShippingAddressEmail(email);
			selectShippingCountryDropDown(country);
			enterToShippingCity(city);
			enterToShippingAddress1(add1);
			enterToShippingZipPostalCode(code);
			enterToShippingPhoneNumber(phone);
		}
	}

	public void selectExpireYear(String expYear) {
		waitForElementVisible(driver, CheckoutPUI.EXP_YEAR_DROPDOWN);
		selectDropdownByText(driver, CheckoutPUI.EXP_YEAR_DROPDOWN, expYear);
	}

}
