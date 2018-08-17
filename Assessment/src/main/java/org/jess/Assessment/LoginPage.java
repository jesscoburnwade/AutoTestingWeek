package org.jess.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	ChromeDriver driver;
	
	@FindBy (xpath = "//*[@id=\"txtUsername\"]")
	WebElement usernameBox;
	@FindBy (xpath = "//*[@id=\"txtPassword\"]")
	WebElement passwordBox;
	@FindBy (xpath = "//*[@id=\"btnLogin\"]")
	WebElement loginButton;
	
	public void Login() {
		usernameBox.sendKeys("Admin");
		passwordBox.sendKeys("AdminAdmin");
		loginButton.click();
	}

}
