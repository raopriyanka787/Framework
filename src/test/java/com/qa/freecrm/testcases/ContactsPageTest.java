package com.qa.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.freecrm.pages.ContactsPage;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;
import com.qa.freecrm.testbase.testBase;
import com.qa.freecrm.utility.TestUtil;

public class ContactsPageTest extends testBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;

	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		contactspage = new ContactsPage();
		testutil = new TestUtil();
		loginpage.validateLogin(pro.getProperty("username"), pro.getProperty("password"));
		testutil.switctomainframe();
	}

	@Test(priority = 1)
	public void contactsTest() {
		homepage.validateContacts();
		Boolean flag = contactspage.contactspageconfirm();
		Assert.assertTrue(flag);
		System.out.println("Control is on contacts page");
	}

	@Test(priority = 2)
	public void newContactTest() throws InterruptedException {
		homepage.validateNewContact();
		Boolean ble = contactspage.validatenewcontact();
		Assert.assertTrue(ble);
		System.out.println("new contacts page logo checked");
	}

	@Test(priority = 3)
	public void selecthardcodedlecontactTest() throws InterruptedException {
		homepage.validateContacts();
		TestUtil.scrollPageDown(driver);
		contactspage.selecthardcodecb();
		Thread.sleep(2000);
		System.out.println(" check box of hard coded value checked");
	}

	@Test(priority = 4)
	public void selectdynamiclecontactTest() throws InterruptedException {
		homepage.validateContacts();
		TestUtil.scrollPageDown(driver);
		contactspage.selectparamcb("AABC xyz");
		contactspage.selectparamcb("ABC Jain");
		contactspage.selectparamcb("abc xyz");
		Thread.sleep(2000);
		System.out.println("Multiple contacts checked dynamically");
	}

	@Test(priority = 5)
	public void createNewContacthcTest() throws InterruptedException {
		homepage.validateNewContact();
		contactspage.CreateNewContacthardcode1();
		Thread.sleep(3000);
		homepage.validateNewContact();
		contactspage.CreateNewContacthardcode2();
		Thread.sleep(3000);
		System.out.println("2 hardcoded contacts created ");

	}

	@Test(priority = 6)
	public void createNewContactdynTest() throws InterruptedException {
		homepage.validateNewContact();
		contactspage.CreateNewContactdynamcode("Dr.", "AAA", "RRAOO", "Virgo", "II");
		Thread.sleep(2000);
		homepage.validateNewContact();
		contactspage.CreateNewContactdynamcode("Mrs.", "BBB", "Rao", "Leo", "III");
		Thread.sleep(3000);

		homepage.validateNewContact();
		contactspage.CreateNewContactdynamcode("Ms.", "CCC", "Bhatia", "Kanh", "IV");
		Thread.sleep(3000);

		homepage.validateNewContact();
		Thread.sleep(1000);
		System.out.println("3 new contacts created dynamically");
	}

	@DataProvider
	public Object[][] getTestProjData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 7, dataProvider = "getTestProjData")
	public void createContactsFromExcel(String Title, String FirstName, String MiddleName, String LastName,
			String Suffix) throws InterruptedException {
		homepage.validateNewContact();
		contactspage.CreateNewContactdynamcodefrommexcel(Title, FirstName, MiddleName, LastName, Suffix);
		System.out.println("TESTS COMPLETE");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
