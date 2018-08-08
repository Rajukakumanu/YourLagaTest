package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
 
/**
 * This class consists implemented methods of WebDriverEventListener interface.
 * Prints logger messages in console for different WebDriver events 
 * @author Praveen Kadambari
 *
 */
public class EventHandler implements WebDriverEventListener {

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		
	}
 
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		ShareDriver.log.info("Clicked on " + ElementValue(element));
	}
 
	public void afterNavigateBack(WebDriver driver) {
		
		ShareDriver.log.info("Navigated back to " + driver.getCurrentUrl());
	}
 
	public void afterNavigateForward(WebDriver driver) {
		
		ShareDriver.log.info("Navigated forward to " + driver.getCurrentUrl());
	}
 
	public void afterNavigateTo(String URL, WebDriver driver) {
		
		ShareDriver.log.info("Navigated to " + URL);
	}

 
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		
	}
 
	public void beforeClickOn(WebElement element, WebDriver driver) {
		
		ShareDriver.log.info("Trying to click on " + ElementValue(element));
 
	}
 
	public void beforeNavigateBack(WebDriver driver) {
		
		ShareDriver.log.info("Navigating back to " + driver.getCurrentUrl());
 
	}
 
	public void beforeNavigateForward(WebDriver driver) {
		
		ShareDriver.log.info("Navigating forward to " + driver.getCurrentUrl());
 
	}
 
	public void beforeNavigateTo(String URL, WebDriver arg1) {
		
		ShareDriver.log.info("Navigating to " + URL);
	}
 

	public void onException(Throwable exception, WebDriver driver) {
		
		ShareDriver.log.info("Exception occured at " + exception.getMessage());
 
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		
		
	}
	
	public static String ElementValue(WebElement element) {
		String sValue = element.toString();
		int iStartindex = sValue.indexOf(">");
		int iEndindex = sValue.lastIndexOf("]");
		String sElementValue = sValue.substring(iStartindex + 1, iEndindex);
		return sElementValue;
	}

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
}
