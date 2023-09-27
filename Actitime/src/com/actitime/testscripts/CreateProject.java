package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.generic.POM.HomepagePOM;
import com.generic.POM.NewProjectPOM;
@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CreateProject extends BaseClass {
	@Test
	public void TestCreateProject() throws EncryptedDocumentException, IOException, InterruptedException {
		HomepagePOM h = new HomepagePOM(driver);
		h.getTaskButton().click();
		NewProjectPOM Np = new NewProjectPOM(driver);
		Np.getAddNewbtn().click();
		Thread.sleep(3000);
		Np.getNewProjbtn().click();
		Np.getProjName();
		Np.getCustomerdd().click();
		Thread.sleep(3000);
		Np.getSelectcompany(driver).click();
		Thread.sleep(3000);
		Np.getProjdesc();
		Thread.sleep(2000);
		Np.getTaskname(null);
		Np.getCreateproject().click();
		Thread.sleep(4000);
		h.getLogoutBtn().click();
		}
	
	

}
