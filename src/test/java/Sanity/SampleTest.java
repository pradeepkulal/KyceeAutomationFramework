package Sanity;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import kycee.Base.BaseClass;
import kycee.PageEvent.ActivateAccountPageEvent;
import kycee.PageEvent.DashBoardPageEvent;
import kycee.PageEvent.ForgotPasswordPageEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.SignInPageEvent;
import kycee.PageEvent.SignUpPageEvent;
import listeners.Retryanalyzer;

public class SampleTest extends BaseClass{
	@Test
	public void notificationMessageInForgotPasswordPageTest() throws InterruptedException, IOException {
		String email =	testDataXL.getCellData("sheet1", "Email", 7);
		HomePageEvent HMEvent = new HomePageEvent();
		SignUpPageEvent singUpEvent = HMEvent.validateSignUpButton();
		singUpEvent.successfullyCreatingNewCustomer();
	}

}
