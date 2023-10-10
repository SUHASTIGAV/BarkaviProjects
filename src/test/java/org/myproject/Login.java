package org.myproject;
import org.openqa.selenium.WebDriver;
import org.helper.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login extends LibGlobal {
	
	@BeforeClass
	private void lauchUrl() throws InterruptedException {
		openFirefox();
		driver.get("https://www.starthreesixty.com/");
		maxWindow();
		Thread.sleep(5000);
		WebElement cookie = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		cookie.click();

	}
	@BeforeMethod
private void signIn() {
	System.out.println("***Welcome to Star360***");

}
	//@Parameters({"Email","Password"})
	@Test(dataProvider="Username")
	private void loginPage(String v1,String v2) throws InterruptedException {
		
		//here you have to put launch urlfor better result
		openFirefox();
		driver.get("https://www.starthreesixty.com/");
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		//fillTextbox(username, "barkavir@gmail.com");
		//apply parameters
		fillTextbox(username, v1);
		WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		fillTextbox(pass,v2);
		driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
		Thread.sleep(3000);
	}

	@AfterMethod
	private void afterTc() {
		System.out.println("You logged in");

	}
	@AfterClass
	private void afterClassend() throws InterruptedException {
		dateTime();
		Thread.sleep(10000);
		driver.close();

	}
//fixing 3 dataproviders
	@DataProvider (name = "Username")
	public String[][] Username() {
		return new String[][] {
		{"vinot","vinoth@123"},
		{"barkavi","123456"},
		{"barkavir@gmail.com","Vinoth@123"}
		};

	}
}
