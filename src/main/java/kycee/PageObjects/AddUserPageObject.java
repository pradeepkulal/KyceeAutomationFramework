package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;

public class AddUserPageObject extends BaseClass {

	public WebElement getElementToastMessage() {
		return driver.findElement(By.xpath(constant.ToastMsg));
	}

	public WebElement getElemenAddUsersPageHeader() {
		return driver.findElement(By.xpath(constant.pageHeader));
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
	
	public WebElement getElementUserTypeDropDown() { 
		return driver.findElement(By.cssSelector(constant.userTypeDrop));
	}
	
	public WebElement getElementAdminSelection() { 
		return driver.findElement(By.cssSelector(constant.adminTypeOption));
	}
	public WebElement getElementUserSelection() { 
		return driver.findElement(By.cssSelector(constant.userTypeOption));
	}
	public WebElement getElementAllotVerificationInput() { 
		return driver.findElement(By.name(constant.allotVerificationInput));
	}
	public WebElement getElementSubmitButton() {
		return driver.findElement(By.xpath(constant.formSubmitBtn));
	}
	
	public WebElement getElementLoader() {
		return driver.findElement(By.xpath(constant.loader));
	}
	
}
