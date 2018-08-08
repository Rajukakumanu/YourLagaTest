# YourLagaTest
Technical Test

Executing Tests:
1. Run the command 'mvn clean install' on your local machine. (command prompt should point to the project directory where the file POM.xml exists. Maven has to be installed on your local machine in this case)
2. Run as maven or junit test from the IDE (Eclipse/Intellij etc)

Reports:
1. You can find the cucumber-html-reports (only gets generated when run as maven test) under the projecct directory (/YourLaga_Test/maven-cucumber-report/cucumber-html-reports). This report is embedded with failure screen shots too.
2. You can find simple html reports under (target/cucumber-html-report)
3. You can find json reports under (maven-cucumber-report/cucumber-json-report/cucumber.json)

Failure Screen Grab Test:
As per the Test 3, the failure Screen Shot gets generated under 'maven-cucumber-report/FailureScreenGrab.png'. 

Test Data: 
You can find the test data in the file 'TestData.properties' under (/YourLaga_Test/src/test/resources/TestData/TestData.properties)

PropertyConfigurator.configure(FileUtilities.getFileInputStream("src/ConfigFiles/log4j.properties"));
