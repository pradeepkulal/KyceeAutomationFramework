package Sanity;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import kycee.Base.BaseClass;
import kycee.PageEvent.DashBoardPageEvent;
import kycee.PageEvent.ForgotPasswordPageEvent;
import kycee.PageEvent.GeneratePasswordEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.SignInPageEvent;
import kycee.Utills.AbstractComponents;

public class ForgotPasswordTest extends BaseClass{
	@Test (priority = 0)
	public void emailFieldErrorMessageInForgotPasswordPageTest() throws InterruptedException, IOException {
		String email =	testDataXL.getCellData(constant.credentialsSheet, constant.emailCol, 9);
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent singInEvent = new SignInPageEvent();
		singInEvent.verifyNavigationToForgotPasswordPage();
		ForgotPasswordPageEvent fpEvent = new ForgotPasswordPageEvent();
		fpEvent.verifyFieldValdationForEmailField();
	}


	@Test(priority = 1)
	public void verifyNavigationToSignInPageFromForgotPasswordPage() throws InterruptedException, IOException {
		HomePageEvent HMEvent = new HomePageEvent();
		SignInPageEvent signInEvnt = HMEvent.validateSignInButton();
		ForgotPasswordPageEvent fpEvnt = signInEvnt.verifyNavigationToForgotPasswordPage();
		fpEvnt.verifyNavigationToSignInPageFromForgotPasswordPage();

	}
	@Test(priority = 2)
	public void verifyNavigationToSignUpPageFromForgotPasswordPage() throws InterruptedException, IOException {
		HomePageEvent HMEvent = new HomePageEvent();
		SignInPageEvent signInEvnt = HMEvent.validateSignInButton();
		ForgotPasswordPageEvent fpEvnt = signInEvnt.verifyNavigationToForgotPasswordPage();
		fpEvnt.verifyNavigationToSignUpPageFromForgotPasswordPage();
	}

	@Test(priority = 3)
	public void verifyInvalidEmailIDErrorNotificationMessagesInForgotPasswordPage() throws InterruptedException, IOException {
		String email =	testDataXL.getCellData(constant.credentialsSheet, constant.emailCol, 9);
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent singInEvent = new SignInPageEvent();
		ForgotPasswordPageEvent fpEvent =singInEvent.verifyNavigationToForgotPasswordPage();
		fpEvent.verifyInvalidEmailIDErrorNotificationMessagesInForgotPasswordPage(email);
	}

	@Test(priority = 4)
	public void verifyTimeDiffrenceBetweenResetPasswordNotificationMessagesInForgotPasswordPage() throws InterruptedException, IOException {
		String email =	testDataXL.getCellData(constant.credentialsSheet, constant.emailCol, 9);
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent singInEvent = new SignInPageEvent();
		ForgotPasswordPageEvent fpEvent =singInEvent.verifyNavigationToForgotPasswordPage();
		fpEvent.verifyTimeDiffrenceBetweenResetPasswordNotificationMessagesInForgotPasswordPage(email);
	}

	@Test(priority = 5)
	public void verifyResetPasswordUsingExpiredLink() throws InterruptedException, IOException, MailosaurException {
		String email =	testDataXL.getCellData(constant.credentialsSheet, constant.emailCol, 9);
		String link = emailReader.getExpiredResetPasswordLinkFromEmail(email);
		GeneratePasswordEvent gpEvnt = new GeneratePasswordEvent();
		AbstractComponents.waitForSeconds(120);
		gpEvnt.verifyExpiredGeneratePasswordPageLink(link);
	}

	@Test(priority = 6)
	public void verifyFieldErrorMessageInResetPasswordPageTest() throws InterruptedException, IOException, MailosaurException {
		String email =	testDataXL.getCellData(constant.credentialsSheet, constant.emailCol, 9);
		String link = emailReader.getResetPasswordLinkFromEmail(email);
		ForgotPasswordPageEvent fpEvent = new ForgotPasswordPageEvent();
		GeneratePasswordEvent gpEvnt = fpEvent.verifyNavigationToResetPassword(link);
		gpEvnt.verifyfieldValidationInGeneratePasswordField();
	}
	@Test(priority = 7)
	public void verifyOldPasswordErrorNotificaationMessagesInResetPasswordField() throws InterruptedException, IOException, MailosaurException {
		String email =	testDataXL.getCellData(constant.credentialsSheet, constant.emailCol, 9);
		String link = emailReader.getResetPasswordLinkFromEmail(email);
		ForgotPasswordPageEvent fpEvent = new ForgotPasswordPageEvent();
		GeneratePasswordEvent gpEvnt = fpEvent.verifyNavigationToResetPassword(link);
		gpEvnt.verifyOldPasswordErrorNotificaationMessagesInGeneratePasswordField();
	}
	
	@Test(priority = 8)
	public void verifySuccessNotificationMessageInResetPasswordPageTestUsingNewLink() throws InterruptedException, IOException, MailosaurException {
		String email =	testDataXL.getCellData(constant.credentialsSheet, constant.emailCol, 9);
		String link = emailReader.getResetPasswordLinkFromEmail(email);
		ForgotPasswordPageEvent fpEvent = new ForgotPasswordPageEvent();
		GeneratePasswordEvent gpEvnt = fpEvent.verifyNavigationToResetPassword(link);
		gpEvnt.verifySuccessfulResetPassswordNotificaationMessagesInGeneratePasswordField();
		testDataXL.setCellData(constant.credentialsSheet, constant.passwordCol, 9, "Test@1234");
		System.err.println("Reset pasworrd 3");
		SignInPageEvent signInEvent = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signInEvent.login("New Business User");
	}
	
	
	@Test(priority = 10,dependsOnMethods = "verifySuccessNotificationMessageInResetPasswordPageTestUsingNewLink"                                                                  )
	public void verifyResetPasswordUsingExpiredLinkAfterResetingPasswordSuccessfuly() throws InterruptedException, IOException, MailosaurException {
		String email =	testDataXL.getCellData(constant.credentialsSheet, constant.emailCol, 9);
		String link = emailReader.getExpiredResetPasswordLinkFromEmail(email);
		ForgotPasswordPageEvent fpEvent = new ForgotPasswordPageEvent();
		GeneratePasswordEvent gpEvnt = new GeneratePasswordEvent();
		gpEvnt.verifyExpiredGeneratePasswordPageLink(link);
	}
	
	@Test(priority = 11)
	public void verifyMaximumAttemptsErrorNotificationMessagesInForgotPasswordPage() throws InterruptedException, IOException {
		String email =	testDataXL.getCellData(constant.credentialsSheet, constant.emailCol, 9);
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent singInEvent = new SignInPageEvent();
		ForgotPasswordPageEvent fpEvent =singInEvent.verifyNavigationToForgotPasswordPage();
		fpEvent.verifySuccessNotificationMessagesInForgotPasswordPage(email);
		fpEvent.verifyMaximumResetPasswordRequestNotificationMessagesInForgotPasswordPage(email);
	}


}
