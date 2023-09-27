package com.generic.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpagePOM {
	@FindBy (id = "username")
	private WebElement untbx;
	
	@FindBy (name = "pwd")
	private WebElement pwtbx;
	
	@FindBy (xpath = "//div[text() ='Login ']")
	private WebElement lgbtn;
	
	
	
	public LoginpagePOM ( WebDriver driver)//constructor
	{
		PageFactory.initElements(driver, this);
	}
		
		public void setLogin(String un, String pwd )
		{
			untbx.sendKeys(un);
			pwtbx.sendKeys(pwd);
			lgbtn.click();
			

}

}
