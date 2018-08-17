package org.jess.IamCool;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")
	private WebElement first_field;
	public void register(Actions action, String[] input) {
		first_field.sendKeys(input[0]);
		action.sendKeys(Keys.TAB).perform();
		for(int i = 1; i < 13; i++) {
			action.sendKeys(input[i]);
			action.sendKeys(Keys.TAB).perform();
		}
		first_field.submit();
	}
}
