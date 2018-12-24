package com.PAGES;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Bases.TestBase;

public class FlightConfirmationPage extends TestBase{
	
	Sign_in_page sg;
	
	@FindBy(xpath ="(//table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/img)[1]")
	WebElement Flightconfirmationpage_verify;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/table/tbody/tr[3]/td/font")
	WebElement Flightconfirmationpage_Depart_Details;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/table/tbody/tr[5]/td/font")
	WebElement Flightconfirmationpage_Return_Details;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/table/tbody/tr[7]/td/font")
	WebElement Flightconfirmationpage_Passenger_Details;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/table/tbody/tr[9]/td/p/font[1]")
	WebElement Flightconfirmationpage_Billed_to_Details;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/table/tbody/tr[11]/td/p/font[1]")
	WebElement Flightconfirmationpage_Delivery_Address;
	
	
	@FindBy(xpath ="//table/tbody/tr[1]/td[2]/font/font/font/b/font")
	WebElement Flightconfirmationpage_Total_taxes;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td[2]/font/b/font/font/b/font")
	WebElement Flightconfirmationpage_Total_price1;
	
	@FindBy(xpath ="//table/tbody/tr[7]/td/table/tbody/tr/td[2]/a/img")
	WebElement Back_to_home_button;
	
	
	
	
    public FlightConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
    
    public Boolean verifyFlightconfirmationpage(){
		return Flightconfirmationpage_verify.isDisplayed();
    	}
    
    
    public String FetchFightConfirmationDetails(){
    	//Back_to_home_button.click();
    	return Flightconfirmationpage_verify.getText()+" "+Flightconfirmationpage_Depart_Details.getText()+" "+Flightconfirmationpage_Return_Details.getText()+" "+
    			Flightconfirmationpage_Passenger_Details.getText()+" "+Flightconfirmationpage_Billed_to_Details.getText()+" "+Flightconfirmationpage_Delivery_Address.getText()+" "
    			+Flightconfirmationpage_Total_taxes.getText()
    			+" "+Flightconfirmationpage_Total_price1.getText();
    	}
    
    
    public Sign_in_page HomepageVerify(){
    	Back_to_home_button.click();
		return new Sign_in_page();
    	}
    
    
    
	}
