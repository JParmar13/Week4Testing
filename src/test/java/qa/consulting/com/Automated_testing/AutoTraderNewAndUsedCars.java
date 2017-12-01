package qa.consulting.com.Automated_testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AutoTraderNewAndUsedCars {

	@FindBy(css = "#postcode")
	WebElement newAndUsedPostcode;

	@FindBy(css = "#radius")
	WebElement newAndUsedRadius;

	@FindBy(css = "label.c-form__checkbox-label:nth-child(2)")
	WebElement usedCheckbox;

	@FindBy(css = "label.c-form__checkbox-label:nth-child(3)")
	WebElement nearlyNewCheckbox;

	@FindBy(css = "label.c-form__checkbox-label:nth-child(4)")
	WebElement newCheckbox;

	@FindBy(css = "#searchVehiclesMake")
	WebElement searchMake;

	@FindBy(css = "#searchVehiclesModel")
	WebElement searchModel;

	@FindBy(css = "#searchVehiclesPriceFrom")
	WebElement searchPriceFrom;

	@FindBy(css = "#searchVehiclesPriceTo")
	WebElement searchPriceTo;

	@FindBy(css = "#js-search-button")
	WebElement searchCarsButton;

	@FindBy(css = "#main-content > div.js-search-results")
	WebElement vehicleListings;

	@FindBy(css = "#main-content > div.vehicle__secondarycol > section > div > div.seller_trade__ctaButtons > a.seller_trade__visit-website--button.tracking-leads-link")
	WebElement visitWebsiteButton;

	@FindBy(css = "body > main > section.search-page__left > div.search-form > form > div > div > h1")
	WebElement carsFound;
	
	public void setPostcode(String postcode) {

		newAndUsedPostcode.sendKeys(postcode);

	}

	public void setRadius(String radius) {
		Select dropdown = new Select(newAndUsedRadius);
		newAndUsedRadius.click();
		dropdown.selectByValue(radius);

	}

	// public void setSearchCondition(String inputShow) {
	// //depending on what user has inputted, new used nearly new, select
	// appropriate checkboxes
	//
	// String[] conditionArray = inputShow.split(",");
	//
	// for (int i = 0; i < conditionArray.length; i++) {
	//
	// }
	//
	//
	//
	//
	// }

	public void setMake(String carMake) {

		Select dropdown = new Select(searchMake);
		searchMake.click();
		dropdown.selectByValue(carMake);

	}

	public void setModel(String carModel) {

		Select dropdown = new Select(searchModel);
		searchModel.click();
		dropdown.selectByValue(carModel);

	}

	public void setPriceFrom(String priceFrom) {

		Select dropdown = new Select(searchPriceFrom);
		searchPriceFrom.click();
		dropdown.selectByValue(priceFrom);

	}

	public void setPriceTo(String priceTo) {

		Select dropdown = new Select(searchPriceTo);
		searchPriceTo.click();
		dropdown.selectByValue(priceTo);
	}

	public void getResult() {

		List<WebElement> links = vehicleListings.findElements(By.className("listing-main-image"));

		links.get(0).click();
	}

	public void visitWebsite() {
		visitWebsiteButton.click();
	}

	public void searchNewAndUsedCars() {
		searchCarsButton.click();
	}
}
