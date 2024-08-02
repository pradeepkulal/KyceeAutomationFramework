package kycee.PageEvent;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.github.javafaker.Faker;

import kycee.Base.BaseClass;
import kycee.PageObjects.AddUserPageObject;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.UsersPageObject;
import kycee.PageObjects.VerificationPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;

public class AddUsersPageEvent extends BaseClass{

	AbstractComponents abstractC = new AbstractComponents();
	ConfigurationData configData = new ConfigurationData();
	
	UsersPageObject usersObj = new UsersPageObject();
	AddUserPageObject addUserObj = new AddUserPageObject();

	
	
	public void verifyCreationOfAdminTypeUser(String firstName, String lastName, String email,String phoneNumber,
			String userType, String verificationCount) throws InterruptedException {
		
		
		WebElement FirstName = addUserObj.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = addUserObj.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = addUserObj.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = addUserObj.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);
		
		WebElement userSelection = addUserObj.getElementUserTypeDropDown();
		abstractC.clickElement(userSelection);

		WebElement UserType = null;
		
		if(userType.equalsIgnoreCase("Admin")) {
			 UserType = addUserObj.getElementAdminSelection();
		}else if (userType.equalsIgnoreCase("User")) {
			 UserType = addUserObj.getElementUserSelection();
			
		}
		abstractC.clickElement(UserType);
		
		

		WebElement verification = addUserObj.getElementAllotVerificationInput();
		abstractC.enterData(verification, verificationCount); 
		
		abstractC.clickElement(addUserObj.getElementSubmitButton());
		abstractC.waitForElementToDisappear(driver, addUserObj.getElementLoader());
		abstractC.waitForSeconds(1);
		
		String actualTaostMessage = abstractC.getTextOfWebElement(addUserObj.getElementToastMessage());
		if (configData.expectedAddUserSuccessNotificationMessage.equals(actualTaostMessage)) {
			Assert.assertEquals(actualTaostMessage, configData.expectedAddUserSuccessNotificationMessage);
		} else {
			Logger.error("Error Message is Not correct");
			Assert.assertEquals(actualTaostMessage, configData.expectedAddUserSuccessNotificationMessage);
		}
	}

}
