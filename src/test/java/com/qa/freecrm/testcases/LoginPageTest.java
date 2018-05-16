package com.qa.freecrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;
import com.qa.freecrm.testbase.testBase;

public class LoginPageTest extends testBase {
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginpagelogotest()

	{
		boolean logoo = loginpage.validateLoginPageLogo();
		Assert.assertTrue(logoo);
		System.out.println("Login Page logo verified");
	}

	@Test(priority = 2)
	public void LoginPageTitleTest() {
		String title = loginpage.getTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
		System.out.println("Login Page Title verified");
	}

	@Test(priority = 3)
	public void LoginPageLoginTest() {
		homepage = loginpage.validateLogin(pro.getProperty("username"), pro.getProperty("password"));
		System.out.println("Logged in successfully");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
