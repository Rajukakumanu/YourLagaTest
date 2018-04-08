package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.MyAccountLocators;
import utilities.UserActions;

public class MyAccount extends UserActions implements MyAccountLocators{
    private WebDriver driver;
	
	public MyAccount(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=ORDERHISTORY_AND_DETAILS)
	WebElement orderHistoryAndDetails;

	public OrderHistory viewMyPreviousOrders() {
		 click(orderHistoryAndDetails, "orderHistoryAndDetails", 15);
		 waitForPageToLoad();
		 OrderHistory orderHistory = new OrderHistory(driver);
		 return orderHistory;
	}
	
	
	
	
	
	
	
	
	
	

}
