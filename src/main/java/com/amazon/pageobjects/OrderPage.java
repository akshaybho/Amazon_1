package com.amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.actiondriver.Action;
import com.amazon.base.Base;

public class OrderPage extends Base {
	
	Action a = new Action();
	
	@FindBy(xpath = "//span[text()=\"Account & Lists\"]")
	WebElement AccAndList;
	
	@FindBy(xpath  = "//a//span[text()=\"Your Orders\"]")
	WebElement YourOrder;
	
	@FindBy(css = "#a-autoid-0-announce")
	WebElement Btn;
	
	
	public void hoverOnAccAndList() {
		a.mouseover(driver, AccAndList);
	}
	
	public void clickOnOrde() {
		YourOrder.click();
	}
	
	public void verifyOrderPage() {
		String text = Btn.getText();
		if(text.equalsIgnoreCase("Search Orders")) {
			System.out.println("Order Page Test Case ==============>>>> PASS");
		}
	}
	

}
