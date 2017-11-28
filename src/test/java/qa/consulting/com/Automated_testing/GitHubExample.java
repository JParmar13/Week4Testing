package qa.consulting.com.Automated_testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitHubExample {

	private String url = "http://www.google.com";
	private WebDriver webDriver;
	
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
	}
	
	@Test
	public void gitTest() {
		
		
		webDriver.navigate().to(url);
		WebElement searchBar = webDriver.findElement(By.cssSelector("#lst-ib"));
		searchBar.sendKeys("github \n");
		WebElement targetSite = webDriver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div > h3 > a"));
		targetSite.click();
		WebElement signInButton = webDriver.findElement(By.cssSelector("body > div.position-relative.js-header-wrapper > header > div > div.HeaderMenu.HeaderMenu--bright.d-lg-flex.flex-justify-between.flex-auto > div > span > div > a:nth-child(1)"));
		signInButton.click();
		WebElement usernameBox = webDriver.findElement(By.cssSelector("#login_field"));
		WebElement passwordBox = webDriver.findElement(By.cssSelector(("#password")));
		WebElement loginButton = webDriver.findElement(By.cssSelector(("#login > form > div.auth-form-body.mt-3 > input.btn.btn-primary.btn-block")));
		
		usernameBox.sendKeys("JParmar13");
		passwordBox.sendKeys("Megalord123");
		loginButton.click();
		
		WebElement testRepo = webDriver.findElement(By.cssSelector("#your_repos > div > div.boxed-group-inner > ul > li:nth-child(1) > a > span > span"));
		testRepo.click();
		
		String expectedUrl = "https://github.com/JParmar13/Week4Testing";
		String currentUrl = webDriver.getCurrentUrl();
		
		assertEquals(expectedUrl, currentUrl);
		
		
	}
	
	
	
	@After
	public void tearDown() {
		webDriver.quit();
	}
}
