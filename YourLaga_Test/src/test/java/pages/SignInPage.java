package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.SignInPageLocators;
import utilities.UserActions;

public class SignInPage extends UserActions implements SignInPageLocators{
    private WebDriver driver;
    
	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy( xpath=EMAIL_TXT_BOX)
	WebElement emailTxtBox;
	
	@FindBy( xpath=PWD_TXT_BOX)
	WebElement pwdTxtBox;
	
	@FindBy( css=SUBMIT_BUTTON)
	WebElement submitButton;
	
	
	
	
	public LoggedInHomePage enterCredentialsAndLogin() {

		LoggedInHomePage  loggedInHomePage =null;
		try{
	    
	      type(emailTxtBox,"emailTxtBox",getConfigProperty("Uname"));
		  type(pwdTxtBox,"pwdTxtBox",getConfigProperty("Pwd"));
		 click(submitButton, "submitButton", 10);
	     waitForPageToLoad();
	  loggedInHomePage = new LoggedInHomePage(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	return loggedInHomePage;
		
	
	}
	
		

}
