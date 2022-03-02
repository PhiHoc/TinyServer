package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.MyAccountPUI;

public class MyAccountPO extends BasePage {
	private WebDriver driver;

	public MyAccountPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnFemaleRadio() {
		waitForElementClickable(driver, MyAccountPUI.FEMALE_RADIO);
		checkToCheckboxOrRadio(driver, MyAccountPUI.FEMALE_RADIO);
	}

	public void updateCustomerData(String firstName, String lastName, String date, String month, String year, String email,
			String companyName) {
		updateToFirstName(firstName);
		updateToLastName(lastName);
		updateToDOBMonth(month);
		updateToDOBYear(year);
		updateToDOBDay(date);
		updateToCompanyName(companyName);
		updateToEmail(email);
	}

	public void updateToFirstName(String fName) {
		waitForElementVisible(driver, MyAccountPUI.FIRST_NAME_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.FIRST_NAME_TEXTBOX, fName);
	}

	public void updateToLastName(String lName) {
		waitForElementVisible(driver, MyAccountPUI.LAST_NAME_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.LAST_NAME_TEXTBOX, lName);
	}

	public void updateToDOBMonth(String dobMonth) {
		waitForElementVisible(driver, MyAccountPUI.DOB_MONTH_DROPDOWN);
		selectDropdownByText(driver, MyAccountPUI.DOB_MONTH_DROPDOWN, dobMonth);
	}

	public void updateToDOBYear(String dobYear) {
		waitForElementVisible(driver, MyAccountPUI.DOB_YEAR_DROPDOWN);
		selectDropdownByText(driver, MyAccountPUI.DOB_YEAR_DROPDOWN, dobYear);
	}

	public void updateToDOBDay(String dobDay) {
		waitForElementVisible(driver, MyAccountPUI.DOB_DAY_DROPDOWN);
		selectDropdownByText(driver, MyAccountPUI.DOB_DAY_DROPDOWN, dobDay);
	}

	public void updateToCompanyName(String comName) {
		waitForElementVisible(driver, MyAccountPUI.COMPANY_NAME_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.COMPANY_NAME_TEXTBOX, comName);
	}

	public void updateToEmail(String email) {
		waitForElementVisible(driver, MyAccountPUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.EMAIL_TEXTBOX, email);
	}

	public boolean isFemaleRadioChecked() {
		return isElementSelected(driver, MyAccountPUI.FEMALE_RADIO);
	}

	public String getValueOfFirstName() {
		waitForElementVisible(driver, MyAccountPUI.FIRST_NAME_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getValueOfLastName() {
		waitForElementVisible(driver, MyAccountPUI.LAST_NAME_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getValueOfCompanyName() {
		waitForElementVisible(driver, MyAccountPUI.COMPANY_NAME_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPUI.COMPANY_NAME_TEXTBOX, "value");
	}

	public String getValueOfEmail() {
		waitForElementVisible(driver, MyAccountPUI.EMAIL_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPUI.EMAIL_TEXTBOX, "value");
	}

	public String getValueDOBDay() {
		waitForElementVisible(driver, MyAccountPUI.DOB_DAY_DROPDOWN);
		return getSelectedItemDropdown(driver, MyAccountPUI.DOB_DAY_DROPDOWN);
	}

	public String getValueDOBMonth() {
		waitForElementVisible(driver, MyAccountPUI.DOB_MONTH_DROPDOWN);
		return getSelectedItemDropdown(driver, MyAccountPUI.DOB_MONTH_DROPDOWN);
	}

	public String getValueDOBYear() {
		waitForElementVisible(driver, MyAccountPUI.DOB_YEAR_DROPDOWN);
		return getSelectedItemDropdown(driver, MyAccountPUI.DOB_YEAR_DROPDOWN);
	}

	public void clickToSaveButtonAtCustomerInfo() {
		waitForElementClickable(driver, MyAccountPUI.SAVE_BUTTON_AT_CUSTOMER_INFO);
		clickToElement(driver, MyAccountPUI.SAVE_BUTTON_AT_CUSTOMER_INFO);
	}

	public void clickToAddresses() {
		waitForElementClickable(driver, MyAccountPUI.ADDRESSES_LINK);
		clickToElement(driver, MyAccountPUI.ADDRESSES_LINK);
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, MyAccountPUI.ADD_NEW_BUTTON);
		clickToElement(driver, MyAccountPUI.ADD_NEW_BUTTON);
	}

	public void enterToAddressData(String fName, String lName, String email, String company, String country,
			String state, String city, String add1, String add2, String zip, String phone, String fax) {
		enterToAddressFirstName(fName);
		enterToAddressLastName(lName);
		enterToAddressCompany(company);
		enterToAddressEmail(email);
		selectAddressCountry(country);
		selectAddressStateProvince(state);
		enterToAddressCity(city);
		enterToAddress1(add1);
		enterToAddress2(add2);
		enterToAddressZipPostalCode(zip);
		enterToAddressPhoneNumber(phone);
		enterToAddressFaxNumber(fax);
	}

	public void enterToAddressFirstName(String fName) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_FIRST_NAME_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.ADDRESS_FIRST_NAME_TEXTBOX, fName);
	}

	public void enterToAddressLastName(String lName) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_LAST_NAME_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.ADDRESS_LAST_NAME_TEXTBOX, lName);
	}

	public void enterToAddressCompany(String company) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_COMPANY_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.ADDRESS_COMPANY_TEXTBOX, company);
	}

	public void enterToAddressEmail(String email) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_EMAIL_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.ADDRESS_EMAIL_TEXTBOX, email);
	}

	public void selectAddressCountry(String country) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_COUNTRY_DROPDOWN);
		selectDropdownByText(driver, MyAccountPUI.ADDRESS_COUNTRY_DROPDOWN, country);
	}

	public void selectAddressStateProvince(String state) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_STATE_DROPDOWN);
		selectDropdownByText(driver, MyAccountPUI.ADDRESS_STATE_DROPDOWN, state);
	}

	public void enterToAddressCity(String city) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_CITY_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.ADDRESS_CITY_TEXTBOX, city);
	}

	public void enterToAddress1(String add1) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_1_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.ADDRESS_1_TEXTBOX, add1);
	}

	public void enterToAddress2(String add2) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_2_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.ADDRESS_2_TEXTBOX, add2);
	}

	public void enterToAddressZipPostalCode(String zip) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_ZIP_POSTAL_CODE_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.ADDRESS_ZIP_POSTAL_CODE_TEXTBOX, zip);
	}

	public void enterToAddressPhoneNumber(String phone) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_PHONE_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.ADDRESS_PHONE_TEXTBOX, phone);
	}

	public void enterToAddressFaxNumber(String fax) {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_FAX_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.ADDRESS_FAX_TEXTBOX, fax);
	}

	public void clickToSaveButtonAtAddress() {
		waitForElementVisible(driver, MyAccountPUI.SAVE_BUTTON_AT_ADDRESS);
		clickToElement(driver, MyAccountPUI.SAVE_BUTTON_AT_ADDRESS);
	}

	public String getValueOfAddressTitle() {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_TITLE);
		return getElementText(driver, MyAccountPUI.ADDRESS_TITLE);
	}

	public String getValueOfAddressName() {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_NAME);
		return getElementText(driver, MyAccountPUI.ADDRESS_NAME);
	}

	public String getValueOfAddressEmail() {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_EMAIL);
		return getElementText(driver, MyAccountPUI.ADDRESS_EMAIL);
	}

	public String getValueOfAddressPhone() {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_PHONE);
		return getElementText(driver, MyAccountPUI.ADDRESS_PHONE);
	}

	public String getValueOfAddressFax() {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_FAX);
		return getElementText(driver, MyAccountPUI.ADDRESS_FAX);
	}

	public String getValueOfAddressCompany() {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_COMPANY);
		return getElementText(driver, MyAccountPUI.ADDRESS_COMPANY);
	}

	public String getValueOfAddress1() {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_1);
		return getElementText(driver, MyAccountPUI.ADDRESS_1);
	}

	public String getValueOfAddress2() {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_2);
		return getElementText(driver, MyAccountPUI.ADDRESS_2);
	}

	public String getValueOfCityStateZip() {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_CITY_STATE_ZIP);
		return getElementText(driver, MyAccountPUI.ADDRESS_CITY_STATE_ZIP);
	}

	public String getValueOfCountry() {
		waitForElementVisible(driver, MyAccountPUI.ADDRESS_COUNTRY);
		return getElementText(driver, MyAccountPUI.ADDRESS_COUNTRY);
	}

	public void clickToChangePassword() {
		waitForElementVisible(driver, MyAccountPUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountPUI.CHANGE_PASSWORD_LINK);
	}

	public void enterToOldPasswordTextBox(String oldPass) {
		waitForElementVisible(driver, MyAccountPUI.OLD_PASSWORD_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.OLD_PASSWORD_TEXTBOX, oldPass);
	}

	public void enterToNewPasswordTextBox(String newPass) {
		waitForElementVisible(driver, MyAccountPUI.NEW_PASSWORD_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.NEW_PASSWORD_TEXTBOX, newPass);
	}

	public void enterToConfirmNewPasswordTextBox(String confirm) {
		waitForElementVisible(driver, MyAccountPUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeysToElement(driver, MyAccountPUI.CONFIRM_PASSWORD_TEXTBOX, confirm);
	}

	public void clickToChangePasswordButton() {
		waitForElementVisible(driver, MyAccountPUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountPUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getTextOnNotificationBar() {
		waitForElementVisible(driver, MyAccountPUI.NOTIFICATION_BAR);
		return getElementText(driver, MyAccountPUI.NOTIFICATION_BAR);
	}

	public void clickCloseNotificationBar() {
		waitForElementVisible(driver, MyAccountPUI.NOTIFICATION_BAR_CLOSE_BUTTON);
		clickToElement(driver, MyAccountPUI.NOTIFICATION_BAR_CLOSE_BUTTON);
	}

	public void clickToMyProductsReview() {
		waitForElementVisible(driver, MyAccountPUI.MY_PRODUCTS_REVIEW_LINK);
		clickToElement(driver, MyAccountPUI.MY_PRODUCTS_REVIEW_LINK);
	}

	public String getLastestReviewTitle() {
		waitForElementVisible(driver, MyAccountPUI.LASTEST_REVIEW_TITLE);
		return getElementText(driver, MyAccountPUI.LASTEST_REVIEW_TITLE);
	}

	public String getLastestReviewText() {
		waitForElementVisible(driver, MyAccountPUI.LASTEST_REVIEW_TEXT);
		return getElementText(driver, MyAccountPUI.LASTEST_REVIEW_TEXT);
	}

	// Orders
	public void clickToOrderLink() {
		waitForElementVisible(driver, MyAccountPUI.ORDERS_LINK);
		clickToElement(driver, MyAccountPUI.ORDERS_LINK);
	}

	public String getOrderNumber() {
		waitForElementVisible(driver, MyAccountPUI.ORDERS_NUMBER);
		return getElementText(driver, MyAccountPUI.ORDERS_NUMBER);
	}

	public void clickToDetailButton() {
		waitForElementVisible(driver, MyAccountPUI.DETAIL_BUTTON);
		clickToElement(driver, MyAccountPUI.DETAIL_BUTTON);
	}

	public String getBillingInfoText() {
		waitForElementVisible(driver, MyAccountPUI.CONFIRM_BILLING_INFO);
		return getElementText(driver, MyAccountPUI.CONFIRM_BILLING_INFO);
	}

	public String getPaymentMethodText() {
		waitForElementVisible(driver, MyAccountPUI.CONFIRM_PAYMENT_METHOD_INFO);
		return getElementText(driver, MyAccountPUI.CONFIRM_PAYMENT_METHOD_INFO);
	}

	public String getShippingMethodText() {
		waitForElementVisible(driver, MyAccountPUI.CONFIRM_SHIPPING_METHOD_INFO);
		return getElementText(driver, MyAccountPUI.CONFIRM_SHIPPING_METHOD_INFO);
	}

	public String getShippinAddressInfoText() {
		waitForElementVisible(driver, MyAccountPUI.CONFIRM_SHIPPING_INFO);
		return getElementText(driver, MyAccountPUI.CONFIRM_SHIPPING_INFO);
	}

	public String getProductSKUText() {
		waitForElementVisible(driver, MyAccountPUI.SKU_NUMBER);
		return getElementText(driver, MyAccountPUI.SKU_NUMBER);
	}

	public String getProductNameText() {
		waitForElementVisible(driver, MyAccountPUI.PRODUCT_NAME_LINK);
		return getElementText(driver, MyAccountPUI.PRODUCT_NAME_LINK);
	}

	public String getProductPriceText() {
		waitForElementVisible(driver, MyAccountPUI.PRODUCT_PRICE);
		return getElementText(driver, MyAccountPUI.PRODUCT_PRICE);
	}

	public String getProductQuantityText() {
		waitForElementVisible(driver, MyAccountPUI.PRODUCT_QUANTITY);
		return getElementText(driver, MyAccountPUI.PRODUCT_QUANTITY);
	}

	public String getProductSubtotalText() {
		waitForElementVisible(driver, MyAccountPUI.PRODUCT_SUBTOTAL);
		return getElementText(driver, MyAccountPUI.PRODUCT_SUBTOTAL);
	}

	public String getGiftWrappingText() {
		waitForElementVisible(driver, MyAccountPUI.GIFT_WRAPPING);
		return getElementText(driver, MyAccountPUI.GIFT_WRAPPING);
	}

	public String getCartTotalText() {
		waitForElementVisible(driver, MyAccountPUI.CART_TOTAL);
		return getElementText(driver, MyAccountPUI.CART_TOTAL);
	}

	public ShoppingCartPO clickToReOrderButton() {
		waitForElementClickable(driver, MyAccountPUI.RE_ORDER_BUTTON);
		clickToElement(driver, MyAccountPUI.RE_ORDER_BUTTON);
		return new ShoppingCartPO(driver);
	}

}
