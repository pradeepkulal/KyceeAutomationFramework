package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;

public class ChangePasswordObjects extends BaseClass {


	public WebElement getElementChangePasswordPageHeader() {
		return driver.findElement(By.xpath(constant.changePasswordPageHeader));
	}
	
	public WebElement getElementNotificationMsg() {
		return driver.findElement(By.xpath(constant.ToastMsg));
	} 
	
	public WebElement getElementLoader() {
		return driver.findElement(By.xpath(constant.loader));
	}
	
	public WebElement getElementValidationMessage() {
		return driver.findElement(By.xpath(constant.validationMessage));
	}
	
	public WebElement getElementOldPassword() {
		return driver.findElement(By.xpath(constant.oldPasswordField));
	}
	
	
	public WebElement getElementNewPassword() {
		return driver.findElement(By.xpath(constant.newPasswordField));
	}
	
	public WebElement getElementConfirmPassword() {
		return driver.findElement(By.xpath(constant.confirmNewPasswordField));
	}
	
	public WebElement getElementSubmitBtn() {
		return driver.findElement(By.xpath(constant.formSubmitBtn));
	}
}
