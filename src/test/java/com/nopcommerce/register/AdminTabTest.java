package com.nopcommerce.register;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.Data;
import com.nopcommerce.data.Data.AddressesData;

import commons.BaseTest;
import pageObject.nopCommerce.AdminPO;
import pageObject.nopCommerce.PageGeneratorManager;

public class AdminTabTest extends BaseTest {

	WebDriver driver;
	AdminPO adminPO;
	String email;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		driver.manage().window().maximize();

		log.info("Before testing - Step 1: Get admin page");
		adminPO = PageGeneratorManager.getAdminPage(driver);

		log.info("Before testing - Step 2: Login");
		adminPO.clickLoginButton();

		log.info("Before testing - Step 3: Open catalog > product");
		adminPO.clickToCatalog();
		adminPO.clickToProduct();

		log.info("Before testing - Step 4: Click to search");
		adminPO.clickToSearchIcon();

	}

	@Test
	public void TC_01_Search_With_Product_Name() {

		log.info("Search with product name - Step 1: Enter data to product name");
		adminPO.enterToProductName("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Search with product name - Step 2: Click search button");
		adminPO.clickToSearchProductButton();

		log.info("Search with product name - Step 3: Verify number of item apear in table");
		assertEquals(adminPO.getNumberOfItemAppear(), 1);

		log.info("Search with product name - Step 4: Verify product information");
		assertEquals(adminPO.getProductInfo(), "Lenovo IdeaCentre 600 All-in-One PC LE_IC_600 500 10000");
	}

	@Test
	public void TC_02_Search_With_Product_Name_Parent_Category_Unchecked() {
		log.info("Search with category unchecked - Step 1: Enter to product name");
		adminPO.enterToProductName("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Search with category unchecked - Step 2: Select computers in category");
		adminPO.selectCategoryByText("Computers");

		log.info("Search with category unchecked - Step 3: uncheck to search with sub-category");
		adminPO.uncheckToSubCategory();

		log.info("Search with category unchecked - Step 4: Click search button");
		adminPO.clickToSearchProductButton();

		log.info("Search with category unchecked - Step 5: Verify no data appeared");
		assertEquals(adminPO.getProductInfo(), "No data available in table");
	}

	@Test
	public void TC_03_Search_With_Product_Name_Parent_Category_Checked() {
		log.info("Search with category checked - Step 1: Enter to product name");
		adminPO.enterToProductName("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Search with category checked - Step 2: Select computers in category");
		adminPO.selectCategoryByText("Computers");

		log.info("Search with category checked - Step 3: check to search with sub-category");
		adminPO.checkToSubCategory();

		log.info("Search with category checked - Step 4: Click search button");
		adminPO.clickToSearchProductButton();

		log.info("Search with category checked - Step 5: Verify 1 data appeared");
		assertEquals(adminPO.getNumberOfItemAppear(), 1);
		assertEquals(adminPO.getProductInfo(), "Lenovo IdeaCentre 600 All-in-One PC LE_IC_600 500 10000");
	}

	@Test
	public void TC_04_Search_With_Product_Name_Child_Category() {
		log.info("Search with child category - Step 1: Enter to product name");
		adminPO.enterToProductName("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Search with child category - Step 2: Select Computers >> Desktops  in category");
		adminPO.selectCategoryByText("Computers >> Desktops");

		log.info("Search with child category - Step 3: uncheck to search with sub-category");
		adminPO.uncheckToSubCategory();

		log.info("Search with child category - Step 4: Click search button");
		adminPO.clickToSearchProductButton();

		log.info("Search with category unchecked - Step 5: Verify 1 data appeared");
		assertEquals(adminPO.getNumberOfItemAppear(), 1);
		assertEquals(adminPO.getProductInfo(), "Lenovo IdeaCentre 600 All-in-One PC LE_IC_600 500 10000");
	}

	@Test
	public void TC_05_Search_With_Product_Name_Manufacturer() {
		log.info("Search with manufacturer - Step 1: Enter to product name");
		adminPO.enterToProductName("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Search with manufacturer - Step 2: Select All  in category");
		adminPO.selectCategoryByText("All");

		log.info("Search with manufacturer - Step 3: uncheck to search with sub-category");
		adminPO.uncheckToSubCategory();

		log.info("Search with manufacturer - Step 4: Select Apple in manufacturer");
		adminPO.selectManufacturerByText("Apple");

		log.info("Search with manufacturer - Step 5: Click search button");
		adminPO.clickToSearchProductButton();

		log.info("Search with manufacturer - Step 6: Verify no data appeared");
		assertEquals(adminPO.getProductInfo(), "No data available in table");
	}

	@Test
	public void TC_06_Go_Directly_To_Product_SKU() {
		log.info("Directly to product SKU - Step 1: Enter to SKU");
		adminPO.enterToProductSKU("LE_IC_600");

		log.info("Directly to product SKU - Step 2: Click go button");
		adminPO.clickGoButton();

		log.info("Directly to product SKU - Step 3: Verify current page are product detail page");
		assertEquals(adminPO.getHeaderText(), "Edit product details ");

		log.info("Directly to product SKU - Step 4: Verify product name");
		assertEquals(adminPO.productName(), "Lenovo IdeaCentre 600 All-in-One PC");
	}

	@Test
	public void TC_07_Create_New_Customer() {
		log.info("Create new customer - Step 1: Open Customers page");
		adminPO.clickToCustomers();
		adminPO.clickToSubCustomers();

		log.info("Create new customer - Step 2: Click add new");
		adminPO.clickToAddNewButton();

		log.info("Create new customer - Step 3: Enter customers data");
		email = Data.getRandomEmail();
		adminPO.enterCustomerData(AddressesData.ADDRESS_FIRST_NAME, AddressesData.ADDRESS_LAST_NAME, email,
				Data.getRandomPassword(), "1/1/2000", AddressesData.ADDRESS_COMPANY_NAME, "Add new customer");
		adminPO.selectCustomerRoleInAddNewCustomer("Guests");

		log.info("Create new customer - Step 4: Click save and continue button");
		adminPO.clickSaveAndContinueButton();

		log.info("Create new customer - Step 5: Verify success message");
		assertEquals(adminPO.getAlertFieldText(), "The new customer has been added successfully.");

		log.info("Create new customer - Step 6: Verify all information");
		assertEquals(adminPO.getValueOfEmailTextBox(), email);
		assertEquals(adminPO.getValueOfFirstNameTextBox(), AddressesData.ADDRESS_FIRST_NAME);
		assertEquals(adminPO.getValueOfLastNameTextBox(), AddressesData.ADDRESS_LAST_NAME);
		assertEquals(adminPO.getValueOfDOBTextBox(), "1/1/2000");
		assertEquals(adminPO.getValueOfCompanyNameTextBox(), AddressesData.ADDRESS_COMPANY_NAME);
		assertEquals(adminPO.getValueOfAdminCommentTexArea(), "Add new customer");

		log.info("Create new customer - Step 7: Click back to customer list");
		adminPO.clickBackToCustomerList();

		log.info("Create new customer - Step 8: Select guests on customers role");
		adminPO.selectCustomerRoleInList("Guests");

		log.info("Create new customer - Step 9: Click search button");
		adminPO.clickToSearchCustomerButton();
	}

	@Test
	public void TC_08_Search_Customer_With_Email() {
		log.info("Search customer email - Step 1: Open Customers page");
		adminPO.clickToSubCustomers();

		log.info("Search customer email - Step 2: Enter to email");
		adminPO.enterToCustomerSearchEmail(email);

		log.info("Search customer email - Step 3: Select Guest on customer role");
		adminPO.selectCustomerRoleInList("Guests");

		log.info("Search customer email - Step 4: Click search button");
		adminPO.clickToSearchCustomerButton();

		log.info("Search customer email - Step 5: Verify infomation appeared");
		assertEquals(adminPO.getProductInfo(), "Guest Automation FC Guests Automation FC");
	}

	@Test
	public void TC_09_Search_Customer_With_First_Name_Last_Name() {
		log.info("Search customer email - Step 1: Open Customers page");
		adminPO.clickToSubCustomers();

		log.info("Search customer email - Step 2: Enter to first name and last name");
		adminPO.enterToCustomerFirstName(AddressesData.ADDRESS_FIRST_NAME);
		adminPO.enterToCustomerLastName(AddressesData.ADDRESS_LAST_NAME);

		log.info("Search customer email - Step 3: Select Guest on customer role");
		adminPO.selectCustomerRoleInList("Guests");

		log.info("Search customer email - Step 4: Click search button");
		adminPO.clickToSearchCustomerButton();

		log.info("Search customer email - Step 5: Verify infomation appeared");
		assertEquals(adminPO.getProductInfo(), "Guest Automation FC Guests Automation FC");
	}

	@Test
	public void TC_10_Search_Customer_With_Company_Name() {
		log.info("Search customer email - Step 1: Open Customers page");
		adminPO.clickToSubCustomers();

		log.info("Search customer email - Step 2: Enter to first name and last name");
		adminPO.enterToCustomerCompany(AddressesData.ADDRESS_COMPANY_NAME);

		log.info("Search customer email - Step 3: Select Guest on customer role");
		adminPO.selectCustomerRoleInList("Guests");

		log.info("Search customer email - Step 4: Click search button");
		adminPO.clickToSearchCustomerButton();

		log.info("Search customer email - Step 5: Verify infomation appeared");
		assertEquals(adminPO.getProductInfo(), "Guest Automation FC Guests Automation FC");
	}

	@Test
	public void TC_11_Search_Customer_With_Full_Data() {
		log.info("Search customer email - Step 1: Open Customers page");
		adminPO.clickToSubCustomers();

		log.info("Search customer email - Step 2: Enter to all data");
		adminPO.enterToCustomerSearchData(AddressesData.ADDRESS_FIRST_NAME, AddressesData.ADDRESS_LAST_NAME, email,
				AddressesData.ADDRESS_COMPANY_NAME, "1", "1");

		log.info("Search customer email - Step 3: Select Guest on customer role");
		adminPO.selectCustomerRoleInList("Guests");

		log.info("Search customer email - Step 4: Click search button");
		adminPO.clickToSearchCustomerButton();

		log.info("Search customer email - Step 5: Verify infomation appeared");
		assertEquals(adminPO.getProductInfo(), "Guest Automation FC Guests Automation FC");
	}

	@Test
	public void TC_12_Edit_Customer() {
		log.info("Edit customer - Step 1: click edit button");
		adminPO.clickEditButton();

		log.info("Edit customer - Step 2: Edit all data");
		email = Data.getRandomEmail();
		adminPO.enterCustomerData("Edit" + AddressesData.ADDRESS_FIRST_NAME, "Edit" + AddressesData.ADDRESS_LAST_NAME,
				email, "", "2/2/2000", "Edit" + AddressesData.ADDRESS_COMPANY_NAME, "Edit customer");

		log.info("Edit customer - Step 3: Click save and continue button");
		adminPO.clickSaveAndContinueButton();

		log.info("Edit customer - Step 4: Verify success message");
		assertEquals(adminPO.getAlertFieldText(), "The customer has been updated successfully.");

		log.info("Edit customer - Step 5: Verify all information");
		assertEquals(adminPO.getValueOfEmailTextBox(), email);
		assertEquals(adminPO.getValueOfFirstNameTextBox(), "Edit" + AddressesData.ADDRESS_FIRST_NAME);
		assertEquals(adminPO.getValueOfLastNameTextBox(), "Edit" + AddressesData.ADDRESS_LAST_NAME);
		assertEquals(adminPO.getValueOfDOBTextBox(), "2/2/2000");
		assertEquals(adminPO.getValueOfCompanyNameTextBox(), "Edit" + AddressesData.ADDRESS_COMPANY_NAME);
		assertEquals(adminPO.getValueOfAdminCommentTexArea(), "Edit customer");

	}

	@Test
	public void TC_13_Add_New_Address_In_Customer_Detail() {
		log.info("Add new address - Step 1: Open Customers page");
		adminPO.clickToSubCustomers();

		log.info("Add new address - Step 2: Search data");
		adminPO.enterToCustomerSearchData("Edit" + AddressesData.ADDRESS_FIRST_NAME,
				"Edit" + AddressesData.ADDRESS_LAST_NAME, email, "Edit" + AddressesData.ADDRESS_COMPANY_NAME, "2", "2");

		log.info("Add new address - Step 3: Select Guest on customer role");
		adminPO.selectCustomerRoleInList("Guests");

		log.info("Add new address - Step 4: Click search button");
		adminPO.clickToSearchCustomerButton();

		log.info("Add new address - Step 5: Click edit button");
		adminPO.clickEditButton();

		log.info("Add new address - Step 6: Click address button");
		adminPO.clickAddNewAddressButton();

		log.info("Add new address - Step 7: Enter address data ");
		adminPO.enterToAddressData(AddressesData.ADDRESS_FIRST_NAME, AddressesData.ADDRESS_LAST_NAME,
				AddressesData.ADDRESS_EMAIL, AddressesData.ADDRESS_COUNTRY, AddressesData.ADDRESS_CITY,
				AddressesData.ADDRESS_1, AddressesData.ADDRESS_2, AddressesData.ADDRESS_ZIP_POSTAL_CODE,
				AddressesData.ADDRESS_PHONE, AddressesData.ADDRESS_FAX);

		log.info("Add new address - Step 8: Click save button");
		adminPO.clickSaveButton();

		log.info("Add new address - Step 9: Verify success message ");
		assertEquals(adminPO.getAlertFieldText(), "The new address has been added successfully.");

		log.info("Add new address - Step 10: Verify all data");
		assertEquals(adminPO.getValueOfAdressEmailTextBox(), AddressesData.ADDRESS_EMAIL);
		assertEquals(adminPO.getValueOfAdressFirstNameTextBox(), AddressesData.ADDRESS_FIRST_NAME);
		assertEquals(adminPO.getValueOfAdressLastNameTextBox(), AddressesData.ADDRESS_LAST_NAME);
		assertEquals(adminPO.getValueOfAdressCountryDropdown(), AddressesData.ADDRESS_COUNTRY);
		assertEquals(adminPO.getValueOfAdressCityTextBox(), AddressesData.ADDRESS_CITY);
		assertEquals(adminPO.getValueOfAdressAddress1TextBox(), AddressesData.ADDRESS_1);
		assertEquals(adminPO.getValueOfAdressAddress2TextBox(), AddressesData.ADDRESS_2);
		assertEquals(adminPO.getValueOfAdressZipTextBox(), AddressesData.ADDRESS_ZIP_POSTAL_CODE);
		assertEquals(adminPO.getValueOfAdressPhonrTextBox(), AddressesData.ADDRESS_PHONE);
		assertEquals(adminPO.getValueOfAdressFaxTextBox(), AddressesData.ADDRESS_FAX);

		log.info("Add new address - Step 11: Click back to customer details ");
		adminPO.clickBackToCustomerDetail();

		log.info("Add new address - Step 12: Verify data  ");
		assertEquals(adminPO.getCustomerInfo(),
				AddressesData.ADDRESS_FIRST_NAME + " " + AddressesData.ADDRESS_LAST_NAME + " "
						+ AddressesData.ADDRESS_EMAIL + " " + AddressesData.ADDRESS_PHONE + " "
						+ AddressesData.ADDRESS_FAX + "\n" + AddressesData.ADDRESS_1 + "\n" + AddressesData.ADDRESS_2
						+ "\n" + AddressesData.ADDRESS_CITY + "," + AddressesData.ADDRESS_ZIP_POSTAL_CODE + "\n"
						+ AddressesData.ADDRESS_COUNTRY);

	}

	@Test
	public void TC_14_Edit_Address_In_Customer_Detail() {
		log.info("Edit address - Step 1: Open Customers page");
		adminPO.clickToSubCustomers();

		log.info("Edit address - Step 2: Search data");
		adminPO.enterToCustomerSearchData("Edit" + AddressesData.ADDRESS_FIRST_NAME,
				"Edit" + AddressesData.ADDRESS_LAST_NAME, email, "Edit" + AddressesData.ADDRESS_COMPANY_NAME, "2", "2");

		log.info("Edit address - Step 3: Select Guest on customer role");
		adminPO.selectCustomerRoleInList("Guests");

		log.info("Edit address - Step 4: Click search button");
		adminPO.clickToSearchCustomerButton();

		log.info("Edit address - Step 5: Click edit button");
		adminPO.clickEditButton();

		log.info("Edit address - Step 6: Click edit address button");
		adminPO.clickAddressEditButton();

		log.info("Edit address - Step 7: Edit address data ");
		adminPO.enterToAddressData("Edit" + AddressesData.ADDRESS_FIRST_NAME, "Edit" + AddressesData.ADDRESS_LAST_NAME,
				"Edit" + AddressesData.ADDRESS_EMAIL, AddressesData.ADDRESS_COUNTRY,
				"Edit" + AddressesData.ADDRESS_CITY, "Edit" + AddressesData.ADDRESS_1, "Edit" + AddressesData.ADDRESS_2,
				AddressesData.ADDRESS_ZIP_POSTAL_CODE, AddressesData.ADDRESS_PHONE, AddressesData.ADDRESS_FAX);

		log.info("Edit address address - Step 8: Click save button");
		adminPO.clickEditSaveButton();

		log.info("Edit address address - Step 9: Verify success message ");
		assertEquals(adminPO.getAlertFieldText(), "The address has been updated successfully.");

		log.info("Edit address address - Step 10: Verify all data");
		assertEquals(adminPO.getValueOfAdressEmailTextBox(), "Edit" + AddressesData.ADDRESS_EMAIL);
		assertEquals(adminPO.getValueOfAdressFirstNameTextBox(), "Edit" + AddressesData.ADDRESS_FIRST_NAME);
		assertEquals(adminPO.getValueOfAdressLastNameTextBox(), "Edit" + AddressesData.ADDRESS_LAST_NAME);
		assertEquals(adminPO.getValueOfAdressCountryDropdown(), AddressesData.ADDRESS_COUNTRY);
		assertEquals(adminPO.getValueOfAdressCityTextBox(), "Edit" + AddressesData.ADDRESS_CITY);
		assertEquals(adminPO.getValueOfAdressAddress1TextBox(), "Edit" + AddressesData.ADDRESS_1);
		assertEquals(adminPO.getValueOfAdressAddress2TextBox(), "Edit" + AddressesData.ADDRESS_2);
		assertEquals(adminPO.getValueOfAdressZipTextBox(), AddressesData.ADDRESS_ZIP_POSTAL_CODE);
		assertEquals(adminPO.getValueOfAdressPhonrTextBox(), AddressesData.ADDRESS_PHONE);
		assertEquals(adminPO.getValueOfAdressFaxTextBox(), AddressesData.ADDRESS_FAX);

		log.info("Edit address address - Step 11: Click back to customer details ");
		adminPO.clickBackToCustomerDetail();

		log.info("Edit address address - Step 12: Verify data  ");
		assertEquals(adminPO.getCustomerInfo(),
				"Edit" + AddressesData.ADDRESS_FIRST_NAME + " " + "Edit" + AddressesData.ADDRESS_LAST_NAME + " "
						+ "Edit" + AddressesData.ADDRESS_EMAIL + " " + AddressesData.ADDRESS_PHONE + " "
						+ AddressesData.ADDRESS_FAX + "\n" + "Edit" + AddressesData.ADDRESS_1 + "\n" + "Edit"
						+ AddressesData.ADDRESS_2 + "\n" + "Edit" + AddressesData.ADDRESS_CITY + ","
						+ AddressesData.ADDRESS_ZIP_POSTAL_CODE + "\n" + AddressesData.ADDRESS_COUNTRY);
	}
	
	@Test
	public void TC_15_Delete_Address_In_Customer_Detail() {
		log.info("Delete address - Step 1: Open Customers page");
		adminPO.clickToSubCustomers();

		log.info("Delete address - Step 2: Search data");
		adminPO.enterToCustomerSearchData("Edit" + AddressesData.ADDRESS_FIRST_NAME,
				"Edit" + AddressesData.ADDRESS_LAST_NAME, email, "Edit" + AddressesData.ADDRESS_COMPANY_NAME, "2", "2");

		log.info("Delete address - Step 3: Select Guest on customer role");
		adminPO.selectCustomerRoleInList("Guests");

		log.info("Delete address - Step 4: Click search button");
		adminPO.clickToSearchCustomerButton();

		log.info("Delete address - Step 5: Click edit button");
		adminPO.clickEditButton();

		log.info("Delete address - Step 6: Click delete address button");
		adminPO.clickDeleteAddressButton();
		
		log.info("Delete address - Step 7: Accept alert");
		driver.switchTo().alert().accept();
		
		log.info("Delete address - Step 8: Verify no address data left ");
		assertEquals(adminPO.getCustomerInfo(),"No data available in table");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
