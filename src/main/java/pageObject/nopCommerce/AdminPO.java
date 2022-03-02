package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.AdminPUI;

public class AdminPO extends BasePage {

	private WebDriver driver;

	public AdminPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLoginButton() {
		waitForElementClickable(driver, AdminPUI.LOGIN_BUTTON);
		clickToElement(driver, AdminPUI.LOGIN_BUTTON);
	}

	public void clickToCatalogMenu() {
		waitForElementClickable(driver, AdminPUI.CATALOG_ICON);
		clickToElement(driver, AdminPUI.CATALOG_ICON);
	}
	
	public void clickToCustomersMenu() {
		waitForElementClickable(driver, AdminPUI.CUSTOMER_ICON);
		clickToElement(driver, AdminPUI.CUSTOMER_ICON);
	}
	
	public void clickToCustomersSubmenu() {
		waitForElementClickable(driver, AdminPUI.CUSTOMER_LINK);
		clickToElement(driver, AdminPUI.CUSTOMER_LINK);
	}

	public void clickToProductsSubMenu() {
		waitForElementClickable(driver, AdminPUI.PRODUCT_LINK);
		clickToElement(driver, AdminPUI.PRODUCT_LINK);
	}

	public void clickToSearchIcon() {
		if (!isElementDisplayed(driver, AdminPUI.SEARCH_BODY)) {
			waitForElementClickable(driver, AdminPUI.SEARCH_DOWN_ANGLE);
			clickToElement(driver, AdminPUI.SEARCH_DOWN_ANGLE);
		}
	}

	public void enterToProductNameTextBox(String name) {
		waitForAllElementVisible(driver, AdminPUI.PRODUCT_NAME_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.PRODUCT_NAME_TEXTBOX, name);
	}

	public int getNumberOfItemAppear() {
		return getElementSize(driver, AdminPUI.EVEN_ITEM_FIELD) + getElementSize(driver, AdminPUI.ODD_ITEM_FIELD);
	}

	public String getProductInfo() {
		scrollToElement(driver, AdminPUI.ODD_ITEM_INFO_FIELD);
		waitForElementVisible(driver, AdminPUI.ODD_ITEM_INFO_FIELD);
		return getElementText(driver, AdminPUI.ODD_ITEM_INFO_FIELD).replace(" Edit", "");
	}

	public void clickToSearchButtonAtProducts() {
		waitForElementClickable(driver, AdminPUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, AdminPUI.SEARCH_PRODUCT_BUTTON);
		
		//Wait for the loading icon disappear
		while(isElementDisplayed(driver, AdminPUI.LOADING_ICON));
	}

	public void selectCategoryByText(String text) {
		waitForElementVisible(driver, AdminPUI.CATEGORY_DROPDOWN);
		selectDropdownByText(driver, AdminPUI.CATEGORY_DROPDOWN, text);
	}

	public void uncheckToSubCategory() {
		waitForElementVisible(driver, AdminPUI.SUBCATEGORY_CHECKBOX);
		uncheckToCheckboxOrRadio(driver, AdminPUI.SUBCATEGORY_CHECKBOX);
	}

	public void checkToSubCategory() {
		waitForElementVisible(driver, AdminPUI.SUBCATEGORY_CHECKBOX);
		checkToCheckboxOrRadio(driver, AdminPUI.SUBCATEGORY_CHECKBOX);
	}

	public void selectManufacturerByText(String text) {
		waitForElementVisible(driver, AdminPUI.MANUFACTURER_DROPDOWN);
		selectDropdownByText(driver, AdminPUI.MANUFACTURER_DROPDOWN, text);
	}

	public void enterToProductSKUTextBox(String string) {
		waitForElementVisible(driver, AdminPUI.SKU_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.SKU_TEXTBOX, string);
	}

	public void clickGoButton() {
		waitForElementClickable(driver, AdminPUI.GO_BUTTON);
		clickToElement(driver,  AdminPUI.GO_BUTTON);
	}

	public String getHeaderText() {
		waitForElementVisible(driver, AdminPUI.PRODUCT_DETAIL_HEADER);
		String header = getElementText(driver, AdminPUI.PRODUCT_DETAIL_HEADER);
		return header.substring(0,header.indexOf("-"));
	}

	public String productName() {
		waitForElementVisible(driver, AdminPUI.DETAIL_PRODUCT_NAME_TEXTBOX);
		return getElementAttributeValue(driver, AdminPUI.DETAIL_PRODUCT_NAME_TEXTBOX,"value");
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, AdminPUI.ADDNEW_BUTTON);
		clickToElement(driver,  AdminPUI.ADDNEW_BUTTON);
	}
	
	public void enterToFirstName(String fname){
		waitForElementVisible(driver, AdminPUI.FIRSTNAME_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.FIRSTNAME_TEXTBOX, fname);
	}
	
	public void enterToLastName(String lname){
		waitForElementVisible(driver, AdminPUI.LASTNAME_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.LASTNAME_TEXTBOX, lname);
	}
	
	public void enterToEmail(String email){
		waitForElementVisible(driver, AdminPUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.EMAIL_TEXTBOX, email);
	}
	
	public void enterToCustomerEmailTextBox(String email){
		waitForElementVisible(driver, AdminPUI.CUSTOMER_SEARCH_EMAIL_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.CUSTOMER_SEARCH_EMAIL_TEXTBOX, email);
	}
	
	public void enterToPassword(String pass){
		waitForElementVisible(driver, AdminPUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.PASSWORD_TEXTBOX, pass);
	}
	
	public void enterToDOB(String dob){
		waitForElementVisible(driver, AdminPUI.DOB_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.DOB_TEXTBOX, dob);
	}
	
	public void enterToCompanyName(String company){
		waitForElementVisible(driver, AdminPUI.COMPANY_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.COMPANY_TEXTBOX, company);
	}
	public void enterToAdminComment(String cmt){
		waitForElementVisible(driver, AdminPUI.COMMENT_TEXTAREA);
		sendkeysToElement(driver, AdminPUI.COMMENT_TEXTAREA, cmt);
	}

	public void enterCustomerData(String fname, String lname, String email, String pass, String dob, String companyname, String cmt) {
		enterToFirstName(fname);
		enterToLastName(lname);
		enterToEmail(email);
		enterToPassword(pass);
		enterToDOB(dob);
		enterToAdminComment(cmt);
		enterToCompanyName(companyname);
	}

	public void clickSaveAndContinueButton() {
		waitForElementClickable(driver, AdminPUI.SAVE_AND_CONTINUE_BUTTON);
		clickToElement(driver, AdminPUI.SAVE_AND_CONTINUE_BUTTON);
	}

	public String getAlertFieldText() {
		waitForElementVisible(driver, AdminPUI.ALERT_FIELD);
		String text = getElementText(driver, AdminPUI.ALERT_FIELD);
		return text.substring(2,text.length());
	}

	public String getValueOfEmailTextBox() {
		waitForElementVisible(driver, AdminPUI.EMAIL_TEXTBOX);
		return getElementAttributeValue(driver, AdminPUI.EMAIL_TEXTBOX, "value");
	}
	
	public String getValueOfFirstNameTextBox() {
		waitForElementVisible(driver, AdminPUI.FIRSTNAME_TEXTBOX);
		return getElementAttributeValue(driver, AdminPUI.FIRSTNAME_TEXTBOX, "value");
	}
	
	public String getValueOfLastNameTextBox() {
		waitForElementVisible(driver, AdminPUI.LASTNAME_TEXTBOX);
		return getElementAttributeValue(driver, AdminPUI.LASTNAME_TEXTBOX, "value");
	}
	
	public String getValueOfDOBTextBox() {
		waitForElementVisible(driver, AdminPUI.DOB_TEXTBOX);
		return getElementAttributeValue(driver, AdminPUI.DOB_TEXTBOX, "value");
	}
	
	public String getValueOfCompanyNameTextBox() {
		waitForElementVisible(driver, AdminPUI.COMPANY_TEXTBOX);
		return getElementAttributeValue(driver, AdminPUI.COMPANY_TEXTBOX, "value");
	}
	
	public String getValueOfAdminCommentTexArea() {
		waitForElementVisible(driver, AdminPUI.COMMENT_TEXTAREA);
		return getElementText(driver, AdminPUI.COMMENT_TEXTAREA);
	}

	public void clickBackToCustomerList() {
		waitForElementClickable(driver, AdminPUI.BACK_TO_CUSTOMER_LINK);
		clickToElement(driver, AdminPUI.BACK_TO_CUSTOMER_LINK);
	}

	public void selectCustomerRoleInAddNewCustomer(String role) {
		waitForElementClickable(driver, AdminPUI.CUSTOMER_ROLE_CLOSE_BUTTON);
		clickToElement(driver, AdminPUI.CUSTOMER_ROLE_CLOSE_BUTTON);
		
		waitForElementClickable(driver, AdminPUI.CUSTOMER_ROLE_FIELD);
		clickToElement(driver, AdminPUI.CUSTOMER_ROLE_FIELD);
		
		waitForElementClickable(driver, AdminPUI.CUSTOMER_ROLE, role);
		clickToElement(driver, AdminPUI.CUSTOMER_ROLE, role);
	}

	public void selectCustomerRoleInList(String role) {
		waitForElementClickable(driver, AdminPUI.CUSTOMER_ROLE_CLOSE_BUTTON);
		clickToElement(driver, AdminPUI.CUSTOMER_ROLE_CLOSE_BUTTON);
		
		waitForElementClickable(driver, AdminPUI.CUSTOMER_ROLE_FIELD_LIST);
		clickToElement(driver, AdminPUI.CUSTOMER_ROLE_FIELD_LIST);
		
		waitForElementClickable(driver, AdminPUI.CUSTOMER_ROLE, role);
		clickToElement(driver, AdminPUI.CUSTOMER_ROLE, role);
	}

	public void clickToSearchButtonAtCustomer() {
		waitForElementClickable(driver, AdminPUI.SEARCH_CUSTOMER_BUTTON);
		clickToElement(driver, AdminPUI.SEARCH_CUSTOMER_BUTTON);
		
		//Wait for the loading icon disappear
		while(isElementDisplayed(driver, AdminPUI.LOADING_ICON));
	}

	public void enterToCustomerFirstName(String fname) {
		waitForElementVisible(driver, AdminPUI.CUSTOMER_SEARCH_FIRSTNAME_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.CUSTOMER_SEARCH_FIRSTNAME_TEXTBOX, fname);
	}

	public void enterToCustomerLastName(String lname) {
		waitForElementVisible(driver, AdminPUI.CUSTOMER_SEARCH_LASTNAME_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.CUSTOMER_SEARCH_LASTNAME_TEXTBOX, lname);
	}

	public void enterToCustomerCompany(String company) {
		waitForElementVisible(driver, AdminPUI.CUSTOMER_SEARCH_COMPANY_TEXTBOX);
		sendkeysToElement(driver, AdminPUI.CUSTOMER_SEARCH_COMPANY_TEXTBOX, company);
	}
	
	
	
	public void enterToCustomerSearchData(String fname, String lname, String email,String company, String dobMonth, String dobDay) {
		enterToCustomerFirstName(fname);
		enterToCustomerLastName(lname);
		enterToCustomerEmailTextBox(email);
		enterToCustomerCompany(company);
		selectCustomerDOBMonth(dobMonth);
		selectCustomerDOBDay(dobDay);
	}

	public void selectCustomerDOBMonth(String dobMonth) {
		waitForElementVisible(driver, AdminPUI.DOB_MONTH_DROPDOWN);
		selectDropdownByText(driver, AdminPUI.DOB_MONTH_DROPDOWN, dobMonth);
	}
	
	public void selectCustomerDOBDay(String dobDay) {
		waitForElementVisible(driver, AdminPUI.DOB_DAY_DROPDOWN);
		selectDropdownByText(driver, AdminPUI.DOB_DAY_DROPDOWN, dobDay);
	}

	public void clickEditButton() {
		scrollToElement(driver, AdminPUI.EDIT_BUTTON);
		waitForElementClickable(driver, AdminPUI.EDIT_BUTTON);
		clickToElement(driver, AdminPUI.EDIT_BUTTON);
	}

	public void clickAddressesIcon() {
		scrollToElement(driver, AdminPUI.ADDRESSES_HEADER);
		waitForElementClickable(driver, AdminPUI.ADDRESSES_HEADER);
		clickToElement(driver, AdminPUI.ADDRESSES_HEADER);
	}

	public void clickAddNewAddressButton() {
		if(!isElementDisplayed(driver, AdminPUI.ADDRESSES_BODY))
			clickAddressesIcon();
		scrollToElement(driver, AdminPUI.ADD_NEW_ADDRESS_BUTTON);
		waitForElementClickable(driver, AdminPUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AdminPUI.ADD_NEW_ADDRESS_BUTTON);
	}
	
	public void enterToAddressFirstName(String fName){
		waitForElementVisible(driver, AdminPUI.ADDRESS_FNAME);
		sendkeysToElement(driver, AdminPUI.ADDRESS_FNAME, fName);
	}
	
	public void enterToAddressLastName(String lName){
		waitForElementVisible(driver, AdminPUI.ADDRESS_LNAME);
		sendkeysToElement(driver, AdminPUI.ADDRESS_LNAME, lName);
	}
	
	public void enterToAddressEmail(String email){
		waitForElementVisible(driver, AdminPUI.ADDRESS_EMAIL);
		sendkeysToElement(driver, AdminPUI.ADDRESS_EMAIL, email);
	}
	
	public void enterToAddressCompany(String company){
		waitForElementVisible(driver, AdminPUI.ADDRESS_COMPANY);
		sendkeysToElement(driver, AdminPUI.ADDRESS_COMPANY, company);
	}
	
	public void enterToAddressCity(String city){
		waitForElementVisible(driver, AdminPUI.ADDRESS_CITY);
		sendkeysToElement(driver, AdminPUI.ADDRESS_CITY, city);
	}
	
	public void enterToAddress1(String add1){
		waitForElementVisible(driver, AdminPUI.ADDRESS_1);
		sendkeysToElement(driver, AdminPUI.ADDRESS_1, add1);
	}
	
	public void enterToAddress2(String add2){
		waitForElementVisible(driver, AdminPUI.ADDRESS_2);
		sendkeysToElement(driver, AdminPUI.ADDRESS_2, add2);
	}
	
	public void enterToAddressZipCode(String zip){
		waitForElementVisible(driver, AdminPUI.ADDRESS_ZIPCODE);
		sendkeysToElement(driver, AdminPUI.ADDRESS_ZIPCODE, zip);
	}
	
	public void enterToAddressPhone(String phone){
		waitForElementVisible(driver, AdminPUI.ADDRESS_PHONE);
		sendkeysToElement(driver, AdminPUI.ADDRESS_PHONE, phone);
	}
	
	public void enterToAddressFax(String fax){
		waitForElementVisible(driver, AdminPUI.ADDRESS_FAX);
		sendkeysToElement(driver, AdminPUI.ADDRESS_FAX, fax);
	}
	
	public void selectCountryDropDown(String country){
		waitForElementVisible(driver, AdminPUI.ADDRESS_COUNTRY_DROPDOWN);
		selectDropdownByText(driver, AdminPUI.ADDRESS_COUNTRY_DROPDOWN, country);
	}

	public void enterToAddressData(String fName, String lName, String email, String country, String city,
			String add1,String add2, String zip, String phone,String fax) {
		enterToAddressFirstName(fName);
		enterToAddressLastName(lName);
		enterToAddressEmail(email);
		selectCountryDropDown(country);
		enterToAddressCity(city);
		enterToAddress1(add1);
		enterToAddress2(add2);
		enterToAddressZipCode(zip);
		enterToAddressPhone(phone);
		enterToAddressFax(fax);
	}

	public void clickSaveButton() {
		waitForElementClickable(driver, AdminPUI.SAVE_BUTTON);
		clickToElement(driver, AdminPUI.SAVE_BUTTON);
	}

	public String getValueOfAdressEmailTextBox() {
		waitForElementVisible(driver, AdminPUI.ADDRESS_EMAIL);
		return getElementAttributeValue(driver, AdminPUI.ADDRESS_EMAIL,"value");
	}

	public String getValueOfAdressFirstNameTextBox() {
		waitForElementVisible(driver, AdminPUI.ADDRESS_FNAME);
		return getElementAttributeValue(driver, AdminPUI.ADDRESS_FNAME,"value");
	}

	public String getValueOfAdressLastNameTextBox() {
		waitForElementVisible(driver, AdminPUI.ADDRESS_LNAME);
		return getElementAttributeValue(driver, AdminPUI.ADDRESS_LNAME,"value");
	}

	public String getValueOfAdressCountryDropdown() {
		waitForElementVisible(driver, AdminPUI.ADDRESS_COUNTRY_DROPDOWN);
		return getSelectedItemDropdown(driver, AdminPUI.ADDRESS_COUNTRY_DROPDOWN,"value");
	}

	public String getValueOfAdressCityTextBox() {
		waitForElementVisible(driver, AdminPUI.ADDRESS_CITY);
		return getElementAttributeValue(driver, AdminPUI.ADDRESS_CITY,"value");
	}

	public String getValueOfAdressAddress1TextBox() {
		waitForElementVisible(driver, AdminPUI.ADDRESS_1);
		return getElementAttributeValue(driver, AdminPUI.ADDRESS_1,"value");
	}

	public String getValueOfAdressAddress2TextBox() {
		waitForElementVisible(driver, AdminPUI.ADDRESS_2);
		return getElementAttributeValue(driver, AdminPUI.ADDRESS_2,"value");
	}

	public String getValueOfAdressZipTextBox() {
		waitForElementVisible(driver, AdminPUI.ADDRESS_ZIPCODE);
		return getElementAttributeValue(driver, AdminPUI.ADDRESS_ZIPCODE,"value");
	}

	public String getValueOfAdressPhonrTextBox() {
		waitForElementVisible(driver, AdminPUI.ADDRESS_PHONE);
		return getElementAttributeValue(driver, AdminPUI.ADDRESS_PHONE,"value");
	}

	public String getValueOfAdressFaxTextBox() {
		waitForElementVisible(driver, AdminPUI.ADDRESS_FAX);
		return getElementAttributeValue(driver, AdminPUI.ADDRESS_FAX,"value");
	}

	public void clickBackToCustomerDetail() {
		waitForElementClickable(driver, AdminPUI.BACK_TO_CUSTOMER_DETAIL);
		clickToElement(driver, AdminPUI.BACK_TO_CUSTOMER_DETAIL);
	}
	
	public String getCustomerInfo() {
		scrollToElement(driver, AdminPUI.CUSTOMER_INFO_FIELD);
		waitForElementVisible(driver, AdminPUI.CUSTOMER_INFO_FIELD);
		return getElementText(driver, AdminPUI.CUSTOMER_INFO_FIELD).replace("\nEdit Delete", "");
	}

	public void clickAddressEditButton() {
		if(!isElementDisplayed(driver, AdminPUI.ADDRESSES_BODY))
			clickAddressesIcon();
		scrollToElement(driver, AdminPUI.EDIT_BUTTON);
		waitForElementClickable(driver, AdminPUI.EDIT_BUTTON);
		clickToElement(driver, AdminPUI.EDIT_BUTTON);
	}

	public void clickEditSaveButton() {
		waitForElementClickable(driver, AdminPUI.EDIT_SAVE_BUTTON);
		clickToElement(driver, AdminPUI.EDIT_SAVE_BUTTON);
	}

	public void clickDeleteAddressButton() {
		if(!isElementDisplayed(driver, AdminPUI.ADDRESSES_BODY))
			clickAddressesIcon();
		scrollToElement(driver, AdminPUI.DELETE_BUTTON);
		waitForElementClickable(driver, AdminPUI.DELETE_BUTTON);
		clickToElement(driver, AdminPUI.DELETE_BUTTON);
	}

}
