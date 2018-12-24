package com.Test;

import org.testng.Assert;
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

public class FlightConfirmationPageTest extends TestBase {
	
	Sign_in_page sp;
	FlightFinder fp;
	TestUtil tu;
	SelectFlight sf;
	Book_A_Flight_page Book;
	FlightConfirmationPage fc;
	
	String sheetName = "FlightFinder";
	//String sheetName_1 = "Book_A_Flight";
	
	public FlightConfirmationPageTest() {
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
	public void FlightConfirmationpage_verify(String DepartingFrom, String DepartingFrom_On_month,String ArrivingIn,String Returning_month,
			String Airline
			){
		fp.Flight_Details_Entry(DepartingFrom, DepartingFrom_On_month,ArrivingIn,Returning_month,Airline);
		 sf.Verify_Depart_Return_Details();
		 String flight_Details = Book.Flight_Details();
		 System.out.println("flight Details:"+flight_Details);
		 fc = Book.Passenger_Details("PRATIK", "DESAI", "8904258387");
		 Boolean verifyFlightconfirmationpage = fc.verifyFlightconfirmationpage();
		 Assert.assertTrue(verifyFlightconfirmationpage, "The Flight confirmation page is Displayed");
		 }
	
	
	@Test(priority=2,dataProvider="getnewtoursData")
	public void FlightConfirmationpage_verify_1(String DepartingFrom, String DepartingFrom_On_month,String ArrivingIn,String Returning_month,
			String Airline
			){
		fp.Flight_Details_Entry(DepartingFrom, DepartingFrom_On_month,ArrivingIn,Returning_month,Airline);
		 sf.Verify_Depart_Return_Details();
		 String flight_Details = Book.Flight_Details();
		 System.out.println("flight Details:"+flight_Details);
		 fc = Book.Passenger_Details("PRATIK", "DESAI", "8904258387");
		  Assert.assertTrue(fc.verifyFlightconfirmationpage());
		  String fetchFightConfirmationDetails = fc.FetchFightConfirmationDetails();
		  System.out.println("Flight confirmation Details:"+fetchFightConfirmationDetails);
	}
	
	@Test(priority=3,dataProvider="getnewtoursData")
	public void FlightConfirmationpage_verify_2(String DepartingFrom, String DepartingFrom_On_month,String ArrivingIn,String Returning_month,
			String Airline
			){
		fp.Flight_Details_Entry(DepartingFrom, DepartingFrom_On_month,ArrivingIn,Returning_month,Airline);
		 sf.Verify_Depart_Return_Details();
		 String flight_Details = Book.Flight_Details();
		 System.out.println("flight Details:"+flight_Details);
		 fc = Book.Passenger_Details("PRATIK", "DESAI", "8904258387");
		 sp = fc.HomepageVerify();
		Assert.assertTrue(sp.Signup_verify());
	}
	
	
	
	/*@AfterMethod 
	public void tearDown(){
		driver.close();
	}*/

}
