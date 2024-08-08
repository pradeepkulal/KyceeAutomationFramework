package Sanity;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import kycee.Base.BaseClass;
import kycee.PageEvent.DashBoardPageEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.MyProfilePageEvent;
import kycee.PageEvent.SignInPageEvent;

public class MyProfilePageTest extends BaseClass{
	
	@Test(description = "Verification of Navigation to Customer My Profile Page",
			priority = 0,groups = {"regression","customer"})
	public void	verifyNavigationToCutomerMyProfilePage() throws IOException, InterruptedException {
		HomePageEvent hmEvnt =new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt= signInEvnt.login("New Customer");
		MyProfilePageEvent mpEvnt = dbEvnt.VerifyNavigationToProfilePage();
		mpEvnt.verifySignInUserType("Customer");
	}
	
	@Test(description = "Verifiying the Negative and Positive Scenarios while uplaoading Profile Photo",
			priority = 1,groups = {"regression","customer"})
	public void	verifyUploadingProfilePhotoInCutomerMyProfilePage() throws IOException, InterruptedException {
		HomePageEvent hmEvnt =new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt= signInEvnt.login("New Customer");
		MyProfilePageEvent mpEvnt = dbEvnt.VerifyNavigationToProfilePage();
		mpEvnt.verifyMouseHoverFunctionalityAndClickInUploadPhoto();
		mpEvnt.verifyInvalidFileUploadAsProfilePhoto();
		mpEvnt.verifyvalidFileUploadAsProfilePhoto();
		
	}
	
	@Test(description = "Verifiying the Field validation Message while editing Personal details",
			priority = 2,groups = {"regression","customer"})
	public void	verifyFieldErrorValidationMessagesInEditPesonalDetails() throws IOException, InterruptedException {
		HomePageEvent hmEvnt =new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt= signInEvnt.login("New Customer");
		MyProfilePageEvent mpEvnt = dbEvnt.VerifyNavigationToProfilePage();
		mpEvnt.verifyFieldValidationForPersonalInformationFields();
	}
	
	@Test(description = "Verifiying the  editing the email id in Personal details",
			priority = 3,groups = {"regression","customer"})
	public void	verifyEditEmailFunctionalityInEditPesonalDetails() throws IOException, InterruptedException, MailosaurException {
		HomePageEvent hmEvnt =new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt= signInEvnt.login("New Customer");
		MyProfilePageEvent mpEvnt = dbEvnt.VerifyNavigationToProfilePage();
		String email = data.name().firstName()+constant.serverDomain;
		mpEvnt.verifyEditEmailFieldInPersonalDetails(email);
	//	mpEvnt.verifyOTPFieldsUsingInvalidOTP();
		
	}

}
