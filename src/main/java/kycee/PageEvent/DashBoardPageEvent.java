package kycee.PageEvent;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import kycee.Base.BaseClass;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.SignInPageObject;
import kycee.PageObjects.UsersPageObject;
import kycee.PageObjects.VerificationPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;

public class DashBoardPageEvent extends BaseClass{


	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	DashBoardObject DBObjects = new DashBoardObject();
	MyProfilePageObject myProfileObject = new MyProfilePageObject();
	VerificationPageObject verificationPageObject = new VerificationPageObject();
	UsersPageObject usersObj = new UsersPageObject();
	ConfigurationData configData = new ConfigurationData();
	//	protected WebDriverWait wait;  

	public void verifyVerificationsCard() throws InterruptedException {
		abstractC.waitForElementToDisappear(driver, DBObjects.getElementLoader());
		WebElement verificationCard = abstractC.waitForElementVisibility(driver, DBObjects.getElementVerificationsCard(),10);
		String actualBeforecolour = abstractC.getColorOfWebElement("background-color",verificationCard);
		softAssert.assertEquals(actualBeforecolour,configData.expectedBeforeCardColor);
		if (actualBeforecolour.equals(configData.expectedBeforeCardColor)) {
			System.out.println("Before Mouse Hover Verifications Card Color is Proper");
		} else {
			Logger.error("Before Mouse Hover  Verifications Card Color is not Proper");
			System.out.println("Before Mouse Hover  Verifications Card Color is not Proper");
		}
		abstractC.moveCursorToWebElement(verificationCard, 20);
		String actuaAfterMouseHoverColor = abstractC.getColorOfWebElement("background-color",verificationCard);
		softAssert.assertEquals(actuaAfterMouseHoverColor,configData.expectedAfterCardColor);

		if (actuaAfterMouseHoverColor.equals(configData.expectedAfterCardColor)) {
			System.out.println("After Mouse Hover Verifications Card Color is Proper");
		} else {
			Logger.error("After Mouse Hover  Verifications Card Color is not Proper");
			System.out.println("After Mouse Hover  Verifications Card Color is not Proper");
		}

		if (abstractC.isElementClickable(verificationCard, Duration.ofSeconds(10))) {
			System.out.println("verification Card is clickable");
			softAssert.assertTrue(true);
		}else {
			Logger.info("verification Card is not Clickable");
			softAssert.assertTrue(false);
		}
		abstractC.clickElement(verificationCard);

		WebElement verificationPageHeader =  verificationPageObject.getElementOfVerficationPageHeader();
		if (abstractC.isElementDisplayed(verificationPageHeader)) {
			System.out.println("Successfully navigated to Verification Page");
			softAssert.assertTrue(true);
		}else {
			System.out.println("Error in Navigation to Verification page");
			softAssert.assertTrue(false);
		}
		softAssert.assertAll();
	}

	public void verifyCreditsAvailableCard() throws InterruptedException {
		abstractC.waitForElementToDisappear(driver, DBObjects.getElementLoader());
		WebElement creditsAvailableCard = abstractC.waitForElementVisibility(driver, DBObjects.getElementCreditsAvailableCard(),10);
		String actualBeforecolour = abstractC.getColorOfWebElement("background-color",creditsAvailableCard);
		Assert.assertEquals(actualBeforecolour,configData.expectedBeforeCardColor);
		if (actualBeforecolour.equals(configData.expectedBeforeCardColor)) {
			System.out.println("Before Mouse Hover Credits Available Card Color is Proper");
		} else {
			Logger.error("Before Mouse Hover  Credits Available Card Color is not Proper");
			System.out.println("Before Mouse Hover  Credits Available Card Color is not Proper");
		}
		abstractC.moveCursorToWebElement(creditsAvailableCard, 20);
		String actuaAfterMouseHoverColor = abstractC.getColorOfWebElement("background-color",creditsAvailableCard);
		Assert.assertEquals(actuaAfterMouseHoverColor,configData.expectedBeforeCardColor);

		if (actuaAfterMouseHoverColor.equals(configData.expectedBeforeCardColor)) {
			System.out.println("After Mouse Hover Credits Available Card Color is Proper");
		} else {
			Logger.error("After Mouse Hover  Credits Available Card Color is not Proper");
			System.out.println("After Mouse Hover  Credits Available Card Color is not Proper");
		}

		if (abstractC.isElementClickable(creditsAvailableCard, Duration.ofSeconds(10))) {
			Logger.error("Credits Available Card is Clickable");
			System.out.println("Credits Available Card is clickable");
			softAssert.assertTrue(false);
		}else {
			System.out.println("Credits Available Card is Not clickable");
		}
		softAssert.assertAll();
	}

	public void VerifyNavigationToProfilePage() throws InterruptedException {
		abstractC.waitForElementToDisappear(driver, DBObjects.getElementLoader());	
		abstractC.waitForWebElementToAppear(driver, DBObjects.getElementProfileDropDown());	
		abstractC.waitForSeconds(1);
		abstractC.clickElement(DBObjects.getElementProfileDropDown());
		abstractC.clickElement(DBObjects.getElementMyProfile());
		String actualPageHeader = abstractC.getTextOfWebElement(myProfileObject.getElementMyProfilePageHeader());
		if (actualPageHeader.equals(configData.myProfilePageHeaderText)) {
			Assert.assertTrue(true);
			System.out.println("User SuccessFully Naviagted to My profile page");
		} else {
			System.out.println("Naviagation to My profile page Failed");
			Assert.assertEquals(actualPageHeader, configData.myProfilePageHeaderText,"Naviagation to My profile page Failed");
		}
	}


	public void verifyVerificationCardCountOfUserType(String userType) throws InterruptedException {
		abstractC.waitForElementToDisappear(driver, DBObjects.getElementLoader());
		String User = userType.toLowerCase();
		String actualVerificationCount = "0";
		String expectedVerificationCount = "0";
		switch (User) {
		case "customer":
			if (DBObjects.getElementVerificationsCard().isDisplayed()) {
				System.out.println("Veification card is displayed");
			}else {
				Assert.assertTrue(false,"Veification card is Not displayed");
			}
			actualVerificationCount = abstractC.getTextOfWebElement(DBObjects.getElementVerificationsCount());
			expectedVerificationCount = testDataXL.getCellData("sheet1", "Verification Count", 2);
			abstractC.assertNumericDataFromExcel(actualVerificationCount, expectedVerificationCount, User + " " + "Verification");

			break;
		case "business user":
			if (DBObjects.getElementVerificationsCard().isDisplayed()) {
				System.out.println("Veification card is displayed");
			}else {
				Assert.assertTrue(false,"Veification card is Not displayed");
			}
			actualVerificationCount = abstractC.getTextOfWebElement(DBObjects.getElementVerificationsCount());
			expectedVerificationCount = testDataXL.getCellData("sheet1", "Verification Count", 3);
			abstractC.assertNumericDataFromExcel(actualVerificationCount, expectedVerificationCount, User + " " + "Verification");

			break;

		case "business admin":
			if (DBObjects.getElementVerificationsCard().isDisplayed()) {
				System.out.println("Veification card is displayed");
			}else {
				Assert.assertTrue(false,"Veification card is Not displayed");
			}
			actualVerificationCount = abstractC.getTextOfWebElement(DBObjects.getElementVerificationsCount());
			expectedVerificationCount = testDataXL.getCellData("sheet1", "Verification Count", 4);
			abstractC.assertNumericDataFromExcel(actualVerificationCount, expectedVerificationCount, User + " " + "Verification");
			break;
		case "super admin":
			System.out.println("No verication card superadmin");
			break;
		case "blogger":
			System.out.println("No verication card blogger");
			break;
		default:
			System.out.println(User + " is not available in the sheet");
			break;

		}
	}

	public void validationOfNavigationMenu() throws InterruptedException{

		abstractC.moveCursorToWebElement(DBObjects.getElemenThumbLogoNavigationIcon(), 20);

		if (AbstractComponents.isElementDisplayed(DBObjects.getElementKYCEE_LogoNavigationIcon())) {
			if (AbstractComponents.isElementDisplayed(DBObjects.getElementWalletNavigationIcon())) {
				if (AbstractComponents.isElementDisplayed(DBObjects.getElementUsersNavigationIcon())) {
					if (AbstractComponents.isElementDisplayed(DBObjects.getElementVerificationsNavigationIcon())) {
						if (AbstractComponents.isElementDisplayed(DBObjects.getElementDashboardNavigationIcon())) {
							DBObjects.getElementDashboardNavigationIcon().click();
							Assert.assertTrue(true);
							Logger.info("Menu validation Success "+ "Dashboard is propoerly visible." );
						}
					}
				}
			}
		}
		else {
			System.out.println("Dashboard is not visible");
			Assert.assertTrue(false);
		}
	}

	public UsersPageEvent verifyNavigationToUserPage() {
		abstractC.clickElement(DBObjects.getElementUsersCard());
		WebElement actualPageHeader = usersObj.getElemenUsersPageHeader();
		abstractC.verifyTextOfthWebEement(actualPageHeader, configData.ExpectedUserPageHeader);
		return new UsersPageEvent();
	}


	public int verifyUserCount() throws InterruptedException {
		abstractC.waitForWebElementToAppear(driver, DBObjects.getElementUsersCount());
		abstractC.waitForSeconds(1);
		double 	UserCount = 0;
		try {
			 	UserCount = Double.valueOf(DBObjects.getElementUsersCount().getText());
		} catch (NumberFormatException e) {
			abstractC.waitForSeconds(2);
			 	UserCount = Double.valueOf(DBObjects.getElementUsersCount().getText());
		}
		
		int userCount  = (int)UserCount;
		return userCount;
	}

	public DashBoardPageEvent verifyNavigationToDashboardPage() {
		abstractC.clickElement(DBObjects.getElementDashboardNavigationIcon());
		abstractC.moveCursorToWebElement(DBObjects.getElementProfileDropDown(), 20);
		abstractC.verifyTextOfthWebEement(DBObjects.getElementDashBoardPageHeader(), configData.expectedDashBoardHeader);
		return new DashBoardPageEvent();		
	}	
	
	public UsersPageEvent verifyNavigationToUserPageThroughNavigation() {
		
		abstractC.clickElement(DBObjects.getElementUsersNavigationIcon());
		abstractC.moveCursorToWebElement(DBObjects.getElementProfileDropDown(), 20);
		abstractC.verifyTextOfthWebEement(usersObj.getElemenUsersPageHeader(), configData.ExpectedUserPageHeader);
		return new UsersPageEvent();		
	}	
}
