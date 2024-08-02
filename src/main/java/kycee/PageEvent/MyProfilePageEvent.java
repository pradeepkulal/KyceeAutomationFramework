package kycee.PageEvent;

import java.util.Iterator;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import kycee.Base.BaseClass;
import kycee.PageObjects.HomePageObjects;
import kycee.PageObjects.MyProfilePageObject;
import kycee.PageObjects.SignInPageObject;
import kycee.PageObjects.SignUpPageObject;
import kycee.Utills.AbstractComponents;
import kycee.Utills.ConfigurationData;
import kycee.Utills.Constants;
import kycee.Utills.Xls_Reader;

public class MyProfilePageEvent extends BaseClass {

	AbstractComponents abstractC = new AbstractComponents();
	HomePageObjects HMObjects = new HomePageObjects();
	SignUpPageObject signUpPageObject = new SignUpPageObject();
	SignInPageObject signInPageObject = new SignInPageObject();
	MyProfilePageObject myProfileobjct = new MyProfilePageObject();
	ConfigurationData configData = new ConfigurationData();
	Constants constant = new Constants();
	SoftAssert softAssert = new SoftAssert();
	protected WebDriverWait wait;

	public void verifyLogedInUserType(String userType) throws InterruptedException {
		switch (userType) {
		case "Business User":
			 userType = "User";
			break;
		case "Business Admin":
			 userType = "Admin";
			break;
		default:
			break;
		}
		String actualUserType = abstractC.getTextOfWebElement(myProfileobjct.getElementUserType());
		if (actualUserType.equals(userType)) {
			Assert.assertTrue(true,"Expected User Type:" + userType + "Actul User Type: " + actualUserType);
		}
		else {
			Logger.fail("Expected User Type:" + userType + "Actul User Type: " + actualUserType);
			Assert.assertTrue(false,"Expected User Type:" + userType + "Actul User Type: " + actualUserType);
		}
	}
	
	
}
