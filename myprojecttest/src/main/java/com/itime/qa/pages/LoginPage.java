package com.itime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.itime.qa.base.BaseTest;

public class LoginPage extends BaseTest{
	//Page Factory
	@FindBy(xpath="//input[@type='text']")
	WebElement untb;
	@FindBy(name="pwd")
	WebElement pwtb;
	@FindBy(xpath="//div[text()='Login ']")
	WebElement loginBtn;
	@FindBy(xpath="//label[contains(text(),keep)]")
	WebElement checkbox;
	@FindBy(xpath="//img[@height='98']")
	WebElement img;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginpageTitle()
	{
		 
		return driver.getTitle();
	}
	public boolean validateimage()
	{
		return img.isDisplayed();
	}
	
public SignUp login1(String un,String pwd)
{
untb.sendKeys(un);
pwtb.sendKeys(pwd);
loginBtn.click();
return new SignUp();
}
}
