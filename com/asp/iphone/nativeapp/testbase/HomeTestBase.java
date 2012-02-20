package com.asp.iphone.nativeapp.testbase;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;

import com.asp.iphone.nativeapp.pagefactory.FeedBackPage;
import com.asp.iphone.nativeapp.pagefactory.HomePage;
import com.asp.mobile.testabstract.home.AbstractFeedBack;
import com.asp.mobile.testabstract.home.AbstractHome;
import com.google.iphone.testing.nativedriver.client.IosNativeDriver;

public class HomeTestBase implements AbstractHome {

	IosNativeDriver driver;// = new IosNativeDriver("http://172.24.120.191:3001/hub");
	HomePage objHomePage ;
	
	
	
	public HomeTestBase(IosNativeDriver driver) {
		this.driver =driver;
		objHomePage = new HomePage(this.driver);
		
    
	}
	@Override
	public boolean verifyAllLinks() {
	    try {
			Assert.assertTrue("Jokes Link is not present",objHomePage.verifyLinks("jokes"));
			System.out.println("Jokes Link Verified");
		    Thread.sleep(500);	
			Assert.assertTrue("Movie Review Link is not present",objHomePage.verifyLinks("Movie Reviews"));
			System.out.println("Moview Review Link Verified");
			Thread.sleep(500);
			Assert.assertTrue("Bollywood news Link is not present",objHomePage.verifyLinks("Bollywood News"));
			System.out.println("Bollywood Newa Link Verified");
			Thread.sleep(500);
			Assert.assertTrue("Event Gallery Link is not present",objHomePage.verifyLinks("Event Gallery"));
			System.out.println("Event Gallery Link Verified");
			Thread.sleep(500);
			Assert.assertTrue("SMS Link is not present",objHomePage.verifyLinks("SMS"));
			System.out.println("SMS Link Verified");
			Thread.sleep(500);
			Assert.assertTrue("Wall Papers Link is not present",objHomePage.verifyLinks("WallPapers"));
			System.out.println("Wall Papers Link Verified");
			Thread.sleep(500);
	    	objHomePage.verifyAllLinks();
		} catch (InterruptedException e) {
			
		}
		return false;
	}

	@Override
	public boolean verifyAllLinkNavigation() {
	    try {
			objHomePage.verifyBollyWoodLinkNavigation();
			System.out.println("Navigation to Bollywood Link Verified");
			objHomePage.verifyEventGalleryLinkNavigation();
			System.out.println("Navigation to EventGallery Link Verified");
			objHomePage.verifyJokesLinkNavigation();
			System.out.println("Navigation to Jokes Link Verified");
			objHomePage.verifyMovieReviewLinkNavigation();
			System.out.println("Navigation to Review Link Verified");
			objHomePage.verifySMSLinkNavigation();
			System.out.println("Navigation to SMS Link Verified");
			objHomePage.verifyWallPaperLinkNavigation();
			System.out.println("Navigation to WallPaper Link Verified");
		} catch (InterruptedException e) {
			
		}
		return false;
	}

}
