package qa.consulting.com.Automated_testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConstrainMovement {

	
	@FindBy(css = "#ui-id-2")
	WebElement constrainButton;
	
	
	@FindBy(css = "#draggabl2 > p")
	WebElement dragHorizontal;
	
	@FindBy(css = "#draggabl > p")
	WebElement dragVertical;
	
	@FindBy(css = "#draggabl3 > p")
	WebElement dragInABox;
	
	@FindBy(css = "#draggabl5")
	WebElement dragWithinParent;
	
	
	public void navigateToConstrain() {
		constrainButton.click();
	}
}
