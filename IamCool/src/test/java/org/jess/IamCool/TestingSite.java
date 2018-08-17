package org.jess.IamCool;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestingSite {
	private WebDriver chrome_driver;
	private WebDriver firefox_driver;
	private Actions chrome_action;
	private Actions firefox_action;
	private static ExtentReports report;
	private ExtentTest test;
	private boolean passed_do_not_make = false;
	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	@BeforeClass 
	public static void setupClass() {
		System.setProperty("webdriver.chrome.driver", Constants.chromeDriver);
		System.setProperty("webdriver.gecko.driver", Constants.firefoxDriver);
		report = new ExtentReports(Constants.reportLocation, true);
	}
	@Before
	public void setup() {
		chrome_driver = new ChromeDriver();
		firefox_driver = new FirefoxDriver();
		chrome_driver.manage().window().maximize();
		firefox_driver.manage().window().maximize();
		chrome_action = new Actions(chrome_driver);
		firefox_action = new Actions(firefox_driver);
	}
	
	@After
	public void tearDown() {
		test.log(passed_do_not_make ? LogStatus.PASS : LogStatus.FAIL, "Passed everything");
		chrome_driver.close();
		firefox_driver.close();
		report.endTest(test);
	}
	
	@AfterClass
	public static void tearDownClass() {
		report.flush();
	}
	
	@Test
	public void test() {
		test = report.startTest("Registration");
		String[] input = new String[13];
		
		String browser;
		int which_browser = 0;
		
		RegistrationPage registrationPageChrome = PageFactory.initElements(chrome_driver, RegistrationPage.class);
		LoginPage loginPageChrome = PageFactory.initElements(chrome_driver,  LoginPage.class);
		
		RegistrationPage registrationPageFirefox = PageFactory.initElements(firefox_driver, RegistrationPage.class);
		LoginPage loginPageFirefox = PageFactory.initElements(firefox_driver,  LoginPage.class);
		
		Object[][] browser_specific_stuff = {{chrome_driver, registrationPageChrome, loginPageChrome, chrome_action}, 
				{firefox_driver, registrationPageFirefox, loginPageFirefox, firefox_action}};
		
		int j;
		
		try {
			file = new FileInputStream(Constants.registration_excel);
		} catch(FileNotFoundException e) {}
		try {
			workbook = new XSSFWorkbook(file);
		} catch(IOException e) {}
		
		sheet = workbook.getSheetAt(0);
		
		for(j = 2; ; j++) { //Test inputs where should make account
			
			if(sheet.getRow(j).getCell(0).getStringCellValue().equals("Fail")) break;
			
			for(int i = 0; i < 13; i++) {
				input[i] = sheet.getRow(j).getCell(i).getStringCellValue();
			}
			browser = sheet.getRow(j).getCell(13).getStringCellValue();
			
			if(browser.equals("chrome")) which_browser = 0;
			if(browser.equals("firefox")) which_browser = 1;
			
			WebDriver driver = (WebDriver) browser_specific_stuff[which_browser][0];
			Actions action = (Actions) browser_specific_stuff[which_browser][3];
			
			driver.get(Constants.register_url);
						
			((RegistrationPage) browser_specific_stuff[which_browser][1]).register(action, input);
			
			driver.get(Constants.login_url);
			
			((LoginPage) browser_specific_stuff[which_browser][2]).login(input[10], input[11], action);
			
			try {
				Thread.sleep(10000);
			} catch(Exception e) {}
			
			assertEquals(driver.getCurrentUrl(), Constants.logged_in_url);
			
			test.log(LogStatus.PASS, "Make user and sign in");
		}
		
		j++;
				
		for(; j < sheet.getPhysicalNumberOfRows(); j++) { // This would fail, if it were possible to actually fail
			passed_do_not_make = false;
			
			for(int i = 0; i < 13; i++) {
				input[i] = sheet.getRow(j).getCell(i).getStringCellValue();
			}
			
			browser = sheet.getRow(j).getCell(13).getStringCellValue();
			
			if(browser.equals("chrome")) which_browser = 0;
			if(browser.equals("firefox")) which_browser = 1;
			
			WebDriver driver = (WebDriver) browser_specific_stuff[which_browser][0];
			Actions action = (Actions) browser_specific_stuff[which_browser][3];

			driver.get(Constants.register_url);
						
			((RegistrationPage) browser_specific_stuff[which_browser][1]).register(action, input);
			
			driver.get(Constants.login_url);
			
			((LoginPage) browser_specific_stuff[which_browser][2]).login(input[10], input[11], action);
			
			try {
				Thread.sleep(10000);
			} catch(Exception e) {}
			
			assertEquals(driver.getCurrentUrl(), Constants.logged_in_url);
			
			test.log(LogStatus.PASS, "Fail to make user");
			
			passed_do_not_make = true;
		}
	}
}
