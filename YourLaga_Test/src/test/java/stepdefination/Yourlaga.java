package stepdefination;


import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CheckOutSummaryPage;
import pages.HomePage;
import pages.LoggedInHomePage;
import pages.MyAccount;
import pages.OrderHistory;
import pages.SignInPage;


public class Yourlaga{
	
	private WebDriver driver = Hooks.driver;
	private HomePage homePage = new HomePage(driver);
	private SignInPage signInPage;
	private LoggedInHomePage loggedInHomePage;
	private CheckOutSummaryPage checkOutSummaryPage;
	private MyAccount myAccount;
	private OrderHistory orderHistory;
	
	@Given("^I login to YourLaga$")
	public void i_login_to_YourLaga() throws Throwable {
		
	   signInPage = homePage.logInToYourLaga();
	   loggedInHomePage = signInPage.enterCredentialsAndLogin();
	   	}
	
	@When("^i QuickView an item$")
	public void i_QuickView_an_item() throws Throwable {
		loggedInHomePage.quickViewAnItem();
	}

	
	@Then("^i change item size to \"([^\"]*)\"$")
	public void i_change_item_size_to(String sSize) throws Throwable {
		loggedInHomePage.changeItemSize(sSize);
	}

	@Then("^i click on AddToCart button$")
	public void i_click_on_AddToCart_button() throws Throwable {
	 loggedInHomePage.clickAddToCart();
	}

	@Then("^click Continue shopping button$")
	public void click_Continue_shopping_button() throws Throwable {
	   loggedInHomePage.clickContinueShopping();
	}
	
	
	@Then("^i click on secondItem quickView and addToCart$")
	public void i_click_on_secondItem_quickView_and_addToCart() throws Throwable {
	    loggedInHomePage.quickViewSecondItem();
	}

	@Then("^i click on Procced to Checkout$")
	public void i_click_on_Procced_to_Checkout() throws Throwable {
		checkOutSummaryPage=loggedInHomePage.proccedToCheckout();
		
	   
	}

	@Then("^Validate Item sizes and it's total$")
	public void validate_Item_sizes_and_it_s_total() throws Throwable {
		loggedInHomePage = checkOutSummaryPage.verifyItemSizesAndTotal();
	}
	
	@Then("^i navigate to order history to view my previous orders$")
	public void i_navigate_to_order_history_to_view_my_previous_orders() throws Throwable {
		myAccount = loggedInHomePage.naviageToMyOrderHistory();
		orderHistory=myAccount.viewMyPreviousOrders();
	}

	@Then("^i select a previous order based on the date \"([^\"]*)\" and add a comment$")
	public void i_select_a_previous_order_based_on_the_date_and_add_a_comment(String sDate) throws Throwable {
		orderHistory.selectOrderAndAddComment();
	}

	@Then("^i verify that the comment appears under 'messages'$")
	public void i_verify_that_the_comment_appears_under_messages() throws Throwable {
	    orderHistory.verifyMessage();
	}
	
	@Then("^i verify that the first products color is \"([^\"]*)\"$")
	public void i_verify_that_the_first_products_color_is(String sColor) throws Throwable {
		orderHistory.verifyItemColor();
	}
	
	

	
	
}