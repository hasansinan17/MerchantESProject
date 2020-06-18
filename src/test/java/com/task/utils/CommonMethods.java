package com.task.utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.task.bases.PageInitiliazer;




public class CommonMethods  extends PageInitiliazer{
	

	
	/**
	 * This method will take a screenshot
	 * @param fileName
	 */
	public static byte[] takeScreenshot(String fileName) {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MMdd_hhmmss");
		String timeStamp=sdf.format(date.getTime());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		byte [] picture = ts.getScreenshotAs(OutputType.BYTES);
		File file=ts.getScreenshotAs(OutputType.FILE);
		String scrshotFile=Constants.SCREENSHOTS_FILEPATH+fileName+timeStamp+".png";
		try {
			FileUtils.copyFile(file, new File(scrshotFile));
		} catch (IOException e) {
			System.out.println("Cannot take a screenshot");
		}
		return picture;
	}
	
	
	/**
	 * This method will enter text
	 * @param element
	 * @param value
	 */
	public static void sendText(WebElement element,String value) {
		//waitForVisibility(element);
		element.clear();
		element.sendKeys(value);
	}
	
	/**
	 * This method will click on the element
	 * @param element
	 */
	public static void click(WebElement element) {
		//waitForClickability(element);
		element.click();
	}
	/**
	 * This method will select value from DD
	 * @param element
	 * @param visibleText
	 */
	public static void selectDdValue(WebElement element, String visibleText) {
		Select select = new Select(element);
		List<WebElement>options=select.getOptions();
		boolean isFound=false;
		for (WebElement option : options) {
			if(option.getText().equals(visibleText)) {
				select.selectByVisibleText(visibleText);
				isFound=true;
				break;
			}
			
		}
		if(!isFound) {
			System.out.println("Value "+visibleText+" was not foud in the dropdown");
		}
	}
	/**
	 * This method will select value from DropDown
	 * @param element
	 * @param index
	 */
			
	public static void selectDDValue(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement>options=select.getOptions();
		boolean isFound=false;
		if(options.size()>index) {
			select.selectByIndex(index);
			isFound=true;
	 }
		if(!isFound) {
			System.out.println("Value with index "+index+" was not selected");
		}
	}
	
		static String jsonFile;
		public static String readJson(String fileName) {
			try {
				jsonFile= new String(Files.readAllBytes(Paths.get(fileName)));
			} catch(IOException e) {
				e.printStackTrace();
			}
			return jsonFile;
	}
	
	
	
	
}
