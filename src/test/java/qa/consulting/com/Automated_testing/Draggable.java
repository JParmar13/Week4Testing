package qa.consulting.com.Automated_testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class Draggable {

	
	private String url = "http://demoqa.com/draggable/";
	private WebDriver webDriver;
	private static ExtentReports report;
	private Actions builder;
	private DraggableDefault draggableDefault;
	
	@BeforeClass
	
	public static void init() {
		report = new ExtentReports();
		String fileName = "MyReport" + ".html";
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
	public void draggableDefaultTest() {
		//Default functionality test
		
		
		draggableDefault = PageFactory.initElements(webDriver, DraggableDefault.class);
		ExtentTest test = report.createTest("First run");
		
		webDriver.navigate().to(url);
		
//		builder.moveToElement(draggableDefault.dragDefaultSquare(), 0, 0).clickAndHold().moveByOffset(120, 120).perform();
//		
//		builder.moveToElement(draggableDefault.dragDefaultSquare()).clickAndHold().moveByOffset(120, 140).perform();
		
		try {
			builder.moveToElement(draggableDefault.dragDefaultSquare()).clickAndHold().moveByOffset(120, 140).perform();
			test.log(Status.INFO, "It worked!");
		} catch (Exception e) {
			test.log(Status.DEBUG, "Object did not get dragged");
			e.printStackTrace();
		}
		
		Point squareActual = draggableDefault.dragDefaultSquare().getLocation();
		System.out.println(squareActual);
		
		
//		try {
//			Assert.assertEquals(expected, squareActual);
//			
//			
//		} catch (Exception e) {
//			
//			
//			e.printStackTrace();
//		}
		
		
		//builder.dragAndDropBy(draggableDefault.dragDefaultSquare(), 120, 150);
		
		
		
		//builder.clickAndHold(three) .moveByOffset(120, 0) .perform();

		
		
		
		
		
		
		
		
		
		//Constrain movement test
		
		
		
		
		//Cursor style test
		
		
		
		//Events test
		
		
		
		//Draggable + Sortable test
		
		
		
	}
	
	
	
	
	
	//@After
	
	
	
	
	
	
	//@AfterClass
	
	
	
	
	
}
