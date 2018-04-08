package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class UserActions {
    public WebDriver driver;
    public Properties properties=new Properties();
	public UserActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	/**
	 * gets specified property value from TestData.properties file 
	 * @param sKey
	 * return {@link String}
	 */
	public String getConfigProperty(String sKey){
		String sKeyValue=null;
		   try {
			FileInputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestData"+File.separator+"TestData.properties"));
		    properties.load(inputStream);
		     sKeyValue = properties.getProperty(sKey);
		   } catch (Exception e) {
			e.printStackTrace();
		}
		return sKeyValue;
	}
	
	/**
	 * Returns a webelement based on index from the list of webelements 
	 * @param listXpath
	 * @param iElementIndex
	 * @return {@link WebElement}
	 */
	public WebElement getListWebElement(String listXpath,int iElementIndex){
		List<WebElement> list = driver.findElements(By.xpath(listXpath));
		WebElement listElement = list.get(iElementIndex);
		return listElement;
	}
	
	/**
	 * Clicks on webelement using javascript executor
	 * @param element
	 * @param sElementName
	 * @param iWaitTime
	 */
			
	public void nativeClick(WebElement element, String sElementName, int iWaitTime){
		waitForPageToLoad();
		try{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail("Error occured while native click on "+sElementName);
		}

	}
	
	
	/**
	 * Enters key input in text box 
	 * @param element
	 * @param sElementName
	 * @param sInputValue
	 */
	public void type(WebElement element,String sElementName, String sInputValue){
		try{
			waitForElementToLoad(element,sElementName, 10);
			element.clear();
			element.sendKeys(sInputValue);
		}catch(Exception exception){
			exception.printStackTrace();
		}	
	}
	
	/**
	 * Navigates to application URL
	 */
	public void getToUrl(String sURL){
		driver.get(sURL);
		waitForPageToLoad();
	}
	
	/**
	 * Hovers the mouse on passed webelement
	 * @param HoverElement
	 * @param sHoverEleName
	 */
public void mouseHover(WebElement HoverElement,String sHoverEleName){
	try{
	Actions builder = new Actions(driver);
    builder.moveToElement(HoverElement).build().perform();}
	catch(Exception e){
		e.printStackTrace();
		Assert.fail("Error occured while hovering "+HoverElement);
	}

}

/**
 * Selects an option from the dropdown
 * @param element
 * @param sSize
 */
public void selectDropdown(WebElement element, String sSize ){
	//waitForElementToLoad(element, "dropdown select", 15);	
	Select dropdown = new Select(element);
		dropdown.selectByVisibleText(sSize);	
}

/**
 * Returns first selected option from a dropdown
 * @param dropDownElement
 * @return
 */
public String getFirstSelectedOption(WebElement dropDownElement){
	Select dropdown = new Select(dropDownElement);
	String firstOption =  dropdown.getFirstSelectedOption().getText();
	return firstOption;
}

/**
 * Switches to passed iframe
 * @param element
 */
public void swithToFrame(WebElement element){
	driver.switchTo().frame(element);
	waitForPageToLoad();
	}

/**
 * Comes out of the iframe
 */
public void swithToDefalutContent(){
	driver.switchTo().defaultContent();
	}


	
	/**
	 * Purpose- This function lets the webdriver wait until the page loads
	 * completely
	 * @throws TimeoutException
	 */
	public boolean waitForPageToLoad() 
	{
		System.out.println("Waiting for page to load");
		try {
			int waitTime = 0;
			boolean isPageLoadComplete = false;
			do {
				isPageLoadComplete = ((String) ((JavascriptExecutor) driver)
						.executeScript("return document.readyState")).equals("complete");
				Thread.sleep(1000);
				waitTime++;
				if (waitTime > 250) {
					break;
				}
			} while (!isPageLoadComplete);
			{
			}
			// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(waitString)));
		} catch (TimeoutException e) {
			return false;
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	/**
	 * Method -  Method for User Click, waits until the element is loaded
	 * and then performs a click action
	 * 
	 * @param element
	 * @param waitTime
	 */

	public void click(WebElement element, String sElementName, int optionWaitTime) {
		try {
			waitForElementToLoad(element, sElementName, optionWaitTime);
			//setHighlight(element);
			element.click();
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			Assert.fail("Element " + sElementName + " is not attached to the page document");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("Element " + sElementName + " was not found in DOM");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Some Exception occured while clicking on "+sElementName);

		}
					
					}
	
	/**
	 * Web driver waits for visibility of specified web element for the amount
	 * of time specified.
	 * 
	 * @param element
	 * @param sElementName
	 * @param waitTime
	 * @return true or false
	 */
	public boolean waitForElementToLoad(WebElement element, String sElementName, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			
			e.printStackTrace();
			Assert.fail("Element " + sElementName + " was not visible in time - " + waitTime);
			return false;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("Element " + element + "is not attached to the page document");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to find the element " + sElementName);
			return false;
		}
		return true;
	}
	
	/**
	 * Returns true if the webelemnt is presents on webpage
	 * @param element
	 * @param sElementName
	 * @param waitTime
	 * @return
	 * @throws UnreachableBrowserException
	 */
	public boolean isElementPresent(WebElement element, String sElementName, int waitTime)
			throws UnreachableBrowserException {
		boolean bFlag = false;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed() || element.isEnabled()) {
				bFlag = true;
			
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("- No such element as " + sElementName);
		} catch (TimeoutException e) {
			e.printStackTrace();
			Assert.fail("- Timed out after waiting for the element " + sElementName);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Element for " + sElementName + " is not displayed");
		}
		return bFlag;
	}
	
	/**
	 * Returns true if the webelement is present on webpage
	 * @param locator
	 * @param waitTime
	 * @return
	 */
	public boolean isElementPresent(By locator, int waitTime)
	{    	
    	boolean bFlag = false;	
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 			
			if(driver.findElement(locator).isDisplayed()||driver.findElement(locator).isEnabled())
			{
				bFlag = true;
			}
		}		
		catch (NoSuchElementException e)
		{
			e.printStackTrace();		
		}
		catch (TimeoutException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail("Element " + locator + " is not displayed");
		}
	
		return bFlag;
	}
	
	
}


