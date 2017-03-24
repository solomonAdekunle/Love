package CORE_SUITE;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TestUtil.Constant;
import TestUtil.TestDataProvider;
import TestUtil.Utility;
import Base.TestBase;

public class LoginTest extends TestBase {
	
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}

	
		@Test(dataProviderClass=TestDataProvider.class,dataProvider="CORE_SUITEDataProvider")
		public void loginTest(Hashtable<String,String> table) throws IOException, InterruptedException{
			test=extent.startTest("LoginTest");
			validateRunmodes("LoginTest", Constant.First_Suite, table.get(Constant.RUNMODE_COL));
			doLogin(table.get(Constant.BROWSER_COL),table.get(Constant.USERNAME_COL), table.get(Constant.PASSWORD_COL));
			Thread.sleep(2000L);
			boolean result=isElementPresent("errorMessage_Selector");
			 String actualResult=null;
		    if(result)
				actualResult="FAILURE";
			else
				actualResult="SUCCESS";
		    
		   Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult);
		    if(table.get(Constant.EXPECTEDRESULT_COL).equals("SUCCESS")){
			// Checking if PlayerMessage will be displayed.
			boolean result1=isElementPresent("hpDeposit_xpath");
		    String actualResult1=null;
		    if(result1)
				actualResult1="SUCCESS";
			else
				actualResult1="FAILURE";
		 Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult1);
		    }
			

	}

		@AfterMethod
		public void close(){
			if(extent!=null){
				extent.endTest(test);
				extent.flush();
			}
			quit();
		}

}

