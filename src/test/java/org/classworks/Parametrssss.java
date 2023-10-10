package org.classworks;

import org.helper.LibGlobal;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//Parameters
public class Parametrssss extends LibGlobal{
@BeforeClass
private void OpenBrowser() {
openFirefox();
maxWindow();

}
@Test
private void LaunchUrl() {
	driver.get("https://www.facebook.com/");
}
@AfterClass
public void Closelink()
{
	driver.close();
}
}
