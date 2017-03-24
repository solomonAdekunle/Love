package Casino;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestUtil.Constant;
import TestUtil.TestDataProvider;
import Base.TestBase;

public class GettingStartedTest extends TestBase{
	
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());
	}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void GettingStartedTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		  openBrowser(prop.getProperty("browserType"));
		    navigate("testsiteURL");
			Thread.sleep(2000);
			click("hp_FooterGettingStrated_xpath");
			 Thread.sleep(3000L);
			click("gettingStarted_HowToDeposit_Selector");
			Thread.sleep(3000L);
			click("gettingStartedHowToDeposit_Faqs_xpath");
			d.navigate().back();
			Thread.sleep(3000L);
						}
		 
	
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
	 public void VIPTest(Hashtable<String,String>table) throws InterruptedException{
		openBrowser(prop.getProperty("browserType"));
		  navigate("testsiteURL");
		  Thread.sleep(1000L);
		  click("hpVegasTab_Selector");
		  Thread.sleep(1000L);
		  click("vegas_footerVIP_Selector");
		  Thread.sleep(2000);
		 boolean logo=isElementPresent("vipLogo_Selector");
		 System.out.println(logo);
		 
		 
	 }
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
	 public void HowToWithdrawTest(Hashtable<String,String>table) throws InterruptedException{
		openBrowser(prop.getProperty("browserType"));
		  navigate("testsiteURL");
		  Thread.sleep(3000L);
		  click("hp_FooterGettingStrated_xpath");
			Thread.sleep(5000L);
			click("gettinStrated_HowToWithdraw_Selector");
			Thread.sleep(3000L);
			click("gettingStartedHowToWithdraw-FAQS_xpath");
			d.navigate().back();
			Thread.sleep(3000L);
			click("gettingStarted_IsMyDepositSafe_Selector");
			Thread.sleep(3000L);
			click("gettingStarted_Security_Selector");
	 }
			@AfterMethod
			public void close(){
//				if(extent!=null){
//					extent.endTest(test);
//					extent.flush();
//				}
				quit();
			}
}


	 
