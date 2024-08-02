package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;
import kycee.Utills.Constants;

public class VerificationPageObject extends BaseClass {
	
	Constants constant = new Constants();
	
	public WebElement getElementOfVerficationPageHeader() {
		return driver.findElement(By.xpath(constant.VerificationPageHeader));
	}
}
