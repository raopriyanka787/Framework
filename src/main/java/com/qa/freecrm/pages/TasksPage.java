package com.qa.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.testbase.testBase;

public class TasksPage extends testBase {

	@FindBy(xpath = "//legend[text()='Task Information']")
	WebElement newtaskpageloggedin;

	@FindBy(xpath = "//input[@value='Show Full Form']")
	WebElement showFullForm;

	public TasksPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean tasksPageconfi() {
		return (showFullForm.isEnabled());
	}

	public boolean newTaskconfi() {
		return (newtaskpageloggedin.isEnabled());
	}

}
