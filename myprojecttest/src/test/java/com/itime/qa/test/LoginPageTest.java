package com.itime.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.itime.qa.base.BaseTest;
import com.itime.qa.pages.LoginPage;
import com.itime.qa.pages.SignUp;

public class LoginPageTest extends BaseTest {
	LoginPage login;
	SignUp sign;
	
	LoginPageTest(){
		//to call test base class constructor
		super ();
		}
	@BeforeMethod
	public void setup() {
		initialization();
		 login=new LoginPage();
	}
	@Test(priority=2)
	public void loginPageTitleTest()
	{
		String title= login.validateLoginpageTitle();
		System.out.println(title);
		Assert.assertEquals(title.trim(), "actiTIME - Login");
		//Assert.assertEquals(title, "actiTIME -  Login");
	}
	
	@Test(priority=1)
	public void actitimeLoginImgTest()
	{
		boolean flag=login.validateimage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest()
	{
		sign=login.login1(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	

}
