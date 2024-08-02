package Sanity;

import java.io.IOException;

import org.testng.annotations.Test;

import kycee.Base.BaseClass;
import kycee.PageEvent.DashBoardPageEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.SignInPageEvent;
import kycee.Utills.Xls_Reader;

public class DashBoardTest extends BaseClass {
	
	
	@Test
	public void verifyVerificationsCard() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signIn = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signIn.login("customer");
		dbEvent.verifyVerificationsCard();
	}
	
	@Test 
	public void verifyCreditsAvailableCard() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signIn = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signIn.login("customer");
		dbEvent.verifyCreditsAvailableCard();
	}
	
	@Test(dependsOnMethods={"verifyResendOTPFunctionaity"})
	public void verifyVerificationCountUsingCustomerLogin() throws InterruptedException, IOException {
		String usertype = "Customer";
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signInEvent.login(usertype);
		dbEvent.verifyVerificationCardCountOfUserType(usertype);
	}
	
	@Test
	public void verifyVerificationCountUsingBusinessAdminLogin() throws InterruptedException, IOException {
		String usertype = "Business Admin";
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signInEvent.login(usertype);
		dbEvent.verifyVerificationCardCountOfUserType(usertype);
	}
	
	@Test
	public void verifyVerificationCountUsingBusinessUserLogin() throws InterruptedException, IOException {
		String usertype = "Business User";
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signInEvent.login(usertype);
		dbEvent.verifyVerificationCardCountOfUserType(usertype);
	}
	
	@Test
	public void validationOfNavigationMenu() throws InterruptedException, IOException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent singInEvent = new SignInPageEvent();
		singInEvent.login("Business Admin");
		DashBoardPageEvent dbEvent = new DashBoardPageEvent();
		dbEvent.validationOfNavigationMenu();
	
	}
	
	
	
}
