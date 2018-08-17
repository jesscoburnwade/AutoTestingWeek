package org.jess.DressTest;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class TestTheDress {
	
	String url = "http://automationpractice.com/index.php";
	ChromeDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Development\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test
	public void methodTest () throws InterruptedException{
		WebElement searchbox = driver.findElement(By.id("search_query_top"));
		searchbox.click();
		searchbox.sendKeys("dresses");
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.name("submit_search"));
		search.submit();
		Thread.sleep(1000);
		WebElement check = driver.findElement(By.className("lighter"));
		String input =  "\"DRESSES\"";
		assertEquals(input,check.getText());
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}
