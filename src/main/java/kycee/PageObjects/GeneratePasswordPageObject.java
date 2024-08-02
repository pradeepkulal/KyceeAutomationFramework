package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;

public class GeneratePasswordPageObject extends BaseClass {
	
	public WebElement getElementGeneratePasswordPageHeader() {
		return driver.findElement(By.xpath(constant.GeneratePasswordPageHeader));
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
	public WebElement getElementSignInLink() {
		return driver.findElement(By.linkText(constant.SignInPageBtn));
	}
	
	public WebElement getElementPassword() {
		return driver.findElement(By.name(constant.password));
	}
	
	public WebElement getElementConfirmPassword() {
		return driver.findElement(By.name(constant.confirmPassword));
	}
	
	public WebElement getElementSubmitBtn() {
		return driver.findElement(By.xpath(constant.submitBtn));
	}

	public WebElement getElementPageExpiredText() {
		try {
			 return driver.findElement(By.xpath(constant.pageExpiredText));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
