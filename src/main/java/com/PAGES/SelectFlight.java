package com.PAGES;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Bases.TestBase;

public class SelectFlight extends TestBase {
	
	@FindBy(xpath ="//img[@src='/images/masts/mast_selectflight.gif']")
	WebElement Select_Flight_img;
	
	
	@FindBy(xpath ="//table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/b/font")
	WebElement Depart_Name;
	
	@FindBy(xpath ="//table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/b/font")
	WebElement Depart_Date;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[2]/font/b")
	WebElement Depart_Flight_name;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/form/table[1]/tbody/tr[4]/td/font/font")
	WebElement Depart_Flight_price;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[3]/font")
	WebElement Depart_Time;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[4]/font")
	WebElement Depart_Stops;
	
	@FindBy(xpath ="//table[2]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/b/font")
	WebElement Return_Name;
	
	@FindBy(xpath ="//table[2]/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/b/font")
	WebElement Return_Date;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/form/table[2]/tbody/tr[3]/td[2]/font/b")
	WebElement Return_Flight_name;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/form/table[2]/tbody/tr[4]/td/font/font")
	WebElement Return_Flight_price;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/form/table[2]/tbody/tr[3]/td[3]/font")
	WebElement Return_Time;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/form/table[2]/tbody/tr[3]/td[4]/font")
	WebElement Return_Stops;
	
	@FindBy(xpath ="//table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input")
	WebElement Continue;
	
	
	public SelectFlight() {
		PageFactory.initElements(driver, this);
	}

	public Boolean verifySelectFlightPage(){
		return Select_Flight_img.isDisplayed();
	}
	
	public String Verify_Depart_Return_Details(){
	    String Depart_Name_1 = Depart_Name.getText();
	    String Depart_Date_1 = Depart_Date.getText();
	    String Depart_Flight_name_1 = Depart_Flight_name.getText();
	    String Depart_Flight_price_1 = Depart_Flight_price.getText();
	    String Depart_Time_1 = Depart_Time.getText();
	    String Depart_Stops_1 = Depart_Stops.getText();
	    String Return_Name_1 = Return_Name.getText();
	    String Return_Date_1 = Return_Date.getText();
	    String Return_Flight_name_1 = Return_Flight_name.getText();
	    String Return_Flight_price_1 = Return_Flight_price.getText();
	    String Return_Time_1 = Return_Time.getText();
	    String Return_Stops_1 = Return_Stops.getText();
		
		Continue.click();
		return Depart_Name_1+" "+Depart_Date_1+" "+Depart_Flight_name_1+" "+Depart_Flight_price_1+" "+Depart_Time_1+" "+Depart_Stops_1+" "+Return_Name_1+" "+Return_Date_1+" "+Return_Flight_name_1+" "+Return_Flight_price_1+" "+Return_Time_1+" "+Return_Stops_1;
		
	}
	}
