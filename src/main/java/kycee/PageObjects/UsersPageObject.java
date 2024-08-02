package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;

public class UsersPageObject extends BaseClass {

	public WebElement getElemenUsersPageHeader() {
		return driver.findElement(By.xpath(constant.pageHeader));
	}
	
	public WebElement getElemenOfFirstRow() {
		return driver.findElement(By.xpath(constant.firstRowInList));
	}
	
	
	public WebElement getElementAddUsersBtn() {
		return driver.findElement(By.xpath(constant.addUsersBtn));
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
}
