package com.PAGES;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Bases.TestBase;

public class FlightFinder extends TestBase
{
	
	SelectFlight sp;
	
	@FindBy(xpath ="(//input[@name='tripType'])[1]")
	WebElement Type_radio_1;
	
	@FindBy(xpath ="(//input[@name='tripType'])[2]")
	WebElement Type_radio_2;
	
	@FindBy(xpath ="//select[@name='passCount']")
	WebElement Passengers;
	
	@FindBy(xpath ="//select[@name='fromPort']")
	WebElement Departing_From_month;
	
	@FindBy(xpath ="//select[@name='fromMonth']")
	WebElement Departing_on_month;
	
	@FindBy(xpath ="//select[@name='fromDay']")
	WebElement Departing_on_Day;
	

	@FindBy(xpath ="//select[@name='toPort']")
	WebElement Arriving_In;
	

	@FindBy(xpath ="//select[@name='toMonth']")
	WebElement Return_to_month;
	
	@FindBy(xpath ="//select[@name='toDay']")
	WebElement Return_to_day;
	
	@FindBy(xpath ="(//input[@type='radio'])[3]")
	WebElement Service_Class;
	
	@FindBy(xpath = "//select[@name='airline']")
	WebElement Airline;
	
	@FindBy(xpath ="//input[@name='findFlights']")
	WebElement Continue_button;
	
	
	
 public FlightFinder() {
	PageFactory.initElements(driver, this);
	}


 public String VerifyFlightFinderdisplay(){
	return driver.getTitle();
}

 
  public SelectFlight Flight_Details_Entry(String Departing_From, String On_month,String Arriving_In_1 , String Returning_month,String Airline_1 ){
	 //Type_radio_1.click();
	 
	 Select s=new Select(Passengers);
	 s.selectByVisibleText("1");
	 
	 Select s1=new Select(Departing_From_month);
	 s1.selectByVisibleText(Departing_From);
	 
	 Select s2=new Select(Departing_on_month);
	 s2.selectByVisibleText(On_month);
	 
	 Select s3=new Select(Departing_on_Day);
	 s3.selectByVisibleText("2");
	 
	 Select s4=new Select(Arriving_In);
	 s4.selectByVisibleText(Arriving_In_1);
	 
	 Select s5=new Select(Return_to_month);
	 s5.selectByVisibleText(Returning_month);
	 
	 Select s6=new Select(Return_to_day);
	 s6.selectByVisibleText("4");
	 
	 Service_Class.click();
	 
	 Select s8=new Select(Airline);
	 s8.selectByVisibleText(Airline_1);
	 
	 Continue_button.click();
	return sp;
	 
	 
	}

}
