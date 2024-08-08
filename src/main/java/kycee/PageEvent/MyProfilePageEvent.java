package kycee.PageEvent;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import com.mailosaur.MailosaurException;

import kycee.Base.BaseClass;
import kycee.PageObjects.ActivateAccountPageObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.SignInPageObject;
import kycee.PageObjects.SignUpPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;
import kycee.Utills.Constants;
import kycee.Utills.Xls_Reader;

public class MyProfilePageEvent extends BaseClass {

	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	ActivateAccountPageObject activatAccountObject = new ActivateAccountPageObject();
	SignUpPageObject signUpPageObject = new SignUpPageObject();
	SignInPageObject signInPageObject = new SignInPageObject();
	MyProfilePageObject myProfileobjct = new MyProfilePageObject();
	ConfigurationData configData = new ConfigurationData();
	Constants constant = new Constants();
	SoftAssert softAssert = new SoftAssert();
	protected WebDriverWait wait;

	public void verifySignInUserType(String userType) throws InterruptedException {
		switch (userType) {
		case "Customer":
			userType = "Customer";
			break;
		case "Business Admin":
			userType = "Admin";
			break;
		case "Business User":
			userType = "User";
			break;
		case "Super Admin":
			userType = "Super Admin";
			break;
		case "Blogger":
			userType = "Blogger";
			break;
		default:
			break;
		}
		String actualUserType = abstractC.getTextOfWebElement(myProfileobjct.getElementUserType());
		if (actualUserType.equals(userType)) {
			Assert.assertTrue(true,"Expected User Type:" + userType + "Actul User Type: " + actualUserType);
		}
		else {
			Logger.fail("Expected User Type:" + userType + "Actul User Type: " + actualUserType);
			Assert.assertTrue(false,"Expected User Type:" + userType + "Actul User Type: " + actualUserType);
		}
	}

	public void verifyMouseHoverFunctionalityAndClickInUploadPhoto() {
		abstractC.moveCursorToWebElement(myProfileobjct.getElementProfilePhoto(), 30);
		WebElement profileEditIcon =myProfileobjct.getElementProfilePhotoEditIcon();
		if (abstractC.isElementClickable(profileEditIcon)
				&& abstractC.isElementDisplayed(profileEditIcon)) {
			System.out.println("Edit Icon is Visible and Clikcable");
		}
		else {
			Logger.info("Either Edit icon in My prfile page is not clickable or not Visible");
		}
	}

	public void verifyInvalidFileUploadAsProfilePhoto() {
		abstractC.uploadFile(constant.invalidPNGFIle);
		abstractC.verifyTextOfthWebEement(signInPageObject.getElementNotificationMsg(),configData.ExpectedInvalidProfilePicUploadNotification);
	}

	public void verifyvalidFileUploadAsProfilePhoto() throws IOException{
		abstractC.uploadFile(configData.validPNGFIle);
		if (abstractC.isElementClickable(myProfileobjct.getElementProfileImgCancelBtn())
				&& abstractC.isElementDisplayed(myProfileobjct.getElementProfileImgCancelBtn())) {
			abstractC.verifyBackGroundColorOfTheElement(myProfileobjct.getElementProfileImgCancelBtn(), configData.ExpectedRedButtonColor );
			abstractC.clickElement(myProfileobjct.getElementProfileImgCancelBtn());
		}
		abstractC.moveCursorToWebElement(myProfileobjct.getElementProfilePhoto(), 30);
		abstractC.clickElement(myProfileobjct.getElementProfilePhotoEditIcon());
		Runtime.getRuntime().exec(configData.validImageAutoITPath);
		abstractC.clickElement(myProfileobjct.getElementProfileImgSubmitBtn());
		abstractC.verifyTextOfthWebEement(signInPageObject.getElementNotificationMsg(),configData.ExpectedSuccessFullEditingPersonalNotification);
	}

	public void verifyFieldValidationForPersonalInformationFields() {
		abstractC.clickElement(myProfileobjct.getElementPersonalInfoEditButton());
		abstractC.enterData(myProfileobjct.getElementEditFirstName(), "");
		abstractC.verifyTextOfthWebEement(myProfileobjct.getElementValidationMessage(), 
				configData.expectedFirstNameValidationMessage);
		abstractC.enterData(myProfileobjct.getElementEditFirstName(), "Archana");
		abstractC.enterData(myProfileobjct.getElementEditLastName(), "");
		abstractC.verifyTextOfthWebEement(myProfileobjct.getElementValidationMessage(), 
				configData.expectedLastNameValidationMessage);
		abstractC.enterData(myProfileobjct.getElementEditLastName(), "P");
		abstractC.enterData(myProfileobjct.getElementEditPhoneNumber(), "");
		abstractC.verifyTextOfthWebEement(myProfileobjct.getElementValidationMessage(), 
				configData.expectedEmptyPhoneNumberValidationMsg);
		abstractC.enterData(myProfileobjct.getElementEditPhoneNumber(), data.phoneNumber().phoneNumber());
		abstractC.enterData(myProfileobjct.getElementEditEmail(), "");
		abstractC.verifyTextOfthWebEement(myProfileobjct.getElementValidationMessage(), 
				configData.expectedEmptyEmailFieldErrorMsg);
	}

	public void verifyEditEmailFieldInPersonalDetails(String email) throws MailosaurException, IOException {
		abstractC.clickElement(myProfileobjct.getElementPersonalInfoEditButton());
		abstractC.enterData(myProfileobjct.getElementEditEmail(), email);
		abstractC.waitForSeconds(2);
		abstractC.clickElement(myProfileobjct.getElementPersonalInfoSubmitButton());
		abstractC.verifyTextOfthWebEement(myProfileobjct.getElementEmailActivationPopUpHeader(), configData.expectedEmailActivationPopUpHeader);
		verifyResendOTPButton(email);
		//	abstractC.waitForSeconds(310);
		String otp = emailReader.getEditEmailOTPFromEmail(email);
		// Enter OTP digits using different locators
		List<WebElement> otpFields = activatAccountObject.getElementOTP();
		for (int j = 0; j < otpFields.size(); j++) {
			String otpDigit = String.valueOf(otp.charAt(j));
			WebElement webElement = otpFields.get(j);
			webElement.sendKeys(otpDigit);
		}
		if (abstractC.isElementDisplayed(myProfileobjct.getElementEmailActivationPopUpHeader())) {
			System.out.println("verify Using expired OTP passed OTP filed is passed");
		}
		else {
			System.out.println("verify Using expired OTP passed OTP filed is Failed");	
		}
		abstractC.clickElement(myProfileobjct.getElementEmailActivationPopUpSubmitbtn());
		String actualToastMessage = abstractC.getTextOfWebElement(activatAccountObject.getElementToastMessage());
		if (actualToastMessage.contains(configData.expectedExpiredOTPToastMessage)) {
			System.out.println("Expired OTP Toast message is correct");
		}
		else {
			System.out.println("Expired OTP Toast message is incorrect");
		}
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

	public String VerifyOTPFieldsUsingValidOTP(String email) throws MailosaurException, IOException, InterruptedException {
		String otp = emailReader.getEditEmailOTPFromEmail(email);
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

	public void verifyOTPFieldsUsingInvalidOTP() {
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
