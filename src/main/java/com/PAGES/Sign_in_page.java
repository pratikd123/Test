package com.PAGES;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Bases.TestBase;

public class Sign_in_page extends TestBase{

	
	//Page Factory - OR:
		@FindBy(xpath="//img[@src='/images/hdr_findflight.gif']")
		WebElement Signup_Verify;
		
		@FindBy(xpath="//input[@name='userName']")
		WebElement username;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement password;
		
		@FindBy(xpath="//input[@name='login']")
		WebElement Login_bt;
		
		
		
		
		
		//Initializing the Page Objects:
		public Sign_in_page(){
			PageFactory.initElements(driver, this);
		}
		
		public boolean Signup_verify(){
			return Signup_Verify.isDisplayed();
			}
		
		public FlightFinder Signin(String un,String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			Login_bt.click();
			return new FlightFinder();
			}
		
}
