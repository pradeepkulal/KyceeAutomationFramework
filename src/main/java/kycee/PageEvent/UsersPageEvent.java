package kycee.PageEvent;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;
import kycee.PageObjects.AddUserPageObject;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.UsersPageObject;
import kycee.PageObjects.VerificationPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;

public class UsersPageEvent extends BaseClass{


	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	DashBoardObject DBObjects = new DashBoardObject();
	MyProfilePageObject myProfileObject = new MyProfilePageObject();
	VerificationPageObject verificationPageObject = new VerificationPageObject();
	UsersPageObject usersObj = new UsersPageObject();
	AddUserPageObject addUserObj = new AddUserPageObject();
	
	ConfigurationData configData = new ConfigurationData();
	
	public AddUsersPageEvent verifyNavigationToAddUsersPage() {
		abstractC.waitForElementVisibility(driver, usersObj.getElementAddUsersBtn(),30);
		abstractC.clickElement(usersObj.getElementAddUsersBtn());
		abstractC.waitForSeconds(2);
		WebElement actualPageHeader = addUserObj.getElemenAddUsersPageHeader();
		abstractC.verifyTextOfthWebEement(actualPageHeader, configData.expectedAddUserHeader);
		return new AddUsersPageEvent();
	} 
	
	public boolean verifyTheDetailsInFirstRow(String firstName, String lastName, String email,String phoneNumber,
			String userType,String verification) {
		
		List<String> firstRowDetails = abstractC.getFirstRowDetails(usersObj.getElemenOfFirstRow());
		System.out.println(firstRowDetails);
		String fullName="";
		if (lastName.isEmpty()) {
			 fullName=firstName;
	}else {
		fullName=firstName+" "+lastName;
	}
		
		List<String> detailsList=new ArrayList<String>();
		detailsList.add(fullName.toLowerCase());
		detailsList.add(email);
		detailsList.add(phoneNumber);
		detailsList.add("pending");
		detailsList.add(userType);
		detailsList.add(verification);
		 for (String element : detailsList) {
			    if (!firstRowDetails.contains(element)) {
			      return false;
			    }
			  }
			  return true;
	}
	
}
