package com.itime.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.itime.qa.util.TestUtil;


public class BaseTest {
	public static WebDriver driver;
	protected static Properties prop;
	
	public BaseTest() {
		try {
			prop=new Properties();
			FileInputStream fis = new FileInputStream("\\Users\\DELL\\eclipse-workspace\\myprojecttest\\src\\main\\java\\com\\itime\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialization() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			}
		else
		{
			System.setProperty("webdriver.gecko.driver",".\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_load,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}
