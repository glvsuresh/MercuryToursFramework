package com.training.mercuryTours.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.mercuryTours.utils.*;

@Listeners(TestNGReport.class)
public class SelectFlights extends CommonLib{
	
	
	@Parameters({"sDeptAirlines","sRtnAirlines"})
	@Test(description="Selecting flights")
	public static void selectFlightsForRoundTrip(String sDeptAirlines,String sRtnAirlines)
	{
		
		try
		{
			clickOnElemByusingName(By.xpath("//input[@name='outFlight']"), sDeptAirlines);
			clickOnElemByusingName(By.xpath("//input[@name='inFlight']"), sRtnAirlines);
			clickElem(By.name("reserveFlights"));
			if(oBrowser.findElement(By.name("passFirst0")).isDisplayed())
			{
				System.out.println("Flight selection is successful");
				Reporter.log("Flight selection is successful");
			}
			else
			{
				takeScreenshot("Flight selection failed");
				System.out.println("Flight selection failed");
				Reporter.log("Error occurred while selecting flight");
				Assert.fail("Error occurred while selecting flight");
			}
		}
		catch(Throwable t)
		{
			takeScreenshot("Flight selection failed");
			System.out.println("Flight selection failed because of "+t.getMessage());
			Reporter.log("Error occurred while selecting flight due to "+t.getMessage());
			Assert.fail("Error occurred while selecting flight due to "+t.getMessage());
		}
	}

}
