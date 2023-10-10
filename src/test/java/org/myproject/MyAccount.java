package org.myproject;

import org.testng.annotations.Test;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.helper.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

public class MyAccount extends LibGlobal {
	WebDriver driver;

	@BeforeClass
	private void LaunchUrl() throws InterruptedException {
		System.setProperty("Webdriver.firefox.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Eclipsesepproj\\Star360Proj\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.starthreesixty.com/");
		driver.manage().window().maximize();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Thread.sleep(10000);
		WebElement cookie = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		cookie.click();
		Thread.sleep(5000);
	}

	@Test
	public void MyAccount() {
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("BARKAVI");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("V");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("bavy@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys("Barkavi@123");
		String confirmpass = pass.getAttribute("value");
		driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys(confirmpass);
		WebElement scrolldown = driver.findElement(By.xpath("//a[text()='Sale']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", scrolldown);
		// driver.findElement(By.xpath("//span[text()='Sign Up for
		// Newsletter']")).click();
	}
@Test
	public void Dob() {
	
		WebElement dob = driver.findElement(By.xpath("//input[@id='dob']"));
		dob.sendKeys("10-09-1988");
}
@Test
	public void Gender1() {
	
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='gender']")));
		dropdown.selectByIndex(1);
		System.out.println("gender clicked");
		driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
		System.out.println("Account created");
		driver.close();
	
}

private void Gender() {
	// TODO Auto-generated method stub
	
}
}
