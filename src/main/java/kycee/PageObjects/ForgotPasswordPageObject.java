package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;
import kycee.Utills.Constants;

public class ForgotPasswordPageObject extends BaseClass {
	
	public WebElement getElementForgotPasswordPageHeader() {
		return driver.findElement(By.xpath(constant.forgotPasswordPageHeader));
	}
	
	public WebElement getElementUserEmailInput() {
		return driver.findElement(By.xpath(constant.emailFieldForgotPassword));
	}
	
	public WebElement getElementSubmitBtn() {
		return driver.findElement(By.xpath(constant.submitBtn));
	}
		
	public WebElement getElementSignInPageLink() {
		return driver.findElement(By.xpath(constant.signInLink));
	}
	
	public WebElement getElementSignUpPageLink() {
		return driver.findElement(By.xpath(constant.signUpLink));
	}
	
	public WebElement getElementLoader() {
		return driver.findElement(By.xpath(constant.loader));
	}
	
	public WebElement getElementValidationMessage() {
		return driver.findElement(By.xpath(constant.validationMessage));
	}
	
	public WebElement getElementNotificationMsg() {
		try {
			return driver.findElement(By.xpath(constant.ToastMsg));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				return driver.findElement(By.xpath(constant.ToastMsg));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	return driver.findElement(By.xpath(constant.ToastMsg));
	} 
	
}
