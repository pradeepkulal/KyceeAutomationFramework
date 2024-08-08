package kycee.PageEvent;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import kycee.Base.BaseClass;
import kycee.PageObjects.ChangePasswordObjects;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.UsersPageObject;
import kycee.PageObjects.VerificationPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;

public class ChangePasswordEvent extends BaseClass{

	AbstractComponents abstractC = new AbstractComponents();
	ConfigurationData configData = new ConfigurationData();
	DashBoardObject DBObjects = new DashBoardObject();
	ChangePasswordObjects cpObject = new ChangePasswordObjects();

	public void fieldValidationInChangePasswordPage(){
		abstractC.clickElement(cpObject.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(cpObject.getElementValidationMessage(), configData.expectedEmptyOldPasswordValidationMessage);
		abstractC.enterData(cpObject.getElementOldPassword(), "Test@123");
		abstractC.enterData(cpObject.getElementOldPassword(), Keys.ENTER);
		abstractC.verifyTextOfthWebEement(cpObject.getElementValidationMessage(), configData.expectedEmptyNewPasswordValidationMessage);
		abstractC.enterData(cpObject.getElementNewPassword(), "Test@123");
		abstractC.enterData(cpObject.getElementNewPassword(), Keys.ENTER);
		abstractC.verifyTextOfthWebEement(cpObject.getElementValidationMessage(), configData.expectedEmptyConfirmPasswordFieldErrorMsg);
		abstractC.enterData(cpObject.getElementConfirmPassword(), "Test@1234");
		abstractC.enterData(cpObject.getElementConfirmPassword(), Keys.ENTER);
		abstractC.verifyTextOfthWebEement(cpObject.getElementValidationMessage(), configData.expectedMismatchPasswordAndConfirmPasswordFieldErrorMsg);
	}

	public void verifyWithIncorrectOldPassword(){
		abstractC.enterData(cpObject.getElementOldPassword(), "ASTss@123");
		abstractC.enterData(cpObject.getElementOldPassword(), Keys.ENTER);
		abstractC.enterData(cpObject.getElementNewPassword(), "Test@1234");
		abstractC.enterData(cpObject.getElementNewPassword(), Keys.ENTER);
		abstractC.enterData(cpObject.getElementConfirmPassword(), "Test@1234");
		abstractC.enterData(cpObject.getElementConfirmPassword(), Keys.ENTER);
		abstractC.verifyTextOfthWebEement(cpObject.getElementNotificationMsg(), configData.expectedIncorrectOldPasswordNotificationErrorMsg);
		abstractC.moveCursorToWebElement(cpObject.getElementChangePasswordPageHeader(), 30);
	}

	public void verifySucessfullyChangingThePassword(String passWord1,String passWord2){
		changePassword(passWord1, passWord2, passWord2);
		abstractC.verifyTextOfthWebEement(cpObject.getElementNotificationMsg(), configData.expectedSuccessFullPasswordChangeNotificationErrorMsg);
		abstractC.moveCursorToWebElement(cpObject.getElementChangePasswordPageHeader(), 30);
	}

	public void changePassword(String oldPassword,String newPassword,String confirmNewPassword) {
		abstractC.enterData(cpObject.getElementOldPassword(), oldPassword);
		abstractC.enterData(cpObject.getElementOldPassword(), Keys.TAB);
		abstractC.enterData(cpObject.getElementNewPassword(), newPassword);
		abstractC.enterData(cpObject.getElementNewPassword(), Keys.TAB);
		abstractC.enterData(cpObject.getElementConfirmPassword(), confirmNewPassword);
		abstractC.enterData(cpObject.getElementConfirmPassword(), Keys.ENTER);
	}

	public void verifytheTmeDiffrenceBetweenChangingThePassword(String passWord2, String passWord3) {
		changePassword(passWord2, passWord3, passWord3);
		abstractC.verifyTextOfthWebEement(cpObject.getElementNotificationMsg(), configData.expectedTimeDifrenceErrorNotificationMsg);
		abstractC.moveCursorToWebElement(cpObject.getElementChangePasswordPageHeader(), 30);
	}

	public void changePasswordUsingLastThreePassword(String passWord)  {
		changePassword(passWord,passWord, passWord);
		abstractC.verifyTextOfthWebEement(cpObject.getElementNotificationMsg(), configData.expectedPasswordLastThreeErrorNotificationMessage);
		abstractC.moveCursorToWebElement(cpObject.getElementChangePasswordPageHeader(), 30);
	}

	public void verifyMaximumResetPasswordRequestNotificationMessagesInForgotPasswordPage(String passWord2, String passWord3) {
		changePassword(passWord2, passWord3, passWord3);
		abstractC.verifyTextOfthWebEement(cpObject.getElementNotificationMsg(), configData.expectedMaximumAttemptsResetPasswordNotifyMsg);
		abstractC.moveCursorToWebElement(cpObject.getElementChangePasswordPageHeader(), 30);
	}

}
