package org.jess.POMTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DraggablePage {
	WebDriver driver;
	
	@FindBy (xpath = "//*[@id=\"draggableview\"]/p")
	private WebElement draggable;
	
	public void dragElement(WebDriver driver) {
		WebElement drop = driver.findElement(By.id("droppableview"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, drop).perform();
	}
}