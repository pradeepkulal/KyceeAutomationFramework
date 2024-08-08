package Sanity;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import kycee.Base.BaseClass;
import kycee.PageEvent.AddUsersPageEvent;
import kycee.PageEvent.DashBoardPageEvent;
import kycee.PageEvent.ForgotPasswordPageEvent;
import kycee.PageEvent.GeneratePasswordEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.SignInPageEvent;
import kycee.PageEvent.UsersPageEvent;

public class AddUserPageTest   extends BaseClass{
	@Test(priority = 0)
	public void succeffullyCreatingNewUserTest() throws InterruptedException, IOException, MailosaurException {

		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email = (firstName + lastName +  constant.serverDomain).toLowerCase();
		//"@yopmail.com";
		String phoneNumber = data.phoneNumber().phoneNumber();
		String userType ="User";
		String verificationCount ="0";
		String adminEmail =	testDataXL.getCellData(constant.credentialsSheet, constant.emailCol, 8);
		String adminPassword = testDataXL.getCellData(constant.credentialsSheet, constant.passwordCol, 8);
		HomePageEvent hmEvnt = new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt= signInEvnt.loginWith(adminEmail,adminPassword);
		int initialUserCount = dbEvnt.verifyUserCount();
		UsersPageEvent usersEvnt = dbEvnt.verifyNavigationToUserPage();
		AddUsersPageEvent addUsersEvnt = usersEvnt.verifyNavigationToAddUsersPage();
		addUsersEvnt.verifyCreationOfAdminTypeUser(firstName, lastName, email, phoneNumber, userType,verificationCount);
		dbEvnt.verifyNavigationToUserPageThroughNavigation();
		usersEvnt.verifyTheDetailsInFirstRow(firstName, lastName, email, phoneNumber, userType, verificationCount);

		dbEvnt.verifyNavigationToDashboardPage();
		int updatedUserCount = dbEvnt.verifyUserCount();
		if (updatedUserCount == initialUserCount + 1) {
			System.out.println("User count increased exactly by 1.");
		} else {

			System.out.println("Test Case Failed: User count did not increase by exactly 1.");
			Assert.assertTrue(false, "User Count is not increased by 1 count");
		}
		testDataXL.setCellData(constant.credentialsSheet, constant.emailCol, 9,email);
	}

	@Test(priority = 1, dependsOnMethods = {"succeffullyCreatingNewUserTest"})
	public void fieldValidationTestInGeneratePasswordPage() throws InterruptedException, IOException, MailosaurException {
		String email =	testDataXL.getCellData(constant.credentialsSheet,constant.emailCol,9);
		String link ="";
		try {
			link=emailReader.getGeneratePasswordLinkFromEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		GeneratePasswordEvent gpEvent = new GeneratePasswordEvent();
		gpEvent.verifyNavigationToGeneratePassword(link);
		gpEvent.verifyfieldValidationInGeneratePasswordField();
		gpEvent.verifySuccessfulGeneratePassswordNotificaationMessagesInGeneratePasswordField();
		testDataXL.setCellData(constant.credentialsSheet, constant.passwordCol, 9, "Test@123");
	}
}
