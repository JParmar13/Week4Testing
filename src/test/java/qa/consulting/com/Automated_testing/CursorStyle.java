package qa.consulting.com.Automated_testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CursorStyle {

	
	@FindBy(css = "#ui-id-3")
	WebElement cursorStyleButton;
	
	@FindBy(css = "#drag2")
	WebElement cursorStyleTopLeft;
	
	@FindBy(css = "#drag")
	WebElement cursorStyleCenter;
	
	public void navigateToCursorStyle() {
		cursorStyleButton.click();
	}
}
