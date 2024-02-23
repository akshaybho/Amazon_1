package com.amazon.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.Base;

public class SearchResult extends Base {
	
	Action a = new Action();
	
	@FindBy(css = "#twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(xpath ="//*[@id=\"search\"]//h2")
	List<WebElement> Products;
	
	@FindBy(css ="#buy-now-button")
	WebElement buyBtn;
	
	public SearchResult() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchItem() throws InterruptedException {
		searchBar.sendKeys("iphone");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	
	public void validateItem() {
		List <WebElement> items = Products;
		for(WebElement e : items) {
			String data = e.getText();
			if(data.equalsIgnoreCase("Apple iPhone")) {
				System.out.println("=====PASS=====");
			}
		}
	}
	
	public boolean clickOnPRoduct() {
		String parent = driver.getWindowHandle();
		List <WebElement> items = Products;
		for(int i=0; i<items.size(); i++) {
			
			items.get(2).click();
			break;
	}
	
	Set <String> windows = driver.getWindowHandles();	
	Iterator <String> itr = windows.iterator();
	
	while(itr.hasNext()) {
		String child = itr.next();
		if(!parent.equals(child)) {
			driver.switchTo().window(child);
		}
	}
	return a.isDisplayed(driver, buyBtn);
}
}
