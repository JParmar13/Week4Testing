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

public class Slider {


	private String url = "http://demoqa.com/slider/";
	private WebDriver webDriver;
	private static ExtentReports report;
	private Actions builder;
	private SliderPageObjects sliderPage;
	
	
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
		
		
		sliderPage = PageFactory.initElements(webDriver, SliderPageObjects.class);
		
		ExtentTest test = report.createTest("Selectable test");
		
		webDriver.navigate().to(url);
		
		Thread.sleep(3000);
		
		builder.moveToElement(sliderPage.rangeSlider).clickAndHold(sliderPage.rangeSlider).moveByOffset(200, 0)
		.release().perform();
			
		String sliderValue = sliderPage.rangeSlider.getAttribute("value");
		
		System.out.println(sliderValue);
		
		
		Assert.assertEquals("3", sliderValue);
		
		
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
