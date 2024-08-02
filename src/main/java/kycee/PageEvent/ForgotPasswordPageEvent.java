package kycee.PageEvent;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.ForgotPasswordPageObject;
import kycee.PageObjects.GeneratePasswordPageObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.SignInPageObject;
import kycee.PageObjects.SignUpPageObject;
import kycee.PageObjects.VerificationPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;

public class ForgotPasswordPageEvent  extends BaseClass{
	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	SignInPageObject signInObj = new SignInPageObject();
	SignUpPageObject signUpObj = new SignUpPageObject();
	DashBoardObject DBObjects = new DashBoardObject();
	MyProfilePageObject myProfileObject = new MyProfilePageObject();
	VerificationPageObject verificationPageObject = new VerificationPageObject();
	ForgotPasswordPageObject fpObject = new ForgotPasswordPageObject();
	GeneratePasswordPageObject gpObject = new  GeneratePasswordPageObject();
	ConfigurationData configData = new ConfigurationData();


	public void verifyFieldValdationForEmailField() {
		abstractC.clickElement(fpObject.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(fpObject.getElementValidationMessage(), configData.expectedEmptyEmailFieldErrorMsg);
		abstractC.enterData(fpObject.getElementUserEmailInput(),"sadad");
		abstractC.verifyTextOfthWebEement(fpObject.getElementValidationMessage(), configData.expectedInvalidEmailFieldErrorMsg);
	}

	public void verifyTimeDiffrenceBetweenResetPasswordNotificationMessagesInForgotPasswordPage(String email) throws InterruptedException {
		verifySuccessNotificationMessagesInForgotPasswordPage(email);
		System.err.println("Reset pasworrd 1");
		Instant start = Instant.now();
		abstractC.waitForSeconds(80);
		abstractC.clickElement(fpObject.getElementSubmitBtn());
		String expString =  "Please wait 3 minutes before making another password reset request."; 
		abstractC.verifyTextOfthWebEement(fpObject.getElementNotificationMsg(), expString);
		abstractC.waitForSeconds(240);
		verifySuccessNotificationMessagesInForgotPasswordPage(email);
		System.err.println("Reset pasworrd 2");
	}

	public void verifySuccessNotificationMessagesInForgotPasswordPage(String email) throws InterruptedException {
		abstractC.enterData(fpObject.getElementUserEmailInput(),email);
		abstractC.clickElement(fpObject.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(fpObject.getElementNotificationMsg(), configData.expectedSuccessfulResetPasswordNotifyMsg);
	}

	public void verifyInvalidEmailIDErrorNotificationMessagesInForgotPasswordPage(String email) throws InterruptedException {
		abstractC.enterData(fpObject.getElementUserEmailInput(),"ksadkdsajl@gmail.com");
		abstractC.clickElement(fpObject.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(fpObject.getElementNotificationMsg(), configData.expectedNotRegisteredNotifyMsg);
	}

	public void verifyMaximumResetPasswordRequestNotificationMessagesInForgotPasswordPage(String email) throws InterruptedException {
		abstractC.enterData(fpObject.getElementUserEmailInput(),email);
		abstractC.clickElement(fpObject.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(fpObject.getElementNotificationMsg(), configData.expectedMaximumAttemptsResetPasswordNotifyMsg);
	}



	public GeneratePasswordEvent verifyNavigationToGeneratePassword(String link) {
		driver.get(link);
		WebElement actualPageHeader = gpObject.getElementGeneratePasswordPageHeader();
		abstractC.verifyTextOfthWebEement(actualPageHeader, configData.ExpectedGeneratePasswordPageHeader);
		return new GeneratePasswordEvent();
	}

	public GeneratePasswordEvent verifyNavigationToResetPassword(String link) {
		driver.get(link);
		WebElement actualPageHeader = gpObject.getElementGeneratePasswordPageHeader();
		abstractC.verifyTextOfthWebEement(actualPageHeader, configData.ExpectedResetPasswordPageHeader);
		return new GeneratePasswordEvent();
	}


	public SignInPageEvent verifyNavigationToSignInPageFromForgotPasswordPage() {
		abstractC.clickElement(fpObject.getElementSignInPageLink());
		WebElement actualPageHeader = signInObj.getElementSignInPageHeader();
		abstractC.verifyTextOfthWebEement(actualPageHeader, configData.ExpectedSignInPageHeader);
		return new SignInPageEvent();
	}

	public SignInPageEvent verifyNavigationToSignUpPageFromForgotPasswordPage() {
		abstractC.clickElement(fpObject.getElementSignUpPageLink());
		WebElement actualPageHeader = signUpObj.getElementSignUpPageHeader();
		abstractC.verifyTextOfthWebEement(actualPageHeader, configData.ExpectedSignUpPageHeader);
		return new SignInPageEvent();
	}
}
