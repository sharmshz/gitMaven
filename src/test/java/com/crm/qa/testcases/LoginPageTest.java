package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PricingPage;
import com.crm.qa.pages.RegistrationPage;

public class LoginPageTest extends BaseClass {

	LoginPage loginpage;
	HomePage homepage;
	RegistrationPage registrationpage;
	PricingPage pricingpage;

	LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		registrationpage = new RegistrationPage();
		pricingpage = new PricingPage();

	}

	@Test(priority = 1)
	public void VerifyPageTitleTest() {
		String actual = "#1 Free CRM software in the cloud for sales and service";
		String expected = loginpage.VerifyPageTitle();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 2)
	public void verifyLoginTest() {
		homepage = loginpage.verifyLogin();
	}

	@Test(priority = 3)
	public void verifySignUpLink() {

		registrationpage = loginpage.verifySignUpLink();

	}

	@Test(priority = 4)
	public void PricingLink() {

		pricingpage = loginpage.PricingLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
