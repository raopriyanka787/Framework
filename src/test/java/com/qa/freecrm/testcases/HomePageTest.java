package com.qa.freecrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freecrm.pages.ContactsPage;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;
import com.qa.freecrm.pages.TasksPage;
import com.qa.freecrm.testbase.testBase;
import com.qa.freecrm.utility.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends testBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TasksPage taskspage;
	TestUtil testutil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		loginpage.validateLogin(pro.getProperty("username"), pro.getProperty("password"));
		homepage = new HomePage();
		contactspage = new ContactsPage();
		taskspage = new TasksPage();
		testutil = new TestUtil();

	}

	@Test(priority = 1)
	public void HomePageLogoTest() throws InterruptedException {
		testutil.switctomainframe();
		Boolean boole = homepage.validateHomePageLogo();
		Assert.assertTrue(boole);
		System.out.println("Home Page Logo verified");
	}

	@Test(priority = 2)
	public void HomePageTitleTest() {
		testutil.switctomainframe();
		String tit = homepage.HomePageTitle();
		Assert.assertEquals("CRMPRO", tit);
		System.out.println("HomePage title verified");
	}

	@Test(priority = 3)
	public void ContactsPageTest() {
		testutil.switctomainframe();
		contactspage = homepage.validateContacts();
		Boolean b = contactspage.contactspageconfirm();
		Assert.assertTrue(b);
		System.out.println("Redirected to Contacts Page");
	}

	@Test(priority = 4)

	public void NewContactsTest() throws InterruptedException {
		testutil.switctomainframe();
		contactspage = homepage.validateNewContact();
		Boolean bo = contactspage.validatenewcontact();
		Thread.sleep(2000);
		Assert.assertTrue(bo);
		System.out.println("Redirected to NewContact page");
	}

	@Test(priority = 5)
	public void TaskPageclickTest() throws InterruptedException {
		testutil.switctomainframe();
		taskspage = homepage.validateTasks();
		Thread.sleep(2000);
		Boolean bt = taskspage.tasksPageconfi();
		Assert.assertTrue(bt);
		System.out.println("Redirected to TasksPage");
	}

	@Test(priority = 6)
	public void NewTaskTest() throws InterruptedException {
		testutil.switctomainframe();
		taskspage = homepage.validatenewTask();
		Boolean bnt = taskspage.newTaskconfi();
		Assert.assertTrue(bnt);
		System.out.println("Redirected to newTask page");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
