package Sanity;

import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import kycee.Base.BaseClass;
import kycee.PageEvent.DashBoardPageEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.MyProfilePageEvent;
import kycee.PageEvent.SignInPageEvent;

public class SignInTest extends BaseClass {
	@Test
	public void signInPageErrorValidationTest() throws InterruptedException, IOException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		signInEvent.login();
		Thread.sleep(1000); 
	}
	
	@Test
	public void signInPageNotificationMessageTest() throws InterruptedException, IOException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		signInEvent.login_NotificationHandling();
		Thread.sleep(1000);
	}
	
	@Test
	public void verifyUsingCustomerLogin() throws InterruptedException, IOException {
		String usertype = "Customer";
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signInEvent.login(usertype);
		dbEvent.VerifyNavigationToProfilePage();
		MyProfilePageEvent myProfileEvent = new MyProfilePageEvent();
		myProfileEvent.verifySignInUserType(usertype);
	}
	
	@Test
	public void verifyUsingBusinessAdminLogin() throws InterruptedException, IOException {
		String usertype = "Business Admin";
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signInEvent.login(usertype);
		dbEvent.VerifyNavigationToProfilePage();
		MyProfilePageEvent myProfileEvent = new MyProfilePageEvent();
		myProfileEvent.verifySignInUserType(usertype);
	}
	
	@Test
	public void verifyUsingBusinessUserLogin() throws InterruptedException, IOException {
		String usertype = "Business User";
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signInEvent.login(usertype);
		dbEvent.VerifyNavigationToProfilePage();
		MyProfilePageEvent myProfileEvent = new MyProfilePageEvent();
		myProfileEvent.verifySignInUserType(usertype);
	}
	
	@Test
	public void verifyUsingSuperAdminLogin() throws InterruptedException, IOException {
		String usertype = "Super Admin";
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signInEvent.login(usertype);
		dbEvent.VerifyNavigationToProfilePage();
		MyProfilePageEvent myProfileEvent = new MyProfilePageEvent();
		myProfileEvent.verifySignInUserType(usertype);
	}
	
	@Test
	public void verifyUsingBloggerLogin() throws InterruptedException, IOException {
		String usertype = "Blogger";
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signInEvent.login(usertype);
		dbEvent.VerifyNavigationToProfilePage();
		MyProfilePageEvent myProfileEvent = new MyProfilePageEvent();
		myProfileEvent.verifySignInUserType(usertype);
	}
	
	@Test
	public void navigationToForgotPasswordPage() throws InterruptedException, IOException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent singInEvent = new SignInPageEvent();
		singInEvent.verifyNavigationToForgotPasswordPage();
	}
}
