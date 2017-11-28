package qa.consulting.com.Automated_testing;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class demosite {

	
	private String url = "http://thedemosite.co.uk/";
	private WebDriver webDriver;
	private static ExtentReports report;
	private Homepage homepage;
	private AddAUser adduserpage;
	private LoginPage userloginpage;
	
	
	@BeforeClass
	public static void init() {
		
		
	    report = new ExtentReports();
	    String fileName = "MyReport" + ".html";
	    String filePath = System.getProperty("user.dir")
	             + File.separatorChar + fileName;
	    	report.attachReporter(new ExtentHtmlReporter(filePath));
	    }
	
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
	}
	
	@Test
	public void demositeTest() throws IOException {
		
	
	SpreadSheetReader ssReader = new SpreadSheetReader("sheetholder.xlsx");
		
		homepage = PageFactory.initElements(webDriver, Homepage.class);
		adduserpage = PageFactory.initElements(webDriver, AddAUser.class);
		userloginpage = PageFactory.initElements(webDriver, LoginPage.class);
		
		String usernameSignUp = ssReader.readRow(0, "sheet1").get(1);
		String passwordSignUp = ssReader.readRow(1, "sheet1").get(1);
		
		
		ExtentTest test = report.createTest("First run");
		
		webDriver.navigate().to(url);
		
		try {
			homepage.navigateToAddUser();
			test.log(Status.INFO, "Navigation to user page was successful");
		} catch (Exception e) {
			test.log(Status.FATAL, "Failure to navigate to user page");
		}   
			
		
		
		try {
			adduserpage.signUpUsername(usernameSignUp);
			test.log(Status.INFO, "Successful input for the sign up username field");
		} catch (Exception e1) {
			test.log(Status.WARNING, "User input for signing up in the username field failed");
			e1.printStackTrace();
		}
		
		
		try {
			adduserpage.signUpPassword(passwordSignUp);
			test.log(Status.INFO, "Successful input for the sign up password field");
		} catch (Exception e2) {
			test.log(Status.WARNING, "User input for signing up in the password field failed");
			e2.printStackTrace();
		}		
		
		try {
			adduserpage.saveUserDetails();
			test.log(Status.INFO, "Users details have saved successfully");
		} catch (Exception e1) {
			test.log(Status.ERROR, "Saving the users details has failed!");
			e1.printStackTrace();
		}
		
		
		
		try {
			userloginpage.navigateToLogIn();
			test.log(Status.INFO, "Navigation to login page was successful");
		} catch (Exception e) {
			test.log(Status.FATAL, "Failure to navigate to login page");
			e.printStackTrace();
		} 	
			
				
		try {
			userloginpage.LogInUsername(usernameSignUp);
			test.log(Status.INFO, "Successful input for the login username field");
		} catch (Exception e) {
			test.log(Status.ERROR, "User input for the login username field failed");
			e.printStackTrace();
		}
		
		try {
			userloginpage.LogInPassword(passwordSignUp);
			test.log(Status.INFO, "Successful input for the login password field");
		} catch (Exception e) {
			test.log(Status.ERROR, "User input for the login username field failed");
			e.printStackTrace();
		}
		
		userloginpage.LogIn();
		
		WebElement successfulLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		String logIn = successfulLogin.getText();
		System.out.println(logIn);	
		
		
		
		
		try {
			Assert.assertEquals("**Successful Login**", logIn);
			test.log(Status.PASS, "Log in successful, run was successful");
			
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "success"));
		} catch (Exception e) {
			
			test.log(Status.FAIL, "Log in failed, run was a failure");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "fail"));
			e.printStackTrace();
		}
				
		
		
		
		
		
		
		
        }
	

	
	
	
	
     @After
     	public void tearDown() {
    	 webDriver.quit();
     	}
	
	
	 @AfterClass
	    public static void cleanUp() {
	        report.flush();
	  	}
	
	
}
