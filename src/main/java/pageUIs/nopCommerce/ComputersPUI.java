package pageUIs.nopCommerce;

public class ComputersPUI {
	public static final String NOTEBOOKS_LINK = "//ul[@class='sublist']//a[contains(text(),'Notebooks')]";
	
	public static final String DESKTOP_LINK = "//ul[@class='sublist']//a[contains(text(),'Desktops ')]";
	
	public static final String SORT_BY_DROPDOWN = "//select[@id='products-orderby']";
	
	public static final String DISPLAY_DROPDOWN = "//select[@id='products-pagesize']";
	
	public static final String DYNAMIC_PRODUCT_TITLE_LINK = "//h2[@class='product-title']/a[text()='%s']";
	
	public static final String PRODUCT_TITLE_LINK = "//h2[@class='product-title']";
	
	public static final String NEXT_PAGE_LINK = "//li[@class='next-page']";
	
	public static final String PREVIOUS_PAGE_LINK = "//li[@class='previous-page']";
	
	public static final String CURRENT_PAGE_LINK = "//li[@class='current-page']";
	
	public static final String PRICE_IN_PAGE_BODY= "//span[@class='price actual-price']";
	
	public static final String ADD_TO_CART_BUTTON = "//button[@class='button-1 add-to-cart-button']";
	
	public static final String PROCESSOR_DROPDOWN = "//select[@id='product_attribute_1']";
	
	public static final String RAM_DROPDOWN = "//select[@id='product_attribute_2']";
	
	public static final String HDD_400GB_RADIO = "//input[@id='product_attribute_3_7']";
	
	public static final String HDD_320GB_RADIO = "//input[@id='product_attribute_3_6']";
	
	public static final String PREMIUM_OS_RADIO = "//input[@id='product_attribute_4_9']";
	
	public static final String HOME_OS_RADIO = "//input[@id='product_attribute_4_8']";
	
	public static final String MICROSOFT_CHECKBOX = "//input[@id='product_attribute_5_10']";
	
	public static final String ACROBATCO_CHECKBOX = "//input[@id='product_attribute_5_11']";
	
	public static final String COMANDER_CHECKBOX = "//input[@id='product_attribute_5_12']";
	
	public static final String COUNT_FIELD = "//div[@class='count']";
	
	public static final String SUB_TOTAL_FIELD = "//div[text()='Sub-Total: ']";
	
	public static final String QUANTITY_TEXTBOX = "//input[@id='product_enteredQuantity_1']";
	
	public static final String PRODUCT_PRICE = "//span[@id='price-value-1']";

	public static final String PRODUCT_BUSY = "//div[@class='ajax-products-busy']";
	
	
}
