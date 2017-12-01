package qa.consulting.com.Automated_testing;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AutoTraderMain {

	private String url = "https://www.autotrader.co.uk/";
	private WebDriver webDriver;
	private static ExtentReports report;
	private ShoppingPage shoppingPage;
	private AutoTraderNewAndUsedCars autoTraderNewAndUsedPage;
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
		// webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		builder = new Actions(webDriver);
	}

	@Test
	public void newAndUsedCars() throws InterruptedException {

		SpreadSheetReader ssReader = new SpreadSheetReader("autotraderspreadsheet.xlsx");
		ExtentTest test = report.createTest("Test X Auto-Trader");
		webDriver.navigate().to(url);
		autoTraderNewAndUsedPage = PageFactory.initElements(webDriver, AutoTraderNewAndUsedCars.class);

		String inputPostcode = ssReader.readRow(0, "sheet1").get(1);
		String distance = ssReader.readRow(1, "sheet1").get(1);
		String inputDistance = distance.substring(0, distance.length() - 2);

		// String inputShow = ssReader.readRow(2, "sheet1").get(1);

		String inputMake = ssReader.readRow(3, "sheet1").get(1).toUpperCase();
		String inputModel = ssReader.readRow(4, "sheet1").get(1).toUpperCase();

		String minimumPrice = ssReader.readRow(5, "sheet1").get(1);
		String inputMinimumPrice = minimumPrice.substring(0, minimumPrice.length() - 2);
		String maximumPrice = ssReader.readRow(6, "sheet1").get(1);
		String inputMaximumPrice = maximumPrice.substring(0, maximumPrice.length() - 2);

		searchForVehicles(inputPostcode, inputDistance, inputMake, inputModel, inputMinimumPrice, inputMaximumPrice);
		
		String actualCarsFound = autoTraderNewAndUsedPage.carsFound.getText();
		String expectedCarsFound = "12 cars found";
		
		try {
			assertEquals(expectedCarsFound, actualCarsFound);
			test.log(Status.PASS, "Successfully searched for vehicles ");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to search for vehicles");
			e.printStackTrace();
		}
		
		//Need to do test logs, screenshots and further tests
		
		//get results and visit website		
		
		
		
		
		autoTraderNewAndUsedPage.getResult();
		
		autoTraderNewAndUsedPage.visitWebsite();
		
		
		String expectedUrl = "http://www.newarth.com/";
		String currentUrl = webDriver.getCurrentUrl();
		
		try {
			assertEquals(expectedUrl, currentUrl);
			test.log(Status.PASS, "Successfully navigated to the target website");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to navigate to the target website");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		

	}

	private void searchForVehicles(String inputPostcode, String inputDistance, String inputMake, String inputModel,
			String inputMinimumPrice, String inputMaximumPrice) throws InterruptedException {

		autoTraderNewAndUsedPage.setPostcode(inputPostcode);

		autoTraderNewAndUsedPage.setRadius(inputDistance);

		// autoTraderNewAndUsedPage.setSearchCondition(inputShow);

		Thread.sleep(4500);

		autoTraderNewAndUsedPage.setMake(inputMake);

		Thread.sleep(300);

		autoTraderNewAndUsedPage.setModel(inputModel);

		autoTraderNewAndUsedPage.setPriceFrom(inputMinimumPrice);

		autoTraderNewAndUsedPage.setPriceTo(inputMaximumPrice);

		autoTraderNewAndUsedPage.searchNewAndUsedCars();
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
