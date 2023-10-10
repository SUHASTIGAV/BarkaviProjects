package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	
	public static void openChrome()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static  void openFirefox()
	{
		WebDriverManager.chromedriver().setup();
		  driver = new FirefoxDriver();
	}
	public static  void openEdge()
	{
		WebDriverManager.chromedriver().setup();
		driver = new EdgeDriver();
	}	
	
	public static void closeBrowser() {
		driver.quit();
	}
	public static void closeBCurrentTab() {
		driver.close();
	}
public static void maxWindow()
{
	driver.manage().window().maximize();
}
public static void minWindow()
{
	driver.manage().window().minimize();
	}

public static void fetchTitle()
{
	String titleName = driver.getTitle();
	System.out.println(titleName);
}
public static void fetchUrl()
{
	String url = driver.getCurrentUrl();
	System.out.println(url);
}

//public static void launchUrl()
//{
//	driver.get("https://www.facebook.com/lite/");
//}


public static void launchUrl(String url)
{
	driver.get(url);
}

public static void hold(int time) throws InterruptedException
{
	Thread.sleep(time);
}

public static void fillTextbox(WebElement element, String input)
{
	element.sendKeys(input);
}

public static void toClick(WebElement ele) 
{
ele.click();
}

public static void mouseOvering(WebElement targetElement)
{
	Actions a = new Actions(driver);
	a.moveToElement(targetElement).perform();
	
}

public static void clickDouble(WebElement element)
{
	Actions a = new Actions(driver);
	a.doubleClick(element).perform();
	
}

public static void copy() throws AWTException
{
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_C);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_C);
}

public static void paste() throws AWTException
{
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_V);
}
public static void takeSnap() throws IOException
{ 
	TakesScreenshot tk = (TakesScreenshot) driver;
	File sr = tk.getScreenshotAs(OutputType.FILE);
	File de = new File ("C:\\Users\\Admin\\eclipse-workspace\\Mavenclass\\Screenshot\\img1.png");
	FileUtils.copyFile(sr, de);
}


public static void dateTime() 
{
	Date d = new Date();
	System.out.println(d);
}






}