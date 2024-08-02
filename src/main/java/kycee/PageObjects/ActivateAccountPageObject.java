package kycee.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;
import kycee.Utills.Constants;

public class ActivateAccountPageObject extends BaseClass {

	public WebElement getElementActivateAccountPopUpHeader() {
		return driver.findElement(By.xpath(constant.activateAccountPopUpHeader));
	}

	public WebElement getElementActivateAccountBtn() {
		return driver.findElement(By.xpath(constant.activateAccountBtn));
	}

	public WebElement getElementlogoutBtn() {
		return driver.findElement(By.xpath(constant.logoutBtn));
	}

	public  List<WebElement> getElementOTP() {
		return driver.findElements(By.xpath(constant.OTPField));
	}
	
	public WebElement getElementResendOTP() {
		return driver.findElement(By.xpath(constant.resendOTP));
	}

	public WebElement getElementtimeRemaining() {
		return driver.findElement(By.xpath(constant.timeRemaining));
	}
	
	public WebElement getElementOTPIn_3() {
		return driver.findElement(By.xpath(constant.OTPIn_3));
	}
	
	public WebElement getElementOTPIn_4() {
		return driver.findElement(By.xpath(constant.OTPIn_4));
	}
	
	public WebElement getElementOTPIn_5() {
		return driver.findElement(By.xpath(constant.OTPIn_5));
	}
	
	public WebElement getElementOTPIn_6() {
		return driver.findElement(By.xpath(constant.OTPIn_6));
	}
	
	public WebElement getElementToastMessage() {
		return driver.findElement(By.xpath(constant.ToastMsg));
	}
	
	public WebElement getElementLoader() {
		return driver.findElement(By.xpath(constant.loader));
	}
}
