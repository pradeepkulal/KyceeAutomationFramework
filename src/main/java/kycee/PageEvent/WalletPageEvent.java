package kycee.PageEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.opencensus.stats.Aggregation.Count;
import kycee.Base.BaseClass;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.ForgotPasswordPageObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.SignInPageObject;
import kycee.PageObjects.SignUpPageObject;
import kycee.PageObjects.WalletPageObjects;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;

public class WalletPageEvent extends BaseClass{

	AbstractComponents abstractC = new AbstractComponents();
	DashBoardObject dbObjct = new DashBoardObject();
	WalletPageObjects wpObjct = new WalletPageObjects();
	ForgotPasswordPageObject forgotPasswordObj = new ForgotPasswordPageObject();
	ConfigurationData configData = new ConfigurationData();

	public void verifyTourFunctionalityInWallet() {
		abstractC.waitForWebElementToAppear(driver, wpObjct.getElementTourTitle());
		abstractC.verifyTextOfthWebEement(wpObjct.getElementTourTitle(), configData.expectedCreditTitle);
		if(abstractC.isNotClickable(wpObjct.getElementTourPreviousBtn())){
			System.out.println("previous is is not Clikable");
		}
		if (abstractC.isElementClickable(dbObjct.getElementTourDoneBtn())) {
			System.out.println("Done butoon is Clikable");
		}
		System.out.println("--------");
		abstractC.clickElement(wpObjct.getElementTourDoneBtn());
	}

	public void verifyNoDataInWallet() {
		if (abstractC.isElementDisplayed(wpObjct.getElementNoDataText())) {
			abstractC.verifyTextOfthWebEement(wpObjct.getElementNoDataText(), configData.expectedNoDataToDisplayMessage);
		}else {
			System.out.println("No Data messge is not Displayed");
		}
	}

	public void VerifyNavigationToOfflineOrdersTab() {
		WebElement offlineTab =wpObjct.getElementOfflineOrdersTab();
		abstractC.verifyBackGroundColorOfTheElement(offlineTab, configData.expectedGreyColor);
		abstractC.clickElement(offlineTab);
		abstractC.verifyBackGroundColorOfTheElement(offlineTab, configData.expectedWhiteColor);
	}

	public void VerifyNavigationToOnlineOrdersTab() {
		WebElement OnlineTab =wpObjct.getElementOnlineOrdersTab();
		abstractC.verifyBackGroundColorOfTheElement(OnlineTab, configData.expectedGreyColor);
		abstractC.clickElement(OnlineTab);
		abstractC.verifyBackGroundColorOfTheElement(OnlineTab, configData.expectedWhiteColor);
	}


	public void VerifyNavigationToTransactionsTab() {
		WebElement transactionsTab =wpObjct.getElementTransactionsTab();
		abstractC.verifyBackGroundColorOfTheElement(transactionsTab, configData.expectedGreyColor);
		abstractC.clickElement(transactionsTab);
		abstractC.verifyBackGroundColorOfTheElement(transactionsTab, configData.expectedWhiteColor);
	}

	public void addOfflinecredits(int creditscount,double price) {
		String count = String.valueOf(creditscount);
		WebElement addCreditsBtn = wpObjct.getElementAddCreditsButton();
		if (abstractC.isElementDisplayed(addCreditsBtn)) {
			abstractC.clickElement(addCreditsBtn);
		}else {
			System.out.println("Add Credits button is not displayed");
			Assert.assertTrue(false, "Add Credits button is not displayed");
		}

		abstractC.verifyTextOfthWebEement(wpObjct.getElementAddCreditsHeader(), configData.expectedAddCreditsPopHeader);
		abstractC.enterData(wpObjct.getElementQuantityField(), count);
		double credtitsPrice = Double.valueOf(wpObjct.getElementCreiditsPrice().getText());
		double creditsAmount = Double.valueOf(wpObjct.getElementCreiditsAmount().getText());
		double subTotal = Double.valueOf(wpObjct.getElementSubTotal().getText());
		double GST = Double.valueOf(wpObjct.getElementGST().getText());
		double totalAmount = Double.valueOf(wpObjct.getElementTotalAmount().getText());
		double gst =0.18;
		double expectedAmount = creditscount* Double.valueOf(price);
		double expectedSubTotal = expectedAmount;
		double expectedGST = abstractC.roundToOneDecimalPlace(creditsAmount* gst);
		double expectedTotalAmount =  expectedSubTotal+GST;
		if (creditsAmount == expectedAmount) {
			System.out.println("Amount calculation is correct");
		}else {
			Assert.assertTrue(false, "Amount calculation is Not correct");
		}
		if (subTotal == expectedAmount) {
			System.out.println("Sub total calculation is corrected");
		}
		else {
			Assert.assertTrue(false, "Sub Total calculation is Not correct");
		}
		if (GST == expectedGST) {
			System.out.println("GST calculation is corrected");
		}else {
			Assert.assertTrue(false, "GST calculation is Not correct");
		}
		if (totalAmount == expectedTotalAmount) {
			System.out.println("total Amount calculation is corrected");
		}else {
			Assert.assertTrue(false, "Total Amount calculation is Not correct");
		}
		abstractC.clickElement(wpObjct.getElementCheckoutViaUPIBtn());
		abstractC.verifyTextOfthWebEement(wpObjct.getElementPaymentHeader(), configData.expectedUPIPaymentHeader);
	}
	
	
	public void verifyOfflineOrdersUPiPaymentScreen(int creditscount,double unitPrice) {
		String status = "pending";
		String UTR = "ABccdf"+data.number().digits(10);
		if(abstractC.isElementDisplayed(wpObjct.getElementQRCode())) {
			System.out.println("QR Code is displayed");
		}else {
			Assert.assertTrue(false, "QR Code is not displayed");
		}
		abstractC.clickElement(wpObjct.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(wpObjct.getElementValidationMessage(), configData.expectedEmptyUTRNumber);
		abstractC.enterData(wpObjct.getElementUTRNumberField(), "213213");
		abstractC.verifyTextOfthWebEement(wpObjct.getElementValidationMessage(), configData.expectedEmptyUTRNumber);
		
		// Duplicate UTR number scenario
		abstractC.enterData(wpObjct.getElementUTRNumberField(), "ASDASDASDGFGFDGDG");
		abstractC.clickElement(wpObjct.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(wpObjct.getElementNotificationMessage(), configData.expectedDuplicateUTRNotifyMsg);
		// Successfull adding offline orders
		abstractC.enterData(wpObjct.getElementUTRNumberField(), UTR);
		abstractC.clickElement(wpObjct.getElementSubmitBtn());
		abstractC.verifyTextOfthWebEement(wpObjct.getElementNotificationMessage(), configData.expectedSuccessOfflineOrderNotifyMsg);
		abstractC.waitForSeconds(3);
		double gst =0.18;
		double expectedAmount = creditscount* Double.valueOf(unitPrice);
		double expectedSubTotal = expectedAmount;
		double expectedGST = abstractC.roundToOneDecimalPlace(expectedAmount* gst);
		String expectedTotalAmount = String.format("%.2f", expectedSubTotal+expectedGST) ;
		List<String> firstRowDetails = (abstractC.getFirstRowDetails(wpObjct.getElemenOfFirstRow()));
		List<String> expectedDetails = Arrays.asList(expectedTotalAmount,String.format("%.2f", unitPrice),UTR.toLowerCase(),status);
		if (abstractC.compareToList(expectedDetails,firstRowDetails)) {
			System.out.println("Offline order created successfully");
		}else {
			Assert.assertTrue(false, "Error in Offline order created");
		}
		
	
	}
}
