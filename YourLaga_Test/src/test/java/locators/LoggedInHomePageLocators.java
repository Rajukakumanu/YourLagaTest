package locators;


public interface LoggedInHomePageLocators {

	
	public static final String DRESS_MENU ="//div[@id='block_top_menu']/ul/li[2]/a[text() ='Dresses']";
	
	
	public static final String FIRST_ITEM ="//ul[@class='product_list grid row']/li[1]//a/span[text() ='Quick view']";
	
	
	public static final String SECOND_ITEM ="//ul[@class='product_list grid row']/li[2]//a/span[text() ='Quick view']";
	
	
	public static final String MOUSEHOVER_FIRSTITEM ="//ul[@class='product_list grid row']/li[1]";
	
	
	public static final String MOUSEHOVER_SECONDITEM ="//ul[@class='product_list grid row']/li[2]";
	
	
	public static final String SIZE_COUNT ="//div[@class ='attribute_list']//select[@class ='form-control attribute_select no-print']";
	
	
	public static final String ADD_TO_CART ="//button[@type ='submit']/span[text() ='Add to cart']";
	
	
	public static final String I_FRAME =".fancybox-iframe";
	
	
	public static final String CONTINUE_SHOPPINGBTN ="//span[@title ='Continue shopping']/span/i";
	
	
	public static final String PROCEED_TO_CHECKOUT ="//a[@title ='Proceed to checkout']";
	
	
	public static final String ITEM_PRICE ="//p/span[@id='our_price_display']";
	
	
	public static final String SIGNOUT_BTN="//div[@class='row']//div/a[@class='logout']";
	
	
	public static final String ACCNT_UNAME="//div[@class='row']//div/a[@class='account']";
	

}
