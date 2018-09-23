package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.util.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static Actions action;	

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"E:\\SeleniumEclipse\\MavenProject\\" + "src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\BrowserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			action=new Actions(driver);
			
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "E:\\Selenium\\BrowserDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("Please Enter valid Browser Name in Properties File");
			System.exit(0);
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		

	}

}
