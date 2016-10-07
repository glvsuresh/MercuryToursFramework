package com.training.mercuryTours.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.training.mercuryTours.utils.*;

@Listeners(TestNGReport.class)
public class LogOut extends CommonLib{
	
	
	@Test(description="Logging Out MT App")
	public static void LogOutFromMercuryTours()
	{
		try
		{
			clickElem(By.xpath("//img[contains(@src,'Logout')]"));
			if(oBrowser.findElement(By.name("userName")).isDisplayed())
			{
				System.out.println("Logging Out MT Successfully");
				Reporter.log("Logging Out MT Successfully");
			}
			else
			{
				takeScreenshot("Logoutfailed.png");
				System.out.println("Logout failed");
				Reporter.log("Error occurred while logging out MT");
				Assert.fail("Error occurred while logging out MT");
			}
		}
		catch(Throwable t)
		{
			takeScreenshot("Logoutfailed.png");
			System.out.println("Logout failed becuase of "+t.getMessage());
			Reporter.log("Logout failed becuase of "+t.getMessage());
			Assert.fail("Logout failed becuase of "+t.getMessage());
		}
	}

}
