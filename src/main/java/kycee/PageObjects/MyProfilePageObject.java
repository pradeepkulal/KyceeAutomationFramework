package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;
import kycee.Utills.Constants;

public class MyProfilePageObject extends BaseClass {

	public WebElement getElementProfilePhoto() {
		return driver.findElement(By.xpath(constant.profilePhoto));
	}

	public WebElement getElementProfilePhotoEditIcon() {
		return driver.findElement(By.xpath(constant.profilePhotoEditIcon));
	}

	public WebElement getElementUploadFile() {
		return driver.findElement(By.xpath(constant.uploadXpath));
	}

	public WebElement getElementUserFullName() {
		return driver.findElement(By.xpath(constant.userFullName));
	}

	public WebElement getElementUserType() {
		return driver.findElement(By.xpath(constant.userType));
	}

	public WebElement getElementMyProfilePageHeader() {
		return driver.findElement(By.xpath(constant.myProfilePageHeader));
	}

	public WebElement getElementPersonalInfoEditButton() {
		return driver.findElement(By.xpath(constant.personalInfoEditButton));
	}

	public WebElement getElementUserFirstName() {
		return driver.findElement(By.xpath(constant.userFirstName));
	}

	public WebElement getElementUserLastName() {
		return driver.findElement(By.xpath(constant.userLastName));
	}

	public WebElement getElementUserEmail() {
		return driver.findElement(By.xpath(constant.userEmail));
	}

	public WebElement getElementUserPhoneNumber() {
		return driver.findElement(By.xpath(constant.userPhoneNumber));
	}

	public WebElement getElementAccountInfoEditButton() {
		return driver.findElement(By.xpath(constant.accountInfoEditButton));
	}

	public WebElement getElementUserCompanyNamet() {
		return driver.findElement(By.xpath(constant.UserCompanyName));
	}

	public WebElement getElementVerifyYourIdentityButton() {
		return driver.findElement(By.xpath(constant.VerifyYourIdentityButton));
	}

	public WebElement getElementUserCIN_Number() {
		return driver.findElement(By.xpath(constant.userCIN_Number));
	}

	public WebElement getElementUserGSTIN_Number() {
		return driver.findElement(By.xpath(constant.userGSTIN_Number));
	}

	public WebElement getElementUserArea() {
		return driver.findElement(By.linkText(constant.userArea));
	}

	public WebElement getElementUserCity() {
		return driver.findElement(By.xpath(constant.userCity));
	}

	public WebElement getElementUserState() {
		return driver.findElement(By.xpath(constant.userState));
	}

	public WebElement getElementUserPinCode() {
		return driver.findElement(By.xpath(constant.userPinCode));
	}

	public WebElement getElementDashboardNavigationIcon() {
		return driver.findElement(By.xpath(constant.dashboardNavigationIcon));
	}

	public WebElement getElementVerificationsNavigationIcon() {
		return driver.findElement(By.xpath(constant.verificationsNavigationIcon));
	}

	public WebElement getElementUsersNavigationIcon() {
		return driver.findElement(By.linkText(constant.usersNavigationIcon));
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

	public WebElement getElementProfileImgSubmitBtn() {
		return driver.findElement(By.xpath(constant.profileImgSubmitbtn));
	}

	public WebElement getElementProfileImgCancelBtn() {
		return driver.findElement(By.xpath(constant.profileImgCancelbtn));
	} 
	public WebElement getElementValidationMessage() {
		return driver.findElement(By.xpath(constant.validationMessage));
	}

	public WebElement getElementEditFirstName() {
		return driver.findElement(By.name(constant.editfirstName));
	}

	public WebElement getElementEditLastName() {
		return driver.findElement(By.name(constant.editlastName));
	}

	public WebElement getElementEditEmail() {
		return driver.findElement(By.name(constant.editemail));
	}

	public WebElement getElementEditPhoneNumber() { 
		return driver.findElement(By.name(constant.editphoneNumber));
	}

	public WebElement getElementNotificationMsg() {
		return driver.findElement(By.xpath(constant.ToastMsg));
	}

	public WebElement getElementPersonalInfoSubmitButton() {
		return driver.findElement(By.xpath(constant.profileImgSubmitbtn));
	} 
	
	public WebElement getElementEmailActivationPopUpSubmitbtn() {
		return driver.findElement(By.xpath(constant.emailActivationPopUpSubmitbtn));
	}
	public WebElement getElementEmailActivationPopUpHeader() {
		return driver.findElement(By.xpath(constant.emailActivationPopUpHeader));
	} 
}
