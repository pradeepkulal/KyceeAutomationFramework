package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;

public class WalletPageObjects extends BaseClass{
	
	public WebElement getElementTourTitle() {
		return driver.findElement(By.xpath(constant.walletTourTitle));
	} 
	
	public WebElement getElementTourSkipBtn() {
		return driver.findElement(By.xpath(constant.Logout));
	} 
	
	public WebElement getElementTourNextBtn() {
		return driver.findElement(By.xpath(constant.tourNextBtn));
	} 
	
	public WebElement getElementTourPreviousBtn() {
		return driver.findElement(By.xpath(constant.tourPreviousBtn));
	} 
	
	public WebElement getElementTourDoneBtn() {
		return driver.findElement(By.xpath(constant.tourDoneBtn));
	} 
	
	public WebElement getElementNoDataText() {
		return driver.findElement(By.xpath(constant.noDataText));
	} 
	
	public WebElement getElementOnlineOrdersTab() {
		return driver.findElement(By.xpath(constant.onlineOrders));
	} 
	
	public WebElement getElementOfflineOrdersTab() {
		return driver.findElement(By.xpath(constant.offlineOrdersTab));
	}
	
	public WebElement getElementTransactionsTab() {
		return driver.findElement(By.xpath(constant.transactionsTab));
	}
	
	public WebElement getElementAddCreditsButton() {
		return driver.findElement(By.xpath(constant.addCreditsBtn));
	}
	
	public WebElement getElementAddCreditsHeader() {
		return driver.findElement(By.xpath(constant.addCreditsHeader));
	}
	
	public WebElement getElementQuantityField() {
		return driver.findElement(By.xpath(constant.quantityField));
	}
	
	public WebElement getElementCreiditsPrice() {
		return driver.findElement(By.xpath(constant.creiditsPrice));
	}
	
	public WebElement getElementCreiditsAmount() {
		return driver.findElement(By.xpath(constant.creiditsAmount));
	}
	
	public WebElement getElementSubTotal() {
		return driver.findElement(By.cssSelector(constant.subTotal));
	}
	
	public WebElement getElementGST() {
		return driver.findElement(By.cssSelector(constant.gst));
	}
	
	public WebElement getElementCheckoutViaUPIBtn() {
		return driver.findElement(By.xpath(constant.checkoutViaUPIBtn));
	}
	
	public WebElement getElementTotalAmount() {
		return driver.findElement(By.cssSelector(constant.totalAmount));
	}
	
	public WebElement getElementQRCode() {
		return driver.findElement(By.xpath(constant.QRCode));
	}
	
	public WebElement getElementUTRNumberField() {
		return driver.findElement(By.xpath(constant.UTRNumberField));
	}
	
	public WebElement getElementSubmitBtn() {
		return driver.findElement(By.xpath(constant.formSubmitBtn));
	}
	public WebElement getElementPaymentHeader() {
		return driver.findElement(By.xpath(constant.paymentHeader));
	}
	
	public WebElement getElementValidationMessage() {
		return driver.findElement(By.xpath(constant.validationMessage));
	}
	
	public WebElement getElementNotificationMessage() {
		return driver.findElement(By.xpath(constant.ToastMsg));
	}
	
	public WebElement getElemenOfFirstRow() {
		return driver.findElement(By.xpath(constant.firstRowInList));
	}
	
	
}
