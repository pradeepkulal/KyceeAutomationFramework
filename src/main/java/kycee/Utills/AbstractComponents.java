package kycee.Utills;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.File;

import kycee.Base.BaseClass;

public class AbstractComponents extends BaseClass{

	Constants constant = new Constants();

	static WebDriverWait wait = new WebDriverWait(driver,   Duration.ofSeconds(10));


	public static void enterData(WebElement element, String textToSend) {
		try { 
			element.sendKeys(Keys.LEFT_CONTROL + "a" + Keys.DELETE);
			element.sendKeys(textToSend);
		} catch (Exception e) {
			System.out.println("Error occured while inputing text int the field " + e.getMessage());
		}
	}

	public static boolean isElementEnabled(WebElement element) {
		try {
			return element.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isNotClickable(WebElement... elements) {
	    List<WebElement> elementsChecked = new ArrayList<>();
	    List<WebElement> elementsToCheckByClass = new ArrayList<>();
	    List<WebElement> elementsToCheckByClick = new ArrayList<>();
	    List<WebElement> elementsToCheckBySendKeys = new ArrayList<>();

	    for (WebElement checkedElement : elements) {
	        if (checkedElement.isEnabled()) {
	            elementsToCheckByClass.add(checkedElement);
	        } else {
	            elementsChecked.add(checkedElement);
	        }
	    }
	    if (!elementsToCheckByClass.isEmpty()) {
	        for (WebElement checkedByClassElement : elementsToCheckByClass) {
	            String classOfElement = checkedByClassElement.getAttribute("class");
	            List<String> classes = new ArrayList<>(Arrays.asList(classOfElement.split(" ")));
	            if (!classes.contains("select2-container-disabled")) {
	                elementsToCheckByClick.add(checkedByClassElement);
	            } else {
	                elementsChecked.add(checkedByClassElement);
	            }
	        }
	    }
	    if (!elementsToCheckBySendKeys.isEmpty()) {
	        for (WebElement checkedBySendKeysElement : elementsToCheckBySendKeys) {
	            try {
	                checkedBySendKeysElement.sendKeys("checking");
	                return false;
	            } catch (Exception e) {
	                elementsChecked.add(checkedBySendKeysElement);
	            }
	        }
	    }
	    return elementsChecked.size() == elements.length;
	}

	public static boolean isElementClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void clickElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (Exception e) {
			System.out.println("The Button is not Clickable - " + e.getMessage());
		}
		waitForSeconds(2);
	}

	public static boolean isElementDisplayed(WebElement element) {
		try {
		waitForWebElementToAppear(driver, element);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static String getTextOfWebElement(WebElement element) {
		waitForWebElementToAppear(driver, element);
		return element.getText();
	}


	public static void waitForElementToAppear(WebDriver driver,By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public static void waitForWebElementToAppear(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToDisappear(WebDriver driver,WebElement ele) throws InterruptedException
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOf(ele));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void selectOptionByText(WebElement dropdownElement, String visibleText) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(visibleText);
	}

	public static void moveCursorToWebElement(WebElement element, int timeOutInSeconds){
		awaitForElementPresence(element, timeOutInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		waitForSeconds(2);
	}

	public String getNotificationText() {
		WebElement loaderElement = driver.findElement(By.xpath(constant.loader));
		WebElement notificationElement = driver.findElement(By.xpath(constant.notificationIcon));
		try {
			waitForElementToDisappear(driver, loaderElement);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notificationElement.getText();

	}


	public List<String> getTextOfWebElements(List<WebElement> elements) {
		List<String> textOfAllWebElemets = new ArrayList<>();
		elements.stream()
		.forEach(element -> textOfAllWebElemets.add(element.getText()));
		return textOfAllWebElemets;
	}

	public static String convertColorToHex(String cssValue,WebElement element) {
		waitForSeconds(1);
		String Css=element.getCssValue(cssValue);
		Color color = Color.fromString(Css);
		return color.asHex().toUpperCase();	
	}
	public static String getColorOfWebElement(String cssValue,WebElement element) {
		waitForSeconds(1);
		String Css=element.getCssValue(cssValue);
		Color color = Color.fromString(Css);
		return color.asHex().toUpperCase();	
	}

	public String convertColorToHex(String cssValue) {
		Color color = Color.fromString(cssValue);
		return color.asHex().toUpperCase();	
	}

	public void verifyTheLinksOfThePage(List<WebElement> links) {
		// TODO Auto-generated method stub

	}
	public void awaitForWebElementListLoad(List<WebElement> elementList, int timeOutInSeconds){
		for(int k = 0; k < timeOutInSeconds; k++){
			if(!(elementList.size() > 0)){
				waitForSeconds(1);
			}else {
				break;
			}
		}
	}

	public List<String> getListElementAttributeValue(List<WebElement> elements, String attributeValue){
		List<String> listElementText = new ArrayList<>();
		elements.stream().forEach(element -> listElementText.add(element.getAttribute(attributeValue)));
		return listElementText;
	}


	public static void clickOnWebElements(List<WebElement> elements) {
		elements.stream().forEach(element -> element.click());
	}


	public static boolean awaitForElementPresence( WebElement element, int timeOutInSeconds){
		try {
			waitForElementVisibility(driver, element, timeOutInSeconds);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	public static WebElement waitForElementVisibility(WebDriver driver, WebElement element, int timeOutInSeconds){
		return (new WebDriverWait(driver , Duration.ofSeconds(timeOutInSeconds))).until(
				ExpectedConditions.visibilityOf(element));
	}

	public static void waitForSeconds(int second){
		try{
			Thread.sleep(second * 1000L);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void scrollToWebElement(WebDriver driver, WebElement element) {
		waitForSeconds(5);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView();", element);
		waitForSeconds(5);
	}



	public String getTextOfWebElement(WebDriver driver,WebElement element) {
		awaitForElementPresence(element, 5);
		return element.getText();
	}

	public static void verifyBackGroundColorOfTheElement(WebElement ele, String expectedColor) {
		String actualColor = convertColorToHex("background-color",ele);

		if (actualColor.equalsIgnoreCase(expectedColor)) {
			System.out.println(ele.getText() +" Color is Proper");
			Assert.assertTrue(true, actualColor);
		}else {
			System.out.println(ele.getText() +" Color is Not  Proper");
			try {
				Logger.error(ele.getText() +" Actual Color: " + actualColor +" Expected Color: " + expectedColor);
				System.out.println(ele.getText().concat(getCurrentTimeInString()));
				String path = System.getProperty("user.dir")+ "\\ScreenShots\\" + ele.getText().concat(getCurrentTimeInString()) + ".png";
				takeScreenShot(ele, path);
				Logger.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void verifyColorOfTheElement(WebElement ele, String expectedColor) {
		String actualColor = convertColorToHex("color",ele);

		if (actualColor.equalsIgnoreCase(expectedColor)) {
			System.out.println(ele.getText() +" Color is Proper");
			Assert.assertTrue(true, actualColor);
		}else {
			System.out.println(ele.getText() +" Color is Not  Proper");
			try {
				Logger.error(ele.getText() +" Actual Color: " + actualColor +" Expected Color: " + expectedColor);
				System.out.println(ele.getText().concat(getCurrentTimeInString()));
				String path = System.getProperty("user.dir")+ "\\ScreenShots\\" + ele.getText().concat(getCurrentTimeInString()) + ".png";
				takeScreenShot(ele, path);
				Logger.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static boolean verifyTextOfthWebEement(WebElement ele, String expectedText) {
		waitForSeconds(1);
		moveCursorToWebElement(ele, 30);
		String actualText = getTextOfWebElement(ele);

		if (actualText.equals(expectedText)) {
			System.out.println(ele.getText() +" Text is proper");
			Assert.assertTrue(true, actualText);
			return true;
		}else {
			System.out.println(ele.getText() +" Text is Not  Proper");
			try {
				Logger.fail(" Actual Result: " + actualText +" Expected Result: " + expectedText);
				String path = System.getProperty("user.dir")+ "\\ScreenShots\\" + ele.getText().concat(getCurrentTimeInString()) + ".png";
				takeScreenShot(ele, path);
				Logger.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}


	public void assertNumericDataFromExcel(String actualCount,String cellData,String countOf) {
		AbstractComponents abstracC = new AbstractComponents();
		double count = Double.valueOf(actualCount);
		int actualVerificationCount  = (int)count;
		double 	expectVerificationCount = Double.valueOf(cellData);
		int expectedVerificationCount  = (int)expectVerificationCount;
		if (actualVerificationCount == expectedVerificationCount) {
			System.out.println(countOf + " Count is correct");
		}else {
			Assert.assertEquals(actualVerificationCount, expectedVerificationCount, countOf + " Count is not correct");
		}
	}

	public void writeDataInExcel(String sheetName, String colName, int rowNum, String data){
		testDataXL.setCellData(sheetName, colName,rowNum, data);
	}

	public static void takeElementScreenShot(WebDriver driver,WebElement element,String filePath) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		Point p = element.getLocation();
		int x = p.getX();
		int y = p.getY();

		try {
			BufferedImage fullImg = ImageIO.read(screenshot);
			BufferedImage eleScreenShot = fullImg.getSubimage(x, y, width, height);
			ImageIO.write(eleScreenShot, "png", screenshot);
			File screenShotLocation = new File(filePath);
			FileHandler.copy(screenshot, screenShotLocation);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void takeScreenShot(WebElement element,String filePath) {
		File screenshot = element.getScreenshotAs(OutputType.FILE);

		// Define the destination path
		File destination = new File(filePath);

		// Copy the screenshot to the destination path
		try {
			FileHandler.copy(screenshot, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Screenshot saved successfully.");
	}

	public static String getCurrentTimeInString() {
		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();
		// Define a formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		// Format the current date and time
		String formattedDateTime = now.format(formatter);
		return formattedDateTime;
	}

	public static String getCurrentTime() {
		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();
		// Define a formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm-ss");
		// Format the current date and time
		String formattedDateTime = now.format(formatter);
		return formattedDateTime;
	}

	public  List<String> getFirstRowDetails(WebElement ele) {
		awaitForElementPresence(ele, 20);
		String[] text= ele.getText().toLowerCase().split("\n");
		List<String> firstRowDetails= Arrays.asList(text);
		return firstRowDetails;
	}

	public void enterData(WebElement element, Keys enter) {
		try { 
			element.sendKeys(enter);
		} catch (Exception e) {
			System.out.println("Error occured while inputing Keys int the field " + e.getMessage());
		}	
	}

	public void uploadFile(String path) {
		WebElement ele = driver.findElement(By.xpath(constant.uploadXpath));
		ele.sendKeys(path);
	}

	public static String convertToRunningText(String sentence) {
		// Remove special characters (e.g., punctuation) and replace multiple spaces with a single space
		String runningText = sentence.replaceAll("[^a-zA-Z0-9 ]", "").replaceAll("\\s+", " ").trim();
		return runningText;
	}

	public static String capitalizeFirstLetter(String sentence) {
		if (sentence == null || sentence.isEmpty()) {
			return sentence;
		}

		// Convert the first character to uppercase and concatenate with the rest of the sentence
		return sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
	}
	
	  public static double roundToOneDecimalPlace(double value) {
	        // Multiply by 10, round, then divide by 10
	        return Math.round(value * 10) / 10.0;
	    }
	  public static double roundToTwoDecimalPlace(double value) {
	        // Multiply by 10, round, then divide by 10
	        return Math.round(value * 100) / 100.0;
	    }
	  public boolean compareToList(List<String> list1,List<String> list2) {
		  Set<String> set2 = new HashSet<>(list2);

	        for (String item : list1) {
	            if (!set2.contains(item)) {
	                return false;
	            }
	        }
	        return true;
	}
}
