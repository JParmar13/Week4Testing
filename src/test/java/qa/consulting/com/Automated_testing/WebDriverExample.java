package qa.consulting.com.Automated_testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample {

	private String url = "http://www.google.com";
	private WebDriver webDriver;
	
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		webDriver.quit();
	}
	
	@Test
	public void qaTest() {
		webDriver.navigate().to(url);
		WebElement searchBar = webDriver.findElement(By.cssSelector("#lst-ib"));
		searchBar.sendKeys("qa \n");
		WebElement targetSite = webDriver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div:nth-child(1) > div > div > h3 > a"));
		targetSite.click();
		String currentUrl = webDriver.getCurrentUrl();
		String expectedUrl = "https://www.qa.com/";
		
		Assert.assertEquals(expectedUrl, currentUrl);
	}
	
}
