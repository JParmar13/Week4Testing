package qa.consulting.com.Automated_testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectableObjects {

	
	@FindBy(css = "#selectable > li:nth-child(1)")
	WebElement sliderItem1;
	
	@FindBy(css = "#selectable > li:nth-child(7)")
	WebElement sliderItem7;
}
