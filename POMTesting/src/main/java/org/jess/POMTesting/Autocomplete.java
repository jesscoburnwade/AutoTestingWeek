package org.jess.POMTesting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Autocomplete {
	WebDriver driver;
	
	@FindBy (id = "tagss")
	WebElement typeBox;
	
	public void autocomp(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(typeBox).click().sendKeys("jav").perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
	}

}
