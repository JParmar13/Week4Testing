package qa.consulting.com.Automated_testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	@FindBy(css ="body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
	WebElement logInPage;
	@FindBy(css ="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	WebElement logInUser;
	@FindBy(css ="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	WebElement logInPassword;
	@FindBy(css ="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	WebElement logInButton;	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
	WebElement logInMessage;

	
	
	public void navigateToLogIn() {
		logInPage.click(); 
	}
		
	public void LogInUsername(String username) {
		logInUser.sendKeys(username);
	}
	
	public void LogInPassword(String password) {
		logInPassword.sendKeys(password);
	}	
	
	public void LogIn() {
		logInButton.click();
	}
}
