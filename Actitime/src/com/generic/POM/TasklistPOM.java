package com.generic.POM;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actitime.generic.BaseClass;
import com.actitime.generic.Filelib;

public class TasklistPOM {
	Filelib f = new Filelib();
	
		@FindBy (xpath="//div[text()='Add New']")
		private WebElement AddNew;
	
		@FindBy (xpath="//div[@class='dropdownContainer addNewMenu']/div[1]")
		private WebElement NewCustomer;
	
		@FindBy (xpath="//input[@class ='inputFieldWithPlaceholder newNameField inputNameField']")
		private WebElement Name;

		@FindBy (xpath="//textarea[@placeholder='Enter Customer Description']")
		private WebElement Description;

		@FindBy (xpath="//div[.='- Select Customer -']")
		private WebElement Dropdown;
		
		@FindBy (xpath ="//div[.='Big Bang Company' and @class = 'itemRow cpItemRow ']")
		private WebElement company;
		
		@FindBy (xpath ="//div[text()='Create Customer']")
		private WebElement CreateBtn;
		
		@FindBy (xpath="//div[@class='titleEditButtonContainer']/div[@class='title']")
		private WebElement title;

		

		public TasklistPOM( WebDriver driver)//constructor
		{
			PageFactory.initElements(driver, this);
		}



		public void setAddNew() {
			AddNew.click();
		}



		public void setNewCustomer(WebElement newCustomer) {
			NewCustomer.click();
		}



		public void setName(WebElement name) throws EncryptedDocumentException, IOException {
			Name.click();
			String aname = f.getExcelData("CustomerDetails", 6, 0);			
			Name.sendKeys(aname);
		}



		public void setDescription(WebElement description) throws EncryptedDocumentException, IOException {

			Description.click();
			String desc = f.getExcelData("CustomerDetails", 6, 1);
			Description.sendKeys(desc);

			
		}


		public void setDropdown(WebElement dropdown) {
			Dropdown.click();
			
		}


		public WebElement getCompany() {
			return company;
		}

		public void setCreateBtn(WebElement createBtn) {
			CreateBtn.click();
		}


		public void setVerifyTitle(WebDriver driver) throws EncryptedDocumentException, IOException {
			String aname = f.getExcelData("CustomerDetails", 6, 0);	
			WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.textToBePresentInElement(title, aname));	
			String ename= title.getText();
			Assert.assertEquals(aname, ename);;

		}
		
		

}