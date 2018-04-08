package stepdefination;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.LoggedInHomePage;

public class Hooks {
	
	public static WebDriver driver;
	
	
@Before

public void projectStart() {
	
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"chromedriver.exe");
	
	driver =new ChromeDriver();
	//driver =new FirefoxDriver();
	driver.manage().deleteAllCookies();
	
	driver.manage().window().maximize();
	
}




@After

public void projectLast(Scenario scenario){
	if(scenario.isFailed()){
		  final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.embed(screenshot, "image/png");
	      saveScreenShotToReports();
		}
	LoggedInHomePage loggedInHomePage = new LoggedInHomePage(driver);
	loggedInHomePage.logOut();
	driver.quit();
}




private void saveScreenShotToReports() {
	try{
	 TakesScreenshot scrShot =((TakesScreenshot)driver);

     //Call getScreenshotAs method to create image file

             File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

         //Move image file to new destination
             
             File DestFile=new File(System.getProperty("user.dir")+File.separator+"maven-cucumber-report"+File.separator+"FailureScreenGrab.png");

             //Copy file at destination

             FileUtils.copyFile(SrcFile, DestFile);

	}catch(Exception e){
		e.printStackTrace();
	}
}
}
