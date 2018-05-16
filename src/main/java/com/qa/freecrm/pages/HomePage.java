package com.qa.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.testbase.testBase;

public class HomePage extends testBase {

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactsLink;
	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement NewContactLink;
	@FindBy(xpath = "//a[@title='Deals']")
	WebElement DealsLink;
	@FindBy(xpath = "//a[@title='New Deal']")
	WebElement NewDealsLink;
	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement TasksLink;
	@FindBy(xpath = "//a[@title='New Task']")
	WebElement NewTasksLink;

	@FindBy(xpath = "//td[contains(text(),'Free')]")
	WebElement Freetext;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public boolean validateHomePageLogo() {

		return Freetext.isEnabled();
	}

	public String HomePageTitle() {
		return (driver.getTitle());
	}

	public ContactsPage validateContacts() {
		contactsLink.click();
		return new ContactsPage();
	}

	public TasksPage validateTasks() {
		TasksLink.click();
		return new TasksPage();
	}

	public ContactsPage validateNewContact() throws InterruptedException {

		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		Thread.sleep(2000);
		NewContactLink.click();
		Thread.sleep(3000);
		return new ContactsPage();
	}

	public TasksPage validatenewTask() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(TasksLink).build().perform();
		Thread.sleep(3000);
		NewTasksLink.click();
		return new TasksPage();

	}

	public ContactsPage validateNewContactfordatafromExcel() throws InterruptedException {

		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		Thread.sleep(2000);
		NewContactLink.click();
		Thread.sleep(2000);
		return new ContactsPage();
	}

}
