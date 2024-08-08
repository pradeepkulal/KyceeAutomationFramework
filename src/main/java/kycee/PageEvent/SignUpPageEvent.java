package kycee.PageEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

import kycee.Base.BaseClass;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.SignUpPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;
import kycee.Utills.Constants;

public class SignUpPageEvent extends BaseClass{

	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	SignUpPageObject signUpPageObject = new SignUpPageObject();
	ConfigurationData configData = new ConfigurationData();

	public void validationOfSignUpPage() throws InterruptedException {
		String firstName = "";
		String lastName = "";
		String email = "";
		String phoneNumber = "";
		String password = "";
		String confirmPassword = "";
		String companyName = "";
		String cin_Number = ""; 
		String gstin_Number = "";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);


		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		WebElement CIN_Number  = signUpPageObject.getElementGSTIN_Number();
		abstractC.enterData(CIN_Number, cin_Number);

		WebElement GSTIN_Number = signUpPageObject.getElementCIN_Number();
		abstractC.enterData(GSTIN_Number, gstin_Number);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());

		WebElement validationMssage = signUpPageObject.getElementValidationMessage();

		if (abstractC.isElementDisplayed(validationMssage) 
				&& abstractC.isElementDisplayed(signUpPageObject.getElementLastNameErrorIcon())
				&& abstractC.isElementDisplayed(signUpPageObject.getElementEmailErrorIcon())
				&& abstractC.isElementDisplayed(signUpPageObject.getElementPhoneErrorIcon())
				&& abstractC.isElementDisplayed(signUpPageObject.getElementPasswordErrorIcon())
				&& abstractC.isElementDisplayed(signUpPageObject.getElementConfirmPasswordErrorIcon())) {
			System.out.println("Validation Message is Displayed");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Validation Message is not Displayed");
			Assert.assertTrue(false);
		}
	}

	public void valiationOfLastName() {
		String firstName = "Pradeep";
		String lastName = "";
		String email = "";
		String phoneNumber = "";
		String password = "";
		String confirmPassword = "";
		String companyName = "";
		String cin_Number = "";
		String gstin_Number = "";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		WebElement CIN_Number  = signUpPageObject.getElementGSTIN_Number();
		abstractC.enterData(CIN_Number, cin_Number);

		WebElement GSTIN_Number = signUpPageObject.getElementCIN_Number();
		abstractC.enterData(GSTIN_Number, gstin_Number);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());

		WebElement validationMssage = signUpPageObject.getElementValidationMessage();

		String actualValidationMessage = abstractC.getTextOfWebElement(validationMssage);

		if (abstractC.isElementDisplayed(validationMssage)
				&& abstractC.isElementDisplayed(signUpPageObject.getElementEmailErrorIcon())
				&& abstractC.isElementDisplayed(signUpPageObject.getElementPhoneErrorIcon())
				&& abstractC.isElementDisplayed(signUpPageObject.getElementPasswordErrorIcon())
				&& abstractC.isElementDisplayed(signUpPageObject.getElementConfirmPasswordErrorIcon())) {
			Assert.assertEquals(actualValidationMessage,configData.expectedLastNameValidationMessage);
		}
		else {
			System.out.println("Last Name Error Message is Proper " + actualValidationMessage);
		}

	}

	public void valiationOfEmailField() {
		String firstName = "Pradeep";
		String lastName = "Kulal";
		String email = "";
		String phoneNumber = "";
		String password = "";
		String confirmPassword = "";
		String companyName = "";
		String cin_Number = "";
		String gstin_Number = "";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		WebElement CIN_Number  = signUpPageObject.getElementGSTIN_Number();
		abstractC.enterData(CIN_Number, cin_Number);

		WebElement GSTIN_Number = signUpPageObject.getElementCIN_Number();
		abstractC.enterData(GSTIN_Number, gstin_Number);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());

		WebElement validationMssage = signUpPageObject.getElementValidationMessage();

		String actualValidationMessage = abstractC.getTextOfWebElement(validationMssage);

		if (abstractC.isElementDisplayed(validationMssage)
				&& abstractC.isElementDisplayed(signUpPageObject.getElementPhoneErrorIcon())
				&& abstractC.isElementDisplayed(signUpPageObject.getElementPasswordErrorIcon())
				&& abstractC.isElementDisplayed(signUpPageObject.getElementConfirmPasswordErrorIcon())) {
			Assert.assertEquals(actualValidationMessage,configData.expectedEmailValidationMessage);
		}
		else {
			System.out.println("Email Field Error Message is Not Displayed"	);
		}

	}

	public void creationOfCustomerUsingAlreadyUsedEmail() {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email = testDataXL.getCellData(constant.credentialsSheet, "Email", 2);
		String phoneNumber = data.phoneNumber().phoneNumber();
		String password = "Test@123";
		String confirmPassword = "Test@123";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());

		WebElement toastMessage = signUpPageObject.getElementToastMessage();

		abstractC.verifyTextOfthWebEement(toastMessage, configData.ExpectedDuplicateEmailIDErrorNotificationMsg);
	}

	public void creationOfCustomerUsingAlreadyUsedPhoneNumber() {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email = (firstName + lastName + constant.serverDomain).toLowerCase();
		String phoneNumber = "9108748776";
		String password = "Test@123";
		String confirmPassword = "Test@123";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());

		WebElement toastMessage = signUpPageObject.getElementToastMessage();
		abstractC.waitForWebElementToAppear(driver, toastMessage);

		abstractC.verifyTextOfthWebEement(toastMessage, configData.ExpectedDuplicatePhoneNumberErrorNotificationMsg);

	}


	public void creationOfCompanyUsingAlreadyUsedEmail() {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email = testDataXL.getCellData(constant.credentialsSheet, "Email", 2);
		String phoneNumber = data.phoneNumber().phoneNumber();
		String password = "Test@123";
		String confirmPassword = "Test@123";
		String companyName = firstName + " " + lastName + " " + "Pvt Ltd";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		ValidateCompanyCreationFunctionality();

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());



		WebElement toastMessage = signUpPageObject.getElementToastMessage();
		abstractC.waitForWebElementToAppear(driver, toastMessage);

		abstractC.verifyTextOfthWebEement(toastMessage, configData.ExpectedDuplicateEmailIDErrorNotificationMsg);


	}

	public void creationOfCompanyUsingAlreadyUsedPhoneNumber() {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email = (firstName + lastName + constant.serverDomain).replaceAll("'", "").toLowerCase();
		String phoneNumber = "9108748776";
		String password = "Test@123";
		String confirmPassword = "Test@123";
		String companyName = firstName + " " + lastName + " " + "Pvt Ltd";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		ValidateCompanyCreationFunctionality();

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());



		WebElement toastMessage = signUpPageObject.getElementToastMessage();
		abstractC.waitForWebElementToAppear(driver, toastMessage);
		abstractC.verifyTextOfthWebEement(toastMessage, configData.ExpectedDuplicatePhoneNumberErrorNotificationMsg);

	}

	public  void ValidateCompanyCreationFunctionality() {

		WebElement yesRadioButton = signUpPageObject.getElementCompanyYes();
		if (abstractC.isElementDisplayed(yesRadioButton) && abstractC.isElementEnabled(yesRadioButton)) {
			if (yesRadioButton.isSelected()== false) {
				abstractC.clickElement(yesRadioButton);
				WebElement companyName = signUpPageObject.getElementCompanyName();
				if (abstractC.isElementEnabled(companyName)) {
					System.out.println("Radio Button is Toggled and Company name is Enabled");
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}

		} 
	}


	public void valiationOfCompanyNameField() {
		String firstName = "pradeep";
		String lastName = "kulal";
		String email = "pradeep.kulal@yopmail.com";
		String phoneNumber = "8891087476";
		String password = "Test@123";
		String confirmPassword = "Test@123";
		String companyName = "";
		String cin_Number = "";
		String gstin_Number = "";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		WebElement yesRadioButton = signUpPageObject.getElementCompanyYes();
		abstractC.clickElement(yesRadioButton);

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		WebElement CIN_Number  = signUpPageObject.getElementGSTIN_Number();
		abstractC.enterData(CIN_Number, cin_Number);

		WebElement GSTIN_Number = signUpPageObject.getElementCIN_Number();
		abstractC.enterData(GSTIN_Number, gstin_Number);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());

		WebElement validationMssage = signUpPageObject.getElementValidationMessage();

		String actualValidationMessage = abstractC.getTextOfWebElement(validationMssage);

		abstractC.verifyTextOfthWebEement(validationMssage, configData.expectedCompanyNameValidationMessage);
	}


	public void validationUsingAlreadyExistingCompanyName() {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email = (firstName + lastName + constant.serverDomain).replaceAll("'", "").toLowerCase();
		String phoneNumber = data.phoneNumber().phoneNumber();
		String password = "Test@123";
		String confirmPassword = "Test@123";
		String companyName = "Intuitive Apps Inc.";
		String cin_Number = "";
		String gstin_Number = "";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		WebElement yesRadioButton = signUpPageObject.getElementCompanyYes();
		abstractC.clickElement(yesRadioButton);

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		WebElement CIN_Number  = signUpPageObject.getElementGSTIN_Number();
		abstractC.enterData(CIN_Number, cin_Number);

		WebElement GSTIN_Number = signUpPageObject.getElementCIN_Number();
		abstractC.enterData(GSTIN_Number, gstin_Number);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());

		WebElement toastMessage = signUpPageObject.getElementToastMessage();
		abstractC.waitForWebElementToAppear(driver, toastMessage);
		abstractC.verifyTextOfthWebEement(toastMessage, configData.ExpectedDuplicateCompanyNameErrorNotificationMsg);
	}

	public void valiationOfCINField() {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email = (firstName + lastName + constant.serverDomain).toLowerCase();
		String phoneNumber = data.phoneNumber().phoneNumber();
		String password = "Test@123";
		String confirmPassword = "Test@123";
		String companyName = "raj comunications";
		String cin_Number = "";
		String gstin_Number = "";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		WebElement yesRadioButton = signUpPageObject.getElementCompanyYes();
		abstractC.clickElement(yesRadioButton);

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		WebElement CIN_Number  = signUpPageObject.getElementGSTIN_Number();
		abstractC.enterData(CIN_Number, cin_Number);

		WebElement GSTIN_Number = signUpPageObject.getElementCIN_Number();
		abstractC.enterData(GSTIN_Number, gstin_Number);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());

		WebElement notificationMessage = signUpPageObject.getElementToastMessage();

		String actualSuccessNotificationMessage = abstractC.getTextOfWebElement(notificationMessage);

		if (abstractC.isElementDisplayed(notificationMessage)) {
			Assert.assertEquals(actualSuccessNotificationMessage,configData.expectedNewAccountCreationSuccessNotificationMessage);
		}
		else {
			System.out.println("Successful Notification Message is Not Displayed"	);
		}
	}

	public void successfullyCreatingNewCustomer() throws InterruptedException {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email = (firstName + lastName + constant.serverDomain).replaceAll("'", "").toLowerCase();
		System.out.println(email);
		String phoneNumber = data.phoneNumber().phoneNumber();
		String password = "Test@123";
		String confirmPassword = "Test@123"; 

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());
		abstractC.waitForElementToDisappear(driver, signUpPageObject.getElementLoader());
		abstractC.waitForSeconds(2);
		String actualTaostMessage =abstractC.getTextOfWebElement(signUpPageObject.getElementToastMessage());
		if (configData.expectedNewAccountCreationSuccessNotificationMessage.equals(actualTaostMessage)) {
			Assert.assertEquals(actualTaostMessage, configData.expectedNewAccountCreationSuccessNotificationMessage);
		} else {
			Assert.assertEquals(actualTaostMessage, configData.expectedNewAccountCreationSuccessNotificationMessage);
		}

		abstractC.writeDataInExcel("sheet1", "Email", 7, email);
		abstractC.writeDataInExcel("sheet1", "Password", 7, password);
	}

	public void successfullyCreatingNewComapanyWithValid_GSTIN_Number() throws InterruptedException {

		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email =(firstName + lastName + constant.serverDomain).replaceAll("'", "").toLowerCase();
		String phoneNumber = data.phoneNumber().phoneNumber();
		String password = "Test@123";
		String confirmPassword = "Test@123";
		String companyName = firstName + " " + lastName + " " + "Pvt Ltd";
		String cin_Number = "";
		String gstin_Number = "GSTIN"+ data.number().randomNumber(16, true);
		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName); 

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		WebElement yesRadioButton = signUpPageObject.getElementCompanyYes();
		abstractC.clickElement(yesRadioButton);

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		WebElement CIN_Number  = signUpPageObject.getElementCIN_Number ();
		abstractC.enterData(CIN_Number, cin_Number);

		WebElement GSTIN_Number = signUpPageObject.getElementGSTIN_Number();
		abstractC.enterData(GSTIN_Number, gstin_Number);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());
		abstractC.waitForElementToDisappear(driver, signUpPageObject.getElementLoader());
		abstractC.waitForSeconds(1);
		String actualTaostMessage =abstractC.getTextOfWebElement(signUpPageObject.getElementToastMessage());
		if (configData.expectedNewAccountCreationSuccessNotificationMessage.equals(actualTaostMessage)) {
			Assert.assertEquals(actualTaostMessage, configData.expectedNewAccountCreationSuccessNotificationMessage);
		} else {
			Logger.error("Error Message is Not correct");
			Assert.assertEquals(actualTaostMessage, configData.expectedNewAccountCreationSuccessNotificationMessage);
		}
	}
	
	public void validationUsingAlreadyExistingCIN_Number() {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email = (firstName + lastName + constant.serverDomain).replaceAll("'", "").toLowerCase();
		String phoneNumber = data.phoneNumber().phoneNumber();
		String password = "Test@123";
		String confirmPassword = "Test@123";
		String companyName = "Intuitive Apps Inc.";
		String cin_Number = "CIN847329743333333333";
		String gstin_Number = "";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		WebElement yesRadioButton = signUpPageObject.getElementCompanyYes();
		abstractC.clickElement(yesRadioButton);

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		WebElement CIN_Number  = signUpPageObject.getElementCIN_Number();
		abstractC.enterData(CIN_Number, cin_Number);

		WebElement GSTIN_Number = signUpPageObject.getElementGSTIN_Number();
		abstractC.enterData(GSTIN_Number, gstin_Number);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());

		WebElement toastMessage = signUpPageObject.getElementToastMessage();
		abstractC.verifyTextOfthWebEement(toastMessage, configData.ExpectedDuplicateCIN_NumberErrorNotificationMsg);
	}


	public void validationUsingAlreadyExistingGSTIN_Number() {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email =(firstName + lastName + constant.serverDomain).replaceAll("'", "").toLowerCase();
		String phoneNumber = data.phoneNumber().phoneNumber();
		String password = "Test@123";
		String confirmPassword = "Test@123";
		String companyName = "Intuitive Apps Inc.";
		String cin_Number = "CIN84732974122123213123";
		String gstin_Number = "GSTIN7439533333 ";

		WebElement FirstName = signUpPageObject.getElementFirstName();
		abstractC.enterData(FirstName, firstName);

		WebElement LastName = signUpPageObject.getElementLastName();
		abstractC.enterData(LastName, lastName);

		WebElement Email = signUpPageObject.getElementEmail();
		abstractC.enterData(Email, email);

		WebElement PhoneNumber = signUpPageObject.getElementPhoneNumber();
		abstractC.enterData(PhoneNumber, phoneNumber);

		WebElement Password = signUpPageObject.getElementPassword();
		abstractC.enterData(Password, password);

		WebElement ConfirmPassword = signUpPageObject.getElementConfirmPassword();
		abstractC.enterData(ConfirmPassword, confirmPassword);

		WebElement yesRadioButton = signUpPageObject.getElementCompanyYes();
		abstractC.clickElement(yesRadioButton);

		WebElement CompanyName = signUpPageObject.getElementCompanyName();
		abstractC.enterData(CompanyName, companyName);

		WebElement CIN_Number  = signUpPageObject.getElementCIN_Number ();
		abstractC.enterData(CIN_Number, cin_Number);

		WebElement GSTIN_Number = signUpPageObject.getElementGSTIN_Number();
		abstractC.enterData(GSTIN_Number, gstin_Number);

		abstractC.clickElement(signUpPageObject.getElementSubmitButton());

		WebElement toastMessage = signUpPageObject.getElementToastMessage();
		abstractC.verifyTextOfthWebEement(toastMessage, configData.ExpectedDuplicateGSTIN_NumberErrorNotificationMsg);
	}


}
