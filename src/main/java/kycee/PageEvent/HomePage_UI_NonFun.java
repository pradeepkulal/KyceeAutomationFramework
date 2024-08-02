package kycee.PageEvent;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import kycee.Base.BaseClass;
import kycee.Utills.FetchElement;
/*
public class HomePage_UI_NonFun extends BaseClass{


	FetchElement ele = new FetchElement();


	String BA_subhead_text = "Introduction 1";
	String domainText = "DOMAINS";
	String domain_Header_Text = "Domains We Serve";
	String business_Casses_Button_text ="BUSINESS CASES";
	String business_Casses_Header_Text= "Business Cases";
	String challenges_Button_text ="CHALLENGES";
	String challenges_Header_Text= "Challenges";
	String About_Us_Button_text ="ABOUT US";
	String Why_KYCEE_text = "WHY KYCEE";
	String expectedBeforeTextColor ="#8A90A2";
	String expectedAfterTextColor = "#292930";
	String expectedTitleList[] = {"About KYCee","Policies","Help & Support","Instagram post"};
	String expectedWhyKYCEEButtonText[] = {"Technology","Design","Innovation"};
	String expectedYellowColor ="#FBD95E";
	String expectedBusinessCasesCardText[] = {"Bulk Processing","Customer Onboarding","Account Recovery","Legal Signatures","Buying & Selling","Decision Making"};
	String expectedlightBlueColor ="#82CEFD";
	String expectedDarkBlueColor = "#5956E9";
	String expectedChallangesButtonText[] = {"Expectations","User Experience","Regulatory","Manual Processes","Data Quality","Evolving Fraud"};
	String expectedAIButtonText = "AI'S Magic";
	String expectedAboutUsText = "About Us";

	public void verifyBasePageIsLoaded() {
		Assert.assertTrue(ele.getWebElements("XPATH",BasePageObject.signUp).size()>0,
				"Page Not Loaded Properly");
	}

	public void verifyText() throws InterruptedException {
		WebElement element =ele.getWebElement("XPATH",BasePageObject.introductionText);
		//scrollToWebElement(driver, element);
		String text = element.getText();
		Assert.assertEquals(text, BA_subhead_text);
		if (text.equals(BA_subhead_text)) {
			System.out.println("Sub Heading text is Proper");
		}
		else {
			System.out.println("Sub Heading text is Not Proper");
		}
	}



	public void verifyDomainsTab() throws InterruptedException {
		WebElement element =ele.getWebElement("XPATH",BasePageObject.domainsTab);
		//	String text = element.getText();
		//	Assert.assertTrue(element.isDisplayed(), "Domain button is displayed");
		//	Assert.assertEquals(text, domainText);
		//		if (text.equals(domainText)) {
		//			System.out.println("Domain button text is Proper");
		//		}
		//		else {
		//			System.out.println("Domain Button text is Not Proper");
		//		}
		//	String actualBeforeTextColor = converColorToHex(element.getCssValue("color"));
		//		Assert.assertEquals(actualBeforeTextColor, expectedBeforeTextColor);
		//		if (actualBeforeTextColor.equals(expectedBeforeTextColor)) {
		//			System.out.println("Before Mouse Hover Domain button Color is Proper");
		//		} else {
		//			System.out.println("Before Mouse Hover Domain button Color is not Proper");
		//		}
		//moveCursorToWebElement(driver,element, 10);
		String text_Bold =  element.getCssValue("font-weight");

		// Verify whether text is bold or not
		Assert.assertTrue( text_Bold.contains("500"));
		if (text_Bold.contains("500")) {
			System.out.println("Domain Text is Bold");
		}
		else {
			System.out.println("Domain Text is Not Bold");
		}
		//Verify Color of the text after Mouse hover
		//String actualAftercolour = converColorToHex(element.getCssValue("color"));
		Assert.assertEquals(actualAftercolour,expectedAfterTextColor);
		if (actualAftercolour.equals(expectedAfterTextColor)) {
			System.out.println("After Mouse Hover Domain button Color is Proper");
		} else {
			System.out.println("After Mouse Hover Domain button Color is not Proper");
		}
		//Verify whether element is clickable or not
	//	Assert.assertTrue(awaitForElementPresence(driver, element, 10));

		// Verify Navigation to specific section after clicking
		element.click();
		WebElement element1 =ele.getWebElement("XPATH",BasePageObject.domainSectionTitle);
		String actualHeaderText= element1.getText();
		Assert.assertEquals(actualHeaderText, domain_Header_Text);
		if (actualHeaderText.equals(domain_Header_Text)) {
			System.out.println("User is Successfully Navigated to Domains Section");
		}
		else {
			System.out.println("User is Not Navigated to Domains Section");
		}
	}

	public void verifyBusinessCassesTab() throws InterruptedException {
		WebElement element =ele.getWebElement("XPATH",BasePageObject.businessCassesTab);
		//		String text = element.getText();
		//		Assert.assertTrue(element.isDisplayed(), "Business Casses button is displayed");
		//		Assert.assertEquals(text, business_Casses_Button_text);
		//		if (text.equals(business_Casses_Button_text)) {
		//			System.out.println("Business Casses button text is Proper");
		//		}
		//		else {
		//			System.out.println("Business Casses Button text is Not Proper");
		//		}
		//		String actualBeforeTextColor = converColorToHex(element.getCssValue("color"));
		//		Assert.assertEquals(actualBeforeTextColor, expectedBeforeTextColor);
		//		if (actualBeforeTextColor.equals(expectedBeforeTextColor)) {
		//			System.out.println("Before Mouse Hover Domain button Color is Proper");
		//		} else {
		//			System.out.println("Before Mouse Hover Domain button Color is not Proper");
		//		}
		moveCursorToWebElement(driver,element, 10);
		String text_Bold =  element.getCssValue("font-weight");

		// Verify whether text is bold or not
		Assert.assertTrue( text_Bold.contains("500"));
		if (text_Bold.contains("500")) {
			System.out.println("Business Casses Text is Bold");
		}
		else {
			System.out.println("Business Casses Text is Not Bold");
		}
		//Verify Color of the text after Mouse hover
		String actualAftercolour = converColorToHex(element.getCssValue("color"));
		Assert.assertEquals(actualAftercolour,expectedAfterTextColor);
		if (actualAftercolour.equals(expectedAfterTextColor)) {
			System.out.println("After Mouse Hover Business Casses button Color is Proper");
		} else {
			System.out.println("After Mouse Hover Business Casses button Color is not Proper");
		}
		//Verify whether element is clickable or not
		Assert.assertTrue(awaitForElementPresence(driver, element, 10));

		// Verify Navigation to specific section after clicking
		element.click();
		WebElement element1 =ele.getWebElement("XPATH",BasePageObject.BusinessCasesSectionTitle);
		String actualHeaderText= element1.getText();
		Assert.assertEquals(actualHeaderText, business_Casses_Header_Text);
		if (actualHeaderText.equals(business_Casses_Header_Text)) {
			System.out.println("User is Successfully Navigated to Business Casses Section");
		}
		else {
			System.out.println("User is Not Navigated to Business Casses Section");
		}
	}

	

	public void verifyChallengesTab() throws InterruptedException {
		WebElement element =ele.getWebElement("XPATH",BasePageObject.challangesTab);
		//		String text = element.getText();
		//		Assert.assertTrue(element.isDisplayed(), "Challenges button is displayed");
		//		Assert.assertEquals(text, challenges_Button_text);
		//		if (text.equals(business_Casses_Button_text)) {
		//			System.out.println("Challenges button text is Proper");
		//		}
		//		else {
		//			System.out.println("Challenges Button text is Not Proper");
		//		}
		//		String actualBeforeTextColor = converColorToHex(element.getCssValue("color"));
		//		Assert.assertEquals(actualBeforeTextColor, expectedBeforeTextColor);
		//		if (actualBeforeTextColor.equals(expectedBeforeTextColor)) {
		//			System.out.println("Before Mouse Hover Domain button Color is Proper");
		//		} else {
		//			System.out.println("Before Mouse Hover Domain button Color is not Proper");
		//		}
		moveCursorToWebElement(driver,element, 10);
		String text_Bold =  element.getCssValue("font-weight");

		// Verify whether text is bold or not
		Assert.assertTrue( text_Bold.contains("500"));
		if (text_Bold.contains("500")) {
			System.out.println("Challenges Text is Bold");
		}
		else {
			System.out.println("Challenges Text is Not Bold");
		}
		//Verify Color of the text after Mouse hover
		String actualAftercolour = converColorToHex(element.getCssValue("color"));
		Assert.assertEquals(actualAftercolour,expectedAfterTextColor);
		if (actualAftercolour.equals(expectedAfterTextColor)) {
			System.out.println("After Mouse Hover Challenges button Color is Proper");
		} else {
			System.out.println("After Mouse Hover Challenges button Color is not Proper");
		}
		//Verify whether element is clickable or not
		Assert.assertTrue(awaitForElementPresence(driver, element, 10));

		// Verify Navigation to specific section after clicking
		element.click();
		WebElement element1 =ele.getWebElement("XPATH",BasePageObject.challengesSectionTitle);
		String actualHeaderText= element1.getText();
		Assert.assertEquals(actualHeaderText, challenges_Header_Text);
		if (actualHeaderText.equals(challenges_Header_Text)) {
			System.out.println("User is Successfully Navigated to Challenges Section");
		}
		else {
			System.out.println("User is Not Navigated to Challenges Section");
		}
	}

	public void verifyWhyKYCEETab() throws InterruptedException {
		WebElement element =ele.getWebElement("XPATH",BasePageObject.whyKYCEETab);
		//		String text = element.getText();
		//		Assert.assertTrue(element.isDisplayed(), "Why KYCEE button is displayed");
		//		Assert.assertEquals(text, Why_KYCEE_text);
		//		if (text.equals(Why_KYCEE_text)) {
		//			System.out.println("Why KYCEE button text is Proper");
		//		}
		//		else {
		//			System.out.println("Why KYCEE Button text is Not Proper");
		//		}
		//		String actualBeforeTextColor = converColorToHex(element.getCssValue("color"));
		//		Assert.assertEquals(actualBeforeTextColor, expectedBeforeTextColor);
		//		if (actualBeforeTextColor.equals(expectedBeforeTextColor)) {
		//			System.out.println("Before Mouse Hover Domain button Color is Proper");
		//		} else {
		//			System.out.println("Before Mouse Hover Domain button Color is not Proper");
		//		}
		moveCursorToWebElement(driver,element, 10);
		String text_Bold =  element.getCssValue("font-weight");

		// Verify whether text is bold or not
		Assert.assertTrue( text_Bold.contains("500"));
		if (text_Bold.contains("500")) {
			System.out.println("Why KYCEE Text is Bold");
		}
		else {
			System.out.println("Why KYCEE Text is Not Bold");
		}
		//Verify Color of the text after Mouse hover
		String actualAftercolour = converColorToHex(element.getCssValue("color"));
		Assert.assertEquals(actualAftercolour,expectedAfterTextColor);
		if (actualAftercolour.equals(expectedAfterTextColor)) {
			System.out.println("After Mouse Hover Why KYCEE button Color is Proper");
		} else {
			System.out.println("After Mouse Hover Why KYCEE button Color is not Proper");
		}
		//Verify whether element is clickable or not
		Assert.assertTrue(awaitForElementPresence(driver, element, 10));

		// Verify Navigation to specific section after clicking
		element.click();
		WebElement element1 =ele.getWebElement("ID",BasePageObject.aboutUsSection);
		Assert.assertTrue(element1.isDisplayed(), "Why KYCEE Section is displayed");
		if (element1.isDisplayed()) {
			System.out.println("User is Successfully Navigated to Why KYCEE Section");
		}
		else {
			System.out.println("User is Not Navigated to Why KYCEE Section");
		}
	}

	public void verifyAboutUsTab() throws InterruptedException {
		WebElement element =ele.getWebElement("XPATH",BasePageObject.aboutUsTab);
		//		String text = element.getText();
		//		Assert.assertTrue(element.isDisplayed(), "About Us button is displayed");
		//		Assert.assertEquals(text, About_Us_Button_text);
		//		if (text.equals(About_Us_Button_text)) {
		//			System.out.println("About Us button text is Proper");
		//		}
		//		else {
		//			System.out.println("About Us Button text is Not Proper");
		//		}
		//		String actualBeforeTextColor = converColorToHex(element.getCssValue("color"));
		//		Assert.assertEquals(actualBeforeTextColor, expectedBeforeTextColor);
		//		if (actualBeforeTextColor.equals(expectedBeforeTextColor)) {
		//			System.out.println("Before Mouse Hover Domain button Color is Proper");
		//		} else {
		//			System.out.println("Before Mouse Hover Domain button Color is not Proper");
		//		}
		moveCursorToWebElement(driver,element, 10);
		String text_Bold =  element.getCssValue("font-weight");

		// Verify whether text is bold or not
		Assert.assertTrue( text_Bold.contains("500"));
		if (text_Bold.contains("500")) {
			System.out.println("About Us Text is Bold");
		}
		else {
			System.out.println("About Us Text is Not Bold");
		}
		//Verify Color of the text after Mouse hover
		String actualAftercolour = converColorToHex(element.getCssValue("color"));
		Assert.assertEquals(actualAftercolour,expectedAfterTextColor);
		if (actualAftercolour.equals(expectedAfterTextColor)) {
			System.out.println("After Mouse Hover About Us button Color is Proper");
		} else {
			System.out.println("After Mouse Hover About Us button Color is not Proper");
		}
		//Verify whether element is clickable or not
		Assert.assertTrue(awaitForElementPresence(driver, element, 10));

		// Verify Navigation to specific section after clicking
		element.click();
		WebElement element1 =ele.getWebElement("ID",BasePageObject.aboutUsSection);
		Assert.assertTrue(element1.isDisplayed(), "About Us Section is displayed");
		if (element1.isDisplayed()) {
			System.out.println("User is Successfully Navigated to About Us Section");
		}
		else {
			System.out.println("User is Not Navigated to About Us Section");
		}
	}

	public void verifyFooterTitles() {
		WebElement element = ele.getWebElement("XPATH",BasePageObject.footerSection);
		waitForSeconds(30);
		scrollToWebElement(driver, element);
		waitForSeconds(30);
		List<WebElement> actualTitleElementList = ele.getWebElements("XPATH", BasePageObject.footerTitle);
		List<String> actualTitleText = getTextOfWebElements(actualTitleElementList);
		List<String> expectedTitleList1 = Arrays.asList(expectedTitleList);
		Assert.assertEquals(actualTitleText,expectedTitleList1);
		if (actualTitleText.equals(expectedTitleList1)) { 
			System.out.println("Footer Titles Text are Proper"); 
		}
		else {
			System.out.println("Footer Titles Text are Not Proper"); 
		} 

	}


	public void verifyBusinessCasesSection() {
		WebElement element =ele.getWebElement("XPATH",BasePageObject.businessCassesTab);
		element.click();

		List<WebElement> ElementList = ele.getWebElements("CLASSNAME", BasePageObject.businessCasesCards);
		for (WebElement webElement : ElementList) {
			moveCursorToWebElement(driver,webElement, 10);
			String actualYellowColor = converColorToHex(webElement.getCssValue("background-color"));
			System.out.println(actualYellowColor);
			Assert.assertEquals(actualYellowColor, expectedYellowColor);
		}
		List<WebElement> actualTitleElementList = ele.getWebElements("XPATH", BasePageObject.businessCasesCardsTitleText);
		List<String> actualTitleText = getTextOfWebElements(actualTitleElementList);
		List<String> expectedTitleList1 = Arrays.asList(expectedBusinessCasesCardText);
		System.out.println(actualTitleText);
		Assert.assertEquals(actualTitleText,expectedTitleList1);
		if (actualTitleText.equals(expectedTitleList1)) { 
			System.out.println("Business cases Section Card Text are Proper"); 
		}
		else {
			System.out.println("Business cases Section Card Text are Not Proper"); 
		} 


	}

	public void verifyChallengesSection() {
		WebElement element =ele.getWebElement("XPATH",BasePageObject.challangesTab);
		Assert.assertTrue(awaitForElementPresence(driver, element, 10));
		element.click();

		List<WebElement> ElementList = ele.getWebElements("XPATH", BasePageObject.challengeSectionButtons);
		for (WebElement webElement : ElementList) {
			moveCursorToWebElement(driver,webElement, 10);
			Assert.assertTrue(awaitForElementPresence(driver, webElement, 10));
			webElement.click();
			String actualLightBlueColor = converColorToHex(webElement.getCssValue("background-color"));
			System.out.println(actualLightBlueColor);
			Assert.assertEquals(actualLightBlueColor, expectedlightBlueColor);
		}
		List<WebElement> actualTitleElementList = ele.getWebElements("XPATH", BasePageObject.challengeSectionButtons);
		List<String> actualTitleText = getTextOfWebElements(actualTitleElementList);
		List<String> expectedTitleList1 = Arrays.asList(expectedChallangesButtonText);
		System.out.println(actualTitleText);
		Assert.assertEquals(actualTitleText,expectedTitleList1);
		if (actualTitleText.equals(expectedTitleList1)) { 
			System.out.println("Challenges Section Button Text are Proper"); 
		}
		else {
			System.out.println("Challenges Section Button are Not Proper"); 
		} 
	}



	public void verifyWhyKYCEESection() {
		WebElement element =ele.getWebElement("XPATH",BasePageObject.whyKYCEETab);
		element.click();
		List<WebElement> actualElementList = ele.getWebElements("XPATH", BasePageObject.whyKYCEESectionButtons);
		List<String> actualTextList= getTextOfWebElements(actualElementList);
		List<String> expectedTextList = Arrays.asList(expectedWhyKYCEEButtonText);
		Assert.assertEquals(actualTextList,expectedTextList);
		if (actualTextList.equals(expectedTextList)) { 
			System.out.println("Why KYCEE Button Text are Proper"); 
		}
		else {
			System.out.println("Why KYCEE Button Text are Not Proper"); 
		}
		// Verify AI's magic button
		WebElement element1 =  ele.getWebElement("XPATH",BasePageObject.AIsMagicButton);
		String actualAIButtonText = element1.getText();
		Assert.assertEquals(actualAIButtonText,expectedAIButtonText);

		String actualDarkBlueColor = converColorToHex(element1.getCssValue("background-color"));
		System.out.println(actualDarkBlueColor);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		Assert.assertEquals(actualDarkBlueColor, expectedDarkBlueColor);
		String display = je.executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('display');",element1).toString();
		moveCursorToWebElement(driver,element1, 10);
		String actualYellowColor = converColorToHex(element1.getCssValue("background-color"));
		System.out.println(actualYellowColor);
		Assert.assertEquals(actualYellowColor, expectedYellowColor);
	}

	public void verifyAboutUsSection() {
		WebElement element =ele.getWebElement("XPATH",BasePageObject.aboutUsTab);
		element.click();
		WebElement aboutUsElement =ele.getWebElement("CSSSELECTOR",BasePageObject.AboutUsButton);
		String actualText= aboutUsElement.getText();
		if (actualText.equalsIgnoreCase(expectedAboutUsText)) { 
			Assert.assertEquals(actualText,expectedAboutUsText);
			System.out.println("About Us Button Text is Proper"); 
		}
		else {
			System.out.println("About Us Button Text are Not Proper"); 
		}
		String actualYellowColor = converColorToHex(aboutUsElement.getCssValue("background-color"));
		if (actualYellowColor.equals(expectedYellowColor)) { 
			System.out.println("About us Button Yellow Color is Proper"); 
		}
		else {
			System.out.println("About Us Button Yellow Color is Not Proper"); 
		}
		//	Assert.assertEquals(actualYellowColor, expectedYellowColor);
		moveCursorToWebElement(driver,aboutUsElement, 10);
		String actualDarkBlueColor = converColorToHex(aboutUsElement.getCssValue("background-color"));
		System.out.println(actualDarkBlueColor);
		if (actualDarkBlueColor.equals(expectedDarkBlueColor)) { 
			System.out.println("About us Button Blue Color is Proper"); 
		}
		else {
			System.out.println("About Us Button Blue Color is Not Proper"); 
		}
		Assert.assertEquals(actualDarkBlueColor, expectedDarkBlueColor);



	}


	public void verifyBrokenLinks() throws MalformedURLException, IOException {
		List<WebElement> links = ele.getWebElements("XPATH",BasePageObject.footerSectionPageLink);
		verifyTheLinksOfThePage(driver,links);
	}

	

} */
