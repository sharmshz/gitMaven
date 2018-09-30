package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseClass;

public class DealsPage extends BaseClass {
	
	@FindBy(xpath="//input[@name='title' and @id='title']")
	WebElement ttle;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement cmpny;
	
	@FindBy (xpath="//select[@name='type']")
	WebElement typeOfDeal;
	
	
	@FindBy (xpath="//select[@name='source']")
	WebElement sourceOfDeal;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement save;
	

	
	public DealsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void createNewDeal(String title,String company,String type,String source) {
		
		ttle.sendKeys(title);
		cmpny.sendKeys(company);
		Select select =new Select(typeOfDeal);
		select.selectByVisibleText(type);
		Select select1 =new Select(sourceOfDeal);		
		select1.selectByVisibleText(source);
		save.click();
		
		
	}
	
	
	}
	
	


