package org.jess.POMTesting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SelectPage {
	WebDriver driver;
	
	@FindBy (xpath = "//*[@id=\"tabs\"]/ul/li[2]")
	private WebElement selectButton;
	@FindBy (xpath = "//*[@id=\"selectable_grid\"]/li[1]")
	private WebElement Button1;
	@FindBy (xpath = "//*[@id=\"selectable_grid\"]/li[7]")
	private WebElement Button7;
	@FindBy (xpath = "//*[@id=\"selectable_grid\"]/li[4]")
	private WebElement Button4;
	
	public void selectElement(WebDriver driver) {
		Actions action = new Actions(driver);
		selectButton.click();
		Button1.click();
		action.keyDown(Keys.CONTROL).perform();
		Button7.click();
		Button4.click();
	}
	
}