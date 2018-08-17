package org.jess.Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoggedInPage {
	
	@FindBy (xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]")
	WebElement PIMbutton;
	@FindBy (xpath = "//*[@id=\"menu_pim_addEmployee\"]/span[2]")
	WebElement addEmployeeButton;
	
	@FindBy (xpath = "//*[@id=\"firstName\"]")
	WebElement addFirstName;
	@FindBy (xpath = "//*[@id=\"middleName\"]")
	WebElement addMiddleName;
	@FindBy (xpath = "//*[@id=\"lastName\"]")
	WebElement addLastName;
	@FindBy (xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
	WebElement addLocation;
	
	@FindBy (xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
	WebElement createLogin;
	
	public void clickPIM() {
		PIMbutton.click();
	}
	
	public void clickAddEmployee() {
		addEmployeeButton.click();
	}
	
	public void addEmployee(Actions action, WebDriver driver) {
		addFirstName.sendKeys("John");
		addMiddleName.sendKeys("David");
		addLastName.sendKeys("Smith");
		addLocation.click();
		action.moveToElement(addLocation).moveByOffset(10,10).click().perform();
		}
}
