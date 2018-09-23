package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends BaseClass {


	HomePage homepage;
	ContactsPage contactspage;
	LoginPage loginpage;

	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData("contacts");
		return data;
	}
/*	
	@Test
	public void login() {
		loginpage.PerformLogin();
		TestUtil.SwitchToFrame();
		homepage.ClickOnNewContact();
	}*/

	@Test(dataProvider = "getCRMTestData")
	public void verifyNewContact(String title,String firstName,String lastName,String company) {
		loginpage.PerformLogin();
		TestUtil.SwitchToFrame();
		homepage.ClickOnNewContact();
	
		contactspage.createNewContact(title, firstName, lastName, company);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
