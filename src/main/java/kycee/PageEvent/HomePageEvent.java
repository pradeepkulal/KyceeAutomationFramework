package kycee.PageEvent;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import kycee.Base.BaseClass;
import kycee.PageObjects.HomePageObjects;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;

public class HomePageEvent extends BaseClass{


	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	ConfigurationData configData = new ConfigurationData();
	protected WebDriverWait wait;



	public  void validateDomainsButton() {
		WebElement DomainsTabButton = HMObjects.domainsTabButtonValidation();
		abstractC.isElementClickable(DomainsTabButton);
		Logger.info("Element is clickable");
		//Logger.info("The Button is clickable");
		abstractC.clickElement(DomainsTabButton);
		if (abstractC.isElementDisplayed(DomainsTabButton)) {
			Assert.assertTrue(true, "The Button is Not displayed");
		}
	}

	public void verifyDomainsTab() throws InterruptedException {
		WebElement DomainsTabButton = HMObjects.domainsTabButtonValidation();
		abstractC.moveCursorToWebElement(DomainsTabButton, 10);
		String text_Bold =  DomainsTabButton.getCssValue("font-weight");

		// Verify whether text is bold or not
		Assert.assertTrue( text_Bold.contains("500"));
		if (text_Bold.contains("500")) {
			System.out.println("Domain Text is Bold");
		}
		else {
			System.out.println("Domain Text is Not Bold");
		}
		String actualAftercolour = abstractC.convertColorToHex(DomainsTabButton.getCssValue("color"));
		Assert.assertEquals(actualAftercolour,configData.expectedAfterTextColor);
		if (actualAftercolour.equals(configData.expectedAfterTextColor)) {
			System.out.println("After Mouse Hover Domain button Color is Proper");
		} else {
			System.out.println("After Mouse Hover Domain button Color is not Proper");
		}
		// Verify whether element is clickable or not
		if (abstractC.isElementClickable(DomainsTabButton )) {
			Assert.assertTrue(true,"Domains Tab Button is Clickable");	
		}else {
			Assert.assertTrue(false,"Domains Tab Button is Clickable");
		}
		// Verify Navigation to specific section after clicking
		abstractC.clickElement(DomainsTabButton);
		WebElement domainSectionHeader = HMObjects.getdomainSectionTitleElement();
		String actualHeaderText= domainSectionHeader.getText();
		Assert.assertEquals(actualHeaderText, configData.domain_Header_Text);
		if (actualHeaderText.equals(configData.domain_Header_Text)) {
			System.out.println("User is Successfully Navigated to Domains Section");
		}
		else {
			System.out.println("User is Not Navigated to Domains Section");
		}



	}


	public void verifyBusinessCassesTab() throws InterruptedException {
		WebElement businessCassesTab = HMObjects.getbusinessCassesButtonElement();
		abstractC.moveCursorToWebElement(businessCassesTab, 10);
		String text_Bold =  businessCassesTab.getCssValue("font-weight");

		// Verify whether text is bold or not
		Assert.assertTrue( text_Bold.contains("500"));
		if (text_Bold.contains("500")) {
			System.out.println("Business Casses Text is Bold");
		}
		else {
			System.out.println("Business Casses Text is Not Bold");
		}
		//Verify Color of the text after Mouse hover
		String actualAftercolour = abstractC.convertColorToHex(businessCassesTab.getCssValue("color"));
		Assert.assertEquals(actualAftercolour,configData.expectedAfterTextColor);
		if (actualAftercolour.equals(configData.expectedAfterTextColor)) {
			System.out.println("After Mouse Hover Business Casses button Color is Proper");
		} else {
			System.out.println("After Mouse Hover Business Casses button Color is not Proper");
		}
		//Verify whether element is clickable or not
		Assert.assertTrue(abstractC.awaitForElementPresence(businessCassesTab, 10));

		// Verify Navigation to specific section after clicking
		businessCassesTab.click();
		WebElement businessCasesSectionTitle = HMObjects.getBusinessCasesSectionTitleElement();
		String actualHeaderText= businessCasesSectionTitle.getText();
		Assert.assertEquals(actualHeaderText, configData.business_Casses_Header_Text);
		if (actualHeaderText.equals(configData.business_Casses_Header_Text)) {
			System.out.println("User is Successfully Navigated to Business Casses Section");
		}
		else {
			System.out.println("User is Not Navigated to Business Casses Section");
		}
		List<WebElement> businessCasesCardsElements = HMObjects.getBusinessCasesCardsElements();
		for (WebElement webElement : businessCasesCardsElements) {
			abstractC.moveCursorToWebElement(webElement, 10);
			String actualYellowColor = abstractC.convertColorToHex(webElement.getCssValue("background-color"));
			Assert.assertEquals(actualYellowColor, configData.expectedYellowColor);
		}
		List<WebElement> actualTitleElementList = HMObjects.getBusinessCasesCardsTextElements();
		List<String> actualTitleText = abstractC.getTextOfWebElements(actualTitleElementList);
		List<String> expectedTitleList1 = Arrays.asList(configData.expectedBusinessCasesCardText);
		Assert.assertEquals(actualTitleText,expectedTitleList1);
		if (actualTitleText.equals(expectedTitleList1)) { 
			System.out.println("Business cases Section Card Text are Proper"); 
		}
		else {
			System.out.println("Business cases Section Card Text are Not Proper"); 
		}
	}


	public void verifyChallengesTab() throws InterruptedException {
		WebElement challangesButton = HMObjects.getChallangesButtonElement();
		abstractC.moveCursorToWebElement(challangesButton, 10);
		String text_Bold =  challangesButton.getCssValue("font-weight");

		// Verify whether text is bold or not
		Assert.assertTrue( text_Bold.contains("500"));
		if (text_Bold.contains("500")) {
			System.out.println("Challenges Text is Bold");
		}
		else {
			System.out.println("Challenges Text is Not Bold");
		}
		//Verify Color of the text after Mouse hover
		String actualAftercolour = abstractC.convertColorToHex(challangesButton.getCssValue("color"));
		Assert.assertEquals(actualAftercolour,configData.expectedAfterTextColor);
		if (actualAftercolour.equals(configData.expectedAfterTextColor)) {
			System.out.println("After Mouse Hover Challenges button Color is Proper");
		} else {
			System.out.println("After Mouse Hover Challenges button Color is not Proper");
		}
		//Verify whether element is clickable or not
		Assert.assertTrue(abstractC.awaitForElementPresence(challangesButton, 10));

		// Verify Navigation to specific section after clicking
		abstractC.clickElement(challangesButton);
		WebElement challengesSection = HMObjects.getChallangesTitleElement();
		String actualHeaderText= challengesSection.getText();
		Assert.assertEquals(actualHeaderText, configData.challenges_Header_Text);
		if (actualHeaderText.equals(configData.challenges_Header_Text)) {
			System.out.println("User is Successfully Navigated to Challenges Section");
		}
		else {
			System.out.println("User is Not Navigated to Challenges Section");
		}

		List<WebElement> ChallengesSectionButtonElements = HMObjects.getChallengesSctionButtonElements();
		for (WebElement webElement : ChallengesSectionButtonElements) {
			abstractC.moveCursorToWebElement(webElement, 10);
			Assert.assertTrue(abstractC.awaitForElementPresence(webElement, 10));
			abstractC.clickElement(webElement);
			String actualLightBlueColor = abstractC.convertColorToHex("background-color",webElement);
			System.out.println(actualLightBlueColor);
			Assert.assertEquals(actualLightBlueColor, configData.expectedlightBlueColor);
		}
		List<String> actualTitleText = abstractC.getTextOfWebElements(ChallengesSectionButtonElements);
		List<String> expectedTitleList1 = Arrays.asList(configData.expectedChallangesButtonText);
		System.out.println(actualTitleText);
		Assert.assertEquals(actualTitleText,expectedTitleList1);
		if (actualTitleText.equals(expectedTitleList1)) { 
			System.out.println("Challenges Section Button Text are Proper"); 
		}
		else {
			System.out.println("Challenges Section Button are Not Proper"); 
		} 

	}

	public void verifyWhyKYCEETab() throws InterruptedException {
		WebElement whyKYCETabButton = HMObjects.getwhyKYCEETabButtonElement();
		abstractC.moveCursorToWebElement(whyKYCETabButton, 10);
		String text_Bold =  whyKYCETabButton.getCssValue("font-weight");

		// Verify whether text is bold or not
		Assert.assertTrue( text_Bold.contains("500"));
		if (text_Bold.contains("500")) {
			System.out.println("Why KYCEE Text is Bold");
		}
		else {
			System.out.println("Why KYCEE Text is Not Bold");
		}
		//Verify Color of the text after Mouse hover
		String actualAftercolour = abstractC.convertColorToHex(whyKYCETabButton.getCssValue("color"));
		Assert.assertEquals(actualAftercolour,configData.expectedAfterTextColor);
		if (actualAftercolour.equals(configData.expectedAfterTextColor)) {
			System.out.println("After Mouse Hover Why KYCEE button Color is Proper");
		} else {
			System.out.println("After Mouse Hover Why KYCEE button Color is not Proper");
		}
		//Verify whether element is clickable or not
		Assert.assertTrue(abstractC.awaitForElementPresence(whyKYCETabButton, 10));

		// Verify Navigation to specific section after clicking
		abstractC.clickElement(whyKYCETabButton);
		WebElement element1 = HMObjects.getwhyKYCEETitleElement();
		Assert.assertTrue(element1.isDisplayed(), "Why KYCEE Section is displayed");
		if (element1.isDisplayed()) {
			System.out.println("User is Successfully Navigated to Why KYCEE Section");
		}
		else {
			System.out.println("User is Not Navigated to Why KYCEE Section");
		}


		List<WebElement> WhyKYCEESectionButtonElements = HMObjects.WhyKYCEESectionButtonElements();
		for (WebElement webElement : WhyKYCEESectionButtonElements) {
			abstractC.moveCursorToWebElement(webElement, 10);
			Assert.assertTrue(abstractC.awaitForElementPresence(webElement, 10));
			abstractC.clickElement(webElement);
		}
		List<String> actualTitleText = abstractC.getTextOfWebElements(WhyKYCEESectionButtonElements);
		List<String> expectedTitleList1 = Arrays.asList(configData.expectedWhyKYCEEButtonText);
		System.out.println(actualTitleText);
		Assert.assertEquals(actualTitleText,expectedTitleList1);
		if (actualTitleText.equals(expectedTitleList1)) { 
			System.out.println("Challenges Section Button Text are Proper"); 
		}
		else {
			System.out.println("Challenges Section Button are Not Proper"); 
		} 



	}

	public void verifyAboutUsTab() throws InterruptedException {
		WebElement aboutUsTabButton = HMObjects.getAboutUsTabButtonElement();
		abstractC.moveCursorToWebElement(aboutUsTabButton, 10);
		String text_Bold =  aboutUsTabButton.getCssValue("font-weight");

		// Verify whether text is bold or not
		Assert.assertTrue( text_Bold.contains("500"));
		if (text_Bold.contains("500")) {
			System.out.println("About Us Text is Bold");
		}
		else {
			System.out.println("About Us Text is Not Bold");
		}
		//Verify Color of the text after Mouse hover
		String actualAftercolour = abstractC.convertColorToHex(aboutUsTabButton.getCssValue("color"));
		Assert.assertEquals(actualAftercolour,configData.expectedAfterTextColor);
		if (actualAftercolour.equals(configData.expectedAfterTextColor)) {
			System.out.println("After Mouse Hover About Us button Color is Proper");
		} else {
			System.out.println("After Mouse Hover About Us button Color is not Proper");
		}
		//Verify whether element is clickable or not
		Assert.assertTrue(abstractC.awaitForElementPresence(aboutUsTabButton, 10));

		// Verify Navigation to specific section after clicking
		abstractC.clickElement(aboutUsTabButton);
		WebElement aboutUsSection = HMObjects.getAboutUsSectionTitleElement();
		Assert.assertTrue(aboutUsSection.isDisplayed(), "About Us Section is displayed");

		String actualAboutUsButtonText = aboutUsSection.getText();
		Assert.assertEquals(actualAboutUsButtonText, configData.About_Us_Button_text);
	}


	public void verifyFooterTitles() {
		WebElement footerSction = HMObjects.getFooterSectionElement();
		abstractC.scrollToWebElement(driver, footerSction);
		List<WebElement> actualTitleElementList = HMObjects.getFooterTitleElements();
		List<String> actualTitleText = abstractC.getTextOfWebElements(actualTitleElementList);
		List<String> expectedTitleList1 = Arrays.asList(configData.expectedTitleList);
		Assert.assertEquals(actualTitleText,expectedTitleList1);
		if (actualTitleText.equals(expectedTitleList1)) { 
			System.out.println("Footer Titles Text are Proper"); 
		}
		else {
			System.out.println("Footer Titles Text are Not Proper"); 
		} 
	}

	public SignInPageEvent validateSignInButton() {
		WebElement signInButton = HMObjects.getSignInButtonElement();
		abstractC.verifyBackGroundColorOfTheElement(signInButton, configData.expectedDarkBlueColor);
		if (abstractC.isElementClickable(signInButton)) {
			Assert.assertTrue(true); 
			System.out.println("Sign in button is clickable");
		}else {
			Logger.info("Sign in Button is not Clickable"); 
		}
		AbstractComponents.clickElement(signInButton);
		WebElement signInButtonBlue = HMObjects.getSignInTextElement();
		if (abstractC.isElementDisplayed(signInButtonBlue)) {
			System.out.println("Successfully navigated to SignIn Page");
			Assert.assertTrue(true);
		}else { 
			System.out.println("Error in Navigation to SignIn page");
		}

		return new SignInPageEvent();
	}

	public SignUpPageEvent validateSignUpButton() {
		WebElement signUpButton = HMObjects.getSignUpButtonElement();
		abstractC.verifyBackGroundColorOfTheElement(signUpButton, configData.expectedDarkBlueColor);		if (abstractC.isElementClickable(signUpButton)) {
			Assert.assertTrue(true);
			System.out.println("Sign Up button is clickable");
		}else {
			Logger.info("Sign Up Button is not Clickable");
		}
		abstractC.clickElement(signUpButton);

		WebElement signUpText =  HMObjects.getSignUpTextElement();
		if (abstractC.isElementDisplayed(signUpText)) { 
			System.out.println("Successfully navigated to SignUp Page");
			Assert.assertTrue(true);
		}else {
			System.out.println("Error in Navigation to SignUp page");
		}
		return new SignUpPageEvent();
	}
}
