package com.qa.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.freecrm.testbase.testBase;

public class ContactsPage extends testBase {
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement fn;
	@FindBy(xpath = "//input[@name='middle_initial']")
	WebElement mn;
	@FindBy(xpath = "//input[@name='surname']")
	WebElement ln;

	@FindBy(xpath = "//input[2][@type='submit' and @value='Save' and @class='button']")
	WebElement savebtn;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactspageconfi;

	@FindBy(xpath = "//input[@value='Load From Company']")
	WebElement LoadFromCompa;

	@FindBy(xpath = "//a[text()='AABC xyz']//parent::td//preceding-sibling::td//input[@name='contact_id']")
	WebElement AABCCheckbox;
	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement cl;
	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement Ncl;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean contactspageconfirm() {
		return (contactspageconfi.isDisplayed());

	}

	public boolean validatenewcontact() {
		return (LoadFromCompa.isEnabled());
	}

	public void selecthardcodecb() {
		AABCCheckbox.click();
	}

	public void selectparamcb(String name) {
		driver.findElement(
				By.xpath("//a[text()='" + name + "']//parent::td//preceding-sibling::td//input[@name='contact_id']"))
				.click();
	}

	public ContactsPage CreateNewContacthardcode1() throws InterruptedException {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText("Dr.");
		fn.sendKeys("OM");
		mn.sendKeys("oM");
		ln.sendKeys("OM");
		Select select1 = new Select(driver.findElement(By.name("suffix")));
		select1.selectByVisibleText("Esq.");
		Thread.sleep(2000);
		savebtn.click();
		Actions action = new Actions(driver);
		action.moveToElement(cl).build().perform();
		Thread.sleep(2000);
		Ncl.click();
		Thread.sleep(2000);
		return new ContactsPage();
	}

	public void CreateNewContacthardcode2() throws InterruptedException {
		Select select3 = new Select(driver.findElement(By.name("title")));
		select3.selectByVisibleText("Mr.");
		fn.sendKeys("OOM");
		mn.sendKeys("OOMM");
		ln.sendKeys("OOMM");
		Select select2 = new Select(driver.findElement(By.name("suffix")));
		select2.selectByVisibleText("III");
		Thread.sleep(2000);
		savebtn.click();

	}

	public void CreateNewContactdynamcode(String tit, String firstname, String middlename, String lastname,
			String suffix) throws InterruptedException {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(tit);
		fn.sendKeys(firstname);
		mn.sendKeys(middlename);
		ln.sendKeys(lastname);
		Select select1 = new Select(driver.findElement(By.name("suffix")));
		select1.selectByVisibleText(suffix);
		Thread.sleep(2000);
		savebtn.click();

	}

	public void CreateNewContactdynamcodefrommexcel(String title, String firstname, String middlename, String lastname,
			String suffix) throws InterruptedException {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		fn.sendKeys(firstname);
		mn.sendKeys(middlename);
		ln.sendKeys(lastname);
		Select select1 = new Select(driver.findElement(By.name("suffix")));
		select1.selectByVisibleText(suffix);
		Thread.sleep(2000);
		savebtn.click();
		Thread.sleep(1000);

	}

}
