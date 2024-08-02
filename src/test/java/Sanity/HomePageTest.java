package Sanity;

import java.io.IOException;
import org.testng.annotations.Test;

import kycee.Base.BaseClass;
import kycee.PageEvent.HomePageEvent;

public class HomePageTest extends BaseClass {
	
	
	@Test
	public void HomePage() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.verifyDomainsTab();
	}
	
	@Test
	public void verifyDomainsButton() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.validateDomainsButton();
	}
	
	@Test
	public void verifyBusinessCassesTab() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.verifyBusinessCassesTab();
	}
	
	@Test
	public void verifyWhyKYCEETab() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.verifyWhyKYCEETab();
	}
	
	@Test
	public void verifyChallengesTab() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.verifyChallengesTab();
	}
	
	@Test
	public void verifyAboutUsTab() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.verifyAboutUsTab();
	}
	
	@Test
	public void verifyFooterTitles() throws IOException, InterruptedException {
		HomePageEvent HMEvent = new HomePageEvent();
		HMEvent.verifyFooterTitles();
	}

}
