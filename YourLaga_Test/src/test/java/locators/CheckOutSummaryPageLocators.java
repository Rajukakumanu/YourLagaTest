package locators;

public interface CheckOutSummaryPageLocators {

	public static final String FIRST_ITEMSIZE = "//table[@id='cart_summary']//tbody/tr[1]//td[@class='cart_description']//small/a";

	public static final String SECONDITEM_SIZE = "//table[@id='cart_summary']//tbody/tr[2]//td[@class='cart_description']//small/a";

	public static final String FIRSTITEM_PRICE = "//table[@id='cart_summary']//tbody/tr[1]//td[@class='cart_unit']/span/span";

	public static final String SECONDITEM_PRICE = "//table[@id='cart_summary']//tbody/tr[2]//td[@class='cart_unit']/span/span";

	public static final String TOTAL_PRODUCTS = "//tr[@class='cart_total_price']//td[@id='total_product']";

	public static final String TOTAL = "//tr[@class='cart_total_price']//td[@id='total_price_without_tax']";

	public static final String TOTAL_SHIPPING = "//tr[@class='cart_total_delivery']//td[@id='total_shipping']";

	public static final String CONTINUE_SHOPPING = "//p[@class='cart_navigation clearfix']//a[@title ='Proceed to checkout']";

	public static final String TERMS_CHECKBOX = "//form[@id='form']//p[@class='checkbox']//input[@type='checkbox']";

	public static final String PAYBY_BANKWIRE = "//div[@id='HOOK_PAYMENT']/div//a[@class='bankwire']";
	
	public static final String CONTINUESHOPPING_SHIPPING_ADDRESS="//p[@class='cart_navigation clearfix']//button[@type ='submit']";
}
