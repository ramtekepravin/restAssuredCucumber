package testRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utility.DateTimeUtility;
import utility.SendEmailUtility;

@RunWith(Cucumber.class)

@CucumberOptions
(
   
   features = "src/test/resources/Feature/", //path of feature file
   
   glue = {"stepdefinations"}, //path of step definition file
   
 /*  format ={
	                "pretty",
	                "html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/CucumberTestReport.json"	                
	        },
   
   plugin = {"json:target/cucumber-reports/CucumberTestReport.json"}, */
   
   dryRun = false, 
   
   monochrome = true
     
)

public class TestRunner {
	
/*	DateTimeUtility DateTimeUtil = new DateTimeUtility();
	SendEmailUtility EmailUtil  = new SendEmailUtility();
	// For sending email after Test Execution
	
	@AfterSuite
	public void after_all() throws IOException, InterruptedException {


		List<String> recipients = Arrays.asList("nikhil.darokar@teknopoint.in","akshay.doshi@teknopoint.in");
		String subject = "ProjectName Regression Suite Report - " + DateTimeUtil.generateDate();
		String body = "Please find the attached report for Today's Regression suite. Thank you for your attention to this report, and we look forward to any feedback or insights you may have.";
		String attachmentPath = "./Reports/ProjectName.html";

		try {
			EmailUtil.sendEmailWithAttachment(recipients, subject, body, attachmentPath);
		} catch (MessagingException e) {
			// Handle any exceptions here
			e.printStackTrace();
		}
	} */

}
