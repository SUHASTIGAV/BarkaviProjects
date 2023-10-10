package org.myproject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example {
	WebDriver driver;

	@BeforeClass
	private void LaunchUrl() throws InterruptedException {
		System.setProperty("Webdriver.firefox.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Eclipsesepproj\\Star360Proj\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
//	System.setProperty("Webdriver.edge.driver", "C:\\Users\\Admin\\eclipse-workspace\\Eclipsesepproj\\Star360Proj\\Driver\\msedgedriver.exe");
//	WebDriver driver=new EdgeDriver();
		driver.get("https://www.starthreesixty.com/");
		driver.manage().window().maximize();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Thread.sleep(10000);
		WebElement cookie = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		cookie.click();
		Thread.sleep(5000);

	}

	@BeforeMethod
	private void Welcome() throws InterruptedException {
		System.out.println("Welcome to *********Star360********");
		Thread.sleep(3000);
	}

	@Test
	public void SearchProduct() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		WebElement searchItem = driver.findElement(By.xpath("//input[@id='search']"));
		searchItem.sendKeys("Kids Shoes");
		WebElement searchbtn = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(searchbtn).click().build().perform();
		a.doubleClick(searchbtn).perform();
		Thread.sleep(20000);
		// searchbtn.click();
		WebElement item = driver.findElement(By.xpath(
				"(//a[@href='https://www.starthreesixty.com/speed-2-mens-lace-up-running-shoe-in-royal-blue-black.html'])[1]"));
		item.click();

		WebElement size = driver.findElement(By.xpath("//div[@id='option-label-us_shoe_size-284-item-7184']"));
		size.click();
		Thread.sleep(2000);
		WebElement addtocart = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
		addtocart.click();
		System.out.println("i found item");
	}

	@AfterMethod
	private void Thanks() {
		System.out.println("Thanks for Visited our Website");
		Date d = new Date();
		System.out.println("You logged out at:" + d);

	}

	@AfterClass
	private void Close() throws InterruptedException {
		Thread.sleep(20000);
//System.out.println("Bye");

	}
}
