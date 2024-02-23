package com.amazon.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;
import com.amazon.actiondriver.Action;
import com.amazon.base.Base;

public class IndexPage extends Base {
	
	Action a = new Action();
	@FindBy(xpath ="//a[@id =\"nav-link-accountList\"]")
	WebElement AccList;
	
	@FindBy(xpath = "//a[@id =\"nav-logo-sprites\"]")
	WebElement Logo;
	
	@FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
	WebElement SearchBar;
	
	@FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]")
	WebElement SearchButton;
	
	@FindBy(css = "span.icp-nav-link-inner")
	WebElement langBtn;
	
	@FindBy(xpath = "//i[@class=\"a-icon a-icon-radio\"]")
	WebElement listOfLang;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);		
	}

	public void mouseHover() {		
		a.mouseHoverElement(driver, AccList);
	}
	
	public boolean validateLogo() {		
		return a.isDisplayed(driver, Logo);
	}
	
	public String getTitle() {
		String title = a.getTitle(driver);	
		return title;
	}
	
	public void searchItem(String item) {
		SearchBar.sendKeys("mac mini");
		SearchBar.sendKeys(Keys.ENTER);				
	}
	
	public void SearchButton() {
		a.click(driver, SearchButton);
	}
	
	public void changeLang() throws InterruptedException {		
		langBtn.click();
		List <WebElement> languages = driver.findElements((By) listOfLang);
		for(WebElement e: languages) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains("HI")) {
				listOfLang.click();
				Thread.sleep(3000);
				a.screenShot(driver, "langChange");
			}
		}
	}
	
	
	
}
