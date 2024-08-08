package Sanity;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.configuration.Config;

import kycee.Base.BaseClass;
import kycee.PageEvent.ChangePasswordEvent;
import kycee.PageEvent.DashBoardPageEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.SignInPageEvent;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;

public class ChangePasswordTest extends BaseClass{

	String passWord1="Test@123";
	String passWord2="Test@1234";
	String passWord3="Test@12345";
	String passWord4="Test@123456";

	@Test(priority = 0)
	public void VerifyFieldValidationInChangePasswordPage() throws IOException {
		String email =	testDataXL.getCellData(constant.credentialsSheet,constant.emailCol, 7);
		HomePageEvent hmEvnt = new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt = signInEvnt.loginWith(email,passWord1);
		ChangePasswordEvent cpEvnt =  dbEvnt.verifyNavigationToChangePasswordPage();
		cpEvnt.fieldValidationInChangePasswordPage();
	}

	@Test(priority = 1)
	public void VerifyWithIncorrectOldPasswordInChangePasswordPage() throws IOException {
		String email =	testDataXL.getCellData(constant.credentialsSheet,constant.emailCol, 7);
		HomePageEvent hmEvnt = new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt = signInEvnt.loginWith(email,passWord1);
		ChangePasswordEvent cpEvnt =  dbEvnt.verifyNavigationToChangePasswordPage();
		cpEvnt.verifyWithIncorrectOldPassword();
	}

	@Test(priority = 2)
	public void VerifyChangingThePasswordSuccessFullyForFirstTime() throws IOException {
		String email =	testDataXL.getCellData(constant.credentialsSheet,constant.emailCol, 7);
		HomePageEvent hmEvnt = new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt =signInEvnt.loginWith(email,passWord1);
		ChangePasswordEvent cpEvnt =  dbEvnt.verifyNavigationToChangePasswordPage();
		cpEvnt.changePasswordUsingLastThreePassword(passWord1);
		AbstractComponents.waitForSeconds(5);
		try {
			cpEvnt.verifySucessfullyChangingThePassword(passWord1, passWord2);
		} catch (Exception e) {
			driver.navigate().refresh();
			AbstractComponents.waitForSeconds(10);	
			e.printStackTrace();
			}
	}

	@Test(priority = 3)
	public void VerifyLogInFunctionalityChangingThePasswordSuccessFullyForFirstTime() throws IOException {
		String email =	testDataXL.getCellData(constant.credentialsSheet,constant.emailCol, 7);
		String OldPasword = testDataXL.getCellData(constant.credentialsSheet,constant.passwordCol, 7);
		HomePageEvent hmEvnt = new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		ConfigurationData configData = new ConfigurationData();
		signInEvnt.loginWithErrorotifications(email, OldPasword,
				configData.expectedIncorrectPasswordNotificationErrorMsg);
		DashBoardPageEvent dbEvnt = signInEvnt.loginWith(email, passWord2);
		ChangePasswordEvent cpEvnt =  dbEvnt.verifyNavigationToChangePasswordPage();
		cpEvnt.verifytheTmeDiffrenceBetweenChangingThePassword(passWord2,passWord3);
		AbstractComponents.waitForSeconds(360);
		cpEvnt.changePasswordUsingLastThreePassword(passWord2);
		AbstractComponents.waitForSeconds(5);
		cpEvnt.verifySucessfullyChangingThePassword(passWord2, passWord3);
		AbstractComponents.waitForSeconds(5);
		cpEvnt.verifytheTmeDiffrenceBetweenChangingThePassword(passWord3,passWord4);
		AbstractComponents.waitForSeconds(360);
		cpEvnt.changePasswordUsingLastThreePassword(passWord3);
		AbstractComponents.waitForSeconds(5);
		try {
			cpEvnt.verifySucessfullyChangingThePassword(passWord3, passWord4);
		} catch (Exception e) {
			AbstractComponents.waitForSeconds(10);
			driver.navigate().refresh();
			}
		AbstractComponents.waitForSeconds(5);
		cpEvnt.verifyMaximumResetPasswordRequestNotificationMessagesInForgotPasswordPage(OldPasword, OldPasword);
		testDataXL.setCellData(constant.credentialsSheet, constant.passwordCol, 7, passWord4);
	}

}
