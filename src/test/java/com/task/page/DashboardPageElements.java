package com.task.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.task.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{
	public  DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Users")
	public  WebElement linkUsers;
	
	



}
