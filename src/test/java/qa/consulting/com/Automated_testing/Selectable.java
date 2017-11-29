package qa.consulting.com.Automated_testing;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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


public class Selectable {

	private String url = "http://demoqa.com/selectable/";
	private WebDriver webDriver;
	private static ExtentReports report;
	private Actions builder;
	private SelectableObjects selectablePage;
	
	@BeforeClass	
	public static void init() {
		report = new ExtentReports();
		String fileName = "MyReportForSelectActions" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
				
    }
	
	@Before	
	public void setUp() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		builder = new Actions(webDriver);
	}	
	
	@Test
	public void draggableDefaultTest() throws InterruptedException {
		//Default functionality test
		
		
		selectablePage = PageFactory.initElements(webDriver, SelectableObjects.class);
		
		ExtentTest test = report.createTest("Selectable test");
		
		webDriver.navigate().to(url);
		
		Thread.sleep(3000);
		
		try {
			builder.clickAndHold(selectablePage.sliderItem1)
			.moveToElement(selectablePage.sliderItem7)
			.release()
			.build()
			.perform();
			
			test.log(Status.INFO, "Cursor has selected elements");
		} catch (Exception e) {
			test.log(Status.ERROR, "Cursor did not select elements");
			e.printStackTrace();
		}
		
		
		String currentColourSlider = selectablePage.sliderItem7.getCssValue("background-color");
		
		try {
			Assert.assertEquals("rgba(243, 152, 20, 1)", currentColourSlider);
			test.log(Status.PASS, "Successfully selected elements, dragged and match colour");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed test, failure to select all elements and match colour");
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
