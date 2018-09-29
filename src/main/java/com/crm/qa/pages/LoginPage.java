package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;
import com.crm.qa.explicitwait.ExplicitWait;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	@FindBy(linkText = "Sign Up")
	WebElement signUpBtn;

	@FindBy(linkText = "Pricing")
	WebElement priceLink;

	public String VerifyPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public HomePage verifyLogin() {
		PerformLogin();
		return new HomePage();
	}

	public String verifySignUpLink() {
		
	
		
		action.moveToElement(signUpBtn).click().build().perform();
		
		return driver.getCurrentUrl();

		

	}

	public PricingPage PricingLink() {
		ExplicitWait.elementToBeClickable(10, priceLink);
		priceLink.click();
		driver.getCurrentUrl();
		return new PricingPage();
	}

	public void PerformLogin() {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		js.executeScript("arguments[0].click();",loginBtn);
	
		
		
		

	}

}
