package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.HomePageLocators;
import utilities.UserActions;

public class HomePage extends UserActions implements HomePageLocators{
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
		
	
	@FindBy (xpath=SIGN_IN_BTN)
	WebElement signInBtn;
	
	
	public SignInPage logInToYourLaga() {
		getToUrl(getConfigProperty("AppURL"));
		
		click(signInBtn,"signInBtn",10);
		SignInPage signInPage = new SignInPage(driver);
		
		return signInPage;
	}

}
