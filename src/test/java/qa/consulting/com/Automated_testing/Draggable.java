package qa.consulting.com.Automated_testing;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	private ConstrainMovement constrainMovement;
	private CursorStyle cursorStylePage;
	
	@BeforeClass	
	public static void init() {
		report = new ExtentReports();
		String fileName = "MyReportForMouseActions" + ".html";
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
		
		ExtentTest test = report.createTest("Draggable default test");
		
		webDriver.navigate().to(url);
		
		Point firstPosition = draggableDefault.draggableSquare.getLocation();
		
		try {
			builder.clickAndHold(draggableDefault.draggableSquare).moveByOffset(60, 20).release().perform();
			test.log(Status.INFO, "Square has been moved");
		} catch (Exception e) {
			test.log(Status.ERROR, "Square has not been moved");
			e.printStackTrace();
		}
		
		Point currentPosition = draggableDefault.draggableSquare.getLocation();
		
		try {
			Assert.assertTrue(checkPosition(firstPosition, currentPosition));
			test.log(Status.PASS, "Object dragged successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Object did not drag successfully");
			e.printStackTrace();
		}
		
	}		
	
	@Test
	public void constrainMovementTest() throws IOException {
		//Constrain movement test
		
		constrainMovement = PageFactory.initElements(webDriver, ConstrainMovement.class);
		ExtentTest test = report.createTest("Constrain movement test");
		webDriver.navigate().to(url);		
		
		try {
			constrainMovement.navigateToConstrain();
			test.log(Status.INFO, "Navigated to constrain movement exercise section");
		} catch (Exception e) {
			test.log(Status.ERROR, "Navigation was unsuccessful");
			e.printStackTrace();
		}
		
		//Horizontal box movement
		
		Point firstHorizontalMovement = constrainMovement.dragHorizontal.getLocation();
		
		try {
			builder.clickAndHold(constrainMovement.dragHorizontal).moveByOffset(60, 0).release().perform();
			test.log(Status.INFO, "Horizontal movement worked");
		} catch (Exception e) {
			test.log(Status.ERROR, "Horizontal movement did not occur");
			e.printStackTrace();
		}
		
		Point newHorizontalMovement = constrainMovement.dragHorizontal.getLocation();		
		
		try {
			Assert.assertTrue(checkPosition(firstHorizontalMovement, newHorizontalMovement));
			test.log(Status.PASS, "Object dragged horizontally successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "SuccessHorizontalDrag"));
		} catch (Exception e) {
			test.log(Status.FAIL, "Object did not drag horizontally successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "FailureHorizontalDrag"));
			e.printStackTrace();
		}
		
		//Vertical box movement		
		
		Point firstVerticalPosition = constrainMovement.dragVertical.getLocation();
		
		try {
			builder.clickAndHold(constrainMovement.dragVertical).moveByOffset(0, 60).release().perform();
			test.log(Status.INFO, "Vertical movement worked");
		} catch (Exception e) {
			test.log(Status.ERROR, "Vertical movement did not occur");
			e.printStackTrace();
		}
		
		Point newVerticalPosition = constrainMovement.dragHorizontal.getLocation();
		
		
		try {
			Assert.assertTrue(checkPosition(firstVerticalPosition, newVerticalPosition));
			test.log(Status.PASS, "Object dragged vertically successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "SuccessVerticalDrag"));
		} catch (Exception e) {
			test.log(Status.FAIL, "Object did not drag vertically successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "FailureVerticalDrag"));
			e.printStackTrace();
		}
		
		//Contained in box movement
		
		Point initialInABoxPosition = constrainMovement.dragInABox.getLocation();
		
		try {
			builder.clickAndHold(constrainMovement.dragInABox).moveByOffset(300 , 15).release().perform();
			test.log(Status.INFO, "Box is being dragged");
		} catch (Exception e) {
			test.log(Status.ERROR, "Box is not being dragged");
			e.printStackTrace();
		}
		
		Point newInABoxPosition = constrainMovement.dragInABox.getLocation();
		
		try {
			Assert.assertTrue(checkPosition(initialInABoxPosition, newInABoxPosition));
			test.log(Status.PASS, "Object dragged within the box successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "SuccessInABoxDrag"));
		} catch (Exception e) {
			test.log(Status.FAIL, "Object did not drag successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "FailureInABoxDrag"));
			e.printStackTrace();
		}
		
		// Movement within DOM element
		
		Point initialContainedSquarePosition = constrainMovement.dragWithinParent.getLocation();

		try {
			builder.clickAndHold(constrainMovement.dragWithinParent).moveByOffset(0, 64).release().perform();
			test.log(Status.INFO, "Contained square successfully moved upwards within element");
		} catch (Exception e) {
			test.log(Status.ERROR, "Contained square movement upwards did not occur");
			e.printStackTrace();
		}

		try {
			builder.clickAndHold(constrainMovement.dragWithinParent).moveByOffset(0, -64).release().perform();
			test.log(Status.INFO, "Contained square successfully moved downwards within element");
		} catch (Exception e1) {
			test.log(Status.ERROR, "Contained square did not move downwards accordingly");
			e1.printStackTrace();
		}

		Point reverseContainedSquarePosition = constrainMovement.dragWithinParent.getLocation();

		try {
			builder.clickAndHold(constrainMovement.dragWithinParent).moveByOffset(0, 64).release().perform();
			test.log(Status.INFO, "Contained square successfully moved upwards within element");
		} catch (Exception e) {
			test.log(Status.ERROR, "Contained square movement upwards did not occur");
			e.printStackTrace();
		}

		Point newContainedSquarePosition = constrainMovement.dragWithinParent.getLocation();

		try {
			Assert.assertTrue(checkPosition(initialContainedSquarePosition, newContainedSquarePosition));
			Assert.assertTrue(checkPosition(reverseContainedSquarePosition, newContainedSquarePosition));
			test.log(Status.PASS, "Contained square dragged within reach upwards and downwards successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "SuccessWithinParentDrag"));
		} catch (Exception e) {
			test.log(Status.FAIL, "Contained square did not drag upwards and downwards successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "FailureWithinParentDrag"));
			e.printStackTrace();
		}
			
		
	}
	
	@Test
	public void cursorStyleTest() throws IOException {
		
		// Cursor Style tests
		
		cursorStylePage = PageFactory.initElements(webDriver, CursorStyle.class);
		ExtentTest test = report.createTest("Cursor style test");
		webDriver.navigate().to(url);		
		
		try {
			cursorStylePage.navigateToCursorStyle();
			test.log(Status.INFO, "Navigated to cursor style exercise section");
		} catch (Exception e) {
			test.log(Status.ERROR, "Navigation was unsuccessful");
			e.printStackTrace();
		}
		
		Point cursorTopLeftInitial = cursorStylePage.cursorStyleTopLeft.getLocation();
		
		
		try {
			builder.clickAndHold(cursorStylePage.cursorStyleTopLeft).moveByOffset(180, 150).release().perform();
			test.log(Status.INFO, "");
		} catch (Exception e) {
			test.log(Status.ERROR, "");
			e.printStackTrace();
		}
		
		Point cursorStyleTopLeftPosition = cursorStylePage.cursorStyleTopLeft.getLocation();
		System.out.println(cursorStyleTopLeftPosition);
		
		int a = cursorTopLeftInitial.x;
		int b = cursorTopLeftInitial.y;
		
		int x = cursorStyleTopLeftPosition.x;
		int y = cursorStyleTopLeftPosition.y;
		Point cursorStyleModified = new Point(x - 55, y - 55);
		Point cursorToCompare = new Point(a + 180, b + 150);
		
		
		try {
			Assert.assertEquals(cursorToCompare, cursorStyleModified);
			test.log(Status.PASS, "Object dragged within the box successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "Successfully compared"));
		} catch (Exception e) {
			test.log(Status.FAIL, "Object did not drag successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "Failure to compare the cursor element"));
			e.printStackTrace();
		}
		
		// Cursor center alignmen
		
		Point cursorStyleCenterInitial = cursorStylePage.cursorStyleCenter.getLocation();
		
		try {
			builder.clickAndHold(cursorStylePage.cursorStyleCenter).moveByOffset(100, 100).release().perform();
			test.log(Status.INFO, "");
		} catch (Exception e) {
			test.log(Status.ERROR, "");
			e.printStackTrace();
		}
		
		Point cursorStyleCenterPosition = cursorStylePage.cursorStyleCenter.getLocation();
		System.out.println(cursorStyleTopLeftPosition);
		
	
		int a1 = cursorStyleCenterInitial.x;
		int b1 = cursorStyleCenterInitial.y;
		
		int x1 = cursorStyleCenterPosition.x;
		int y1 = cursorStyleCenterPosition.y;
		
		Point cursorStyleActual = new Point(x1 -100, y1 - 100);
		Point cursorToCompareCenter = new Point(a1 + 44, b1 + 44);
		
		
		try {
			Assert.assertEquals(cursorToCompareCenter, cursorStyleActual);
			test.log(Status.PASS, "Object dragged within the box successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "Successfully compared"));
		} catch (Exception e) {
			test.log(Status.FAIL, "Object did not drag successfully");
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "Failure to compare the cursor element"));
			e.printStackTrace();
		}
		
		
		
		
		
	}

	public boolean checkPosition(Point firstPosition, Point lastPosition) {
		boolean checkDrag;
		if (firstPosition != lastPosition) {
			checkDrag = true;
		} else {
			checkDrag = false;
		}
		return checkDrag;
	}
	
		
	@After
	public void tearDown() {
		webDriver.quit();
	}

	@AfterClass
	public static void cleanUp() {
		report.flush();
	}
		
		
		
		
		//Cursor style test
		
		
		
		//Events test
		
		
		
		//Draggable + Sortable test
		
	
	
	
	
	
	
	
	
	
	
	
	
	//@AfterClass
	
	
	
	
	
}
