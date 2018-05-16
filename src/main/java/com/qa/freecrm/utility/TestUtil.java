package com.qa.freecrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.qa.freecrm.testbase.testBase;

public class TestUtil extends testBase {

	public static String TEST_DATA_PATH = "C:\\Users\\raop\\workspace\\com.freecrm.framework\\src\\main\\java\\com\\qa\\freecrm\\testdata\\Book1.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	public static long PAGE_LOAD_TIMEOUT = 1000;
	public static long IMPLICIT_WAIT = 1000;

	public void switctomainframe() {
		driver.switchTo().frame("mainpanel");
	}

	public void switchtoleftframe() {
		driver.switchTo().frame("processFrame");
	}

	public static Object[][] getTestData(String sheetName) {
		try {
			FileInputStream file = new FileInputStream(TEST_DATA_PATH);
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void TakesScreensshot() {

		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("user.dir" + "/Screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (WebDriverException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
