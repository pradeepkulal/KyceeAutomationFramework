package Sanity;

import org.testng.annotations.Test;

import kycee.Base.BaseClass;
import kycee.PageEvent.DashBoardPageEvent;
import kycee.PageEvent.HomePageEvent;
import kycee.PageEvent.SignInPageEvent;
import kycee.PageEvent.WalletPageEvent;

public class WalletPageTest extends BaseClass{

	@Test(description = "verification of tour functionality for the first time", priority = 0
			)
	public void verifyTourFuncionalityInWaletsPage() {
		HomePageEvent hmEvnt = new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt= signInEvnt.login("New Customer");
		WalletPageEvent wpEvnt = dbEvnt.verifyNavigationToWalletPageThroughNavigation();
		wpEvnt.verifyTourFunctionalityInWallet();
	}
	
	@Test(description = "verification of tour functionality for the first time", priority = 1
			)
	public void verifyComponentsInWalletsPage() {
		HomePageEvent hmEvnt = new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt= signInEvnt.login("New Customer");
		WalletPageEvent wpEvnt = dbEvnt.verifyNavigationToWalletPageThroughNavigation();
		wpEvnt.VerifyNavigationToOfflineOrdersTab();
		wpEvnt.verifyNoDataInWallet();
		wpEvnt.VerifyNavigationToTransactionsTab();
		wpEvnt.verifyNoDataInWallet();
		wpEvnt.VerifyNavigationToOnlineOrdersTab();
		wpEvnt.verifyNoDataInWallet();
	}
	
	@Test(description = "verification of tour functionality for the first time", priority = 2)
	public void verifyAddCretitsFunctionality() {
		HomePageEvent hmEvnt = new HomePageEvent();
		SignInPageEvent signInEvnt = hmEvnt.validateSignInButton();
		DashBoardPageEvent dbEvnt= signInEvnt.login("New Customer");
		WalletPageEvent wpEvnt = dbEvnt.verifyNavigationToWalletPageThroughNavigation();
		wpEvnt.addOfflinecredits(1,10);
		 wpEvnt.verifyOfflineOrdersUPiPaymentScreen(1,10);
	}
}
