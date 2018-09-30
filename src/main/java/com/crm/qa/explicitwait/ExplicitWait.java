package com.crm.qa.explicitwait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseClass;

public class ExplicitWait extends BaseClass {

	public WebDriverWait wait;

	public static void elementToBeClickable(long timetowait, WebElement element) {
    new WebDriverWait(driver, timetowait).until(ExpectedConditions.elementToBeClickable(element));
	
	}

	public static void visibilityOf(long timetowait, WebElement element) {
	new WebDriverWait(driver, timetowait).until(ExpectedConditions.visibilityOf(element));
	
	}

}
