package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;
import kycee.Utills.Constants;

public class SignUpPageObject extends BaseClass {
	
	public WebElement getElementSignUpPageHeader() {
		return driver.findElement(By.xpath(constant.signUpPageHeader));
	}
		
		
	public WebElement getElementFirstName() {
		return driver.findElement(By.name(constant.firstName));
	}
	
	public WebElement getElementLastName() {
		return driver.findElement(By.name(constant.lastName));
	}
	
	public WebElement getElementEmail() {
		return driver.findElement(By.name(constant.email));
	}
	
	public WebElement getElementPhoneNumber() { 
		return driver.findElement(By.name(constant.phoneNumber));
	}
	
	public WebElement getElementPassword() {
		return driver.findElement(By.name(constant.password));
	}
	
	public WebElement getElementConfirmPassword() {
		return driver.findElement(By.name(constant.confirmPassword));
	}
	
	public WebElement getElementCompanyName() {
		return driver.findElement(By.name(constant.companyName));
	}
	
	public WebElement getElementCIN_Number() {
		return driver.findElement(By.name(constant.cinNumber));
	}
	
	public WebElement getElementGSTIN_Number() {
		return driver.findElement(By.name(constant.gstin));
	}
	
	public WebElement getElementCompanyYes() {
		return driver.findElement(By.xpath(constant.yesCheckBox));
	}
	
	public WebElement getElementCompanyNo() {
		return driver.findElement(By.xpath(constant.noCheckBox));
	}
	
	public WebElement getElementSubmitButton() {
		return driver.findElement(By.xpath(constant.submitBtn));
	}
	
	public WebElement getElementSignInLink() {
		return driver.findElement(By.linkText(constant.SignInPageBtn));
	}
	
	public WebElement getElementToastMessage() {
		return driver.findElement(By.xpath(constant.ToastMsg));
	}
	
	public WebElement getElementValidationMessage() {
		return driver.findElement(By.xpath(constant.validationMessage));
	}
	
	public WebElement getElementFirstNameErrorIcon() {
		return driver.findElement(By.xpath(constant.firstNameErrorIcon));
	}
	
	public WebElement getElementLastNameErrorIcon() {
		return driver.findElement(By.xpath(constant.lastNameErrorIcon));
	}
	
	public WebElement getElementEmailErrorIcon() {
		return driver.findElement(By.xpath(constant.emailErrorIcon));
	}
	
	public WebElement getElementPhoneErrorIcon() {
		return driver.findElement(By.xpath(constant.phoneNumberErrorIcon));
	}
	
	public WebElement getElementPasswordErrorIcon() {
		return driver.findElement(By.xpath(constant.passwordErrorIcon));
	}
	
	public WebElement getElementConfirmPasswordErrorIcon() {
		return driver.findElement(By.xpath(constant.confirmPasswordErrorIcon));
	}
	
	public WebElement getElementCompanyNameErrorIcon() {
		return driver.findElement(By.xpath(constant.companyNameErrorIcon));
	}
	
	public WebElement getElementPasswordVisibilityIcon() {
		return driver.findElement(By.xpath(constant.passwordVisibilityIcon));
	}
	
	public WebElement getElementConfirmPasswordIcon() {
		return driver.findElement(By.xpath(constant.confirmPasswordVisibilityIcon));
	}
	
	public WebElement getElementNotificationIcon() {
		return driver.findElement(By.xpath(constant.notificationIcon));
	} 
	
	public WebElement getElementLoader() {
		return driver.findElement(By.xpath(constant.loader));
	}
}
