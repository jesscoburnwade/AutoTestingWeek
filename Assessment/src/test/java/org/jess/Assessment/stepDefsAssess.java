package org.jess.Assessment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefsAssess {
	ChromeDriver driver;
	public ExtentTest test;
	public static ExtentReports report;
	public static int i = 0;
	WebElement element;
	Actions action;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Development\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		if (i==0) {
			report = new ExtentReports(Constant.path + Constant.file, true);
		}
		i++;
	}
	
	@After
	public void teardown() {
		if (i == 10) {
			report.flush();
		}
		driver.quit();
	}
	
	@Given("^the login page$")
	public void the_login_page() {
		driver.get(Constant.loginURL);
	}

	@When("^I login$")
	public void i_login() {
		test = report.startTest("Test Login");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.Login();
		test.log(LogStatus.INFO, "Logged in");
	}

	@When("^I click the PIM tab$")
	public void i_click_the_PIM_tab() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoggedInPage loggedInPage = PageFactory.initElements(driver, LoggedInPage.class);
		loggedInPage.clickPIM();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^then the Add Employee Tab$")
	public void then_the_Add_Employee_Tab() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoggedInPage loggedInPage = PageFactory.initElements(driver, LoggedInPage.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loggedInPage.clickAddEmployee();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^I fill out the Add Employee Details correctly$")
	public void i_fill_out_the_Add_Employee_Details_correctly() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoggedInPage loggedInPage = PageFactory.initElements(driver, LoggedInPage.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loggedInPage.addEmployee(action, driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^I choose to create Login Details by clicking the appropriate button$")
	public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I can search for the Employee I have just created$")
	public void i_can_search_for_the_Employee_I_have_just_created() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^select them for inspection$")
	public void select_them_for_inspection() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}