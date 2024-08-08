package kycee.PageEvent;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import kycee.Base.BaseClass;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.ForgotPasswordPageObject;
import kycee.PageObjects.GeneratePasswordPageObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.VerificationPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;

public class GeneratePasswordEvent extends BaseClass{
	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	DashBoardObject DBObjects = new DashBoardObject();
	ForgotPasswordPageObject fpObject = new ForgotPasswordPageObject();
	GeneratePasswordPageObject gpObj = new GeneratePasswordPageObject();
	ConfigurationData configData = new ConfigurationData();
	
	public GeneratePasswordEvent verifyNavigationToGeneratePassword(String link) {
		driver.get(link);
		WebElement actualPageHeader = gpObj.getElementGeneratePasswordPageHeader();
		abstractC.verifyTextOfthWebEement(actualPageHeader, configData.ExpectedGeneratePasswordPageHeader);
		return new GeneratePasswordEvent();
	}
	
	public void verifyfieldValidationInGeneratePasswordField() {

		abstractC.clickElement(gpObj.getElementSubmitBtn());
		WebElement actualValidationMessage =gpObj.getElementValidationMessage();
		
		abstractC.verifyTextOfthWebEement(actualValidationMessage, configData.expectedEmptyPasswordFieldErrorMsg);
		abstractC.enterData(gpObj.getElementPassword(), "Test@123");
		gpObj.getElementPassword().sendKeys(Keys.ENTER);
		actualValidationMessage =gpObj.getElementValidationMessage();
		abstractC.verifyTextOfthWebEement(actualValidationMessage, configData.expectedEmptyConfirmPasswordFieldErrorMsg);
		abstractC.enterData(gpObj.getElementConfirmPassword(), "Test@1233");
		actualValidationMessage =gpObj.getElementValidationMessage();
		abstractC.verifyTextOfthWebEement(actualValidationMessage, configData.expectedMismatchPasswordAndConfirmPasswordFieldErrorMsg);
	
	}

	public void verifyOldPasswordErrorNotificaationMessagesInGeneratePasswordField() {
		abstractC.enterData(gpObj.getElementPassword(),"Test@123");
		gpObj.getElementPassword().sendKeys(Keys.ENTER);
		abstractC.enterData(gpObj.getElementConfirmPassword(),"Test@123");
		gpObj.getElementConfirmPassword().sendKeys(Keys.ENTER);
		System.out.println("jk");
		abstractC.verifyTextOfthWebEement(gpObj.getElementNotificationMsg(), configData.expectedOldPasswordErrorNotification);
	}
	
	public void verifySuccessfulGeneratePassswordNotificaationMessagesInGeneratePasswordField() {
		abstractC.enterData(gpObj.getElementPassword(),"Test@123");
		gpObj.getElementPassword().sendKeys(Keys.ENTER);
		abstractC.enterData(gpObj.getElementConfirmPassword(),"Test@123");
		gpObj.getElementConfirmPassword().sendKeys(Keys.ENTER);
		abstractC.verifyTextOfthWebEement(gpObj.getElementNotificationMsg(), configData.expectedSuccessfulGeneratePassswordNotification);
	}
	
	public void verifySuccessfulResetPassswordNotificaationMessagesInGeneratePasswordField() {
		abstractC.enterData(gpObj.getElementPassword(),"Test@1234");
		gpObj.getElementPassword().sendKeys(Keys.ENTER);
		abstractC.enterData(gpObj.getElementConfirmPassword(),"Test@1234");
		gpObj.getElementConfirmPassword().sendKeys(Keys.ENTER);
		abstractC.verifyTextOfthWebEement(gpObj.getElementNotificationMsg(), configData.expectedSuccessfulResetPassswordNotification);
	}
	
	public void verifyExpiredGeneratePasswordPageLink(String link) throws IOException {
		driver.get(link);
		WebElement pageExpiredText = gpObj.getElementPageExpiredText();		
		if (abstractC.isElementDisplayed(gpObj.getElementPageExpiredText())) {
			abstractC.verifyTextOfthWebEement(pageExpiredText, configData.expectedPageExpiredText);
			
		}	
		else {
			Assert.assertTrue(false,"Link is not expired");
		}
				
	
	}
	

}
