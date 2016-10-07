package com.training.mercuryTours.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.training.mercuryTours.utils.CommonLib;
import com.training.mercuryTours.utils.*;

@Listeners(TestNGReport.class)
public class Login extends CommonLib {
	
	@Parameters({"sUserName","sPassword"})
	@Test(description="LoginToMercuryTours")
	public static void loginToMercuryTours(String sUserName,String sPassword)
	{
		try
		{
			enterText(By.name("userName"), sUserName);
			enterText(By.name("password"), sPassword);
			clickElem(By.name("login"));
			if(oBrowser.findElement(By.linkText("ITINERARY")).isDisplayed())
			{
				System.out.println("Logged into Mercury Tours Successfully");
				Reporter.log("Logged into Mercury Tours Successfully");
			}
			else
			{
				System.out.println("Failed to Login to Mercury Tours");
				takeScreenshot("LoginFailed.png");
				Reporter.log("Failed to Login to Mercury Tours");
				Assert.fail("Failed to Login to Mercury Tours");
			}
			
		}
		catch(Throwable t)
		{
			takeScreenshot("MTLogin.png");
			System.out.println("Login To Mercury Tours is unsuccessfull");
			System.out.println("Failed to Login to Mercury Tours because of "+t.getMessage());
			Reporter.log("Failed to Login to Mercury Tours"+t.getMessage());
			Assert.fail("Failed to Login to Mercury Tours due to "+t.getMessage());
		}
	}

}
