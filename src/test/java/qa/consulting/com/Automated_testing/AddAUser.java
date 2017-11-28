package qa.consulting.com.Automated_testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAUser {

	
	@FindBy(css ="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	WebElement signUpUser;
	@FindBy(css ="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	WebElement signUpPassword;
	@FindBy(css ="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	WebElement saveDetails;	
	
	public void signUpUsername(String username) {
		signUpUser.sendKeys(username);
	}
	
	public void signUpPassword(String password) {
		signUpPassword.sendKeys(password);
	}
	
	public void saveUserDetails() {
		saveDetails.click();
	}
}
