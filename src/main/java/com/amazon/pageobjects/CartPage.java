package com.amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.base.Base;

public class CartPage extends Base {
	
	@FindBy(css = "#nav-cart")
	WebElement Cart;
	
	@FindBy(css = "#deselect-all")
	WebElement Deselect;
	
	@FindBy(xpath = "//*[@id=\"sc-active-cart\"]/div/div[1]/div[1]/h1")
	WebElement cartText;
	
	@FindBy(css = "#searchDropdownBox")
		WebElement allDropdown;
	
	
	public void clickOnCart() {
		Cart.click();
	}
	
	public void selectCheckBox() {
		Deselect.isSelected();
	}
	
	public void verifyPage() {
		String text = cartText.getText();
		if(text.equalsIgnoreCase("Shopping Cart")) {
			System.out.println("====PASS====");
		}
	}
	
	 

}
