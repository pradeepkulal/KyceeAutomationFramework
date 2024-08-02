package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;
import kycee.Utills.Constants;

public class DashBoardObject extends BaseClass {
	
	public WebElement getElementDashBoardPageHeader() {
		return driver.findElement(By.xpath(constant.pageHeader));
	} 
	
	public WebElement getElementUsersCard() {
		return driver.findElement(By.xpath(constant.usersCard));
	} 
	
	public WebElement getElementVerificationsCard() {
		return driver.findElement(By.xpath(constant.VerificationsCard));
	}
	
	public WebElement getElementCreditsAvailableCard() {
		return driver.findElement(By.xpath(constant.CreditsAvailableCard));
	}
	
	public WebElement getElementSelfCreditsCard() {
		return driver.findElement(By.xpath(constant.selfCreditsCard));
	}
	
	public WebElement getElementUsersCount() {
		return driver.findElement(By.xpath(constant.usersCount));
	}
	
	public WebElement getElementVerificationsCount() {
		return driver.findElement(By.cssSelector(constant.VerificationsCount));
	}
	
	public WebElement getElementSelfCreditsCount() {
		return driver.findElement(By.xpath(constant.selfCreditsCount));
	}
	
	public WebElement getElementCompanyCreditsCount() {
		return driver.findElement(By.xpath(constant.companyCreditsCount));
	}
	
	public WebElement getElementSuccessVerificationCount() {
		return driver.findElement(By.xpath(constant.successVerificationCount));
	}
	
	public WebElement getElementNotSuccessFullVerificationCount() {
		return driver.findElement(By.xpath(constant.notSuccessFullVerificationCount));
	}
	
	public WebElement getElementVerifyYourIdentityButton() {
		return driver.findElement(By.xpath(constant.verifyYourIdentityButton));
	}
	
	public WebElement getElemenThumbLogoNavigationIcon() {
		return driver.findElement(By.xpath(constant.thumbLogoNavigationIcon));
	}
	
	public WebElement getElementKYCEE_LogoNavigationIcon() {
		return driver.findElement(By.xpath(constant.KYCEE_LogoNavigationIcon));
	}
	
	public WebElement getElementDashboardNavigationIcon() {
		return driver.findElement(By.xpath(constant.dashboardNavigationIcon));
	}
	
	public WebElement getElementVerificationsNavigationIcon() {
		return driver.findElement(By.xpath(constant.verificationsNavigationIcon));
	}
	
	public WebElement getElementUsersNavigationIcon() {
		return driver.findElement(By.xpath(constant.usersNavigationIcon));
	}
	
	public WebElement getElementWalletNavigationIcon() {
		return driver.findElement(By.xpath(constant.walletNavigationIcon));
	}
	
	public WebElement getElementAccountsNavigationIcon() {
		return driver.findElement(By.xpath(constant.accountsNavigationIcon));
	}
	
	public WebElement getElementTransactionsNavigationIcon() {
		return driver.findElement(By.xpath(constant.transactionsNavigationIcon));
	}
	
	public WebElement getElementOrdersNavigationIcon() {
		return driver.findElement(By.xpath(constant.ordersNavigationIcon));
	}
	
	public WebElement getElementTestimonialsNavigationIcon() {
		return driver.findElement(By.xpath(constant.testimonialsNavigationIcon));
	}
	
	public WebElement getElementKyceeLogoNavigationIcon() {
		return driver.findElement(By.xpath(constant.kyceeLogoNavigationIcon));
	}
	 
	public WebElement getElementLoader() {
		return driver.findElement(By.xpath(constant.loader));
	}
	
	public WebElement getElementProfileDropDown() {
		return driver.findElement(By.xpath(constant.dropdown_profile));
	}
	
	
	public WebElement getElementMyProfile() {
		return driver.findElement(By.xpath(constant.My_Profile));
	}
	
	public WebElement getElementChange_Password() {
		return driver.findElement(By.xpath(constant.Change_Password));
	}
	
	public WebElement getElementSettings() {
		return driver.findElement(By.xpath(constant.Settings));
	}
	
	public WebElement getElementReview() {
		return driver.findElement(By.xpath(constant.Review));
	}
	
	public WebElement getElementLogOut() {
		return driver.findElement(By.xpath(constant.Logout));
	} 
}
