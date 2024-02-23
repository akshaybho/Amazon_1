package com.amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.Base;

public class AccountCreation extends Base {
	
	Action a = new Action();
	@FindBy(xpath = "//h1[@class=\"a-spacing-small moa_desktop_signup\"]")
	WebElement accCreate;
	
	public AccountCreation() {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateTitle() {
		return a.isDisplayed(driver, accCreate);
	}

}
