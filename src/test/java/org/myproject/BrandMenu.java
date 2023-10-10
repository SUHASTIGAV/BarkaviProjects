package org.myproject;

import javax.annotation.WillNotClose;

import org.helper.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrandMenu extends LibGlobal {

	WebDriver driver;

	@BeforeClass
	private void LaunchUrl() throws InterruptedException {
		System.setProperty("Webdriver.firefox.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Eclipsesepproj\\Star360Proj\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		// openFirefox();
		driver.get("https://www.starthreesixty.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		WebElement cookie = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		cookie.click();
		Thread.sleep(2000);
	}

	@BeforeMethod
	private void beforeTc() {
		fetchTitle();
	}

	@Test
	private void Bran() {
		WebElement menu1 = driver.findElement(By.xpath("//a[text()='Brand']"));
		menu1.click();
		driver.findElement(By.xpath("(//a[text()='ASICS'])[2])")).click();
		driver.findElement(By.xpath("//div[@option-id='7178']")).click();
		WebElement sortby = driver.findElement(By.xpath("(//select[@id='sorter'])[1]"));
		Select s = new Select(sortby);
		s.selectByIndex(3);
		String print = sortby.getAttribute("Value");
		System.out.println(print);
	}

	@AfterMethod
	private void afterTc() {
		dateTime();

	}

	@AfterClass
	public void Closewin() {
		// driver.close();
	}

}
