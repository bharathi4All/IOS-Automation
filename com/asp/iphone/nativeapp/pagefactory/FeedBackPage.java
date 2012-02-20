package com.asp.iphone.nativeapp.pagefactory;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;

import com.google.iphone.testing.nativedriver.client.By;
import com.google.iphone.testing.nativedriver.client.IosNativeDriver;
import com.google.iphone.testing.nativedriver.client.IosNativeElement;

public class FeedBackPage {
	IosNativeDriver driver;
	public FeedBackPage(IosNativeDriver driver) {
		this.driver = driver;
		//Assert.assertTrue("Home page not loaded",verifyHomeTitle());
	}

	public boolean verifyHomeTitle(){
		return driver.getTitle().equalsIgnoreCase("Feedback");
	}

	public boolean verifyAllLinks(){
		
		Assert.assertTrue("Jokes Link is not present",driver.findElement(By.text("Jokes")).getText().equalsIgnoreCase("jokes"));
		Assert.assertTrue("Movie Review Link is not present",driver.findElement(By.text("Movie Reviews")).getText().equalsIgnoreCase("Movie Reviews"));
		Assert.assertTrue("Bollywood news Link is not present",driver.findElement(By.text("Bollywood News")).getText().equalsIgnoreCase("Bollywood News"));
		Assert.assertTrue("Event Gallery Link is not present",driver.findElement(By.text("Event Gallery")).getText().equalsIgnoreCase("Event Gallery"));
		Assert.assertTrue("SMS Link is not present",driver.findElement(By.text("SMS")).getText().equalsIgnoreCase("SMS"));
		Assert.assertTrue("Wall Papers Link is not present",driver.findElement(By.text("WallPapers")).getText().equalsIgnoreCase("WallPapers"));
		return true;
	}

	public void enterFromID(){
		try {
			List<IosNativeElement>	in =  driver.findIosNativeElements(By.className("UITextField"));
			System.out.println("S1 " + in.size());
			in.get(0).click();
			in.get(0).sendKeys("dummy@aspiresys.com");
		} catch (Exception e) {
			Assert.fail("Could Not Enter From ID");
		}

	}

	public void enterToID(){
		try {
			List<IosNativeElement>	in =  driver.findIosNativeElements(By.className("UITextField"));
			in.get(1).click();
			in.get(1).sendKeys("dummy@aspiresys.com");
			System.out.println("HERE");
		} catch (Exception e) {
			Assert.fail("Could not Enter To  Id");
		}


	}

	public void clickCanceButton(){
		try {
			((IosNativeElement)(driver.findIosNativeElements(By.text("Cancel")).toArray()[0])).click();
			((IosNativeElement)(driver.findIosNativeElements(By.text("Delete Draft")).toArray()[0])).click();
		} catch (Exception e) {
			Assert.fail("Click cancel Button process failed");
		}
	}
	
	public void clickSendButton(){
		try {
			((IosNativeElement)(driver.findIosNativeElements(By.text("Send")).toArray()[0])).click();
		} catch (Exception e) {
			Assert.fail("Send buttomn is not present");
		}
	}

	public void verifyProcess(String message){
		//((IosNativeElement)(driver.findIosNativeElements(By.text("Ok")).toArray()[0])).click();
		List<IosNativeElement> in1 =  driver.findIosNativeElements(By.className("UILabel"));
		Assert.assertTrue("Expected Message Not displyed;Test Failed" ,in1.get(1).getText().trim().equalsIgnoreCase(message));
		((IosNativeElement)(driver.findIosNativeElements(By.text("Ok")).toArray()[0])).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
		}
		in1=null;
		in1 =  driver.findIosNativeElements(By.className("UIButton"));
		System.out.println("Siii1 " + in1.size());
		in1.get(0).click();
		//in1.get(1).click();
		for(int i=0;i<8 ;i++)
		System.out.println("Siii1 " + in1.get(i).getText());
		
	}


	public boolean navigateToFeedBackPage(){
		List<IosNativeElement> in =  driver.findIosNativeElements(By.className("UIButton"));
		System.out.println("S1 " + in.size());
		in.get(1).click();
		Assert.assertTrue(driver.findElement(By.text("About Us")).getText().equalsIgnoreCase("About Us"));
		Assert.assertTrue(driver.findElement(By.text("Check Update")).getText().equalsIgnoreCase("Check Update"));
		Assert.assertTrue(driver.findElement(By.text("Feedback")).getText().equalsIgnoreCase("Feedback"));
		driver.findElement(By.text("Feedback")).click();
		return true;
	}



}
