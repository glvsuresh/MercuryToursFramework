package com.training.mercuryTours.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.mercuryTours.utils.*;

@Listeners(TestNGReport.class)
public class BookFlight extends CommonLib {

	
	@Parameters({ "sPassFN", "sPassLN", "sCreditNo" })
	@Test(description = "Entering Passenger Details")
	public static void enterPassengerDetails(String sPassFN, String sPassLN,
			String sCreditNo) {
		try {
			enterText(By.name("passFirst0"), sPassFN);
			enterText(By.name("passLast0"), sPassLN);
			enterText(By.name("creditnumber"), sCreditNo);
			clickElem(By.name("buyFlights"));
			if (oBrowser.findElement(
					By.xpath("//img[contains(@src,'mast_confirmation')]"))
					.isDisplayed()) {
				System.out.println("Entered Passenger details successfully");
				Reporter.log("Entered Passenger details successfully");

			} else {
				System.out.println("Error occurred while entering passenger details");
				takeScreenshot("FailedPasgr.png");
				Reporter.log("Error occurred while entering passenger details");
				Assert.fail("Error occurred while entering passenger details");
			}
		} catch (Throwable t) {
			System.out.println("Failed while entering passenger details");
			takeScreenshot("FailedPasgr.png");
			Reporter.log("Error occurred while entering passenger details due to "+t.getMessage());
			Assert.fail("Error occurred while entering passenger details due to "+t.getMessage());
		}
	}
}
