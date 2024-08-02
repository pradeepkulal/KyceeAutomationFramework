package kycee.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;
import kycee.Utills.Constants;

public class HomePageObjects extends BaseClass{

	Constants constant = new Constants();
	
	public WebElement domainsTabButtonValidation() { 
		return driver.findElement(By.xpath(constant.domainsTab));
	}	
	public WebElement getdomainSectionTitleElement() {
		return driver.findElement(By.xpath(constant.domainSectionTitle));
	}	
	public WebElement getbusinessCassesButtonElement() {
		return driver.findElement(By.xpath(constant.businessCassesTab));
	}	
	public WebElement getBusinessCasesSectionTitleElement() {
		return driver.findElement(By.xpath(constant.BusinessCasesSectionTitle));
	}	
	
	public WebElement getChallangesButtonElement() {
		return driver.findElement(By.xpath(constant.challangesTab));
	}	
	public WebElement getChallangesTitleElement() {
		return driver.findElement(By.xpath(constant.challengesSectionTitle));
	}
	
	public WebElement getwhyKYCEETabButtonElement() {
		return driver.findElement(By.xpath(constant.whyKYCEETab));
	}	
	public WebElement getwhyKYCEETitleElement() {
		return driver.findElement(By.xpath(constant.whyKYCEESection));
	}
	
	public WebElement getAboutUsTabButtonElement() {
		return driver.findElement(By.xpath(constant.aboutUsTab));
	}	
	public WebElement getAboutUsSectionTitleElement() {
		return driver.findElement(By.id(constant.aboutUsSection));
	}
	
	public WebElement getFooterSectionElement() {
		return driver.findElement(By.xpath(constant.footerSection));
	}
	public List<WebElement> getFooterTitleElements() {
		return driver.findElements(By.xpath(constant.footerTitle));
	}
	
	public List<WebElement> getBusinessCasesCardsElements() {
		return driver.findElements(By.className(constant.businessCasesCards));
	}
	public List<WebElement> getBusinessCasesCardsTextElements() {
		return driver.findElements(By.xpath(constant.businessCasesCardsTitleText));
	}
	
	public List<WebElement> getChallengesSctionButtonElements() {
		return driver.findElements(By.xpath(constant.challengeSectionButtons));
	}
	
	public WebElement getAboutUsButtonElement() {
		return driver.findElement(By.xpath(constant.AboutUsButton));
	}
	public List<WebElement> WhyKYCEESectionButtonElements() {
		return  driver.findElements(By.xpath(constant.whyKYCEESectionButtons));
	}
	public WebElement getSignInButtonElement() {
		return driver.findElement(By.xpath(constant.signInButton));
	}
	
	public WebElement getSignUpButtonElement() {
		return driver.findElement(By.xpath(constant.signUpButton));
	}
	
	public WebElement getSignInTextElement() {
		return driver.findElement(By.xpath(constant.signInPageHeader));
	}
	
	public WebElement getSignUpTextElement() {
		return driver.findElement(By.xpath(constant.signUpPageHeader));
	}
}
