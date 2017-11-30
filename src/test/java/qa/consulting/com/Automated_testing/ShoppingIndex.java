package qa.consulting.com.Automated_testing;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ShoppingIndex {

	private String url = "http://automationpractice.com/index.php";
	private WebDriver webDriver;
	private static ExtentReports report;
	private ShoppingPage shoppingPage;
	private AddToCart addToCartPage;
	private Actions builder;

	@BeforeClass
	public static void init() {
		report = new ExtentReports();
		String fileName = "MyReportForShoppingPage" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));

	}

	@Before
	public void setUp() {

		webDriver = new ChromeDriver();
		//webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		builder = new Actions(webDriver);
	}
	@Ignore
	@Test
	public void loginTest() throws InterruptedException, IOException {

		SpreadSheetReader ssReader = new SpreadSheetReader("shoppingspreadsheet.xlsx");
		ExtentTest test = report.createTest("First run of shopping page");
		webDriver.navigate().to(url);
		shoppingPage = PageFactory.initElements(webDriver, ShoppingPage.class);

		try {
			shoppingPage.navigateToSignIn();
			test.log(Status.INFO, "Navigating to sign in page");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error trying to connect to sign in page");
			e.printStackTrace();
		}

		String userEmail = ssReader.readRow(0, "sheet1").get(1);
		String userFirstName = ssReader.readRow(1, "sheet1").get(1);
		String userLastName = ssReader.readRow(2, "sheet1").get(1);
		String userPassword = ssReader.readRow(3, "sheet1").get(1);

		// String userDateOfBirth = ssReader.readRow(4, "sheet1").get(1);
		// String[] dobArray = userDateOfBirth.split("/");
		// String userDayOfBirth = dobArray[0];
		// System.out.println(userDayOfBirth);
		// String userMonthOfBirth = dobArray[1];
		// System.out.println(userMonthOfBirth);
		// String userYearOfBirth = dobArray[2];
		// System.out.println(userYearOfBirth);

		String userAddress = ssReader.readRow(5, "sheet1").get(1);
		String userCity = ssReader.readRow(6, "sheet1").get(1);
		String userState = ssReader.readRow(7, "sheet1").get(1);
		String userPostcode = ssReader.readRow(8, "sheet1").get(1).substring(0, 5);

		String userCountry = ssReader.readRow(9, "sheet1").get(1);
		String userMobilePhone = ssReader.readRow(10, "sheet1").get(1);
		String userAddressAlias = ssReader.readRow(11, "sheet1").get(1);

		try {
			shoppingPage.enterEmailCreateAccount(userEmail);
			test.log(Status.INFO, "Inputting email address");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error inputting information");
			e.printStackTrace();
		}

		try {
			shoppingPage.createAccountButtonSignIn();
			test.log(Status.INFO, "Navigating towards create account page");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error trying to click create account");
			e.printStackTrace();
		}

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		try {
			shoppingPage.selectGender();
			test.log(Status.INFO, "Selecting Gender");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error selecting gender");
			e.printStackTrace();
		}		
		
		try {
			shoppingPage.enterPersonalFirstName(userFirstName);
			test.log(Status.INFO, "Setting users first name");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error setting first name");
			e.printStackTrace();
		}
		

		
		try {
			shoppingPage.enterPersonalLastName(userLastName);
			test.log(Status.INFO, "Setting users last name");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error setting last name");
			e.printStackTrace();
		}
		

		
		try {
			shoppingPage.enterPersonalPassword(userPassword);
			test.log(Status.INFO, "Setting the users password");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error setting the users password");
			e.printStackTrace();
		}
		// shoppingPage.enterDayOfBirth(userDayOfBirth);
		//
		// shoppingPage.enterMonthOfBirth(userMonthOfBirth);
		//
		// shoppingPage.enterYearOfBirth(userYearOfBirth);

		

		try {
			shoppingPage.enterAddressFirstName(userFirstName);
			test.log(Status.INFO, "Setting the first name");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error setting first name");
			e.printStackTrace();
		}
		

		
		try {
			shoppingPage.enterAddressLastName(userLastName);
			test.log(Status.INFO, "Setting the last name");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error setting last name");
			e.printStackTrace();
		}
		

		
		try {
			shoppingPage.enterAddress(userAddress);
			test.log(Status.INFO, "Entering the users address");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error setting the users address");
			e.printStackTrace();
		}
		

		
		try {
			shoppingPage.enterAddressCity(userCity);
			test.log(Status.INFO, "Entering the users city");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error setting the users city");
			e.printStackTrace();
		}
		

		
		try {
			shoppingPage.enterAddressState(userState);
			test.log(Status.INFO, "Entering the users state : Alabama");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error setting users state");
			e.printStackTrace();
		}
		

		
		try {
			shoppingPage.enterAddressPostCode(userPostcode);
			test.log(Status.INFO, "Setting the users ZIPCODE");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error setting the users Zip Code");
			e.printStackTrace();
		}
		// shoppingPage.enterAddressCountry(userCountry);

		 // Validate phone number to be 11 digits

		
		try {
			shoppingPage.enterAddressMobilePhone(userMobilePhone);
			test.log(Status.INFO, "Entering the users mobile phone");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error entering the users mobile phone");
			e.printStackTrace();
		}
		

		
		try {
			shoppingPage.enterAddressAlias(userAddressAlias);
			test.log(Status.INFO, "Entering the users alias address");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error entering the users alias address");
			e.printStackTrace();
		}
		

		
		try {
			shoppingPage.registerUser();			
			String fullname = userFirstName + " " + userLastName;			
			assertEquals(fullname, shoppingPage.userNameNavbar.getText());
			test.log(Status.PASS, "Successfully passed creating and registering a new user account");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "SuccessUserRegister"));
		} catch (Exception e) {
			test.log(Status.FAIL, "Failure to successfully register and create a new user account");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "FailureUserRegister"));
			e.printStackTrace();
		}
		
		
		
		
	}

	@Test
	public void logIn() throws IOException {

		SpreadSheetReader ssReader = new SpreadSheetReader("shoppingspreadsheet.xlsx");
		ExtentTest test = report.createTest("Attempting to log in the shopping site");
		webDriver.navigate().to(url);
		shoppingPage = PageFactory.initElements(webDriver, ShoppingPage.class);

		try {
			shoppingPage.navigateToSignIn();
			test.log(Status.INFO, "Navigating to sign in page");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error trying to connect to sign in page");
			e.printStackTrace();
		}

		
		try {
			logInMethod(ssReader);			
			assertEquals("Blobby Dee", shoppingPage.userNameNavbar.getText());
			test.log(Status.PASS, "Successfully logged in");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "SuccessfulLogIn"));
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to log in");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "FailureLogIn"));
			e.printStackTrace();
		}
		
		
		
		

	}

	@Test
	public void AddToCartTest() throws InterruptedException, IOException {

		SpreadSheetReader ssReader = new SpreadSheetReader("shoppingspreadsheet.xlsx");
		ExtentTest test = report.createTest("First run of shopping page");
		webDriver.navigate().to(url);
		addToCartPage = PageFactory.initElements(webDriver, AddToCart.class);
		String additionalComment = "I hope my products are swiftly and safely, thank you for your time and service!";

		try {
			addToCartPage.navigateToTShirts();
			test.log(Status.INFO, "Navigate to T-Shirts page");
		} catch (Exception e1) {
			test.log(Status.ERROR, "Error navigating to T-shirts page");
			e1.printStackTrace();
		}

		try {
			builder.moveToElement(addToCartPage.fadedShortSleeve).click(addToCartPage.addTShirt).build().perform();
			test.log(Status.INFO, "Added T-shirt to cart");
		} catch (Exception e1) {
			test.log(Status.ERROR, "Error adding the T-shirt to the cart");
			e1.printStackTrace();
		}

		
		try {
			addToCartPage.proceedToCartSummary();
			test.log(Status.INFO, "Navigate to cart summary");
		} catch (Exception e1) {
			test.log(Status.ERROR, "Error navigating to cart summary");
			e1.printStackTrace();
		}

		try {
			addToCartPage.proceedToCheckout();
			test.log(Status.INFO, "Navigate to checkout page");
		} catch (Exception e1) {
			test.log(Status.ERROR, "Error navigating to checkout page");
			e1.printStackTrace();
		}

		Thread.sleep(2000);

		try {
			logInMethod(ssReader);
			test.log(Status.PASS, "Successfully logged in");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to log in");
			e.printStackTrace();
		}

		try {
			addToCartPage.additionalCommentBox(additionalComment);
			test.log(Status.INFO, "Adding comment to additional comment box");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error adding additional comment");
			e.printStackTrace();
		}

		Thread.sleep(2000);

		try {
			addToCartPage.proceedToShipping();
			test.log(Status.INFO, "Navigating to shipping page");
		} catch (Exception e) {
			test.log(Status.ERROR, "Error navigating to shipping page");
			e.printStackTrace();
		}

		try {
			builder.moveToElement(addToCartPage.agreeToTerms).click(addToCartPage.agreeToTerms);
			webDriver.findElement(By.id("cgv")).click();
			Thread.sleep(1000);

			addToCartPage.proceedToPayment();
			test.log(Status.INFO, "Navigating to payment page");
		} catch (Exception e) {
			test.log(Status.DEBUG, "Failure to navigate to payment page, check agree term box");
			e.printStackTrace();
		}

		try {
			addToCartPage.useBankWirePaymentMethod();
			test.log(Status.INFO, "Bank wire payment method selected");
		} catch (Exception e) {
			test.log(Status.ERROR, "Failed to select payment method");
			e.printStackTrace();
		}

		String expected = addToCartPage.orderComplete.getText();
		String actual = "Your order on My Store is complete";
		
		
		
		try {
			addToCartPage.confirmCart();
			assertEquals(expected, actual);
			test.log(Status.PASS, "Successfully purchased T-shirt!");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "SuccessfulCartPurchase"));
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to purchase item");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "FailureCartPurchase"));
			e.printStackTrace();
		}
		
	
		

	}

	private void logInMethod(SpreadSheetReader ssReader) {

		shoppingPage = PageFactory.initElements(webDriver, ShoppingPage.class);

		String userEmail = ssReader.readRow(0, "sheet1").get(1);
		String userPassword = ssReader.readRow(3, "sheet1").get(1);

		shoppingPage.enterRegisteredEmail(userEmail);

		shoppingPage.enterRegisteredPassword(userPassword);

		shoppingPage.userLogIn();

		
		
		
	}

//	 @After
//	 public void tearDown() {
//	 webDriver.quit();
//	
//	 }

	@AfterClass
	public static void cleanUp() {
		report.flush();
	}
}
