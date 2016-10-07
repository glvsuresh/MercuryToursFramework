package com.training.mercuryTours.main;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import com.training.mercuryTours.utils.CommonLib;

public class MercuryTourDriver {
	
	public static void main(String[] args) {
		try
		{
			String sXMLSuiteFile;
			List<String> oSuiteFile;
			String sOutputFolder;
			
			TestNG oTestNG=new TestNG();
			System.out.println(System.getProperty("user.dir"));
			sXMLSuiteFile=System.getProperty("user.dir")+"/src/testng.xml";
			sOutputFolder="Results/Report as on "+CommonLib.getDateTimeStamp();
			oSuiteFile=new ArrayList<String>();
			oSuiteFile.add(sXMLSuiteFile);
			oTestNG.setOutputDirectory(sOutputFolder);
			oTestNG.setTestSuites(oSuiteFile);
			oTestNG.run();
			
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
	}

}
