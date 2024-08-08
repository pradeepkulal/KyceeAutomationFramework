package Sanity;

import java.io.IOException;

import org.testng.annotations.Test;

import kycee.Base.BaseClass;
import kycee.PageEvent.DashBoardPageEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.SignInPageEvent;
import kycee.PageEvent.SignUpPageEvent;
import kycee.Utills.Xls_Reader;

public class DashBoardTest extends BaseClass {
	
	
	@Test(description = "Verification of Verification Card in Customer Dasboard",groups = {"regression","customer"})
	public void verifyVerificationsCard() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signIn = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signIn.login("customer");
		dbEvent.verifyVerificationsCard();
	}
	
	@Test (description = "Verification of Credits Available Card in Customer Dasboard",groups = {"regression","customer"})
	public void verifyCreditsAvailableCard() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signIn = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signIn.login("customer");
		dbEvent.verifyCreditsAvailableCard();
	}
	
	@Test
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
	
	@Test(description = "validating Tour Fumctionality in Customer Dashboard", dependsOnMethods = "succeffullyActivateCustomerUser", priority = 2)
	public void validationOfTourFunctionalityInDashBoardForCustomer() throws InterruptedException{
		HomePageEvent HMEvent = new HomePageEvent();
		SignInPageEvent signInEvent = HMEvent.validateSignInButton();
		String email =	testDataXL.getCellData("sheet1", "Email", 7);
		String password = testDataXL.getCellData("sheet1", "Password", 7);
		DashBoardPageEvent dbEvnt = signInEvent.loginWith(email, password);
		dbEvnt.verifyTourFunctionalityInDashBoardOfCustomer();
	}
	
	
	
	
}
