package com.asp.mobile.testabstract.home;

public interface AbstractFeedBack {
	
	public  boolean clickAndNavigateToFeedBackPage();
	
	public  boolean enterDetails();
	
	public  boolean clickCanceButton();
	
	public  boolean clickSendButton();
	
	public  boolean verifyAlert(String message);
	
	public  boolean verifyButton(String arg);
}
