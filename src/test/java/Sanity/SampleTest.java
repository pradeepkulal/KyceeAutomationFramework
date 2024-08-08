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
import kycee.PageEvent.MyProfilePageEvent;
import kycee.PageEvent.SignInPageEvent;
import kycee.PageEvent.SignUpPageEvent;
import kycee.Utills.ConfigurationData;
import listeners.Retryanalyzer;

public class SampleTest extends BaseClass{
	@Test(priority = 0)
	public void verifyUsingBloggerLogin() throws InterruptedException, IOException {
		String usertype = "Business Admin";
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignInButton();
		SignInPageEvent signInEvent = new SignInPageEvent();
		DashBoardPageEvent dbEvent = signInEvent.login(usertype);
		dbEvent.VerifyNavigationToProfilePage();
		MyProfilePageEvent myProfileEvent = new MyProfilePageEvent();
		myProfileEvent.verifySignInUserType(usertype);
	}
	
}
