package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyFirstTestFW extends BaseTest{

	@Test(dataProvider="testdata")
	public static void LoginTest(String username, String password) throws InterruptedException
	{
	     driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		 driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys(username);
		 driver.findElement(By.id(loc.getProperty("next_button"))).click();
		 Thread.sleep(4000);
		 driver.findElement(By.xpath(loc.getProperty("passwordField"))).sendKeys(password);
		 Thread.sleep(4000);
		 driver.findElement(By.xpath(loc.getProperty("login_nextbtn"))).click();
		 Thread.sleep(8000);
	}
	
	@DataProvider(name= "testdata")
	public Object[][] tData()
	{
	   return new Object[][] 
       {
		  {"madhavi.com","abacd@12"},
		  {"madhavi1233@.com","nmhasaffa3#"}, 
		  {"madhdddhd1234.com","fsafsdfdsggd!"},
		  {"madhavi.patil2019@gmail.com","Automation123#"}
	   };
	} 
	
}

