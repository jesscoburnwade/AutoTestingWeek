package org.jess.IamCool;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input")
	private WebElement username_field;
	
	public void login(String username, String password, Actions action) {
		username_field.sendKeys(username);
		action.sendKeys(Keys.TAB).sendKeys(password).perform();
		username_field.submit();
	}
}
