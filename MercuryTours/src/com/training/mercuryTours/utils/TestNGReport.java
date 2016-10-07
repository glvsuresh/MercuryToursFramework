package com.training.mercuryTours.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import com.training.mercuryTours.utils.CommonLib;;


public class TestNGReport extends TestListenerAdapter
{
		@Override
		public void onTestFailure(ITestResult tr)
		{
			
			File scrFile = ((TakesScreenshot)CommonLib.oBrowser).getScreenshotAs(OutputType.FILE);
	        try {
	        	    String sFilePath=Constants.sScreenShotPath;
	        	    FileUtils.copyFile(scrFile, new File(sFilePath+tr.getName()+".png"));
	        	    Reporter.log("Test case is failed. Please refer ");
	                Reporter.log("<a href="+sFilePath+tr.getName()+".Png>ScreenShot</a>"); 
	                Reporter.setCurrentTestResult(null); 

	            }
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
		
		@Override
		public void onTestSuccess(ITestResult tr)
		{
			
			Reporter.log(tr.getName()+"Testcase is passed");
		}
}


