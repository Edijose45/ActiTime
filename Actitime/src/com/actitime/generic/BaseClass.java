
package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.generic.POM.LoginpagePOM;

public class BaseClass

{
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser()
	{
		Reporter.log("open browser", true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterTest
	public void closeBrowser()
	{
		Reporter.log("close browser", true);
		driver.quit();
		
	}
	@BeforeMethod
	public void login() throws IOException
	{
		Reporter.log("login", true);
		Filelib f= new Filelib();
		String url = f.getPropertyData("URL");
		String un =f.getPropertyData("USERNAME");
		String pwd =f.getPropertyData("PASSWORD");
		driver.get(url);
		LoginpagePOM lp= new LoginpagePOM(driver);
		lp.setLogin(un, pwd);
		
		
		
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("logout", true);
	}


	

}
