package com.Bases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.UTIL.TestUtil;
import com.UTIL.WebdriverEventListner;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebdriverEventListner eventListener;
	
	public TestBase()  {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\Config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void initialization(){
		String browername = prop.getProperty("browser");
		
		if(browername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Mohan\\Desktop\\Hybrid_Framework\\Hybrid_framework\\Newtours\\driver\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browername.equals("FF")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Mohan\\git\\Test_Repo\\hybridframework\\driver\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		
		//for listner events
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebdriverEventListner();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
