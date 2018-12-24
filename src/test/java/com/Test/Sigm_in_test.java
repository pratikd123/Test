package com.Test;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Bases.TestBase;
import com.PAGES.FlightFinder;
import com.PAGES.Sign_in_page;



public class Sigm_in_test extends TestBase{
	
	Sign_in_page sp;
	FlightFinder fp;
	
	Logger log = Logger.getLogger(Sigm_in_test.class);
	
	public Sigm_in_test() {
		super();
	}

	
	@BeforeMethod
	public void setup() {
		initialization();//call the method of testbase to open brower and url
		sp = new Sign_in_page();
		fp=new FlightFinder();
		}
	
	

	
	@Test(priority=1)
	public void Sign_in_page_verify(){
		log.info("****************************** Starting test cases execution  *****************************************");
		boolean flag = sp.Signup_verify();
		AssertJUnit.assertTrue(flag);
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	
	@Test(priority=2)
	public void Sign_in_page(){
		fp = sp.Signin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.close();
	}

}
