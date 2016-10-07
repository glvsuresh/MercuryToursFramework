package com.training.mercuryTours.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.mercuryTours.utils.*;

@Listeners(TestNGReport.class)
public class FindFlights extends CommonLib {
	
	@Parameters({"sPasscount","sDeparture","sTravelDt","sArrival","sRetnDate","sAirLinesName"})
	@Test(description="Searching for flights")
	public static void findFlights(String sPasscount,String sDeparture, String sTravelDt,String sArrival,String sRetnDate,String sAirLinesName)
	{
		try
		{
			WebElement oPassLstBox=oBrowser.findElement(By.name("passCount"));
			selectValFromListbox(oPassLstBox, sPasscount);
			WebElement oDepart=oBrowser.findElement(By.name("fromPort"));
			selectValFromListbox(oDepart, sDeparture);
			WebElement oDay=oBrowser.findElement(By.name("fromDay"));
			selectValFromListbox(oDay, sTravelDt);
			WebElement oArrival=oBrowser.findElement(By.name("toPort"));
			selectValFromListbox(oArrival, sArrival);
			WebElement oReturnDate=oBrowser.findElement(By.name("toDay"));
			selectValFromListbox(oReturnDate, sRetnDate);
			clickElem(By.xpath("//input[@value='Business']"));
			WebElement oAirline=oBrowser.findElement(By.name("airline"));
			selectValFromListbox(oAirline, sAirLinesName);
			clickElem(By.name("findFlights"));
			if(oBrowser.findElement(By.xpath("//img[contains(@src,'selectflight')]")).isDisplayed())
			{
				System.out.println("Searching flights is successful");
				Reporter.log("Searching flights is successful");
			}
			else
			{
				takeScreenshot("FlightSearchFailed");
				System.out.println("Flight search is failed");
				Reporter.log("Flight search is failed");
				Assert.fail("Flight search is failed");
			}
			
		}
		catch(Throwable t)
		{
			System.out.println("Failed to search for flights");
			Reporter.log("Flight search is failed due to "+t.getMessage());
			Assert.fail("Flight search is failed due to "+t.getMessage());
		
		}
	}
	

}
