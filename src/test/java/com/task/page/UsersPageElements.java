package com.task.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.task.utils.CommonMethods;

public class UsersPageElements extends CommonMethods{
	public  UsersPageElements() {
		PageFactory.initElements(driver, this);
	}
	@FindBy( linkText = "New User")
	public  WebElement linkNewUser;
	
	@FindBy(xpath = "//div[@id='q_username_input']/select")
	public WebElement userDD;
	
	@FindBy(id="q_username")
	public WebElement inputUserName;
	
	@FindBy(xpath = "//div[@id='q_email_input']/select")
	public WebElement emailDD;
	
	@FindBy(id="q_email")
	public WebElement inputEmail;
	
	@FindBy(name = "commit")
	public WebElement filterBtn;
	
	@FindBy(id = "page_title")
	public WebElement userName;

	@FindBy(xpath = "//div[@class='flash flash_notice']")
	public WebElement confMessage;
	
	@FindBy(xpath = "//input[@id='q_created_at_gteq_datetime']")
	public WebElement from;
	
	@FindBy(xpath = "//a[@title='Prev']")
	public WebElement prev;
	
	@FindBy(xpath = "//a[@title='Next']")
	public WebElement next;
	
	@FindBy(xpath = "//span[@class='ui-datepicker-month']")
	public WebElement month;
	
	@FindBy(xpath = "//span[@class='ui-datepicker-year']")
	public WebElement year;
	
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
	public List<WebElement> fromDate;
	
	@FindBy(xpath = "//input[@id='q_created_at_lteq_datetime']")
	public WebElement to;
	
	@FindBy(xpath = "//*[@id=\"index_table_users\"]")
	public WebElement resultTable;
	
	@FindBy(xpath = "//table[@id='index_table_users']/tbody/tr/td")
	public List<WebElement> resultRows;
	
	@FindBy(xpath = "//*[@id=\"index_table_users\"]/tbody/tr[1]")
	public WebElement resultCols;
	


}
