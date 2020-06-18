package com.task.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.task.utils.CommonMethods;

public class NewUserPageElements extends CommonMethods{
	public  NewUserPageElements() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user_username")
	public WebElement userName;
	
	@FindBy(id="user_password")
	public WebElement password;
	
	@FindBy(id="user_email")
	public WebElement email;
	
	@FindBy(name = "commit")
	public WebElement createUserBtn;
	



}
