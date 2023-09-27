package com.generic.POM;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actitime.generic.Filelib;

public class NewTaskPOM {
	@FindBy (xpath="//div[text()='Add New']")
	private WebElement AddNewbtn;
	
	@FindBy (xpath ="//div[text()='+ New Tasks']")
	private WebElement NewTask;
	
	@FindBy (xpath="(//div[@class='comboboxButton'])[1]")
	private WebElement SelectCustomer;
	
	@FindBy (xpath="//div[.='SBI_006' and @class='itemRow cpItemRow selected']")
	private WebElement choosecustomer;
	
	@FindBy (xpath ="//div[text()='- Select Project -']")
	private WebElement SelectProject;
	
	@FindBy (xpath="(//input[@placeholder='Enter task name'])[1]")
	private WebElement Task;
	
	
	@FindBy (xpath="//div[text()='Create Tasks']")
	private WebElement Createtask;
	
	@FindBy (xpath="//div[@class='title' and @title='NewTask1']")
	private WebElement verify;
	
	public NewTaskPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddNewbtn() {
		return AddNewbtn;
	}

	public WebElement getNewTask() {
		return NewTask;
	}

	public WebElement getSelectCustomer() {
		return SelectCustomer;
	}

	public WebElement getChoosecustomer(WebDriver driver) {
		Actions t = new Actions(driver);
		t.click(choosecustomer);
		return choosecustomer;
	}

	public WebElement getSelectProject() {
		return SelectProject;
	}

	public WebElement getTask() throws EncryptedDocumentException, IOException {
		Filelib f = new Filelib();
		String Tdetails = f.getExcelData("TaskDetails", 1, 0);
		Task.sendKeys(Tdetails);
		
		return Task;
	}

	public WebElement getCreatetask() throws InterruptedException {
		return Createtask;
	}
	
	public void getVerify(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		Filelib f = new Filelib();
		String Tdetails = f.getExcelData("TaskDetails", 1, 0);
		String atDetails = verify.getText();
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(verify, Tdetails));	
		
		Assert.assertEquals(Tdetails, atDetails);
	}
	
	
	
}
