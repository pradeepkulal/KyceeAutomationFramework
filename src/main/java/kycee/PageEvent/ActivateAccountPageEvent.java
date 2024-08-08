package kycee.PageEvent;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.mailosaur.MailosaurException;

import kycee.Base.BaseClass;
import kycee.PageObjects.ActivateAccountPageObject;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.VerificationPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;
import kycee.Utills.Constants;

public class ActivateAccountPageEvent extends BaseClass{

	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	DashBoardObject DBObjects = new DashBoardObject();
	MyProfilePageObject myProfileObject = new MyProfilePageObject();
	VerificationPageObject verificationPageObject = new VerificationPageObject();
	ActivateAccountPageObject activatAccountObject = new ActivateAccountPageObject();
	ConfigurationData configData = new ConfigurationData();
	SoftAssert softAssert = new SoftAssert();
	protected WebDriverWait wait;

	public void verifyNavigationToActivateAccountPage() {
		WebElement pageHeader = abstractC.waitForElementVisibility(driver, activatAccountObject.getElementActivateAccountPopUpHeader(), 30);
		if(pageHeader.isDisplayed()) {
			System.out.println("Successfully navigated To Activate Account Pop Up");
		}else {
			Logger.fail("User is not navigated To Activate Account Pop Up");
			softAssert.assertTrue(false);
		}
	}

	public void verifyActivateAccountButton() {
		WebElement activateAcoountButton = activatAccountObject.getElementActivateAccountBtn();
		if(abstractC.isElementClickable(activateAcoountButton)) {
			System.out.println("Activate Account Button is clickable");
		}else {
			Logger.fail("Activate Account Button is Not clickable");
			softAssert.assertTrue(false);
		}
		//	abstractC.verifyColorOfTheElement(activateAcoountButton, configData.expectedAIButtonText );
		abstractC.clickElement(activateAcoountButton);


	}

	public String VerifyOTPFieldsUsingValidOTP(String email) throws MailosaurException, IOException, InterruptedException {
		String otp = emailReader.getotpFromEmailUsingID(email);
		// Enter OTP digits using different locators
		List<WebElement> otpFields = activatAccountObject.getElementOTP();
		for (int j = 0; j < otpFields.size(); j++) {
			String otpDigit = String.valueOf(otp.charAt(j));
			WebElement webElement = otpFields.get(j);
			webElement.sendKeys(otpDigit);
		}
		abstractC.waitForSeconds(2);
		return activatAccountObject.getElementToastMessage().getText();
	}

	public void VerifyOTPFieldsUsingExpiredOTP(String email) throws InterruptedException, MailosaurException, IOException {
		abstractC.waitForSeconds(310);
		String otp = emailReader.getotpFromEmailUsingID(email);
		// Enter OTP digits using different locators
		List<WebElement> otpFields = activatAccountObject.getElementOTP();
		for (int j = 0; j < otpFields.size(); j++) {
			String otpDigit = String.valueOf(otp.charAt(j));
			WebElement webElement = otpFields.get(j);
			webElement.sendKeys(otpDigit);
		}
		if (abstractC.isElementDisplayed(activatAccountObject.getElementActivateAccountPopUpHeader())) {
			System.out.println("verify Using expired OTP passed OTP filed is passed");
		}
		else {
			System.out.println("verify Using expired OTP passed OTP filed is Failed");	
		}
		abstractC.waitForSeconds(1);
		String actualToastMessage = abstractC.getTextOfWebElement(activatAccountObject.getElementToastMessage());
		if (actualToastMessage.contains(configData.expectedExpiredOTPToastMessage)) {
			System.out.println("Expired OTP Toast message is correct");
		}
		else {
			System.out.println("Expired OTP Toast message is incorrect");
		}

		abstractC.waitForSeconds(1);
	}

	public void verifyResendOTPButton(String email) {
		WebElement resendOtpButton = activatAccountObject.getElementResendOTP();
		if (abstractC.isElementClickable(resendOtpButton)) {
			System.out.println("Resend OTP button is clickable");
		}else {
			Logger.error("Resend OTP button is clickable");
			Assert.assertTrue(false);
		}

		abstractC.clickElement(resendOtpButton);
	}

	public void VerifyOTPFieldsUsingInvalidOTP() {
		String otp = "123456";
		// Enter OTP digits using different locators
		List<WebElement> otpFields = activatAccountObject.getElementOTP();
		for (int j = 0; j < otpFields.size(); j++) {
			String otpDigit = String.valueOf(otp.charAt(j));
			WebElement webElement = otpFields.get(j);
			webElement.sendKeys(otpDigit);
		}

		abstractC.waitForSeconds(1);
		String actualToastMessage = abstractC.getTextOfWebElement(activatAccountObject.getElementToastMessage());
		if (actualToastMessage.contains(configData.expectedInvalidOTPToastMessage)) {
			System.out.println("invalid OTP Toast message is correct");
		}
		else {
			System.out.println("Invalid OTP Toast message is incorrect :- "+ actualToastMessage);
		}	

		if (abstractC.isElementDisplayed(activatAccountObject.getElementActivateAccountPopUpHeader())) {
			System.out.println("verify Using invalid OTP passed OTP filed is passed");
		}
		else {
			System.out.println("verify Using invalid OTP passed OTP filed is Failed");	
		}
	}

}
