package kycee.Base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import com.mailosaur.MailosaurClient;

import io.github.bonigarcia.wdm.WebDriverManager;
import kycee.Utills.AbstractComponents;
import kycee.Utills.Constants;
import kycee.Utills.EmailReader;
import kycee.Utills.Xls_Reader;


public class BaseClass {

	public static WebDriver driver;
	public static ExtentHtmlReporter sparkReporter;
	public static ExtentReports extent;
	public Logger logger;
	public static ExtentTest Logger;
	public static Xls_Reader testDataXL;
	public static EmailReader emailReader;
	public static Xls_Reader notificationDataXL;
	public static SoftAssert softAssert;
	public static Constants constant; 
	public static Faker data;
	
	@BeforeTest
	public void beforeTestMethod() {
		logger = LogManager.getLogger(BaseClass.class);
		sparkReporter = new ExtentHtmlReporter(System.getProperty("user.dir") 
				+ File.separator + "Reports" + File.separator + "KyceeReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName","");
		extent.setSystemInfo("UserName","");
		sparkReporter.config().setDocumentTitle("KYCEE_Automation_Report");
		sparkReporter.config().setReportName("KYCEE_Regression_Report");
		constant = new Constants();
		testDataXL = new Xls_Reader(constant.LoginTestDataPath);
		 notificationDataXL = new Xls_Reader(constant.errorMessageExcelPath);
		 emailReader = new EmailReader();
		 softAssert = new SoftAssert();
		 data = new Faker();
	}


	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod(String browser,Method testMethod) {
		Logger = extent.createTest(testMethod.getName());
		setupDriver(browser);
		driver.get(Constants.QA_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}


	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			
			try {
				Logger.addScreenCaptureFromPath(getScreenShot(result.getName()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + " - Test Case Failed ", ExtentColor.RED));
			Logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+ " - Test Case Failed ", ExtentColor.RED));
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			Logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + " - Test Case Skipped ", ExtentColor.ORANGE));
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			Logger.log(Status.PASS,MarkupHelper.createLabel(result.getName() + " - Test Case Passed ", ExtentColor.ORANGE));
		}
		driver.quit();
	}


	@AfterTest
	public void afterTest() {
		extent.flush();
		
	}


	private void setupDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			WebDriverManager.chromedriver().clearResolutionCache().setup();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	public String getScreenShot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return file.getPath();
	
	}



}
