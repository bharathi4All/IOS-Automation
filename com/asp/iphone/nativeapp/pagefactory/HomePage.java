package com.asp.iphone.nativeapp.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;

import com.google.iphone.testing.nativedriver.client.By;
import com.google.iphone.testing.nativedriver.client.IosNativeDriver;
import com.google.iphone.testing.nativedriver.client.IosNativeElement;

public class HomePage {
	IosNativeDriver driver;

	public HomePage(IosNativeDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.getTitle();
		//Assert.assertTrue("Home page not loaded",verifyHomeTitle());
	}

	public boolean verifyHomeTitle(){
		return driver.getTitle().equalsIgnoreCase("InMobi Entertainment");
	}

	public boolean verifyLinks(String linkname){
		List<IosNativeElement> in1 =  driver.findIosNativeElements(By.className("UILabel"));
		for(int i=0;i<in1.size() ;i++){
			if( in1.get(i).getText().equalsIgnoreCase(linkname)){		
				return true;
			}
		}
		return false;
	}



	public boolean verifyAllLinks() throws InterruptedException{
		/*Assert.assertTrue("Jokes Link is not present",driver.findElement(By.text("Jokes")).getText().equalsIgnoreCase("jokes"));
		System.out.println("Jokes Link Verified");
	    Thread.sleep(500);	
		Assert.assertTrue("Movie Review Link is not present",driver.findElement(By.text("Movie Reviews")).getText().equalsIgnoreCase("Movie Reviews"));
		System.out.println("Moview Review Link Verified");
		Thread.sleep(500);
		Assert.assertTrue("Bollywood news Link is not present",driver.findElement(By.text("Bollywood News")).getText().equalsIgnoreCase("Bollywood News"));
		System.out.println("Moview Review Link Verified");
		Thread.sleep(500);
		Assert.assertTrue("Event Gallery Link is not present",driver.findElement(By.text("Event Gallery")).getText().equalsIgnoreCase("Event Gallery"));
		System.out.println("Event Gallery Link Verified");
		Thread.sleep(500);
		Assert.assertTrue("SMS Link is not present",driver.findElement(By.text("SMS")).getText().equalsIgnoreCase("SMS"));
		System.out.println("SMS Link Verified");
		Thread.sleep(500);
		Assert.assertTrue("Wall Papers Link is not present",driver.findElement(By.text("WallPapers")).getText().equalsIgnoreCase("WallPapers"));
		System.out.println("Wall Papers Link Verified");
		Thread.sleep(500);*/


		List<IosNativeElement> in1 =  driver.findIosNativeElements(By.className("UILabel"));
		return true;
	}

	public void verifyJokesLinkNavigation() throws InterruptedException{
		List<IosNativeElement> in =  driver.findIosNativeElements(By.className("UIButton"));
		System.out.println("S1 " + in.size());
		in.get(5).click();
		waitForTitle("Jokes", 20);
		Assert.assertTrue("Joke Navigation Failed present",driver.getTitle().equalsIgnoreCase("Jokes"));
		navigateToHomePage();
	}

	public void verifyMovieReviewLinkNavigation() throws InterruptedException{
		List<IosNativeElement> in =  driver.findIosNativeElements(By.className("UIButton"));
		System.out.println("S1 " + in.size());
		in.get(6).click();
		waitForTitle("Movie Reviews", 20);
		Assert.assertTrue("MovieReview Navigation Failed present",driver.getTitle().equalsIgnoreCase("Movie Reviews"));
		navigateToHomePage();
	}

	public void verifyBollyWoodLinkNavigation() throws InterruptedException{
		List<IosNativeElement> in =  driver.findIosNativeElements(By.className("UIButton"));
		in.get(7).click();
		waitForTitle("Bollywood News", 20);
		Assert.assertTrue("BollyWood Link Navigation Failed present",driver.getTitle().equalsIgnoreCase("Bollywood News"));
		navigateToHomePage();
	}

	public void verifyEventGalleryLinkNavigation() throws InterruptedException{
		List<IosNativeElement> in =  driver.findIosNativeElements(By.className("UIButton"));
		in.get(2).click();
		waitForTitle("Event Gallery", 20);
		Assert.assertTrue("Eveny Gallery Navigation Failed present",driver.getTitle().equalsIgnoreCase("Event Gallery"));
		navigateToHomePage();
	}

	public void verifySMSLinkNavigation() throws InterruptedException{
		List<IosNativeElement> in =  driver.findIosNativeElements(By.className("UIButton"));
		in.get(3).click();
		waitForTitle("SMS", 20);
		Assert.assertTrue("SMS Link Navigation Failed present",driver.getTitle().equalsIgnoreCase("SMS"));
		navigateToHomePage();
	}

	public void verifyWallPaperLinkNavigation() throws InterruptedException{
		List<IosNativeElement> in =  driver.findIosNativeElements(By.className("UIButton"));
		System.out.println("S1 " + in.size());
		in.get(4).click();
		waitForTitle("Wallpaper", 20);
		Assert.assertTrue("WallPaper Link NavigationFailed;",driver.getTitle().equalsIgnoreCase("Wallpaper"));
		navigateToHomePage();
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



	public void waitForTitle(String title, int time){
		int i=0;
		while(!driver.getTitle().trim().equalsIgnoreCase(title.trim())){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			if(i==time) break;

		}
	}



	public void navigateToHomePage() {
		try {
			Thread.sleep(500);
			List<IosNativeElement> in1 =  driver.findIosNativeElements(By.className("UIButton"));
			in1.get(0).click();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
