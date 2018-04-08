package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features",
glue = { "stepdefination" }, 
plugin = { "pretty","html:target/cucumber-html-report","json:maven-cucumber-report/cucumber-json-report/cucumber.json"}, 
tags = { "@AddProducts,@AddMessage,@CaptureScreenGrab" })
public class YourLagaTestRunner {
	
}