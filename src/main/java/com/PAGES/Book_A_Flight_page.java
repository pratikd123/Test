package com.PAGES;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Bases.TestBase;

public class Book_A_Flight_page extends TestBase{
	
	FlightConfirmationPage fc;
	
	@FindBy(xpath ="//table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")
	WebElement Book_a_Flight_verify;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[1]/td[1]/b/font")
	WebElement Depart_name;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/b/font")
	WebElement Depart_date;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/font/b")
	WebElement Depart_Flight;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]/font")
	WebElement Depart_Price;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]/b/font")
	WebElement Return_name;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/b/font")
	WebElement Return_date;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/b/font")
	WebElement Return_Flight;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[6]/td[3]/font")
	WebElement Return_Price;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/font")
	WebElement Passengers;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/font")
	WebElement Taxes;
	
	@FindBy(xpath ="//table/tbody/tr[2]/td/table/tbody/tr[9]/td[2]/font/b")
	WebElement  Total_Price;
	
	@FindBy(xpath ="//table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/input")
	WebElement  Passenger_Firstname;
	
	@FindBy(xpath ="//table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")
	WebElement  Passenger_Lastname;
	
	@FindBy(xpath ="//table/tbody/tr[6]/td/table/tbody/tr[2]/td[2]/input")
	WebElement  Passenger_phone_number;
	
	@FindBy(xpath ="//table/tbody/tr[5]/td/form/table/tbody/tr[23]/td/input")
	WebElement  Secure_purchase;
	
	
	
	
	public Book_A_Flight_page() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean Verify_Book_a_Flightpage(){
		return Book_a_Flight_verify.isDisplayed();
	}
	
	
	public String Flight_Details(){
		String Depart_name_1 = Depart_name.getText();
		String Depart_date_1 = Depart_date.getText();
		String Depart_Flight_1 =Depart_Flight.getText();
		String Depart_Price_1 =Depart_Price.getText();
		String Return_name_1 =Return_name.getText();
		String Return_date_1 =Return_date.getText();
		String Return_Flight_1 =Return_Flight.getText();
		String Return_Pricee_1 =Return_Price.getText();
		String Passengers_1 =Passengers.getText();
		String Taxes_1 =Taxes.getText();
		String Total_Price_1 =Total_Price.getText();
		
		return Depart_name_1+" "+Depart_date_1+" "+Depart_Flight_1+" "+Depart_Price_1+" "+Return_name_1+" "+Return_date_1+" "+Return_Flight_1+" "+Return_Pricee_1+" "+Passengers_1+" "
		+Taxes_1+" "+Total_Price_1;
		}
	
	
	
	public FlightConfirmationPage Passenger_Details(String Passenger_Firstname_2,String Passenger_Lastname_2,String Passenger_phone_number_2){
		Passenger_Firstname.sendKeys(Passenger_Firstname_2);
		Passenger_Lastname.sendKeys(Passenger_Lastname_2);
		Passenger_phone_number.sendKeys(Passenger_phone_number_2);
		Secure_purchase.click();
		
		
		
		return new FlightConfirmationPage();
		
		
	}


}
