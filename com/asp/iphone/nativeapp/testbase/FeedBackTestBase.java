/*
Copyright 2011 NativeDriver committers
Copyright 2011 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.asp.iphone.nativeapp.testbase;

import junit.framework.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;

import com.asp.iphone.nativeapp.pagefactory.FeedBackPage;
import com.asp.iphone.nativeapp.pagefactory.HomePage;
import com.asp.mobile.testabstract.home.AbstractFeedBack;
import com.google.iphone.testing.nativedriver.client.IosNativeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Sample test for iOS NativeDriver.
 * 
 * @author Tomohiro Kaizu
 */
public class FeedBackTestBase  implements AbstractFeedBack{
	IosNativeDriver driver;// = new IosNativeDriver("http://172.24.120.191:3001/hub");
	FeedBackPage objFeedBackPage ;
	
	public FeedBackTestBase(IosNativeDriver driver) {
		this.driver =driver;
		new HomePage(this.driver).navigateToFeedBackPage();
		objFeedBackPage = new FeedBackPage(driver);
    
	}
	public void testNativeDriver() throws Exception {
		IosNativeDriver driver = new IosNativeDriver("http://172.24.120.191:3001/hub");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}



	@Override
	public boolean clickAndNavigateToFeedBackPage() {
        return objFeedBackPage.navigateToFeedBackPage();
	}

	@Override
	public boolean enterDetails() {
		objFeedBackPage.enterFromID();
		objFeedBackPage.enterToID();
		return false;
	}

	@Override
	public boolean clickCanceButton() {
		objFeedBackPage.clickCanceButton();
		return false;
	}

	@Override
	public boolean verifyAlert(String message) {
		objFeedBackPage.verifyProcess(message);
		return false;
	}
	@Override
	public boolean clickSendButton() {
		objFeedBackPage.clickSendButton();
		return false;
	}
	@Override
	public boolean verifyButton(String arg) {
		// TODO Auto-generated method stub
		return false;
	}
}
