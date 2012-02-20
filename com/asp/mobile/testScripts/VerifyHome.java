package com.asp.mobile.testScripts;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.asp.iphone.nativeapp.testbase.HomeTestBase;
import com.asp.mobile.testabstract.home.AbstractHome;
import com.google.iphone.testing.nativedriver.client.IosNativeDriver;

public class VerifyHome {

	static WebDriver driver;
	static AbstractHome runner;
	
	@BeforeClass
	public static void initiate(){
	driver = new IosNativeDriver("http://172.24.120.54:3001/hub");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)	;
	runner = new HomeTestBase((IosNativeDriver)driver);
	}
	
	@Test
	public void verifyLinks(){
		runner.verifyAllLinks();
	}
	
	@Test
	public void verifYAllLinkNavigation(){
		runner.verifyAllLinkNavigation();
	}
}
