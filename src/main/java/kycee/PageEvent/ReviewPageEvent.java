package kycee.PageEvent;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import kycee.Base.BaseClass;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.ForgotPasswordPageObject;
import kycee.PageObjects.GeneratePasswordPageObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.ReviewPageObject;
import kycee.PageObjects.SignInPageObject;
import kycee.PageObjects.SignUpPageObject;
import kycee.PageObjects.VerificationPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;

public class ReviewPageEvent extends BaseClass {
	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	SignInPageObject signInObj = new SignInPageObject();
	SignUpPageObject signUpObj = new SignUpPageObject();
	DashBoardObject DBObjects = new DashBoardObject();
	ReviewPageObject rpObject = new ReviewPageObject();
	ConfigurationData configData = new ConfigurationData();

	public void fieldValidationInReviewPage() {
		abstractC.clickElement(rpObject.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(rpObject.getElementValidationMessage(), configData.expectedEmptyReviewTitleValidationErrorMsg);
		abstractC.enterData(rpObject.getElementReviewTitleInput(), "review title");
		abstractC.clickElement(rpObject.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(rpObject.getElementValidationMessage(), configData.expectedEmptyReviewDescriptionValidationErrorMsg);
	}

	public void addReviewWith(String title,String description,int numberOfStars) {
		abstractC.enterData(rpObject.getElementReviewTitleInput(), title);
		abstractC.enterData(rpObject.getElementReviewDescriptionInput(), description);
		switch (numberOfStars) {
		case 1:
			abstractC.clickElement(rpObject.getElementRatingStar1());
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar1(), configData.expectedRatingYellowColor);
			break;
		case 2:
			abstractC.clickElement(rpObject.getElementRatingStar2());
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar1(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar2(), configData.expectedRatingYellowColor);
			break;
		case 3:
			abstractC.clickElement(rpObject.getElementRatingStar3());
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar1(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar3(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar3(), configData.expectedRatingYellowColor);
			break;
		case 4:
			abstractC.clickElement(rpObject.getElementRatingStar4());
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar1(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar2(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar3(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar4(), configData.expectedRatingYellowColor);
			break;
		case 5:
			abstractC.clickElement(rpObject.getElementRatingStar5());
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar1(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar2(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar3(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar4(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar5(), configData.expectedRatingYellowColor);
			break;
		default:
			break;
		}
		abstractC.clickElement(rpObject.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(rpObject.getElementNotificationMsg(), configData.expectedSuccessReviewNotificationMsg);
	}

	public void verifyDetailsOfReviewAddedInReviewPage(String title,String description,int numberOfStars) {
		abstractC.verifyTextOfthWebEement(rpObject.getElementReviewTitle(), abstractC.capitalizeFirstLetter(title));
		abstractC.verifyTextOfthWebEement(rpObject.getElementReviewDescription(), abstractC.capitalizeFirstLetter(description));
		switch (numberOfStars) {
		case 1:
			Assert.assertTrue(abstractC.isElementDisplayed(rpObject.getElementReviewRating1()),"Rating is not displayed Correctly");
			break;
		case 2:
			Assert.assertTrue(abstractC.isElementDisplayed(rpObject.getElementReviewRating2()),"Rating is not displayed Correctly");
			break;
		case 3:
			Assert.assertTrue(abstractC.isElementDisplayed(rpObject.getElementReviewRating3()),"Rating is not displayed Correctly");
			break;
		case 4:
			Assert.assertTrue(abstractC.isElementDisplayed(rpObject.getElementReviewRating4()),"Rating is not displayed Correctly");
			break;
		case 5:
			Assert.assertTrue(abstractC.isElementDisplayed(rpObject.getElementReviewRating5()),"Rating is not displayed Correctly");
			break;
		default:
			Assert.assertFalse(abstractC.isElementDisplayed(rpObject.getElementReviewRating1()),"Rating is not displayed Correctly");
			break;
		}
	}

	public void editReviewWith(String title,String description,int numberOfStars) {
		abstractC.clickElement(rpObject.getElementEditReviewIcon());
		abstractC.verifyTextOfthWebEement(rpObject.getElementEditReviewPageHeader(), configData.expectedEditReviewPageHeader);
		abstractC.enterData(rpObject.getElementReviewTitleInput(), title);
		abstractC.enterData(rpObject.getElementReviewDescriptionInput(), description);
		switch (numberOfStars) {
		case 1:
			abstractC.clickElement(rpObject.getElementRatingStar1());
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar1(), configData.expectedRatingYellowColor);
			break;
		case 2:
			abstractC.clickElement(rpObject.getElementRatingStar2());
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar1(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar2(), configData.expectedRatingYellowColor);
			break;
		case 3:
			abstractC.clickElement(rpObject.getElementRatingStar3());
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar1(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar2(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar3(), configData.expectedRatingYellowColor);
			break;
		case 4:
			abstractC.clickElement(rpObject.getElementRatingStar4());
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar1(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar2(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar3(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar4(), configData.expectedRatingYellowColor);
			break;
		case 5:
			abstractC.clickElement(rpObject.getElementRatingStar5());
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar1(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar2(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar3(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar4(), configData.expectedRatingYellowColor);
			abstractC.verifyColorOfTheElement(rpObject.getElementRatingStar5(), configData.expectedRatingYellowColor);
			break;
		default:
			break;
		}
	}

	public void clickUpdateReviewSubmitButton() {
		abstractC.clickElement(rpObject.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(rpObject.getElementNotificationMsg(), configData.expectedSuccessUpdateReviewNotificationMsg);
	}
	
	public void verifyCancelButton() {
		WebElement cancelButton = rpObject.getElementCancelButton();
		abstractC.verifyBackGroundColorOfTheElement(cancelButton, configData.ExpectedRedButtonColor);
		abstractC.clickElement(cancelButton);
		abstractC.waitForSeconds(1);
		abstractC.verifyTextOfthWebEement(rpObject.getElementEditReviewPageHeader(), configData.expectedReviewPageHeader);
	}
	
	public void verifyBackIcon() {
		abstractC.isElementClickable(rpObject.getElementBackIcon());
		abstractC.clickElement(rpObject.getElementBackIcon());
		abstractC.waitForSeconds(1);
		abstractC.verifyTextOfthWebEement(rpObject.getElementEditReviewPageHeader(), configData.expectedReviewPageHeader);
	}

}
