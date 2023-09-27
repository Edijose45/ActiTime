package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.generic.POM.HomepagePOM;
import com.generic.POM.NewProjectPOM;
import com.generic.POM.TasklistPOM;
@Listeners (com.actitime.generic.ListenerImplementation.class)

public class CreateCustomer extends BaseClass {
@Test
public void testcustomer() throws InterruptedException, EncryptedDocumentException, IOException
{
	HomepagePOM h= new HomepagePOM(driver);
	h.getTaskButton().click();
	TasklistPOM T = new TasklistPOM(driver);
	T.setAddNew();
	T.setNewCustomer(null);
	T.setName(null);
	T.setDescription(null);
	T.setDropdown(null);
	T.getCompany().click();
	T.setCreateBtn(null);
	T.setVerifyTitle(driver);
	Thread.sleep(4000);
	h.getLogoutBtn().click();
	
	
	
	
}
}
