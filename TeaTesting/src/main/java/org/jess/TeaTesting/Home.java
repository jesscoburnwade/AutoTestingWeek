package org.jess.TeaTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Home {
	ChromeDriver driver;
	
	@FindBy (xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	WebElement menuButton;
	@FindBy (xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	WebElement checkoutCheck;
	
	public void Menu() throws InterruptedException {
		menuButton.click();
	}
	
	public void checkOut() {
		checkoutCheck.click();
	}
}