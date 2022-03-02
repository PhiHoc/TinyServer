package com.nopcommerce.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.Data;

import commons.BaseTest;
import pageObject.nopCommerce.CheckoutPO;
import pageObject.nopCommerce.ComputersPO;
import pageObject.nopCommerce.LoginPO;
import pageObject.nopCommerce.MyAccountPO;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPO;
import pageObject.nopCommerce.ShoppingCartPO;
import pageObject.nopCommerce.UserHomePO;

public class OrderTabTest extends BaseTest {

	WebDriver driver;
	UserHomePO userHomePO;
	LoginPO loginPO;
	RegisterPO registerPO;
	ComputersPO computerPO;
	CheckoutPO checkoutPO;
	ShoppingCartPO shoppingcartPO;
	MyAccountPO myAccountPO;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		driver.manage().window().maximize();

		log.info("Before testing - Step 1: Open home Page");
		userHomePO = PageGeneratorManager.getHomePage(driver);

		log.info("Before testing - Step 2: Login an account");
		loginPO = userHomePO.clickToLoginPage();
		loginPO.loginWithData(Data.RegisterData.EMAIL, Data.RegisterData.PASSWORD);
	}

	@Test
	public void TC_01_Add_Product_To_Cart() {
		log.info("Add product to cart - Step 1: Open computers page");
		computerPO = userHomePO.clickToComputersPage();

		log.info("Add product to cart - Step 2: Click to desktop link");
		computerPO.clickToSublistLinkByName("Desktops ");

		log.info("Add product to cart - Step 3: Click to build your own computer product");
		computerPO.clickToProductByName("Build your own computer");

		log.info("Add product to cart - Step 4: Select 2.5Ghz processor");
		computerPO.selectProcessorByText("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

		log.info("Add product to cart - Step 5: Select 8GB RAM");
		computerPO.selectRAMByText("8GB [+$60.00]");

		log.info("Add product to cart - Step 6: Select 400GB HDD");
		computerPO.select400GbHDD();

		log.info("Add product to cart - Step 6: Select premium OS");
		computerPO.selectPremiumOS();

		log.info("Add product to cart - Step 7: Check to microsoft office software ");
		computerPO.checkToMicrosoftOfficeSoftWare();

		log.info("Add product to cart - Step 8: Check to Acrobat Reader software ");
		computerPO.checkToAcrobatReaderSoftWare();

		log.info("Add product to cart - Step 9: Check to Total Comander software ");
		computerPO.checkToTotalComanderSoftWare();

		log.info("Add product to cart - Step 10: Click to add to cart ");
		computerPO.clickAddToCartButton();

		log.info("Add product to cart - Step 11: Verify notification bar message ");
		verifyEquals(userHomePO.getTextOnNotificationBar(), "The product has been added to your shopping cart");

		log.info("Add product to cart - Step 12: Click notification bar close button");
		userHomePO.clickCloseNotificationBar();

		log.info("Add product to cart - Step 13: Click to shopping cart link");
		shoppingcartPO = userHomePO.clickToShoppingCartPage();

		log.info("Add product to cart - Step 14: Verify product has been added to shopping cart");
		verifyTrue(shoppingcartPO.getNumberOfProductInShoppingCart() == 1);

		log.info("Add product to cart - Step 15: Verify product name");
		verifyEquals(shoppingcartPO.getNameOfProductInShoppingCart(), "Build your own computer");

		log.info("Add product to cart - Step 16: Verify product price");
		verifyEquals(shoppingcartPO.getPriceOfProductInShoppingCart(), "$1,500.00");
	}

	@Test
	public void TC_02_Edit_Product_In_Shopping_Cart() {
		log.info("Edit product in shopping cart - Step 1: Click to edit link");
		shoppingcartPO.clickToEditLink();

		log.info("Edit product in shopping cart - Step 2: Select 2.2Ghz processor");
		computerPO.selectProcessorByText("2.2 GHz Intel Pentium Dual-Core E2200");

		log.info("Edit product in shopping cart - Step 3: Select 4GB RAM");
		computerPO.selectRAMByText("4GB [+$20.00]");

		log.info("Edit product in shopping cart - Step 4: Select 320 HDD");
		computerPO.select320GbHDD();

		log.info("Edit product in shopping cart - Step 5: Select home OS");
		computerPO.selectHomeOS();

		log.info("Edit product in shopping cart - Step 6: Check to microsoft office software ");
		computerPO.checkToMicrosoftOfficeSoftWare();

		log.info("Edit product in shopping cart - Step 7: Uncheck to Acrobat Reader software ");
		computerPO.unCheckToAcrobatReaderSoftWare();

		log.info("Edit product in shopping cart - Step 8: Uncheck to Total Comander software ");
		computerPO.unCheckToTotalComanderSoftWare();

		log.info("Edit product in shopping cart - Step 9: Increase quantity to 2 ");
		computerPO.enterToQuantityTextBox("2");

		log.info("Edit product in shopping cart - Step 10: Click to add to cart button");
		computerPO.clickAddToCartButton();

		log.info("Edit product in shopping cart- Step 11: Verify notification bar message ");
		verifyEquals(userHomePO.getTextOnNotificationBar(), "The product has been added to your shopping cart");

		log.info("Edit product in shopping cart- Step 12: Click notification bar close button");
		userHomePO.clickCloseNotificationBar();

		log.info("Edit product in shopping cart- Step 13: Click to shopping cart link");
		userHomePO.clickToShoppingCartPage();

		log.info("Edit product in shopping cart- Step 14: Verify product name");
		verifyEquals(shoppingcartPO.getNameOfProductInShoppingCart(), "Build your own computer");

		log.info("Edit product in shopping cart- Step 15: Verify product price");
		verifyEquals(shoppingcartPO.getPriceOfProductInShoppingCart(), "$1,320.00");

		log.info("Edit product in shopping cart- Step 16: Verify quantity");
		verifyEquals(shoppingcartPO.getQuantityOfProductInShoppingCart(), "2");

		log.info("Edit product in shopping cart- Step 17: Verify product total price");
		verifyEquals(shoppingcartPO.getTotalPriceOfProductInShoppingCart(), "$2,640.00");

	}
	
	@Test
	public void TC_03_Remove_From_Shopping_Cart() {
		log.info("Remove from shopping cart - Step 1: Click to remove button");
		shoppingcartPO.clickRemoveButton();

		log.info("Remove from shopping cart - Step 2: Verify message in page body");
		verifyEquals(shoppingcartPO.getMessageInPageBody(), "Your Shopping Cart is empty!");

		log.info("Remove from shopping cart - Step 3: Verify no product displayed in wishlist");
		verifyTrue(shoppingcartPO.getNumberOfProductInShoppingCart() == 0);
	}
	
	@Test
	public void TC_04_Update_Shopping_Cart() {
		log.info("Update shopping cart - Step 1: Open computers page");
		computerPO = userHomePO.clickToComputersPage();

		log.info("Update shopping cart - Step 2: Click to desktop link");
		computerPO.clickToSublistLinkByName("Desktops ");

		log.info("Update shopping cart - Step 3: Click to Lenovo IdeaCentre 600 All-in-One PC product");
		computerPO.clickToProductByName("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Update shopping cart - Step 4: Click to add to cart ");
		computerPO.clickAddToCartButton();

		log.info("Update shopping cart - Step 5: Verify notification bar message ");
		verifyEquals(userHomePO.getTextOnNotificationBar(), "The product has been added to your shopping cart");

		log.info("Update shopping cart - Step 6: Click notification bar close button");
		userHomePO.clickCloseNotificationBar();

		log.info("Update shopping cart - Step 7: Click to shopping cart link ");
		userHomePO.clickToShoppingCartPage();

		log.info("Update shopping cart - Step 8: Update quantity to 5");
		shoppingcartPO.updateToQuantity("5");

		log.info("Update shopping cart - Step 9: Click to update shopping cart button");
		shoppingcartPO.clickToUppdateShoppingCartButton();

		log.info("Update shopping cart - Step 10: Verify total price updated");
		verifyEquals(shoppingcartPO.getTotalPriceOfProductInShoppingCart(), "$2,500.00");

		log.info("Update shopping cart - Step 11: Remove the product form shopping cart");
		shoppingcartPO.clickRemoveButton();
	}

	@Test
	public void TC_05_Checkout_Order_Payment_Method_By_Cheque() {

		log.info("Checkout/ Order payment - Step 1: Open computers page");
		computerPO = userHomePO.clickToComputersPage();

		log.info("Checkout/ Order payment - Step 2: Click to notebook link");
		computerPO.clickToSublistLinkByName("Notebooks");

		log.info("Checkout/ Order payment - Step 3: Click to Apple MacBook Pro 13-inch product");
		computerPO.clickToProductByName("Apple MacBook Pro 13-inch");

		log.info("Checkout/ Order payment - Step 4: Click to add to cart ");
		computerPO.clickAddToCartButton();

		log.info("Checkout/ Order payment - Step 5: Verify notification bar message ");
		verifyEquals(userHomePO.getTextOnNotificationBar(), "The product has been added to your shopping cart");

		log.info("Checkout/ Order payment - Step 6: Click notification bar close button");
		userHomePO.clickCloseNotificationBar();

		log.info("Checkout/ Order payment - Step 7: Click to shopping cart link ");
		shoppingcartPO = userHomePO.clickToShoppingCartPage();

		log.info("Checkout/ Order payment - Step 8: Click to estimate shipping link");
		shoppingcartPO.clickToEstimateShippingLink();

		log.info("Checkout/ Order payment - Step 9: Select country");
		shoppingcartPO.selectShippingAddressCountryDropDownByText(Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Checkout/ Order payment - Step 10: Enter to zip/ postal code");
		shoppingcartPO.enterToShippingAddressZipPostalCode(Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE);

		log.info("Checkout/ Order payment - Step 11: Wait for shipping method appear");
		shoppingcartPO.waitForShippingMethodAppear();

		log.info("Checkout/ Order payment - Step 12: Click to apply button");
		shoppingcartPO.clickToApplyButton();

		log.info("Checkout/ Order payment - Step 13: Check to I agree checkbox");
		shoppingcartPO.checkToIAgreeCheckBox();

		log.info("Checkout/ Order payment - Step 14: Click to checkout button");
		checkoutPO = shoppingcartPO.clickToCheckoutButton();

		log.info("Checkout/ Order payment - Step 15: Uncheck to ship to the same address");
		checkoutPO.uncheckToShipToTheSameAddress();

		log.info("Checkout/ Order payment - Step 16: Enter to billing address with register data");
		checkoutPO.enterDataToBillingAddress(Data.RegisterData.FIRST_NAME, 
				Data.RegisterData.LAST_NAME,
				Data.RegisterData.EMAIL, 
				Data.AddressesData.ADDRESS_COUNTRY, 
				Data.RegisterData.CITY,
				Data.RegisterData.ADDRESS_1, 
				Data.RegisterData.ZIP_POSTAL_CODE, 
				Data.RegisterData.PHONE);

		log.info("Checkout/ Order payment - Step 17: Click to continue button");
		checkoutPO.clickToBillingContinueButton();

		log.info("Checkout/ Order payment - Step 18: Select new address on shipping address dropdown");
		checkoutPO.selectNewShippingAddress();

		log.info("Checkout/ Order payment - Step 19: Enter to billing address with address data");
		checkoutPO.enterDataToShippingAddress(Data.AddressesData.ADDRESS_FIRST_NAME,
				Data.AddressesData.ADDRESS_LAST_NAME, 
				Data.AddressesData.ADDRESS_EMAIL,
				Data.AddressesData.ADDRESS_COUNTRY, 
				Data.AddressesData.ADDRESS_CITY, 
				Data.AddressesData.ADDRESS_1,
				Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE, 
				Data.AddressesData.ADDRESS_PHONE);

		log.info("Checkout/ Order payment - Step 20: Click to continue button");
		checkoutPO.clickToShippingAddressContinueButton();

		log.info("Checkout/ Order payment - Step 21: Click to shipping method continue button");
		checkoutPO.clickToShippingMethodContinueButton();

		log.info("Checkout/ Order payment - Step 22: Select payment method check/ money order");
		checkoutPO.selectToPaymentMethodCheckMoneyOrder();

		log.info("Checkout/ Order payment - Step 23: Click to payment method continue button");
		checkoutPO.clickToPaymentMethodContinueButton();

		log.info("Checkout/ Order payment - Step 24: Verify text in payment info section");
		verifyEquals(checkoutPO.getPaymentInfoSectionText(),
				"Mail Personal or Business Check, Cashier's Check or money order to:\n\n" 
						+ "NOP SOLUTIONS\n"
						+ "your address here,\n" 
						+ "New York, NY 10001\n" + "USA\n"
						+ "Notice that if you pay by Personal or Business Check, "
						+ "your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. "
						+ "If you want us to ship faster upon receipt of your payment, "
						+ "then we recommend your send a money order or Cashier's check.\n"
						+ "P.S. You can edit this text from admin panel.");

		log.info("Checkout/ Order payment - Step 25: Click payment info continue button");
		checkoutPO.clickToPaymentInfoContinueButton();

		log.info("Checkout/ Order payment - Step 26: Verify billing info");
		verifyEquals(checkoutPO.getBillingInfoText(),
				"Billing Address\n" + Data.RegisterData.FIRST_NAME + " " 
						+ Data.RegisterData.LAST_NAME + "\n"
						+ "Email: " + Data.RegisterData.EMAIL + "\n" 
						+ "Phone: " + Data.RegisterData.PHONE + "\n"
						+ "Fax:\n" + Data.RegisterData.COMPANY_NAME 
						+ "\n" + Data.RegisterData.ADDRESS_1 + "\n"
						+ Data.RegisterData.CITY + "," 
						+ Data.RegisterData.ZIP_POSTAL_CODE + "\n"
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Checkout/ Order payment - Step 27: Verify billing info");
		verifyEquals(checkoutPO.getPaymentMethodText(), "Payment Method: Check / Money Order");

		log.info("Checkout/ Order payment - Step 28: Verify Shipping Address info");
		verifyEquals(checkoutPO.getShippinAddressInfoText(),
				"Shipping Address\n" + Data.AddressesData.ADDRESS_FIRST_NAME + " "
						+ Data.AddressesData.ADDRESS_LAST_NAME + "\n" + "Email: " + Data.AddressesData.ADDRESS_EMAIL
						+ "\n" + "Phone: " + Data.AddressesData.ADDRESS_PHONE + "\n" + "Fax:\n"
						+ Data.RegisterData.COMPANY_NAME + "\n" + Data.AddressesData.ADDRESS_1 + "\n"
						+ Data.AddressesData.ADDRESS_CITY + "," + Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE + "\n"
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Checkout/ Order payment - Step 29: Verify shipping method info");
		verifyEquals(checkoutPO.getShippingMethodText(), "Shipping Method: Ground");

		log.info("Checkout/ Order payment - Step 30: Verify product SKU number");
		verifyEquals(checkoutPO.getProductSKUText(), "AP_MBP_13");

		log.info("Checkout/ Order payment - Step 31: Verify product name");
		verifyEquals(checkoutPO.getProductNameText(), "Apple MacBook Pro 13-inch");

		log.info("Checkout/ Order payment - Step 32: Verify product price");
		verifyEquals(checkoutPO.getProductPriceText(), "$1,800.00");

		log.info("Checkout/ Order payment - Step 33: Verify product price");
		verifyEquals(checkoutPO.getProductPriceText(), "$1,800.00");

		log.info("Checkout/ Order payment - Step 34: Verify product quantity");
		verifyEquals(checkoutPO.getProductQuantityText(), "2");

		log.info("Checkout/ Order payment - Step 35: Verify product sub total");
		verifyEquals(checkoutPO.getProductSubtotalText(), "$3,600.00");

		log.info("Checkout/ Order payment - Step 36: Verify gift wrapping");
		verifyEquals(checkoutPO.getGiftWrappingText(), "Gift wrapping: No");

		log.info("Checkout/ Order payment - Step 37: Verify order sub total");
		verifyEquals(checkoutPO.getOrderSubTotalText(), "Sub-Total: $3,600.00");

		log.info("Checkout/ Order payment - Step 38: Verify shipping");
		verifyEquals(checkoutPO.getShippingCostText(), "Shipping: (Ground) $0.00");

		log.info("Checkout/ Order payment - Step 39: Verify tax");
		verifyEquals(checkoutPO.getTaxText(), "Tax: $0.00");

		log.info("Checkout/ Order payment - Step 40: Verify order total");
		verifyEquals(checkoutPO.getOrderTotalText(), "Total: $3,600.00");

		log.info("Checkout/ Order payment - Step 41: Click to confirm button");
		checkoutPO.clickToConfirmButton();

		log.info("Checkout/ Order payment - Step 43: Verify order compele page body title message");
		verifyEquals(checkoutPO.getOrderCompletePageBodyTitleText(), "Your order has been successfully processed!");

		log.info("Checkout/ Order payment - Step 44: Verify is order number visible");
		verifyTrue(checkoutPO.isOrderNumberVisible());

		String orderNumber = checkoutPO.getOrderNumber();

		log.info("Checkout/ Order payment - Step 45: Click to my account page");
		myAccountPO = userHomePO.clickToMyAccountPage();

		log.info("Checkout/ Order payment - Step 46: Click to order link");
		myAccountPO.clickToOrderLink();

		log.info("Checkout/ Order payment - Step 47: Verify order number");
		verifyEquals(myAccountPO.getOrderNumber().toUpperCase(), orderNumber);

		log.info("Checkout/ Order payment - Step 48: Click to detail button");
		myAccountPO.clickToDetailButton();

		log.info("Checkout/ Order payment - Step 49: Verify billing info");
		verifyEquals(checkoutPO.getBillingInfoText(),
				"Billing Address\n" + Data.RegisterData.FIRST_NAME + " " + Data.RegisterData.LAST_NAME + "\n"
						+ "Email: " + Data.RegisterData.EMAIL + "\n" + "Phone: " + Data.RegisterData.PHONE + "\n"
						+ "Fax:\n" + Data.RegisterData.COMPANY_NAME + "\n" + Data.RegisterData.ADDRESS_1 + "\n"
						+ Data.RegisterData.CITY + "," + Data.RegisterData.ZIP_POSTAL_CODE + "\n"
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Checkout/ Order payment - Step 50: Verify billing info");
		verifyEquals(myAccountPO.getPaymentMethodText(), "Payment Method: Check / Money Order");

		log.info("Checkout/ Order payment - Step 51: Verify Shipping Address info");
		verifyEquals(checkoutPO.getShippinAddressInfoText(),
				"Shipping Address\n" + Data.AddressesData.ADDRESS_FIRST_NAME + " "
						+ Data.AddressesData.ADDRESS_LAST_NAME + "\n" 
						+ "Email: " + Data.AddressesData.ADDRESS_EMAIL
						+ "\n" + "Phone: " + Data.AddressesData.ADDRESS_PHONE 
						+ "\n" + "Fax:\n"
						+ Data.RegisterData.COMPANY_NAME + "\n" 
						+ Data.AddressesData.ADDRESS_1 + "\n"
						+ Data.AddressesData.ADDRESS_CITY + "," 
						+ Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE + "\n"
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Checkout/ Order payment - Step 52: Verify shipping method info");
		verifyEquals(myAccountPO.getShippingMethodText(), "Shipping Method: Ground");

		log.info("Checkout/ Order payment - Step 53: Verify product SKU number");
		verifyEquals(myAccountPO.getProductSKUText(), "AP_MBP_13");

		log.info("Checkout/ Order payment - Step 54: Verify product name");
		verifyEquals(myAccountPO.getProductNameText(), "Apple MacBook Pro 13-inch");

		log.info("Checkout/ Order payment - Step 55: Verify product price");
		verifyEquals(myAccountPO.getProductPriceText(), "$1,800.00");

		log.info("Checkout/ Order payment - Step 56: Verify product price");
		verifyEquals(myAccountPO.getProductPriceText(), "$1,800.00");

		log.info("Checkout/ Order payment - Step 57: Verify product quantity");
		verifyEquals(myAccountPO.getProductQuantityText(), "2");

		log.info("Checkout/ Order payment - Step 58: Verify product sub total");
		verifyEquals(myAccountPO.getProductSubtotalText(), "$3,600.00");

		log.info("Checkout/ Order payment - Step 59: Verify gift wrapping");
		verifyEquals(myAccountPO.getGiftWrappingText(), "Gift wrapping: No");

		log.info("Checkout/ Order payment - Step 60: Verify order sub total");
		verifyEquals(myAccountPO.getCartTotalText(),
				"Sub-Total: $3,600.00\n" + "Shipping: $0.00\n" + "Tax: $0.00\n" + "Order Total: $3,600.00");

	}

	@Test
	public void TC_06_Checkout_Order_Payment_Method_By_Card_Visa() {
		log.info("Checkout/ Order payment - Step 1: Open computers page");
		computerPO = userHomePO.clickToComputersPage();

		log.info("Checkout/ Order payment - Step 2: Click to notebook link");
		computerPO.clickToSublistLinkByName("Notebooks");

		log.info("Checkout/ Order payment - Step 3: Click to Apple MacBook Pro 13-inch product");
		computerPO.clickToProductByName("Apple MacBook Pro 13-inch");

		log.info("Checkout/ Order payment - Step 4: Click to add to cart ");
		computerPO.clickAddToCartButton();

		log.info("Checkout/ Order payment - Step 5: Verify notification bar message ");
		verifyEquals(userHomePO.getTextOnNotificationBar(), "The product has been added to your shopping cart");

		log.info("Checkout/ Order payment - Step 6: Click notification bar close button");
		userHomePO.clickCloseNotificationBar();

		log.info("Checkout/ Order payment - Step 7: Click to shopping cart link ");
		shoppingcartPO = userHomePO.clickToShoppingCartPage();

		log.info("Checkout/ Order payment - Step 8: Click to estimate shipping link");
		shoppingcartPO.clickToEstimateShippingLink();

		log.info("Checkout/ Order payment - Step 9: Select country");
		shoppingcartPO.selectShippingAddressCountryDropDownByText(Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Checkout/ Order payment - Step 10: Enter to zip/ postal code");
		shoppingcartPO.enterToShippingAddressZipPostalCode(Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE);

		log.info("Checkout/ Order payment - Step 11: Wait for shipping method appear");
		shoppingcartPO.waitForShippingMethodAppear();

		log.info("Checkout/ Order payment - Step 12: Click to apply button");
		shoppingcartPO.clickToApplyButton();

		log.info("Checkout/ Order payment - Step 13: Check to I agree checkbox");
		shoppingcartPO.checkToIAgreeCheckBox();

		log.info("Checkout/ Order payment - Step 14: Click to checkout button");
		checkoutPO = shoppingcartPO.clickToCheckoutButton();

		log.info("Checkout/ Order payment - Step 15: Uncheck to ship to the same address");
		checkoutPO.uncheckToShipToTheSameAddress();

		log.info("Checkout/ Order payment - Step 16: Selecct new billing address");
		checkoutPO.selectNewBillingAddress();

		log.info("Checkout/ Order payment - Step 17: Enter to billing address with register data");
		checkoutPO.enterDataToBillingAddress(Data.RegisterData.FIRST_NAME, 
				Data.RegisterData.LAST_NAME,
				Data.RegisterData.EMAIL, 
				Data.AddressesData.ADDRESS_COUNTRY, 
				Data.RegisterData.CITY,
				Data.RegisterData.ADDRESS_1, 
				Data.RegisterData.ZIP_POSTAL_CODE, 
				Data.RegisterData.PHONE);

		log.info("Checkout/ Order payment - Step 18: Click to continue button");
		checkoutPO.clickToBillingContinueButton();

		log.info("Checkout/ Order payment - Step 19: Select new address on shipping address dropdown");
		checkoutPO.selectNewShippingAddress();

		log.info("Checkout/ Order payment - Step 20: Enter to shipping address with address data");
		checkoutPO.enterDataToShippingAddress(Data.AddressesData.ADDRESS_FIRST_NAME,
				Data.AddressesData.ADDRESS_LAST_NAME, 
				Data.AddressesData.ADDRESS_EMAIL,
				Data.AddressesData.ADDRESS_COUNTRY, 
				Data.AddressesData.ADDRESS_CITY, 
				Data.AddressesData.ADDRESS_1,
				Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE, 
				Data.AddressesData.ADDRESS_PHONE);

		log.info("Checkout/ Order payment - Step 21: Click to continue button");
		checkoutPO.clickToShippingAddressContinueButton();

		log.info("Checkout/ Order payment - Step 22: Click to shipping method continue button");
		checkoutPO.clickToShippingMethodContinueButton();

		log.info("Checkout/ Order payment - Step 23: Select payment method credit card");
		checkoutPO.selectToPaymentMethodCreditCard();

		log.info("Checkout/ Order payment - Step 24: Click to payment method continue button");
		checkoutPO.clickToPaymentMethodContinueButton();

		log.info("Checkout/ Order payment - Step 25: Enter to card holder name");
		checkoutPO.enterToCardHolderName("Amex");

		log.info("Checkout/ Order payment - Step 26: Enter to card number");
		checkoutPO.enterToCardNumber("374245455400126");

		log.info("Checkout/ Order payment - Step 27: Enter to card code");
		checkoutPO.enterToCardCode("123");
		checkoutPO.selectExpireYear("2036");

		log.info("Checkout/ Order payment - Step 28 Click payment info continue button");
		checkoutPO.clickToPaymentInfoContinueButton();

		log.info("Checkout/ Order payment - Step 29: Verify billing info");
		verifyEquals(checkoutPO.getBillingInfoText(),
				"Billing Address\n" + Data.RegisterData.FIRST_NAME + " " 
						+ Data.RegisterData.LAST_NAME + "\n"
						+ "Email: " + Data.RegisterData.EMAIL + "\n" 
						+ "Phone: " + Data.RegisterData.PHONE + "\n"
						+ "Fax:\n" + Data.RegisterData.ADDRESS_1 
						+ "\n" + Data.RegisterData.CITY + ","
						+ Data.RegisterData.ZIP_POSTAL_CODE + "\n" 
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Checkout/ Order payment - Step 29: Verify billing info");
		verifyEquals(checkoutPO.getPaymentMethodText(), "Payment Method: Credit Card");

		log.info("Checkout/ Order payment - Step 30: Verify Shipping Address info");
		verifyEquals(checkoutPO.getShippinAddressInfoText(),
				"Shipping Address\n" + Data.AddressesData.ADDRESS_FIRST_NAME + " "
						+ Data.AddressesData.ADDRESS_LAST_NAME + "\n" 
						+ "Email: " + Data.AddressesData.ADDRESS_EMAIL
						+ "\n" + "Phone: " + Data.AddressesData.ADDRESS_PHONE 
						+ "\n" + "Fax:\n"
						+ Data.RegisterData.COMPANY_NAME + "\n" 
						+ Data.AddressesData.ADDRESS_1 + "\n"
						+ Data.AddressesData.ADDRESS_CITY + "," 
						+ Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE + "\n"
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Checkout/ Order payment - Step 31: Verify shipping method info");
		verifyEquals(checkoutPO.getShippingMethodText(), "Shipping Method: Ground");

		log.info("Checkout/ Order payment - Step 32: Verify product SKU number");
		verifyEquals(checkoutPO.getProductSKUText(), "AP_MBP_13");

		log.info("Checkout/ Order payment - Step 33: Verify product name");
		verifyEquals(checkoutPO.getProductNameText(), "Apple MacBook Pro 13-inch");

		log.info("Checkout/ Order payment - Step 34: Verify product price");
		verifyEquals(checkoutPO.getProductPriceText(), "$1,800.00");

		log.info("Checkout/ Order payment - Step 35: Verify product price");
		verifyEquals(checkoutPO.getProductPriceText(), "$1,800.00");

		log.info("Checkout/ Order payment - Step 36: Verify product quantity");
		verifyEquals(checkoutPO.getProductQuantityText(), "2");

		log.info("Checkout/ Order payment - Step 37: Verify product sub total");
		verifyEquals(checkoutPO.getProductSubtotalText(), "$3,600.00");

		log.info("Checkout/ Order payment - Step 38: Verify gift wrapping");
		verifyEquals(checkoutPO.getGiftWrappingText(), "Gift wrapping: No");

		log.info("Checkout/ Order payment - Step 39: Verify order sub total");
		verifyEquals(checkoutPO.getOrderSubTotalText(), "Sub-Total: $3,600.00");

		log.info("Checkout/ Order payment - Step 40: Verify shipping");
		verifyEquals(checkoutPO.getShippingCostText(), "Shipping: (Ground) $0.00");

		log.info("Checkout/ Order payment - Step 41: Verify tax");
		verifyEquals(checkoutPO.getTaxText(), "Tax: $0.00");

		log.info("Checkout/ Order payment - Step 42: Verify order total");
		verifyEquals(checkoutPO.getOrderTotalText(), "Total: $3,600.00");

		log.info("Checkout/ Order payment - Step 43: Click to confirm button");
		checkoutPO.clickToConfirmButton();

		log.info("Checkout/ Order payment - Step 45: Verify order compele page body title message");
		verifyEquals(checkoutPO.getOrderCompletePageBodyTitleText(), "Your order has been successfully processed!");

		log.info("Checkout/ Order payment - Step 46: Verify is order number visible");
		verifyTrue(checkoutPO.isOrderNumberVisible());

		String orderNumber = checkoutPO.getOrderNumber();

		log.info("Checkout/ Order payment - Step 47: Click to my account page");
		myAccountPO = userHomePO.clickToMyAccountPage();

		log.info("Checkout/ Order payment - Step 48: Click to order link");
		myAccountPO.clickToOrderLink();

		log.info("Checkout/ Order payment - Step 49: Verify order number");
		verifyEquals(myAccountPO.getOrderNumber().toUpperCase(), orderNumber);

		log.info("Checkout/ Order payment - Step 50: Click to detail button");
		myAccountPO.clickToDetailButton();

		log.info("Checkout/ Order payment - Step 51 Verify billing info");
		verifyEquals(checkoutPO.getBillingInfoText(),
				"Billing Address\n" + Data.RegisterData.FIRST_NAME 
						+ " " + Data.RegisterData.LAST_NAME + "\n"
						+ "Email: " + Data.RegisterData.EMAIL 
						+ "\n" + "Phone: " + Data.RegisterData.PHONE + "\n"
						+ "Fax:\n" + Data.RegisterData.ADDRESS_1 
						+ "\n" + Data.RegisterData.CITY + ","
						+ Data.RegisterData.ZIP_POSTAL_CODE + "\n" 
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Checkout/ Order payment - Step 52: Verify billing info");
		verifyEquals(myAccountPO.getPaymentMethodText(), "Payment Method: Credit Card");

		log.info("Checkout/ Order payment - Step 53: Verify Shipping Address info");
		verifyEquals(checkoutPO.getShippinAddressInfoText(),
				"Shipping Address\n" + Data.AddressesData.ADDRESS_FIRST_NAME + " "
						+ Data.AddressesData.ADDRESS_LAST_NAME + "\n" + "Email: " 
						+ Data.AddressesData.ADDRESS_EMAIL
						+ "\n" + "Phone: " + Data.AddressesData.ADDRESS_PHONE 
						+ "\n" + "Fax:\n"
						+ Data.RegisterData.COMPANY_NAME + "\n" 
						+ Data.AddressesData.ADDRESS_1 + "\n"
						+ Data.AddressesData.ADDRESS_CITY + "," 
						+ Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE + "\n"
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Checkout/ Order payment - Step 54: Verify shipping method info");
		verifyEquals(myAccountPO.getShippingMethodText(), "Shipping Method: Ground");

		log.info("Checkout/ Order payment - Step 55: Verify product SKU number");
		verifyEquals(myAccountPO.getProductSKUText(), "AP_MBP_13");

		log.info("Checkout/ Order payment - Step 56: Verify product name");
		verifyEquals(myAccountPO.getProductNameText(), "Apple MacBook Pro 13-inch");

		log.info("Checkout/ Order payment - Step 57: Verify product price");
		verifyEquals(myAccountPO.getProductPriceText(), "$1,800.00");

		log.info("Checkout/ Order payment - Step 58: Verify product price");
		verifyEquals(myAccountPO.getProductPriceText(), "$1,800.00");

		log.info("Checkout/ Order payment - Step 59: Verify product quantity");
		verifyEquals(myAccountPO.getProductQuantityText(), "2");

		log.info("Checkout/ Order payment - Step 60: Verify product sub total");
		verifyEquals(myAccountPO.getProductSubtotalText(), "$3,600.00");

		log.info("Checkout/ Order payment - Step 61: Verify gift wrapping");
		verifyEquals(myAccountPO.getGiftWrappingText(), "Gift wrapping: No");

		log.info("Checkout/ Order payment - Step 62: Verify order sub total");
		verifyEquals(myAccountPO.getCartTotalText(),
				"Sub-Total: $3,600.00\n" + "Shipping: $0.00\n" + "Tax: $0.00\n" + "Order Total: $3,600.00");
	}

	@Test
	public void TC_07_RE_ORDER() {
		log.info("Re-order - Step 1: Click to re-order button");
		shoppingcartPO = myAccountPO.clickToReOrderButton();

		log.info("Re-order - Step 2: Update quantity to 10");
		shoppingcartPO.updateQuantityTo10();

		log.info("Re-order - Step 3: Click to update shopping cart button");
		shoppingcartPO.clickToUppdateShoppingCartButton();

		log.info("Re-order - Step 4: Check to I agree checkbox");
		shoppingcartPO.checkToIAgreeCheckBox();

		log.info("Re-order - Step 5: Click to checkout button");
		checkoutPO = shoppingcartPO.clickToCheckoutButton();

		log.info("Re-order - Step 6: Uncheck to ship to the same address");
		checkoutPO.uncheckToShipToTheSameAddress();

		log.info("Re-order - Step 7: Select new billing address dropdown");
		checkoutPO.selectNewBillingAddress();

		log.info("Re-order - Step 8: Enter to address with address data");
		checkoutPO.enterDataToBillingAddress(Data.AddressesData.ADDRESS_FIRST_NAME,
				Data.AddressesData.ADDRESS_LAST_NAME, 
				Data.AddressesData.ADDRESS_EMAIL,
				Data.AddressesData.ADDRESS_COUNTRY, 
				Data.AddressesData.ADDRESS_CITY, 
				Data.AddressesData.ADDRESS_1,
				Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE, 
				Data.AddressesData.ADDRESS_PHONE);

		log.info("Re-order - Step 9: Click to continue button");
		checkoutPO.clickToBillingContinueButton();

		log.info("Re-order - Step 10: Select new address on shipping address dropdown");
		checkoutPO.selectNewShippingAddress();

		log.info("Re-order - Step 11: Enter to shipping address with register data");
		checkoutPO.enterDataToShippingAddress(Data.RegisterData.FIRST_NAME, 
				Data.RegisterData.LAST_NAME,
				Data.RegisterData.EMAIL, 
				Data.AddressesData.ADDRESS_COUNTRY, 
				Data.RegisterData.CITY,
				Data.RegisterData.ADDRESS_1, 
				Data.RegisterData.ZIP_POSTAL_CODE, 
				Data.RegisterData.PHONE);

		log.info("Re-order - Step 12: Click to continue button");
		checkoutPO.clickToShippingAddressContinueButton();

		log.info("Re-order - Step 13: Check to next day air radio");
		checkoutPO.checkToNextDayAirMethodRadio();

		log.info("Re-order - Step 14: Click to shipping method continue button");
		checkoutPO.clickToShippingMethodContinueButton();

		log.info("Re-order - Step 15: Select payment method check/ money order");
		checkoutPO.selectToPaymentMethodCheckMoneyOrder();

		log.info("Re-order - Step 16: Click to payment method continue button");
		checkoutPO.clickToPaymentMethodContinueButton();

		log.info("Re-order - Step 17: Verify text in payment info section");
		verifyEquals(checkoutPO.getPaymentInfoSectionText(),
				"Mail Personal or Business Check, Cashier's Check or money order to:\n\n" 
						+ "NOP SOLUTIONS\n"
						+ "your address here,\n" 
						+ "New York, NY 10001\n" + "USA\n"
						+ "Notice that if you pay by Personal or Business Check, "
						+ "your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. "
						+ "If you want us to ship faster upon receipt of your payment, "
						+ "then we recommend your send a money order or Cashier's check.\n"
						+ "P.S. You can edit this text from admin panel.");

		log.info("Re-order - Step 18: Click payment info continue button");
		checkoutPO.clickToPaymentInfoContinueButton();

		log.info("Re-order - Step 19: Verify billing info");
		verifyEquals(checkoutPO.getBillingInfoText(),
				"Billing Address\n" + Data.AddressesData.ADDRESS_FIRST_NAME + " " 
						+ Data.AddressesData.ADDRESS_LAST_NAME
						+ "\n" + "Email: " + Data.AddressesData.ADDRESS_EMAIL 
						+ "\n" + "Phone: " + Data.AddressesData.ADDRESS_PHONE 
						+ "\n" + "Fax:\n" + Data.AddressesData.ADDRESS_1 + "\n"
						+ Data.AddressesData.ADDRESS_CITY 
						+ "," + Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE + "\n"
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Re-order - Step 20: Verify billing info");
		verifyEquals(checkoutPO.getPaymentMethodText(), "Payment Method: Check / Money Order");

		log.info("Re-order - Step 21: Verify Shipping Address info");
		verifyEquals(checkoutPO.getShippinAddressInfoText(),
				"Shipping Address\n" + Data.RegisterData.FIRST_NAME + " " 
						+ Data.RegisterData.LAST_NAME + "\n"
						+ "Email: " + Data.RegisterData.EMAIL + "\n" 
						+ "Phone: " + Data.RegisterData.PHONE + "\n"
						+ "Fax:\n" + Data.RegisterData.COMPANY_NAME 
						+ "\n" + Data.RegisterData.ADDRESS_1 + "\n"
						+ Data.RegisterData.CITY + "," 
						+ Data.RegisterData.ZIP_POSTAL_CODE + "\n"
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Re-order - Step 22: Verify shipping method info");
		verifyEquals(checkoutPO.getShippingMethodText(), "Shipping Method: Next Day Air");

		log.info("Re-order - Step 23: Verify product SKU number");
		verifyEquals(checkoutPO.getProductSKUText(), "AP_MBP_13");

		log.info("Re-order - Step 24: Verify product name");
		verifyEquals(checkoutPO.getProductNameText(), "Apple MacBook Pro 13-inch");

		log.info("Re-order - Step 25: Verify product price");
		verifyEquals(checkoutPO.getProductPriceText(), "$1,800.00");

		log.info("Re-order - Step 26: Verify product quantity");
		verifyEquals(checkoutPO.getProductQuantityText(), "10");

		log.info("Re-order - Step 27: Verify product sub total");
		verifyEquals(checkoutPO.getProductSubtotalText(), "$18,000.00");

		log.info("Re-order - Step 28: Verify gift wrapping");
		verifyEquals(checkoutPO.getGiftWrappingText(), "Gift wrapping: No");

		log.info("Re-order - Step 29: Verify order sub total");
		verifyEquals(checkoutPO.getOrderSubTotalText(), "Sub-Total: $18,000.00");

		log.info("Re-order - Step 30: Verify shipping");
		verifyEquals(checkoutPO.getShippingCostText(), "Shipping: (Next Day Air) $0.00");

		log.info("Re-order - Step 31: Verify tax");
		verifyEquals(checkoutPO.getTaxText(), "Tax: $0.00");

		log.info("Re-order - Step 32: Verify order total");
		verifyEquals(checkoutPO.getOrderTotalText(), "Total: $18,000.00");

		log.info("Re-order - Step 33: Click to confirm button");
		checkoutPO.clickToConfirmButton();

		log.info("Re-order - Step 34: Verify order compele page body title message");
		verifyEquals(checkoutPO.getOrderCompletePageBodyTitleText(), "Your order has been successfully processed!");

		log.info("Re-order - Step 35: Verify is order number visible");
		verifyTrue(checkoutPO.isOrderNumberVisible());

		String orderNumber = checkoutPO.getOrderNumber();

		log.info("Re-order - Step 36: Click to my account page");
		myAccountPO = userHomePO.clickToMyAccountPage();

		log.info("Re-order - Step 37: Click to order link");
		myAccountPO.clickToOrderLink();

		log.info("Re-order - Step 38: Verify order number");
		verifyEquals(myAccountPO.getOrderNumber().toUpperCase(), orderNumber);

		log.info("Re-order - Step 39: Click to detail button");
		myAccountPO.clickToDetailButton();

		log.info("Re-order - Step 40: Verify billing info");
		verifyEquals(checkoutPO.getBillingInfoText(),
				"Billing Address\n" + Data.AddressesData.ADDRESS_FIRST_NAME + " " 
						+ Data.AddressesData.ADDRESS_LAST_NAME
						+ "\n" + "Email: " + Data.AddressesData.ADDRESS_EMAIL 
						+ "\n" + "Phone: " + Data.AddressesData.ADDRESS_PHONE + "\n" 
						+ "Fax:\n" + Data.AddressesData.ADDRESS_1 + "\n"
						+ Data.AddressesData.ADDRESS_CITY + "," 
						+ Data.AddressesData.ADDRESS_ZIP_POSTAL_CODE + "\n"
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Re-order - Step 41: Verify billing info");
		verifyEquals(myAccountPO.getPaymentMethodText(), "Payment Method: Check / Money Order");

		log.info("Re-order - Step 42: Verify Shipping Address info");
		verifyEquals(checkoutPO.getShippinAddressInfoText(),
				"Shipping Address\n" + Data.RegisterData.FIRST_NAME + " " 
						+ Data.RegisterData.LAST_NAME + "\n"
						+ "Email: " + Data.RegisterData.EMAIL + "\n" 
						+ "Phone: " + Data.RegisterData.PHONE + "\n"
						+ "Fax:\n" + Data.RegisterData.COMPANY_NAME +
						"\n" + Data.RegisterData.ADDRESS_1 + "\n"
						+ Data.RegisterData.CITY + "," 
						+ Data.RegisterData.ZIP_POSTAL_CODE + "\n"
						+ Data.AddressesData.ADDRESS_COUNTRY);

		log.info("Re-order - Step 43: Verify shipping method info");
		verifyEquals(myAccountPO.getShippingMethodText(), "Shipping Method: Next Day Air");

		log.info("Re-order - Step 44: Verify product SKU number");
		verifyEquals(myAccountPO.getProductSKUText(), "AP_MBP_13");

		log.info("Re-order - Step 45: Verify product name");
		verifyEquals(myAccountPO.getProductNameText(), "Apple MacBook Pro 13-inch");

		log.info("Re-order - Step 46: Verify product price");
		verifyEquals(myAccountPO.getProductPriceText(), "$1,800.00");

		log.info("Re-order - Step 47: Verify product quantity");
		verifyEquals(myAccountPO.getProductQuantityText(), "10");

		log.info("Re-order - Step 48: Verify product sub total");
		verifyEquals(myAccountPO.getProductSubtotalText(), "$18,000.00");

		log.info("Re-order - Step 49: Verify gift wrapping");
		verifyEquals(myAccountPO.getGiftWrappingText(), "Gift wrapping: No");

		log.info("Re-order - Step 50: Verify order sub total");
		verifyEquals(myAccountPO.getCartTotalText(),
				"Sub-Total: $18,000.00\n" + "Shipping: $0.00\n" + "Tax: $0.00\n" + "Order Total: $18,000.00");

	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
