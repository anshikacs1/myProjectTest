package com.itime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.itime.qa.base.BaseTest;

public class SignUp extends BaseTest{
	@FindBy(xpath="//td[@class='navItem navCell relative selected']//div[@class='img']")
	WebElement ttImg;
	@FindBy(xpath="//div[@class='popup_menu_icon settings_icon']")
	WebElement settings;
	@FindBy(xpath="//div[text()='Turn Features On / Off']")
	WebElement turnFeatureonOff;
@FindBy(xpath="//div[contains(text(),'General')]")
WebElement general;
@FindBy(xpath="//a[text()='Types of Work']")
WebElement toW;
@FindBy(xpath="//a[contains(text(),'Schedule')]")
WebElement wos;
public SignUp() {
	PageFactory.initElements(driver, this);
	
}
public String validateTitle()
{
	return driver.getTitle();

}
public boolean validimg()
{
return ttImg.isDisplayed();	
}
public WorkingDays clickonsettings()
{
	settings.click();
	Actions action = new Actions(driver);
	action.moveToElement(turnFeatureonOff).moveToElement(general).moveToElement(toW).moveToElement(wos).build().perform();
	wos.click();
	return new WorkingDays();
}

}
