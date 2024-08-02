package kycee.Utills;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;

public class FetchElement {

	public WebElement getWebElement(String identifierType, String identifierValue) {

		switch(identifierType) {

		case "ID" :
			return BaseClass.driver.findElement(By.id(identifierValue));

		case "CLASSNAME" :
			return BaseClass.driver.findElement(By.className(identifierValue));

		case "XPATH" :
			return BaseClass.driver.findElement(By.xpath(identifierValue));

		case "CSSSELECTOR" :
			return BaseClass.driver.findElement(By.cssSelector(identifierValue));

		case "TAGNAME" :
			return BaseClass.driver.findElement(By.tagName(identifierValue));

		case "PARTIALLINKTEXT" :
			return BaseClass.driver.findElement(By.partialLinkText(identifierValue));

		case "LINKTEXT" :
			return BaseClass.driver.findElement(By.linkText(identifierValue));

		case "NAME" :
			return BaseClass.driver.findElement(By.name(identifierValue));

		default:
			return null;
		}
	}

	public List<WebElement> getWebElements(String identifierType, String identifierValue){

		switch(identifierType) {
		case "ID" :
			return BaseClass.driver.findElements(By.id(identifierValue));

		case "CLASSNAME" :
			return BaseClass.driver.findElements(By.className(identifierValue));

		case "XPATH" :
			return BaseClass.driver.findElements(By.xpath(identifierValue));

		case "CSSSELECTOR" :
			return BaseClass.driver.findElements(By.cssSelector(identifierValue));

		case "TAGNAME" :
			return BaseClass.driver.findElements(By.tagName(identifierValue));

		case "PARTIALLINKTEXT" :
			return BaseClass.driver.findElements(By.partialLinkText(identifierValue));

		case "LINKTEXT" :
			return BaseClass.driver.findElements(By.linkText(identifierValue));

		case "NAME" :
			return BaseClass.driver.findElements(By.name(identifierValue));

		default:
			return null;
		}
	}
}
