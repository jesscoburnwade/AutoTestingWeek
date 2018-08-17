package webdriver.websriver;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class TestingStuff {
	
	String url = "http://php.thedemosite.co.uk/";
	//String url = "http://automationpractice.com/index.php";
	ChromeDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Development\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test
	public void methodTest() throws InterruptedException {
	    driver.findElement(By.linkText("3. Add a User")).click();
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("user");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("passw");
	    Thread.sleep(1000);
	    driver.findElement(By.name("FormsButton2")).click();
	    driver.findElement(By.linkText("4. Login")).click();
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("user");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("passw");
	    Thread.sleep(1000);
	    driver.findElement(By.name("FormsButton2")).click();
	    WebElement check = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
	    assertEquals("**Successful Login**", check.getText());
//	    driver.findElement(By.id("search_query_top")).click();
//	    driver.findElement(By.id("search_query_top")).clear();
//	    driver.findElement(By.id("search_query_top")).sendKeys("dress");
//	    driver.findElement(By.id("searchbox")).submit();
//	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Showing 1 - 7 of 7 items'])[1]/following::img[1]")).click();
//	    driver.findElement(By.id("color_11")).click();
//	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='S'])[1]/following::span[1]")).click();
//	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$88.94'])[2]/following::span[3]")).click();
	    Thread.sleep(2000);
//		WebElement addUser = driver.findElement(By.id ("link=3. Add a User"));
//		addUser.click();
//		WebElement User = driver.findElement(By.id("name=username"));
//		User.click();
//		User.sendKeys("user");
//		WebElement Pass = driver.findElement(By.id("name=password"));
//		Pass.click();
//		Pass.sendKeys("password");
//		WebElement Enter = driver.findElement(By.name("FormsButton2"));
//		Enter.click();
//		WebElement Login = driver.findElement(By.id("link=4. Login"));
//		Login.click();
//		User.click();
//		User.sendKeys("user");
//		Pass.click();
//		Pass.sendKeys("password");
//		Enter.click();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}
