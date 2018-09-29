package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.BaseClass;


public class HomePage extends BaseClass {


	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy (xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement deals;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newDeal;
	
	public HomePage() {
	PageFactory.initElements(driver, this);
	}
	
	
	
	public void ClickOnNewContact() {		
		
		
		action.moveToElement(contacts).build().perform();
		newContact.click();		
		
	}
	
	
	public void ClickOnNewDeal()
	{
		action.moveToElement(deals).build().perform();
		
		newDeal.click();
		
	}
	
}
