package org.myproject;

import org.helper.LibGlobal;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testingfailedrerun.Rerun;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Allmenutest extends LibGlobal {
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
		Thread.sleep(5000);
		WebElement cookie = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		cookie.click();
		
	}
	

	@Test
	private void Bran() throws InterruptedException {
		Thread.sleep(2000);
		WebElement menu1 = driver.findElement(By.xpath("//a[text()='Brand']"));
		menu1.click();
		System.out.println("1st did");
		
		WebElement submenu2 = driver.findElement(By.xpath("(//a[text()='ASICS'])[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(submenu2).click();
		System.out.println("Ascis clicked");
	
	}
	
	@Test
	private void newIn() throws InterruptedException {
		Thread.sleep(5000); 
		//hard assert
		Assert.assertTrue("check newIn", 10>9);
		 WebElement menu2 = driver.findElement(By.xpath("//a[text()='NEW IN']"));
		 menu2.click();
		 WebElement men = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
		 men.click();
		WebElement tshirt = driver.findElement(By.xpath("(//a[@class='product-item-link'])[4]"));
		tshirt.click();
		
		
	}
	//rerun method
	@Test
	//(retryAnalyzer=Rerun.class)---done here
	private void men() throws InterruptedException {
		Thread.sleep(2000);
		WebElement menu3 = driver.findElement(By.xpath("(//a[text()='MEN'])[2]"));
						Actions a=new Actions(driver);
		a.moveToElement(menu3).build().perform();
		Thread.sleep(3000);
		
		WebElement sandal = driver.findElement(By.xpath("(//a[text()='SANDALS'])[2]"));
		sandal.click();
		
		driver.findElement(By.xpath("(//a[@class='product-item-link'])[4]")).click();
		Thread.sleep(2000);
		WebElement size = driver.findElement(By.xpath("//span[text()='Size guide']"));
		size.click();
		Thread.sleep(4000);
		WebElement sizenum = driver.findElement(By.xpath("(//div[@class='swatch-option text'])[1]"));
		sizenum.click();
		WebElement addtocart = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
		addtocart.click();
		
		
	}
//	@Test
//	private void women() {
//		WebElement menu4 = driver.findElement(By.xpath("(//a[text()='WOMEN'])[2]"));
//		Actions a=new Actions(driver);
//		a.moveToElement(menu4);
//		driver.findElement(By.xpath("(//a[text()='SANDALS'])[1]")).click();
//	}
	@AfterClass
	private void closeProject() {
		driver.close();

	}

}
