package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseClass;

public class ContactsPage extends BaseClass {

	
	
	@FindBy(id="first_name")
	WebElement fName;
	
	@FindBy(id="surname")
	WebElement sName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(id="company_position")
	WebElement position;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement save;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void createNewContact(String title, String firstName, String lastName, String company){
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title' and @class='select']")));
		select.selectByVisibleText(title);		
		fName.sendKeys(firstName);
		sName.sendKeys(lastName);
		companyName.sendKeys(company);
		save.click();
		
	}
}
