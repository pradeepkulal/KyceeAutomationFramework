package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;
import kycee.Utills.Constants;

public class SignInPageObject extends BaseClass {
	
	
	public WebElement getElementUserEmailInput() {
		return driver.findElement(By.xpath(constant.userEmailInput));
	}
	
	public WebElement getElementUserPasswordInput() {
		return driver.findElement(By.xpath(constant.userPasswordInput));
	}
	
	public WebElement getElementSubmitBtn() {
		return driver.findElement(By.xpath(constant.submitBtn));
	}
	
	public WebElement getElementForgotPasswordLink() {
		return driver.findElement(By.xpath(constant.forgotPasswordLink));
	}
	
	public WebElement getElementSignUpPageLink() {
		return driver.findElement(By.xpath(constant.signUpPageLink));
	}
	
	public WebElement getElementValidationMessage() {
		return driver.findElement(By.xpath(constant.validationMessage));
	}
	
	public WebElement getElementNotificationMsg() {
		return driver.findElement(By.xpath(constant.ToastMsg));
	} 
	
	public WebElement getElementLoader() {
		return driver.findElement(By.xpath(constant.loader));
	}

	public WebElement getElementSignInPageHeader() {
		return driver.findElement(By.xpath(constant.signInPageHeader));
		
	}
	
	
}
