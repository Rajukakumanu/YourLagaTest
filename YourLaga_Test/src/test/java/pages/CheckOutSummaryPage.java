package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.CheckOutSummaryPageLocators;
import utilities.UserActions;



public class CheckOutSummaryPage extends UserActions implements CheckOutSummaryPageLocators{
	WebDriver driver;
	
		public CheckOutSummaryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	     
		@FindBy(xpath=FIRST_ITEMSIZE)
		WebElement firstItemSize;
		
		@FindBy(xpath=SECONDITEM_SIZE)
		WebElement secondItemSize;
		
		@FindBy(xpath=FIRSTITEM_PRICE)
		WebElement firstItemPrice;
		
		@FindBy(xpath=SECONDITEM_PRICE)
		WebElement secondItemPrice;
		
		@FindBy(xpath=TOTAL_PRODUCTS)
		WebElement totalProducts;
		
		@FindBy(xpath=TOTAL)
		WebElement total;
		
		@FindBy(xpath=TOTAL_SHIPPING)
		WebElement totalShipping;
		
		@FindBy(xpath=CONTINUE_SHOPPING)
		WebElement continueShopping;
		
		@FindBy(xpath=TERMS_CHECKBOX)
		WebElement termsCheckBox;
		
		@FindBy(xpath=PAYBY_BANKWIRE)
		WebElement payByBankWire;
		
		@FindBy(xpath=CONTINUESHOPPING_SHIPPING_ADDRESS)
		WebElement continueShoppingShippingAddress;

		public LoggedInHomePage verifyItemSizesAndTotal() {
			waitForPageToLoad();
			
			// verify first element size
			Assert.assertEquals(LoggedInHomePage.sExpectedFirstItemSize,firstItemSize.getText().substring(firstItemSize.getText().length()-1));
			// verify first element size
			Assert.assertEquals(LoggedInHomePage.sExpectedSecondItemSize,secondItemSize.getText().substring(secondItemSize.getText().length()-1));
			// verify first element price
			Assert.assertEquals(LoggedInHomePage.sExpectedFirstItemPrice,firstItemPrice.getText());
			// verify second element price
			Assert.assertEquals(LoggedInHomePage.sExpectedSecondItemPrice,secondItemPrice.getText());
		    
			//verify total products
			Double sumOfTotalProducts = Double.parseDouble(firstItemPrice.getText().replaceAll("[$,]", ""))+Double.parseDouble(secondItemPrice.getText().replaceAll("[$,]", ""));
		    Assert.assertTrue("Total Products not matched with item price total", String.valueOf(sumOfTotalProducts).contains(totalProducts.getText().replaceAll("[$,]", "")));
		    
		    //verify total
		    Double totalPriceInclShipping =  Double.parseDouble(totalProducts.getText().replaceAll("[$,]", ""))+Double.parseDouble(totalShipping.getText().replaceAll("[$,]", "")); 
		    Assert.assertEquals(String.valueOf(totalPriceInclShipping),total.getText().replaceAll("[$,]",""));
		    
		    //click continue shopping
		    click(continueShopping, "continueShopping", 15);
		    waitForPageToLoad();
		    //click address continue shopping
		    click(continueShoppingShippingAddress, "continueShoppingAddrs", 15);
		    waitForPageToLoad();
		    //click shipping continue shopping
		    nativeClick(termsCheckBox, "termsCheckBox", 15);
		    click(continueShoppingShippingAddress, "continueShoppingShipping", 15);
		    waitForPageToLoad();
		    click(payByBankWire, "payByBankWire", 15);
		    //click I confirm my order
		    click(continueShoppingShippingAddress, "I Confirm My Order", 15);
		    waitForPageToLoad();
		    LoggedInHomePage loggedInHomePage = new LoggedInHomePage(driver);
			return loggedInHomePage;
		}
		
	
	

}
