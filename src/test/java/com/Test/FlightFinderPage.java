package com.Test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Bases.TestBase;
import com.PAGES.FlightFinder;
import com.PAGES.SelectFlight;
import com.PAGES.Sign_in_page;
import com.UTIL.TestUtil;


public class FlightFinderPage extends TestBase {
	
	Sign_in_page sp;
	FlightFinder fp;
	TestUtil tu;
	SelectFlight sf;
	
	String sheetName = "FlightFinder";
	
	Logger log = Logger.getLogger(FlightFinderPage.class);
	
	public FlightFinderPage() {
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
	
	

	
	@Test(priority=1)
	public void FlightFinder_in_page_verify(){
		String verifyFlightFinderdisplay = fp.VerifyFlightFinderdisplay();
		Assert.assertEquals(verifyFlightFinderdisplay, "Find a Flight: Mercury Tours:");
	}
	
	
	@DataProvider
	public Object[][] getnewtoursData(){
		Object data[][] = com.UTIL.TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getnewtoursData")
	public void ValidateFlightFinder( String DepartingFrom, String DepartingFrom_On_month,String ArrivingIn,String Returning_month,
			String Airline
			){
		sf=fp.Flight_Details_Entry(DepartingFrom, DepartingFrom_On_month,ArrivingIn,Returning_month,Airline);
		}
	
	

	@AfterMethod
	public void tearDown(){
		driver.close();
	}

	

}
