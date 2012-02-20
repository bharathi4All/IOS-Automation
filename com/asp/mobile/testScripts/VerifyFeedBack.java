package com.asp.mobile.testScripts;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.asp.iphone.nativeapp.pagefactory.HomePage;
import com.asp.iphone.nativeapp.testbase.FeedBackTestBase;
import com.asp.mobile.testabstract.home.AbstractFeedBack;
import com.google.iphone.testing.nativedriver.client.IosNativeDriver;

public class VerifyFeedBack {
	
	static WebDriver driver;
	static AbstractFeedBack runner;
	@BeforeClass
	public static void initiate(){
	driver = new IosNativeDriver("http://172.24.120.54:3001/hub");
	}
	
	//@Test
	public void verifyFeedBackCancelProcess(){
		runner = new FeedBackTestBase((IosNativeDriver)driver);
	runner.enterDetails();
	runner.clickCanceButton();
	runner.verifyAlert("Cancelled");
	}
	
	@Test
	public void verifyFeedBackSendProcess(){
    runner = new FeedBackTestBase((IosNativeDriver)driver);
	runner.enterDetails();
	runner.clickSendButton();
	runner.verifyAlert("Sent successfully");
	}

}
