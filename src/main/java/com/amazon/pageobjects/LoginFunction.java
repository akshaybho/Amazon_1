package com.amazon.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.base.Base;

public class LoginFunction extends Base {
	
	@FindBy(xpath = "//span[text()=\"Account & Lists\"]")
	WebElement signIn;
	
	@FindBy(css = "#ap_email")
	WebElement txt_username;
	
	@FindBy(css = ".a-button-input")
	WebElement submitBtn;
	
	@FindBy(css = "#ap_password")
	WebElement txt_password;
	
	@FindBy(css = "#signInSubmit")
	WebElement signInBtn;
	
	public void clickSignIn() {
	 signIn.click();
	}
	
	public void enterUsername(String name) {
		name = p.getProperty("username");
		txt_username.sendKeys(name);
	}
	
	public void clickSubmit() {
		submitBtn.click();
	}
	
	public void enterPassword(String pwd) throws IOException {
		pwd = Base.decodeString(p.getProperty("password"));
		txt_password.sendKeys(pwd);
	}
	
	public void clickOnSignInButton() {
		signInBtn.click();
	}
}
