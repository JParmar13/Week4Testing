package qa.consulting.com.Automated_testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart {

	@FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
	WebElement tShirtsButton;

	@FindBy(css = "#center_column > ul > li > div > div.left-block > div > a.product_img_link > img")
	WebElement fadedShortSleeve;

	@FindBy(css = "#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
	WebElement addTShirt;

	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span > i")
	WebElement proceedToCartSummary;

	@FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")
	WebElement proceedToCheckout;

	@FindBy(css = "#ordermsg > textarea")
	WebElement additionalCommentOrder;

	@FindBy(css = "#center_column > form > p > button > span")
	WebElement proceedToShipping;
	
	@FindBy(id = "#cgv")
	WebElement agreeToTerms;
	
	@FindBy(css = "#form > p > button > span")
	WebElement proceedToPayment;
	
	@FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
	WebElement useBankWire;

	@FindBy(css = "#cart_navigation > button > span")
	WebElement confirmOrder;
	
	@FindBy(css = "#center_column > div > p > strong")
	WebElement orderComplete;
	
	public void navigateToTShirts() {
		tShirtsButton.click();
	}

	public void proceedToCartSummary() {
		proceedToCartSummary.click();
	}

	public void proceedToCheckout() {
		proceedToCheckout.click();
	}

	public void additionalCommentBox(String additionalComment) {
		additionalCommentOrder.sendKeys(additionalComment);
	}

	public void proceedToShipping() {
		proceedToShipping.click();
	}
	
	public void proceedToPayment() {
		proceedToPayment.click();
	}
	
	public void useBankWirePaymentMethod() {
		useBankWire.click();
	}
	
	public void confirmCart() {
		confirmOrder.click();
	}
}
