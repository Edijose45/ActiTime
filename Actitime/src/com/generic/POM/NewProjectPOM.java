package com.generic.POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.Filelib;

public class NewProjectPOM {
	@FindBy (xpath="//div[text()='Add New']")
	private WebElement AddNewbtn;
	
	@FindBy (xpath ="//div[@class='item createNewProject']")
	private WebElement NewProjbtn;
	
	@FindBy (xpath="(//input[@placeholder='Enter Project Name'])[2]")
	private WebElement ProjName;
	
	@FindBy (xpath="(//div[@class='dropdownButton'])[15]")
	private WebElement Customerdd; 
	
	@FindBy(xpath="//div[@class='itemRow cpItemRow selected']")
	private WebElement Selectcompany;
	
	
	@FindBy (xpath="//textarea[@placeholder='Add Project Description']")
	private WebElement Projdesc;
	
	@FindBy (xpath="(//input[@placeholder='Enter task name'])[1]")
	private WebElement Taskname;
	
	@FindBy (xpath="//div[text()='Create Project']")
	private WebElement Createproject;

	public NewProjectPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	public WebElement getAddNewbtn() {
		return AddNewbtn;
	}

	public WebElement getNewProjbtn() {
		return NewProjbtn;
	}

	public void getProjName() throws EncryptedDocumentException, IOException
	{
		Filelib f = new Filelib();
		String pdetails = f.getExcelData("ProjectDetails", 1, 0);
		ProjName.sendKeys(pdetails);
		
	}
	
	public WebElement getCustomerdd() {
		return Customerdd;
	}
	
	public WebElement getSelectcompany(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.click(Selectcompany);
		return Selectcompany;
	}
	
	
	public WebElement getProjdesc() throws EncryptedDocumentException, IOException {
		
		Filelib f = new Filelib();
		String pdesc = f.getExcelData("ProjectDetails", 1, 1);
		Projdesc.sendKeys(pdesc);
		return AddNewbtn;
	}
	
	
	public void getTaskname(WebElement taskname) throws EncryptedDocumentException, IOException {

		Filelib f = new Filelib();
		String Tname = f.getExcelData("ProjectDetails", 6, 2);
		Taskname.sendKeys(Tname);
	}
	

	public WebElement getCreateproject() {
		return Createproject;
	}

	public WebElement getSelectcustomer() {
		return null;
	}

	
	

		
	
}
