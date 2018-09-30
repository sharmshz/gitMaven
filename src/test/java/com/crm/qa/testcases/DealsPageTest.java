package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends BaseClass {
	
	HomePage homepage;
	LoginPage loginpage;
	DealsPage dealspage;
	String dealSheet="";
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage=new HomePage();
		loginpage=new LoginPage();
		dealspage=new DealsPage();
		
	}

	
	@DataProvider
	public Object[][] getDealsTestData()
	{
		Object data[][]=TestUtil.getTestData("deals");
		return data;
	}
	
	@Test(dataProvider="getDealsTestData")	
	public void verifyCreateDeal(String title, String company, String type,String source) {
		
		loginpage.PerformLogin();
		TestUtil.SwitchToFrame();
		homepage.ClickOnNewDeal();
		dealspage.createNewDeal(title, company, type, source);
		
		
	}

	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
