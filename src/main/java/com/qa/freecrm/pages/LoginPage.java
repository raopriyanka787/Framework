package com.qa.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.testbase.testBase;

public class LoginPage extends testBase {
	JavascriptExecutor js;

	@FindBy(name = "username")
	WebElement uname;
	@FindBy(name = "password")
	WebElement upass;
	@FindBy(xpath = "//input[@value='Login' and @class='btn btn-small']")
	WebElement LoginButton;

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement loginpagelogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateLoginPageLogo() {
		return (loginpagelogo.isDisplayed());
	}

	public HomePage validateLogin(String un, String pass)

	{
		uname.sendKeys(un);
		upass.sendKeys(pass);
		WebElement ele = driver.findElement(By.xpath("//input[@value='Login' and @class='btn btn-small']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		return new HomePage();
	}

	public String getTitle() {
		return (driver.getTitle());

	}

}
