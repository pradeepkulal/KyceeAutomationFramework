package Sanity;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import kycee.Base.BaseClass;
import kycee.PageEvent.ActivateAccountPageEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.SignInPageEvent;
import kycee.PageEvent.SignUpPageEvent;
import kycee.Utills.ConfigurationData;

public class ActivationPopUpTest  extends BaseClass{
	@Test(description = "Successfully activating Customer profile in first attempt",priority = 0)
	public void succeffullyActivateCustomerUser() throws InterruptedException, IOException, MailosaurException {
		HomePageEvent HMEvent = new HomePageEvent();
		SignInPageEvent signInEvent = HMEvent.validateSignInButton();
		String email =	testDataXL.getCellData("sheet1", "Email", 7);
		String password = testDataXL.getCellData("sheet1", "Password", 7);
		signInEvent.loginWith(email, password);
		ActivateAccountPageEvent acountActivateEvent = new ActivateAccountPageEvent();
		acountActivateEvent.verifyNavigationToActivateAccountPage();
		acountActivateEvent.verifyActivateAccountButton();
		ConfigurationData configData = new ConfigurationData();
		String actualToastMessage = acountActivateEvent.VerifyOTPFieldsUsingValidOTP(email);
		if (actualToastMessage.equals(configData.ExpectedSuccessfillActivationOfCustomerNotification)) {
			Assert.assertEquals(actualToastMessage, configData.ExpectedSuccessfillActivationOfCustomerNotification);
		}else {
			Assert.assertEquals(actualToastMessage, configData.ExpectedSuccessfillActivationOfCustomerNotification);
		}
	}
	
	public void verifyResendOTPFunctionaity() throws InterruptedException, IOException, MailosaurException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignUpButton();
		SignUpPageEvent signUpEvent = new SignUpPageEvent();
		signUpEvent.successfullyCreatingNewCustomer();
		Thread.sleep(5000); 
		String email =	testDataXL.getCellData("sheet1", "Email", 7);
		String password = testDataXL.getCellData("sheet1", "Password", 7);
		SignInPageEvent signInEvent = new SignInPageEvent();
	
		signInEvent.loginWith(email, password);
		ActivateAccountPageEvent acountActivateEvent = new ActivateAccountPageEvent();
		acountActivateEvent.verifyNavigationToActivateAccountPage();
		acountActivateEvent.verifyActivateAccountButton();
		acountActivateEvent.VerifyOTPFieldsUsingInvalidOTP();
		acountActivateEvent.VerifyOTPFieldsUsingExpiredOTP(email);
		acountActivateEvent.verifyResendOTPButton(email);
		ConfigurationData configData = new ConfigurationData();
		String actualToastMessage = acountActivateEvent.VerifyOTPFieldsUsingValidOTP(email);
		if (actualToastMessage.equals(configData.ExpectedSuccessfillActivationOfCustomerNotification)) {
			Assert.assertEquals(actualToastMessage, configData.ExpectedSuccessfillActivationOfCustomerNotification);
		}else {
			Assert.assertEquals(actualToastMessage, configData.ExpectedSuccessfillActivationOfCustomerNotification);
		}
	}
}
