package com.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Bases.TestBase;
import com.PAGES.FlightFinder;
import com.PAGES.SelectFlight;
import com.PAGES.Sign_in_page;
import com.UTIL.TestUtil;

public class SelectFlightTest extends TestBase {
	
	
	Sign_in_page sp;
	FlightFinder fp;
	TestUtil tu;
	SelectFlight sf;
	
	String sheetName = "FlightFinder";
	
	public SelectFlightTest() {
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
		}
	
	@DataProvider
	public Object[][] getnewtoursData(){
		Object data[][] = com.UTIL.TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getnewtoursData")
	public void SelectFlight_in_page_verify(String DepartingFrom, String DepartingFrom_On_month,String ArrivingIn,String Returning_month,
			String Airline){
		fp.Flight_Details_Entry(DepartingFrom, DepartingFrom_On_month,ArrivingIn,Returning_month,Airline);
		Boolean verifySelectFlightPage = sf.verifySelectFlightPage();
		Assert.assertTrue(verifySelectFlightPage, "The Select page is not Displayed");
	}
	
	@Test(priority=2, dataProvider="getnewtoursData")
	public void Verify_Depart_Return_Details(String DepartingFrom, String DepartingFrom_On_month,String ArrivingIn,String Returning_month,
			String Airline){
		fp.Flight_Details_Entry(DepartingFrom, DepartingFrom_On_month,ArrivingIn,Returning_month,Airline);
		String verify_Depart_Return_Details = sf.Verify_Depart_Return_Details();
		System.out.println(verify_Depart_Return_Details);
	}
	
	@AfterMethod 
	public void tearDown(){
		driver.close();
	}
}
