package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.LoggedInHomePageLocators;
import utilities.UserActions;

public class LoggedInHomePage extends UserActions implements LoggedInHomePageLocators{
	WebDriver driver;
	public static String sExpectedFirstItemSize;
	public static String sExpectedSecondItemSize;
	public static String sExpectedFirstItemPrice;
	public static String sExpectedSecondItemPrice;
	
	
	public LoggedInHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath=DRESS_MENU)
	WebElement dressMenu;
	
	@FindBy(xpath =FIRST_ITEM)
	WebElement firstItem;
	
	@FindBy(xpath =SECOND_ITEM)
	WebElement secondItem;
	
	@FindBy(xpath =MOUSEHOVER_FIRSTITEM)
	WebElement mouseHoverFirstItem;
	
	@FindBy(xpath =MOUSEHOVER_SECONDITEM)
	WebElement mouseHoverSecondItem;
	
	@FindBy(xpath =SIZE_COUNT)
	WebElement sizeCount;
	
	@FindBy(xpath =ADD_TO_CART)
	WebElement addtoCart;
	
	@FindBy(css =I_FRAME)
	WebElement iframe;
	
	
	@FindBy(xpath =CONTINUE_SHOPPINGBTN)
	WebElement continueShoppingBtn;
	
	@FindBy(xpath =PROCEED_TO_CHECKOUT)
	WebElement proceedToCheckout;
	
	@FindBy(xpath =ITEM_PRICE)
	WebElement itemPrice;
	
	@FindBy(xpath=SIGNOUT_BTN)
	WebElement signOutBtn;
	
	@FindBy(xpath=ACCNT_UNAME)
	WebElement accntUname;

	
	public void quickViewAnItem() {
		
		click(dressMenu, "dressMenu", 20);
		waitForPageToLoad();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,800)");
		waitForPageToLoad();
		mouseHover(mouseHoverFirstItem, "mouseHover");
		click(firstItem, "quickView", 10);
		waitForPageToLoad();
	}

	public void changeItemSize(String sSize) {
		swithToFrame(iframe);
		waitForPageToLoad();
		sExpectedFirstItemSize = sSize;
		waitForPageToLoad();
		waitForElementToLoad(itemPrice, "itemPrice", 30);
		sExpectedFirstItemPrice = itemPrice.getText();
		selectDropdown(sizeCount,sSize);
	}

	public void clickAddToCart() {
		click(addtoCart, "addtoCart", 10);	
		waitForPageToLoad();
	}

	public void clickContinueShopping() {
		nativeClick(continueShoppingBtn, "continueShoppingBtn", 15);
		swithToDefalutContent();		
	}

	public void quickViewSecondItem() {
		waitForPageToLoad();
		mouseHover(mouseHoverSecondItem, "mouseOverSecound");
		click(secondItem, "secondItem", 10);
		waitForPageToLoad();
		swithToFrame(iframe);
		sExpectedSecondItemSize = getFirstSelectedOption(sizeCount);
		sExpectedSecondItemPrice = itemPrice.getText();
		clickAddToCart();
	}

	public CheckOutSummaryPage proccedToCheckout() {
		waitForPageToLoad();
		click(proceedToCheckout, "proceedToCheckout", 10);
		waitForPageToLoad();
		CheckOutSummaryPage checkOutSummaryPage  = new CheckOutSummaryPage(driver);
		return checkOutSummaryPage;
		
	}

	public void logOut() {
		waitForPageToLoad();
		nativeClick(signOutBtn, "signOutBtn", 15);
        waitForPageToLoad();		
	}

	public MyAccount naviageToMyOrderHistory() {
		click(accntUname, "accntUname", 15);
		waitForPageToLoad();
		MyAccount myAccount = new MyAccount(driver);
		return myAccount;
	}
	

}
