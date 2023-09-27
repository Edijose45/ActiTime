package com.generic.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePOM {
	@FindBy(id="container_tasks")
	private WebElement TaskButton;
	
	@FindBy (id="logoutLink")
	private WebElement LogoutBtn;
	
	
	public HomepagePOM(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}


	public WebElement getTaskButton() {
		return TaskButton;
	}


	public WebElement getLogoutBtn()
	{
		return LogoutBtn;
	}
	
	
}
