package com.task.bases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.task.utils.ConfigsReader;
import com.task.utils.Constants;



public class BaseClass {
	public static WebDriver driver;
	

	public static void setUp() {
		ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver=new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver=new FirefoxDriver();
			break;	

		default:
			System.err.println("Browser is not supported");
			break;
		}
		
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
		Set<Cookie> cookies=driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie);
					}
		driver.manage().deleteAllCookies();
		//driver.get(Constants.HRMS_URL);
		driver.get(ConfigsReader.getProperty("url"));
	}
	
	public static void tearDown() {
		if (driver!=null) {
			driver.quit();
			
		}
		
	}

}
