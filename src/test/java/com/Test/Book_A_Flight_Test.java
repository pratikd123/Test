package com.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Bases.TestBase;
import com.PAGES.Book_A_Flight_page;
import com.PAGES.FlightConfirmationPage;
import com.PAGES.FlightFinder;
import com.PAGES.SelectFlight;
import com.PAGES.Sign_in_page;
import com.UTIL.TestUtil;

public class Book_A_Flight_Test extends TestBase {
	
	Sign_in_page sp;
	FlightFinder fp;
	TestUtil tu;
	SelectFlight sf;
	Book_A_Flight_page Book;
	FlightConfirmationPage fc;
	
	String sheetName = "FlightFinder";
	//String sheetName_1 = "Book_A_Flight";
	
	public Book_A_Flight_Test() {
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setup() {
		initialization();//call the method of testbase to open brower and url
		sp = new Sign_in_page();
		fp = sp.Signin(prop.getProperty("username"), prop.getProperty("password"));
		fp=new FlightFinder();
		tu=new com.UTIL.TestUtil();
		sf=new SelectFlight();
		Book=new Book_A_Flight_page();
		fc=new FlightConfirmationPage();
		}
	
	@DataProvider
	public Object[][] getnewtoursData(){
		Object data[][] = com.UTIL.TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1,dataProvider="getnewtoursData")
	public void Verify_Book_A_Flight(String DepartingFrom, String DepartingFrom_On_month,String ArrivingIn,String Returning_month,
			String Airline
			){
		fp.Flight_Details_Entry(DepartingFrom, DepartingFrom_On_month,ArrivingIn,Returning_month,Airline);
		String verify_Depart_Return_Details = sf.Verify_Depart_Return_Details();
		System.out.println(verify_Depart_Return_Details);
		Boolean verify_Book_a_Flightpage = Book.Verify_Book_a_Flightpage();
		Assert.assertTrue(verify_Book_a_Flightpage, "Book_A_Flight page is not Displayed");
	}
	
	
	@Test(priority=2,dataProvider="getnewtoursData")
	public void Book_A_Flight_Details(String DepartingFrom, String DepartingFrom_On_month,String ArrivingIn,String Returning_month,
			String Airline
			){
		fp.Flight_Details_Entry(DepartingFrom, DepartingFrom_On_month,ArrivingIn,Returning_month,Airline);
		 sf.Verify_Depart_Return_Details();
		 String flight_Details = Book.Flight_Details();
		 System.out.println("Flight Details are:"+flight_Details);
		 Assert.assertEquals(flight_Details, "Acapulco to Frankfurt 2/2/2018 Blue Skies Airlines 360 270 Frankfurt to Acapulco 3/4/2018 3/4/2018 270 1 $44 $584", "Values are not matched");
		 }
	
	
	
	
	@Test(priority=3,dataProvider="getnewtoursData")
	public void Book_A_Flight_Details_1(String DepartingFrom, String DepartingFrom_On_month,String ArrivingIn,String Returning_month,
			String Airline
			){
		fp.Flight_Details_Entry(DepartingFrom, DepartingFrom_On_month,ArrivingIn,Returning_month,Airline);
		 sf.Verify_Depart_Return_Details();
		 String flight_Details = Book.Flight_Details();
		 System.out.println("flight Details:"+flight_Details);
		 fc = Book.Passenger_Details("PRATIK", "DESAI", "8904258387");
		 }
	
	
	
	@AfterMethod 
	public void tearDown(){
		driver.close();
	}

}
