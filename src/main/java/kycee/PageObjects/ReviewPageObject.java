package kycee.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import kycee.Base.BaseClass;

public class ReviewPageObject extends BaseClass{

	public WebElement getElementReviewPageHeader() {
		return driver.findElement(By.xpath(constant.ReviewPageHeader));
	}
	
	public WebElement getElementReviewTitleInput() {
		return driver.findElement(By.xpath(constant.reviewTitleInput));
	}
	
	public WebElement getElementReviewDescriptionInput() {
		return driver.findElement(By.xpath(constant.reviewDescriptionInput));
	}
	
	public WebElement getElementSubmitBtn() {
		return driver.findElement(By.xpath(constant.formSubmitBtn));
	}
	
	public WebElement getElementRatingStar1() {
		return driver.findElement(By.xpath(constant.ratingstar1));
	}
	
	public WebElement getElementRatingStar2() {
		return driver.findElement(By.xpath(constant.ratingstar2));
	}
	
	public WebElement getElementRatingStar3() {
		return driver.findElement(By.xpath(constant.ratingstar3));
	}
	
	public WebElement getElementRatingStar4() {
		return driver.findElement(By.xpath(constant.ratingstar4));
	}
	
	public WebElement getElementRatingStar5() {
		return driver.findElement(By.xpath(constant.ratingstar5));
	}
	
	public WebElement getElementLoader() {
		return driver.findElement(By.xpath(constant.loader));
	}
	
	public WebElement getElementValidationMessage() {
		return driver.findElement(By.xpath(constant.validationMessage));
	}
	
	public WebElement getElementNotificationMsg() {
		try {
			return driver.findElement(By.xpath(constant.ToastMsg));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				return driver.findElement(By.xpath(constant.ToastMsg));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	return driver.findElement(By.xpath(constant.ToastMsg));
	}

	public WebElement getElementReviewTitle() {
		return driver.findElement(By.xpath(constant.reviewTitle));
	} 
	
	public WebElement getElementReviewDescription() {
		return driver.findElement(By.xpath(constant.reviewDescription));
	} 
	
	public WebElement getElementReviewRating1() {
		return driver.findElement(By.xpath(constant.reviewRating1));
	} 
	
	public WebElement getElementReviewRating2() {
		return driver.findElement(By.xpath(constant.reviewRating2));
	} 
	
	public WebElement getElementReviewRating3() {
		return driver.findElement(By.xpath(constant.reviewRating3));
	} 
	
	public WebElement getElementReviewRating4() {
		return driver.findElement(By.xpath(constant.reviewRating4));
	} 
	
	public WebElement getElementReviewRating5() {
		return driver.findElement(By.xpath(constant.reviewRating5));
	} 
	
	
	
	public WebElement getElementEditReviewIcon() {
		return driver.findElement(By.xpath(constant.editReviewIcon));
	}
	
	public WebElement getElementCancelButton() {
		return driver.findElement(By.xpath(constant.reviewUpdateCancelButton));
	}
	
	public WebElement getElementBackIcon() {
		return driver.findElement(By.xpath(constant.editReviewBackIcon));
	}

	public WebElement getElementEditReviewPageHeader() {
		return driver.findElement(By.xpath(constant.editReviewPageHeader));	}
}
