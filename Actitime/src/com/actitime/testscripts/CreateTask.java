package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.generic.POM.HomepagePOM;
import com.generic.POM.NewTaskPOM;
@Listeners (com.actitime.generic.ListenerImplementation.class)

public class CreateTask extends BaseClass {
	@Test
	public void testCreateTask() throws InterruptedException, EncryptedDocumentException, IOException
	{
		HomepagePOM h = new HomepagePOM(driver);
		h.getTaskButton().click();
		NewTaskPOM  nt = new NewTaskPOM(driver);
		nt.getAddNewbtn().click();
		nt.getNewTask().click();
		Thread.sleep(3000);
		nt.getTask();
		Thread.sleep(5000);
		nt.getCreatetask().click();
		nt.getVerify(driver);
		Thread.sleep(2000);
		h.getLogoutBtn().click();
		
		
	}

}
