package org.jess.POMTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistPage {
	@FindBy (xpath = "//*[@id=\"name_3_firstname\"]")
	private WebElement fname;
	@FindBy (xpath = "//*[@id=\"name_3_lastname\"]")
	private WebElement lname;
	@FindBy (xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[1]")
	private WebElement marital;
	@FindBy (xpath = "//*[@id=\"pie_register\"]/li[3]/div/div/input[2]")
	private WebElement hobby;
	@FindBy (xpath = "//*[@id=\"dropdown_7\"]")
	private Select country;
	@FindBy (xpath = "//*[@id=\"mm_date_8\"]")
	private Select dobmonth;
	@FindBy (xpath = "//*[@id=\"dd_date_8\"]")
	private Select dobday;
	@FindBy (xpath = "//*[@id=\"yy_date_8\"]")
	private Select dobyear;
	@FindBy (xpath = "//*[@id=\"phone_9\"]")
	private WebElement phone;
	@FindBy (xpath = "//*[@id=\"username\"]")
	private WebElement uname;
	@FindBy (xpath = "//*[@id=\"email_1\"]")
	private WebElement email;
	@FindBy (xpath = "//*[@id=\"description\"]")
	private WebElement desc;
	@FindBy (xpath = "//*[@id=\"password_2\"]")
	private WebElement passw;
	@FindBy (xpath = "//*[@id=\"confirm_password_password_2\"]")
	private WebElement confirmPassw;
	@FindBy (xpath = "//*[@id=\"pie_register\"]/li[14]/div/input")
	private WebElement submit;
	
	WebDriver driver;
	public void inputMethod(WebDriver driver) {
		FileInputStream file = null;
		XSSFWorkbook workbook = null;
		try {
			file = new FileInputStream (Constant.Path_TestData + Constant.File_TestData);
			workbook = new XSSFWorkbook(file);
		}
		catch (FileNotFoundException e1) {}
		catch (IOException e2) {}
		
		System.out.println(workbook);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFCell cell_fname = sheet.getRow(0).getCell(0);
		XSSFCell cell_lname = sheet.getRow(0).getCell(1);
		XSSFCell cell_phone = sheet.getRow(0).getCell(2);
		XSSFCell cell_uname = sheet.getRow(0).getCell(3);
		XSSFCell cell_email = sheet.getRow(0).getCell(4);
		XSSFCell cell_desc = sheet.getRow(0).getCell(5);
		XSSFCell cell_passw = sheet.getRow(0).getCell(6);
		XSSFCell cell_confirmPassw = sheet.getRow(0).getCell(7);
		
		String phoneno = String.valueOf((int)cell_phone.getNumericCellValue());
	
		fname.sendKeys(cell_fname.getStringCellValue());
		lname.sendKeys(cell_lname.getStringCellValue());
		marital.click();
		hobby.click();
		country = new Select(driver.findElement(By.xpath("//*[@id=\"dropdown_7\"]")));
		country.selectByVisibleText("United Kingdom");
		dobmonth = new Select(driver.findElement(By.xpath("//*[@id=\"mm_date_8\"]")));
		dobmonth.selectByVisibleText("5");
		dobday = new Select(driver.findElement(By.xpath("//*[@id=\"dd_date_8\"]")));
		dobday.selectByVisibleText("20");
		dobyear = new Select(driver.findElement(By.xpath("//*[@id=\"yy_date_8\"]")));
		dobyear.selectByVisibleText("1984");
		phone.sendKeys(phoneno);
		uname.sendKeys(cell_uname.getStringCellValue());
		email.sendKeys(cell_email.getStringCellValue());
		desc.sendKeys(cell_desc.getStringCellValue());
		passw.sendKeys(cell_passw.getStringCellValue());
		confirmPassw.sendKeys(cell_confirmPassw.getStringCellValue());
	}
}