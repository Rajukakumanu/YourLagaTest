package pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.OrderHistoryLocators;
import utilities.UserActions;

public class OrderHistory extends UserActions implements OrderHistoryLocators{

	private WebDriver driver;
	private List<WebElement> itemReference;
	private String sComment;
	
	public OrderHistory(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name=COMMENT_TXT_BOX)
	WebElement commentTxtBox;
	
	@FindBy(name=SUBMIT_MESSAGE)
	WebElement submitMessage;
	
    @FindBy(xpath=FIRST_PRODUCT_COLOR)
    WebElement firstProductColor;
    
    @FindBy(xpath = ITEM_ROW)
    WebElement itemRow;
    
    
    
    
	public void selectOrderAndAddComment() {
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy:MM:dd:HH:mm:ss"); 
	        LocalDateTime now = LocalDateTime.now();
	        
		itemReference = driver.findElements(By.xpath("//td[contains(text(), '"+getConfigProperty("OrderDate")+"')]/../td//a[@class='color-myaccount']"));
	    click(itemReference.get(0), "Order Reference", 15);
	    waitForPageToLoad();
	    
	   
	     sComment ="This is a test comment at "+dtf.format(now);
	    System.out.println("Comment Entered "+sComment);
	    //write comment
	    type(commentTxtBox, "commentTxtBox",sComment);
	    waitForPageToLoad();
	    //submit message
	    nativeClick(submitMessage, "submitMessage", 15);
	    waitForPageToLoad();
	}

	public void verifyMessage() {
	   waitForPageToLoad();
	   By xpath = By.xpath("//td[text()='"+sComment+"']");
	   boolean isMessageAppeared = isElementPresent(xpath, 20);
	   // Verify the entered message is displayed on the webpage or not
		Assert.assertTrue("Entered Message Not Appeared under Messages.", isMessageAppeared);
	
	}

	public void verifyItemColor() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", itemRow);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   // Verify the first Item color is Red or not
       Assert.assertTrue("Ordered Item Color is not Red",firstProductColor.getText().contains(getConfigProperty("colorName")) );
	}

}
