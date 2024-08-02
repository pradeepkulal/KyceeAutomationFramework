 package Sanity;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import kycee.Base.BaseClass;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.SignUpPageEvent;
import kycee.PageObjects.SignUpPageObject;
import kycee.Utills.FetchElement;
import listeners.Retryanalyzer;
public class SignUpPageTest extends BaseClass {
	
	
	
	@Test(description = "Error validation of first name field", priority = 0, groups = {"regression","sanity"})
	public void validationOfFirstNameFildTest() throws InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignUpButton();
		SignUpPageEvent signUpPageEvent = new SignUpPageEvent();
		signUpPageEvent.validationOfSignUpPage();
	}
	
	@Test(description = "Error validation of Last name field", priority = 1, groups = {"regression"})
	public void validationOfLastNameFildTest() throws InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignUpButton();
		SignUpPageEvent signUpPageEvent = new SignUpPageEvent();
		signUpPageEvent.valiationOfLastName();
	}
	
	@Test
	public void validationOfEmailFeildTest() throws InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignUpButton();
		SignUpPageEvent signUpPageEvent = new SignUpPageEvent();
		signUpPageEvent.valiationOfEmailField();
	}
	
	@Test(retryAnalyzer = Retryanalyzer.class)
	public void verifyCustomerCreationUsingAlreadyUsedEmail() throws InterruptedException, IOException, MailosaurException {
		HomePageEvent HMEvent = new HomePageEvent();
		SignUpPageEvent signUpEvnt =  HMEvent.validateSignUpButton();
		signUpEvnt.creationOfCustomerUsingAlreadyUsedEmail();
		
	}
	
	@Test(retryAnalyzer = Retryanalyzer.class)
	public void CreationOfCompanyUsingAlreadyExistingCIN_Number() throws InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignUpButton(); 
		SignUpPageEvent signUpPageEvent = new SignUpPageEvent();
		signUpPageEvent.validationUsingAlreadyExistingCIN_Number();
	}
	@Test(retryAnalyzer = Retryanalyzer.class)
	public void CreationOfCompanyUsingAlreadyExistingGSTIN_Number() throws InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignUpButton();
		SignUpPageEvent signUpPageEvent = new SignUpPageEvent();
		signUpPageEvent.validationUsingAlreadyExistingGSTIN_Number();
	}
	
	@Test(retryAnalyzer = Retryanalyzer.class)
	public void verifyCompanyCreationUsingAlreadyUsedEmail() throws InterruptedException, IOException, MailosaurException {
		HomePageEvent HMEvent = new HomePageEvent();
		SignUpPageEvent signUpEvnt =  HMEvent.validateSignUpButton();
		signUpEvnt.creationOfCompanyUsingAlreadyUsedEmail();
		
	}
	
	@Test
	public void verifyCustomerCreationUsingAlreadyUsedPhoneNumber() throws InterruptedException, IOException, MailosaurException {
		HomePageEvent HMEvent = new HomePageEvent();
		SignUpPageEvent signUpEvnt =  HMEvent.validateSignUpButton();
		signUpEvnt.creationOfCustomerUsingAlreadyUsedPhoneNumber();
		
	}
	
	@Test
	public void verifyCompanyCreationUsingAlreadyUsedPhoneNumber() throws InterruptedException, IOException, MailosaurException {
		HomePageEvent HMEvent = new HomePageEvent();
		SignUpPageEvent signUpEvnt =  HMEvent.validateSignUpButton();
		signUpEvnt.creationOfCompanyUsingAlreadyUsedPhoneNumber();
		
	}
	
	@Test
	public void validationOfYesOrNoTest() throws InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignUpButton();
		SignUpPageEvent signUpPageEvent = new SignUpPageEvent();
		signUpPageEvent.ValidateCompanyCreationFunctionality();
	}
	
	@Test
	public void valiationOfCompanyNameField() throws InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignUpButton();
		SignUpPageEvent signUpPageEvent = new SignUpPageEvent();
		signUpPageEvent.valiationOfCompanyNameField();	
	}
	
	@Test
	public void existingCompanyNameTest(){
		HomePageEvent hpEvnt = new HomePageEvent();
		SignUpPageEvent signUpEvnt = hpEvnt.validateSignUpButton();
		signUpEvnt.validationUsingAlreadyExistingCompanyName();
	}
	
	@Test
	public void validationOfCreatingNewCustomer() throws InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignUpButton();
		SignUpPageEvent signUpPageEvent = new SignUpPageEvent();
		signUpPageEvent.successfullyCreatingNewCustomer();	
	}
	 
	@Test
	public void creatingCompanyWithValidGSTIN_Number() throws InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateSignUpButton();
		SignUpPageEvent signUpPageEvent = new SignUpPageEvent();
		signUpPageEvent.successfullyCreatingNewComapanyWithValid_GSTIN_Number();	
	}
	
}