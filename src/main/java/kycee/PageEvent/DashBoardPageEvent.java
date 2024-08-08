package kycee.PageEvent;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.mongodb.DB;

import kycee.Base.BaseClass;
import kycee.PageObjects.ChangePasswordObjects;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.ReviewPageObject;
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
	ChangePasswordObjects  cpObject = new ChangePasswordObjects();
	ReviewPageObject rpObjct = new ReviewPageObject();
	UsersPageObject usersObj = new UsersPageObject();
	ConfigurationData configData = new ConfigurationData();
	//	protected WebDriverWait wait;  

	public void verifyVerificationsCard() throws InterruptedException {
		WebElement verificationCard = abstractC.waitForElementVisibility(driver, DBObjects.getElementVerificationsCard(),10);
		abstractC.verifyBackGroundColorOfTheElement(verificationCard, configData.expectedWhiteColor);
		abstractC.moveCursorToWebElement(verificationCard, 30);
		abstractC.verifyBackGroundColorOfTheElement(verificationCard, configData.expectedSlateGrayColor);

		if (abstractC.isElementClickable(verificationCard)) {
			System.out.println("verification Card is clickable");
		}else {
			Logger.error("verification Card is not Clickable");
			System.out.println("verification Card is not clickable");
		}
		abstractC.clickElement(verificationCard);

		WebElement verificationPageHeader =  verificationPageObject.getElementOfVerficationPageHeader();
		abstractC.verifyTextOfthWebEement(verificationPageHeader, configData.ExpectedVerificationsPageHeader);
	}

	public void verifyCreditsAvailableCard() throws InterruptedException {
		WebElement creditsAvailableCard = abstractC.waitForElementVisibility(driver, DBObjects.getElementCreditsAvailableCard(),30);
		abstractC.verifyBackGroundColorOfTheElement(creditsAvailableCard, configData.expectedWhiteColor);
		abstractC.moveCursorToWebElement(creditsAvailableCard, 30);
		abstractC.verifyBackGroundColorOfTheElement(creditsAvailableCard, configData.expectedWhiteColor);

		if (abstractC.isElementClickable(creditsAvailableCard)) {
			Logger.error("Credits Available Card is Clickable");
			System.out.println("Credits Available Card is clickable");
		}else {
			System.out.println("Credits Available Card is Not clickable");
		}
	}

	public MyProfilePageEvent VerifyNavigationToProfilePage() throws InterruptedException {
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
		return new MyProfilePageEvent();
	}


	public void verifyVerificationCardCountOfUserType(String userType) throws InterruptedException {
		String User = userType.toLowerCase();
		String actualVerificationCount = "0";
		String expectedVerificationCount = "0";
		switch (User) {
		case "customer":
			if (abstractC.isElementDisplayed(DBObjects.getElementVerificationsCard())) {
				System.out.println("Veification card is displayed");
			}else {
				Assert.assertTrue(false,"Veification card is Not displayed");
			}
			actualVerificationCount = abstractC.getTextOfWebElement(DBObjects.getElementVerificationsCount());
			expectedVerificationCount = testDataXL.getCellData("sheet1", "Verification Count", 2);
			abstractC.assertNumericDataFromExcel(actualVerificationCount, expectedVerificationCount, User + " " + "Verification");

			break;
		case "business user":
			if (abstractC.isElementDisplayed(DBObjects.getElementVerificationsCard())) {
				System.out.println("Veification card is displayed");
			}else {
				Assert.assertTrue(false,"Veification card is Not displayed");
			}
			actualVerificationCount = abstractC.getTextOfWebElement(DBObjects.getElementVerificationsCount());
			expectedVerificationCount = testDataXL.getCellData("sheet1", "Verification Count", 3);
			abstractC.assertNumericDataFromExcel(actualVerificationCount, expectedVerificationCount, User + " " + "Verification");

			break;

		case "business admin":
			if (abstractC.isElementDisplayed(DBObjects.getElementVerificationsCard())) {
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

	public UsersPageEvent verifyNavigationToUserPage() throws InterruptedException {
		abstractC.waitForElementVisibility(driver, DBObjects.getElementUsersCard(),30);
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
	
	public WalletPageEvent verifyNavigationToWalletPageThroughNavigation() {

		abstractC.clickElement(DBObjects.getElementWalletNavigationIcon());
		abstractC.moveCursorToWebElement(DBObjects.getElementProfileDropDown(), 20);
		abstractC.verifyTextOfthWebEement(usersObj.getElemenUsersPageHeader(), configData.ExpectedWalletPageHeader);
		return new WalletPageEvent();		
	}

	public ChangePasswordEvent verifyNavigationToChangePasswordPage() {
		abstractC.waitForWebElementToAppear(driver, DBObjects.getElementProfileDropDown());	
		abstractC.waitForSeconds(1);
		abstractC.clickElement(DBObjects.getElementProfileDropDown());
		abstractC.clickElement(DBObjects.getElementChange_Password());
		abstractC.verifyTextOfthWebEement(cpObject.getElementChangePasswordPageHeader(), configData.expectedChangePasswordPageHeader);
		return new ChangePasswordEvent();		
	}

	public ReviewPageEvent VerifyNavigationToReviewPage() {
		abstractC.waitForWebElementToAppear(driver, DBObjects.getElementProfileDropDown());	
		abstractC.waitForSeconds(1);
		abstractC.clickElement(DBObjects.getElementProfileDropDown());
		abstractC.clickElement(DBObjects.getElementReview());
		abstractC.verifyTextOfthWebEement((rpObjct.getElementReviewPageHeader()), configData.expectedReviewPageHeader);
		return new ReviewPageEvent();		
	}

	public void verifyTourFunctionalityInDashBoardOfCustomer() {
		abstractC.waitForWebElementToAppear(driver, DBObjects.getElementTourTitle());
		abstractC.verifyTextOfthWebEement(DBObjects.getElementTourTitle(), configData.expectedWalletTitle);
		if(!(abstractC.isElementEnabled(DBObjects.getElementTourPreviousBtn()))
				&& abstractC.isElementClickable(DBObjects.getElementTourNextBtn())){
			System.out.println("Wallet Tour is Correctly visible");
			
		}
		abstractC.clickElement(DBObjects.getElementTourNextBtn());
		abstractC.waitForSeconds(3);
		abstractC.verifyTextOfthWebEement(DBObjects.getElementTourTitle(), configData.expectedVerificationTitle);
		if(!(abstractC.isElementEnabled(DBObjects.getElementTourPreviousBtn()))
				&& abstractC.isElementClickable(DBObjects.getElementTourDoneBtn())){
			System.out.println("Verification Tour is Correctly visible");
		}
		abstractC.clickElement(DBObjects.getElementTourDoneBtn());
	}	
}
