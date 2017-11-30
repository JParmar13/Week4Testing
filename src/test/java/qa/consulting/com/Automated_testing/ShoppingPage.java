package qa.consulting.com.Automated_testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingPage {

	
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	WebElement shoppingSignIn;
	
	@FindBy(css = "#email_create")
	WebElement createAccountEmailEntry;
	
	@FindBy(css = "#SubmitCreate > span")
	WebElement createAnAccountButton;
	
	@FindBy(css = "#id_gender1")
	WebElement genderRadioButton;	
	
	@FindBy(css = "#customer_firstname")
	WebElement personalFirstName;
	
	@FindBy(css = "#customer_lastname")
	WebElement personalLastName;
	
	@FindBy(css = "#passwd")
	WebElement personalPassword;
	
	@FindBy(css = "#days")
	WebElement dayOfBirth;
	
	@FindBy(css = "#months")
	WebElement monthOfBirth;
	
	@FindBy(css = "#years")
	WebElement yearOfBirth;
	
	@FindBy(css = "#firstname")
	WebElement addressFirstName;
	
	@FindBy(css = "#lastname")
	WebElement addressLastName;
	
	@FindBy(css = "#address1")
	WebElement addressLine;
	
	@FindBy(css = "#city")
	WebElement addressCity;
	
	@FindBy(css = "#id_state")
	WebElement addressState;
	
	@FindBy(css = "#postcode")
	WebElement addressPostcode;
	
	@FindBy(css = "#id_country")
	WebElement addressCountry;
	
	@FindBy(css = "#phone_mobile")
	WebElement addressPhone;
	
	@FindBy(css = "#alias")
	WebElement addressAlias;
	
	@FindBy(css = "#submitAccount > span")
	WebElement accountRegister;
	
	@FindBy(css = "#email")
	WebElement signInEmail;
	
	@FindBy(css = "#passwd")
	WebElement signInPassword;
	
	@FindBy(css = "#SubmitLogin > span")
	WebElement submitSignIn;
	
	@FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a > span")
	WebElement userNameNavbar;
	
	public void navigateToSignIn() {
		shoppingSignIn.click();
	}
	
	public void enterEmailCreateAccount(String email) {
		createAccountEmailEntry.sendKeys(email);
	}
	
	public void createAccountButtonSignIn() {
		createAnAccountButton.click();
	}
	
	public void selectGender() {
		genderRadioButton.click();
	}
	
	public void enterPersonalFirstName(String personalFName) {
		personalFirstName.sendKeys(personalFName);
	}
	
	public void enterPersonalLastName(String personalLName) {
		personalLastName.sendKeys(personalLName);
	}
	
	public void enterPersonalPassword(String personalPWord) {
		personalPassword.sendKeys(personalPWord);
	}
	
	public void enterDayOfBirth(String userDayOfBirth) {
		dayOfBirth.click();
		dayOfBirth.sendKeys(userDayOfBirth);
	}
	
	public void enterMonthOfBirth(String userMonthOfBirth) {
		monthOfBirth.click();
		
		String userMonth = "";
		
		switch (userMonthOfBirth) {
		
		case "1": userMonth = "January";
		break;		
		case "2": userMonth = "February";
		break;
		case "3": userMonth = "March";
		break;
		case "4": userMonth = "April";
		break;
		case "5": userMonth = "May";
		break;
		case "6": userMonth = "June";
		break;
		case "7": userMonth = "July";
		break;
		case "8": userMonth = "August";
		break;
		case "9": userMonth = "September";
		break;
		case "10": userMonth = "October";
		break;
		case "11": userMonth = "November";
		break;
		case "12": userMonth = "December";
		break;
			
		}
		
		monthOfBirth.sendKeys(userMonth);
	}
	
	public void enterYearOfBirth(CharSequence userYearOfBirth) {
		yearOfBirth.click();
		yearOfBirth.sendKeys(userYearOfBirth);
	}
	
	public void enterAddressFirstName(String addressFName) {
		addressFirstName.sendKeys(addressFName);
	}
	
	public void enterAddressLastName(String addressLName) {
		addressLastName.sendKeys(addressLName);
	}
	
	public void enterAddress(String address) {
		addressLine.sendKeys(address);
	}
	
	public void enterAddressCity(String addressCityInput) {
		addressCity.sendKeys(addressCityInput);
	}
	
	public void enterAddressState(String addressStateInput) {
		Select dropdown = new Select(addressState);
		addressState.click();		
		dropdown.selectByVisibleText(addressStateInput);
	}
	
	public void enterAddressPostCode(String addressPCode) {
		
		
		
		addressPostcode.sendKeys(addressPCode);
	}
	
//	public void enterAddressCountry(String userCountry) {
//		Select dropdown = new Select(addressCountry);
//		addressCountry.click();
//		dropdown.selectByValue(userCountry);
//		
//	}
	
	public void enterAddressMobilePhone(String addressMPhone) {
		addressPhone.sendKeys(addressMPhone);
	}
	
	public void enterAddressAlias(String addressAliasInput) {
		 addressAlias.sendKeys(addressAliasInput);
	}
	
	public void registerUser() {
		accountRegister.click();
	}

	public void enterRegisteredEmail(String registeredEmail) {
		signInEmail.sendKeys(registeredEmail);
	}
	
	public void enterRegisteredPassword(String registeredPassword) {
		signInPassword.sendKeys(registeredPassword);
	}

	public void userLogIn() {
		submitSignIn.click();
	}
	
}
