package kycee.PageEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import kycee.Base.BaseClass;
import kycee.PageObjects.DashBoardObject;
import kycee.PageObjects.ForgotPasswordPageObject;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.SignInPageObject;
import kycee.PageObjects.SignUpPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;
import kycee.Utills.Constants;
import kycee.Utills.Xls_Reader;

public class SignInPageEvent extends BaseClass {

	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	SignUpPageObject signUpPageObject = new SignUpPageObject();
	SignInPageObject signInPageObject = new SignInPageObject();
	DashBoardObject dbObjct = new DashBoardObject();
	ForgotPasswordPageObject forgotPasswordObj = new ForgotPasswordPageObject();
	ConfigurationData configData = new ConfigurationData();
	Constants constant = new Constants();
	
	protected WebDriverWait wait;

	public void login() throws IOException {
		String filePath = ".//TestData//LoginData.xlsx";

		try (FileInputStream inputStream = new FileInputStream(filePath);
				XSSFWorkbook workBook = new XSSFWorkbook(inputStream)) {

			XSSFSheet sheet = workBook.getSheet("Sheet1");
			int maxAttempts = 1;
			int rows = sheet.getLastRowNum(); 
			for (int attempt = 0; attempt < maxAttempts; attempt++) {
				boolean loginSuccessful = false;

				for (int i = 1; i <= rows; i++) {
					int j = 0; 
					signInPageObject.getElementUserEmailInput().clear();
					signInPageObject.getElementUserEmailInput().sendKeys(sheet.getRow(i).getCell(j++).toString());
					signInPageObject.getElementUserPasswordInput().clear();
					signInPageObject.getElementUserPasswordInput().sendKeys(sheet.getRow(i).getCell(j++).toString());
					AbstractComponents.waitForSeconds(2);

					signInPageObject.getElementSubmitBtn().click();
					AbstractComponents.waitForSeconds(2);

					wait = new WebDriverWait(driver, Duration.ofSeconds(8));

					// Check for login feedback
					if (handleLoginFeedback(wait)) {
						loginSuccessful = true;
						break; // Exit the loop on successful login
					}
				}

				if (loginSuccessful) {
					System.out.println("Login successful!");
					break; // Exit the outer loop if login is successful
				}
			}
		}
	}

	private boolean handleLoginFeedback(WebDriverWait wait) {
		String xpathWithErrorMessage = "//div[contains(text(), 'Kindly enter a valid email address.') or " +
				"contains(text(), 'The email address provided is not valid.') or " +
				"contains(text(), 'Please provide a valid password.')]";

		try {
			WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathWithErrorMessage)));
			if (errorMessageElement.isDisplayed()) {
				String errorMessage = errorMessageElement.getText();
				handleErrorMessage(errorMessage);
				return false; // Return false if an error message is displayed
			}
		} catch (Exception e) {
			// No error message found, assume login was successful
			return true;
		}
		return false; // In case no success or failure is determined
	}

	private void handleErrorMessage(String errorMessage) {
		switch (errorMessage) {
		case "Kindly enter a valid email address.":
			System.out.println("Empty Email Address ...Retrying");
			break;
		case "The email address provided is not valid.":
			System.out.println("Invalid Email Address ...Retrying");
			break;
		case "Please provide a valid password.":
			System.out.println("Empty Password ...Retrying");
			break;
		default:
			break;
		}
	}

	public void login_NotificationHandling() throws IOException {
		String filePath = ".//TestData//LoginData.xlsx";

		try (FileInputStream inputStream = new FileInputStream(filePath);
				XSSFWorkbook workBook = new XSSFWorkbook(inputStream)) {

			XSSFSheet sheet = workBook.getSheet("Sheet2");

			int maxAttempts = 1;
			int rows = sheet.getLastRowNum();

			for (int attempt = 0; attempt < maxAttempts; attempt++) {
				for (int i = 1; i <= rows; i++) {
					int j = 0;
					signInPageObject.getElementUserEmailInput().clear();
					signInPageObject.getElementUserEmailInput().sendKeys(sheet.getRow(i).getCell(j++).toString());
					signInPageObject.getElementUserPasswordInput().clear();
					signInPageObject.getElementUserPasswordInput().sendKeys(sheet.getRow(i).getCell(j++).toString());
					AbstractComponents.waitForSeconds(2);

					signInPageObject.getElementSubmitBtn().click();
					AbstractComponents.waitForSeconds(2);

					wait = new WebDriverWait(driver, Duration.ofSeconds(8));
					handleNotificationLoginFeedback(wait);
				}
			}
		}
	}

	private void handleNotificationLoginFeedback(WebDriverWait wait) {
		String xpathWithNotification = "//div[contains(text(), 'The User has been inactive. Please contact support.') or " +
				"contains(text(), 'The User has been terminated. Please contact support.') or " +
				"contains(text(), 'Incorrect password.') or " +
				"contains(text(), 'Email not associated with an account.')]";

		try {
			WebElement errorMessageNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathWithNotification)));
			if (errorMessageNotification.isDisplayed()) {
				String errorNotificationMessage = errorMessageNotification.getText();
				handleNotificationErrorMessage(errorNotificationMessage);
			}
		} catch (Exception e) {
			// No error message found; proceed normally
		}
	}

	private void handleNotificationErrorMessage(String errorNotificationMessage) {
		boolean handled = true; 

		switch (errorNotificationMessage) {
		case "The User has been inactive. Please contact support.":
			System.out.println("Inactive User ...Retrying");
			break;
		case "The User has been terminated. Please contact support.":
			System.out.println("Terminated User ...Retrying");
			break;
		case "Incorrect password.":
			System.out.println("Incorrect Password ...Retrying");
			break;
		case "Email not associated with an account.":
			System.out.println("Unregistered User ...Retrying");
			break;
		default:
			System.out.println("Unhandled notification: " + errorNotificationMessage);
			handled = false;
			break;
		}

		if (!handled) {
			
			System.out.println("Error Message is not handled");
			Assert.assertTrue(false, "Unhandled notification: " + errorNotificationMessage);
		}
	}
	
	public DashBoardPageEvent login(String user) {
		String User = user.toLowerCase();
		String email = "";
		String password = "";
		switch (User) {
		case "customer":
			 email = testDataXL.getCellData("Sheet1", "Email", 2);
			 password = testDataXL.getCellData("Sheet1", "Password", 2);
			break;
		case "business user":
			 email = testDataXL.getCellData("Sheet1", "Email", 3); 
			 password = testDataXL.getCellData("Sheet1", "Password", 3);
			break;
		case "business admin":
			 email = testDataXL.getCellData("Sheet1", "Email", 4);
			 password = testDataXL.getCellData("Sheet1", "Password", 4);
			break;
		case "super admin":
			 email = testDataXL.getCellData("Sheet1", "Email", 5);
			 password = testDataXL.getCellData("Sheet1", "Password", 5);
			break;
		case "blogger":
			 email = testDataXL.getCellData("Sheet1", "Email", 6);
			 password = testDataXL.getCellData("Sheet1", "Password", 6);
			break;
		default:
			System.out.println(User + " is not available in the sheet");
			break;
		}
		
		abstractC.enterData(signInPageObject.getElementUserEmailInput(), email);
		abstractC.enterData(signInPageObject.getElementUserPasswordInput(), password);
		abstractC.clickElement(signInPageObject.getElementSubmitBtn());
		System.out.println(User + " is Successfully Logged In");
		if (abstractC.isElementDisplayed(dbObjct.getElementDashBoardPageHeader())) {
			abstractC.verifyTextOfthWebEement(dbObjct.getElementDashBoardPageHeader(), configData.expectedDashBoardHeader);
		}else {
			Assert.assertTrue(false,User + " Log In Failed");
		}
		return new DashBoardPageEvent();
	}

	public DashBoardPageEvent loginWith(String email, String password) {
		abstractC.waitForSeconds(5);
		abstractC.enterData(signInPageObject.getElementUserEmailInput(), email);
		abstractC.enterData(signInPageObject.getElementUserPasswordInput(), password);
		abstractC.clickElement(signInPageObject.getElementSubmitBtn());
		System.out.println("Successfully Logged In");
		abstractC.waitForSeconds(5);
		return new DashBoardPageEvent();		
	}
	
	public ForgotPasswordPageEvent verifyNavigationToForgotPasswordPage() {
		abstractC.clickElement(signInPageObject.getElementForgotPasswordLink());
		WebElement forgotPasswordHeader = forgotPasswordObj.getElementForgotPasswordPageHeader();
			if (abstractC.isElementDisplayed(forgotPasswordHeader)) {
			abstractC.verifyTextOfthWebEement(forgotPasswordHeader, configData.forgotPasswordHeaderText);
		} else {
			Assert.assertFalse(true);
		}
		return new ForgotPasswordPageEvent();		
	}

}
