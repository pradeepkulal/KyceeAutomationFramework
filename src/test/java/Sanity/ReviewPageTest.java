package Sanity;

import org.testng.annotations.Test;

import kycee.Base.BaseClass;
import kycee.PageEvent.DashBoardPageEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.ReviewPageEvent;
import kycee.PageEvent.SignInPageEvent;

public class ReviewPageTest extends BaseClass{
	@Test(priority = 0)
	public void verifyValidationOfFieldInReviewPage() {
		HomePageEvent hmPageEvnt = new HomePageEvent();
		SignInPageEvent signInEvnt = hmPageEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt = signInEvnt.login("New Customer");
		ReviewPageEvent rpEvnt = dbEvnt.VerifyNavigationToReviewPage();
		rpEvnt.fieldValidationInReviewPage();
	}
	
	@Test(priority = 1)
	public void verifyFunctionalityOfReviewPage() {
		String reviewTitle ="review title";
		String reviewDescription = "review description";
		int reviewStarCount = 4;
		String editReviewTitle ="edit review title";
		String editReviewDescription = "edit review description";
		int editreviewStarCount = 3;
		HomePageEvent hmPageEvnt = new HomePageEvent();
		SignInPageEvent signInEvnt = hmPageEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt = signInEvnt.login("New Customer");
		ReviewPageEvent rpEvnt = dbEvnt.VerifyNavigationToReviewPage();
		rpEvnt.addReviewWith(reviewTitle, reviewDescription, reviewStarCount);
		rpEvnt.verifyDetailsOfReviewAddedInReviewPage(reviewTitle, reviewDescription, reviewStarCount);
		rpEvnt.editReviewWith(editReviewTitle, editReviewDescription, editreviewStarCount);
		rpEvnt.verifyCancelButton();
		rpEvnt.verifyDetailsOfReviewAddedInReviewPage(reviewTitle, reviewDescription, reviewStarCount);
		rpEvnt.editReviewWith(editReviewTitle, editReviewDescription, editreviewStarCount);
		rpEvnt.verifyBackIcon();
		rpEvnt.verifyDetailsOfReviewAddedInReviewPage(reviewTitle, reviewDescription, reviewStarCount);
		rpEvnt.editReviewWith(editReviewTitle, editReviewDescription, editreviewStarCount);
		rpEvnt.clickUpdateReviewSubmitButton();
		rpEvnt.verifyDetailsOfReviewAddedInReviewPage(editReviewTitle, editReviewDescription, editreviewStarCount);
	}

}
