package com.amazon.pageobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.Base;

public class AllDropDown extends Base {
	
	@FindBy(css = "div.nav-search-facade")
	WebElement AllBtn;
	
	@FindBy(xpath = "//*[@id=\"searchDropdownBox\"]/option")
	WebElement items;
	
	Action a = new Action();
	
	public AllDropDown() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickAllBtn() {
		a.click(driver, AllBtn);
	}
	
	public void validateAscending() {
		
		List <WebElement> options = driver.findElements((By)(items));
		
		List <String> optionTexts = new ArrayList <String>();
		for(WebElement opt : options) {
			optionTexts.add(opt.getText());
		}
		
		boolean isAscending = isSortedAsc(optionTexts);
		
		if(isAscending) {
			System.out.println("dropdown option are in ascending order");
			System.out.println("=====PASS=====");
		}
		else {
			System.out.println("dropdown options are not in ascending order");
		}
		}
	private static boolean isSortedAsc(List<String> list) {
		List <String> sortedList = new ArrayList<String>(list);
		Collections.sort(sortedList);
		return list.equals(sortedList);
	}

}
